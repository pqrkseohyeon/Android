package com.cookandroid.project10_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        StrictMode.VmPolicy.Builder builder =new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 전화를 걸기 위해 URI 문자열을 "tel:전화번호" 형식으로 사용
                // ACTION_DIAL로 사용하면 전화 걸기 창이 열린다.
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 웹브라우저를 열기 위해 URI 문자열을 "http://웹 주소" 형식으로 사용
                // 액션은 ACTION_VIEW를 사용했다.
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //구글 맵을 열기 위해 URI 문자열을 구글 맵 주소와 경위도 형식으로 사용
                // 액션은 ACTION_VIEW를 사용했다.
                Uri uri = Uri.parse("http://maps.google.com/maps?q="+37.554264+","+126.913598);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 구글 검색을 열기 위해 액션은 ACTION_WEB_SEARCH를 사용
                // 검색을 위해 putExtra()로 넘기는데,
                // 첫 번째 파라미터 SearchManager.QUERY를 사용하고,
                // 두 전째 파라미터에는 검색에 사용할 단어를 넣었다.
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"안드로이드");
                startActivity(intent);

            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메시지를 보내기 위해 액션은 ACTION_SENDTO를 사용
                // 보낼 문자는 putExtra()로 넘기는데,
                // 첫 번째 파라미터로 SearchManager.QUERY를 사용하고,
                // 두 번째 파라미터에 보낼 문자를 넣었다. 또한 setData()를 설정해야 한다.
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","안녕하세요?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // 카메라를 열기 위해 액션은 MediaStore.ACTION_IMAGE_CAPTURE를 사용용
//               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivity(intent);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.fromFile(new File(Environment.
                        getExternalStorageDirectory().getPath()+"/jeju13.jpg"));
                intent.setDataAndType(uri, "image/jpeg");

                startActivity(intent);
            }
        });

    }
}