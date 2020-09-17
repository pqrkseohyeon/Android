package com.cookandroid.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
//    LinearLayout baseLayout;
//    Button button1;

    EditText edtAngle;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setTitle("배경색 바꾸기");
//        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
//        button1 = (Button) findViewById(R.id.button1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 =(ImageView) findViewById(R.id.imageView1);
    }

    // 1. 옵션메뉴 만들기(create) - 방법1: xml로 디자인 (선호)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        MenuInflater minflater = getMenuInflater();
//        minflater.inflate(R.menu.menu1, menu);
//        return true;
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // 1. 옵션메뉴 만들기(create) - 방법2: java로 디자인 (비선호)
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        menu.add(0, 1, 0, "배경색 (빨강)");
//        menu.add(0, 2, 0, "배경색 (초록)");
//        menu.add(0, 3, 0, "배경색 (파랑)");
//
//        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
//        sMenu.add(0, 4, 0, "버튼 45도 회전");
//        sMenu.add(0, 5, 0, "버튼 2배 확대");
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case 1:
//                baseLayout.setBackgroundColor(Color.RED);
//                return true;
//            case 2:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                return true;
//            case 3:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                return true;
//            case 4:
//                button1.setRotation(45);
//                return true;
//            case 5:
//                button1.setScaleX(2);
//                return true;
//        }
//        return false;


    //2. 옵션 메뉴 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.itemRed:
//                baseLayout.setBackgroundColor(Color.RED);
//                return true;
//            case R.id.itemGreen:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                return true;
//            case R.id.itemBlue:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                return true;
//            case R.id.subRotate:
//                button1.setRotation(45);
//                return true;
//            case R.id.subSize:
//                button1.setScaleX(2);
//                return true;
//
//        }
//
//        return false;
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText()
                        .toString()));
                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju2);
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju14);
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju6);
                return true;
        }
        return false;
    }
}