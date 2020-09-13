package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //0.뷰 자체 - 1. 레이아웃과 2.위젯으로 구성
        setContentView(R.layout.main);

        // 2.위젯
//        TextView tv0;//객체변수
//        tv0 = new TextView();

        TextView tv1, tv2, tv3;
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);

        tv1.setText("안녕하세요?");
        tv1.setTextColor(Color.RED);
        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
        tv3.setSingleLine();

    }
}