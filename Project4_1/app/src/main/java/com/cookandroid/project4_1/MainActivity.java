package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //멤버변수로 격상
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    String num1, num2;
    Double result;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 1.바인딩(View)
        setTitle("초간단 계산기(수정)");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd); //2.바인딩(위젯)
        btnSub = (Button) findViewById(R.id.BtnSub); //2.바인딩(위젯)
        btnMul = (Button) findViewById(R.id.BtnMul); //2.바인딩(위젯)
        btnDiv = (Button) findViewById(R.id.BtnDiv); //2.바인딩(위젯)
        btnMod = (Button) findViewById(R.id.BtnMod); //2.바인딩(위젯)

        textResult = (TextView) findViewById(R.id.TextResult); //2.바인딩(위젯)

        //이벤트 처리
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                // num1이나 num2가 둘 중에 하나라도 공백이면, 에러표시
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    result = Double.parseDouble(num1)
                            + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // num1이나 num2가 둘 중에 하나라도 공백이면, 에러표시
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    result = Double.parseDouble(num1)
                            - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }

            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                // num1이나 num2가 둘 중에 하나라도 공백이면, 에러표시
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", 1000)
                            .show();
                } else {
                    result = Double.parseDouble(num1)
                            * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                // num1이나 num2가 둘 중에 하나라도 공백이면, 에러표시
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // num2가 0이면 나누지 않는다.
                    if (num2.trim().equals("0")) {
                        Toast.makeText(getApplicationContext(),
                                "0으로 나눌 수 없습니다!", Toast.LENGTH_SHORT).show();

                    } else {
                        result = Double.parseDouble(num1)
                                / Double.parseDouble(num2);
                        result = (int) (result * 100) / 100.0; // 소수점 아래 2자리까지만 출력
                        textResult.setText("계산 결과 : " + result.toString(result));
                    }
                }

            }
        });


        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                // num1이나 num2가 둘 중에 하나라도 공백이면, 에러표시
                if (num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", 1000)
                            .show();
                } else {
                    result = Double.parseDouble(num1)
                            % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }

            }

        });






    }

}
