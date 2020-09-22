package com.cookandroid.project10_activity_intent;

//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class SecondActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.second);
//        setTitle("Second 액티비티");
//
//        //메인 액티비티에서 받은 두 값을 더함
//        Intent inIntent = getIntent();
//        final int hapValue = inIntent.getIntExtra("Num1", 0)
//                + inIntent.getIntExtra("Num2", 0);
//
//        Button btnReturn = (Button) findViewById(R.id.btnReturn);
//        btnReturn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // 인텐트를 생성하고 더한 값을 넣는다.
//                Intent outIntent = new Intent(getApplicationContext(),
//                        MainActivity.class);
//                outIntent.putExtra("Hap", hapValue);
//                setResult(RESULT_OK, outIntent); //메인 액티비티로 돌려줌, 메인 액티비티의 onActivityResult() 메소드가 실행
//                finish(); // 현재 액티비티를 닫는다.
//            }
//        });
//    }
//}


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();

        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;
        if (calc.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    + inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("-")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    - inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    * inIntent.getIntExtra("Num2", 0);
        } else {
            calValue = inIntent.getIntExtra("Num1", 0)
                    / inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }

}