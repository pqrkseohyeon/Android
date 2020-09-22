package com.cookandroid.project11_2_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터(개선)");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        // 2. 정의한 MyGalleryAdapter 변수를 생성하여, activity_main.xml의 그리드뷰에 적용
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);

    }
    // 1. BaseAdapter를 상속받는 MyGalleryAdapter를 정의
    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        // 3. 영화 포스터 그림 파일의 아이디를 배열로 지정한다.
        Integer[] posterID = {
                 R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,
                 R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,
                 R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,
                 R.drawable.mov20};

        String[] posterTitle = { "여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀",
                "혹성탈출", "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다" };

        public MyGalleryAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(120,200)); // 이미지뷰 크기 지정
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER); // 이미지뷰를 각 그리드뷰 칸의 중앙에 배치
            imageview.setPadding(5,5,5,5); // 공백 설정

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            // 클릭 리스너가 아닌 터치 리스너를 사용했다는 것에 유의
            imageview.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    //이미지뷰를 각 그리드뷰 칸의 중앙에 배치하고 이미지뷰에 ㅇㅇ화 포스터 1개를 적용용
                   ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    Toast toast = new Toast(getApplicationContext());
                    View toastView = (View) View.inflate(
                            getApplicationContext(), R.layout.toast, null);
                    TextView toastText = (TextView) toastView
                            .findViewById(R.id.textView1);
                    toastText.setText(posterTitle[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });
            return imageview;
        }
    }
}