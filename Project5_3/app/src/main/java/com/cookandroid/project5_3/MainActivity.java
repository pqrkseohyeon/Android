package com.cookandroid.project5_3;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;
    TextView tview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //XML을 안쓰겠다! -> 추천방법은 아니다.
        // setContentView(R.layout.activity_main);


        // 1. 레이아웃 만들기 전에 파라미터(속성)을 준비, 레이아웃 만들기 전에
        // 2. 레이아웃 만들기
        // 3. 레이아웃 속성 정하기


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this); //액티비티
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params); //1) 콘텐츠 뷰 추가 -> 액티비티에

        // 1. 에디트 텍스트
        edt = new EditText(this);
        edt.setHint("여기에 입력하세요");

        baseLayout.addView(edt);

        //2. 버튼
        btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn); // 2) 뷰 추가 -> 레이아웃에

        // 3.텍스트뷰
        tview = new TextView(this);
        tview.setText("텍스트뷰입니다.");
        tview.setTextSize(20);
        tview.setTextColor(Color.MAGENTA);
        baseLayout.addView(tview);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                tview.setText(edt.getText().toString());
            }
        });

    }

}
