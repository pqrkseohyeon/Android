package com.cookandroid.ch05_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    // 1. 버튼을 배열로!
    Button [] numButtons = new Button[10];
    //버튼의 ID를 배열로, 목적은 반복문에서 인덱스(i)를 쓰려고
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.ex05_01);
//        setContentView(R.layout.ex05_02);
//        setContentView(R.layout.ex05_03);
//        setContentView(R.layout.ex05_04);
//        setContentView(R.layout.ex05_05);
//        setContentView(R.layout.ex05_06);
//        setContentView(R.layout.ex05_07);
//        setContentView(R.layout.ex05_10);
//        setContentView(R.layout.ex05_11);
//        setContentView(R.layout.ex05_12);
//        setContentView(R.layout.ex05_13);
//        setContentView(R.layout.ex05_14);
//        setContentView(R.layout.ex05_18);
//        setContentView(R.layout.ex05_19);
//        setContentView(R.layout.ex5_1);
//        setContentView(R.layout.ex5_2);
//        setContentView(R.layout.ex5_4);
//        setContentView(R.layout.ex5_5);
        setContentView(R.layout.ex5_6); //1. 바인딩(View)

        setTitle("그리드레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);// 2.바인딩(위젯)
        edit2 = (EditText) findViewById(R.id.Edit2);// 2.바인딩(위젯)

        btnAdd = (Button) findViewById(R.id.BtnAdd);// 2.바인딩(위젯)
        btnSub = (Button) findViewById(R.id.BtnSub);// 2.바인딩(위젯)
        btnMul = (Button) findViewById(R.id.BtnMul);// 2.바인딩(위젯)
        btnDiv = (Button) findViewById(R.id.BtnDiv);// 2.바인딩(위젯)
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        // 3.바인딩읠 배열에
        for (i=0;i<numBtnIDs.length;i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        // 4. 이벤트 처리를 배열에에
       for(i=0;i<numBtnIDs.length;i++){
            final int index; // 주의! 꼭 필요함..
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(edit1.isFocused()==true){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);

                    }else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}