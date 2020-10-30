package org.techtown.diary;

import android.app.Application;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;

// applicatio  클래스를 정의하고 앱에 등록하여 사용하는 경우에는 이 Application 클래스 안에 넣어둘 수도 있고
// AppHelper와 같은 별도의 클래스를 만들어 그 안에 넣어둘 수도 있다.
// 안드로이드에서 제공하는 HTTP 라이브러리를 사용하면 쉽고 빠르게 네트워크 통신을 할 수 있다.
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    //static으로 했으므로 어디서나 참조 가능
    public static RequestQueue requestQueue;
    //먼저 요청(Request) 객체를 만들고 이 요청 객체를 요청 큐(RequestQueue)라는 곳에 넣어주기만 하면 된다.
    // 그러면 요청 큐가 알아서 웹서버에 요청하고 응답까지 받아 사용자가 사용할 수 있도록 지정된 메소드를 호출

    @Override
    public void onCreate() {
        super.onCreate();

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlStack() {
                @Override
                protected HttpURLConnection createConnection(URL url) throws IOException {
                    HttpURLConnection connection = super.createConnection(url);
                    connection.setInstanceFollowRedirects(false);

                    return connection;
                }
            });
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static interface OnResponseListener {
        public void processResponse(int requestCode, int responseCode, String response);
    }

    public static void send(final int requestCode, final int requestMethod, final String url, final Map<String,String> params,
                     final OnResponseListener listener) {

        StringRequest request = new StringRequest(
                requestMethod,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d(TAG, "Response for " + requestCode + " -> " + response);

                        if (listener != null) {
                            listener.processResponse(requestCode, 200, response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error for " + requestCode + " -> " + error.getMessage());

                        if (listener != null) {
                            listener.processResponse(requestCode, 400, error.getMessage());
                        }
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

        };

        request.setShouldCache(false);
        request.setRetryPolicy(new DefaultRetryPolicy(10 * 1000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.requestQueue.add(request);
        Log.d(TAG, "Request sent : " + requestCode);
        Log.d(TAG, "Request url : " + url);
    }

}
