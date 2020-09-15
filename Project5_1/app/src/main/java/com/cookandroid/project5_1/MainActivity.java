package com.cookandroid.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //XML을 안쓰겠다! -> 추천방법은 아니다.
       // setContentView(R.layout.activity_main);


        // 1. 레이아웃 만들기 전에 파라미터(속성)을 준비, 레이아웃 만들기 전에
        // 2. 레이아웃 만들기
        // 3. 레이아웃 속성 정하기

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this); // 액티비티
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0,255,0));
        setContentView(baseLayout,params); // 1)콘텐츠 뷰 추가 -> 액티비티에

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn); // 2) 뷰 추가-> 레이아웃에

        //버튼에 이벤트 처리
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "코드로 생성한 버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}