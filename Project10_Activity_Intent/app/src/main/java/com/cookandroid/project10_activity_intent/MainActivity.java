package com.cookandroid.project10_activity_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

//        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
//        btnNewActivity.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
//                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
//
//                // 인텐트를 생성하고 두 값을 넣는다.
//                Intent intent = new Intent(getApplicationContext(),
//                        SecondActivity.class);
//                intent.putExtra("Num1",
//                        Integer.parseInt(edtNum1.getText().toString()));
//                intent.putExtra("Num2",
//                        Integer.parseInt(edtNum2.getText().toString()));
//                // 값을 돌려받기 위새 startActivityForResult()를 사용,
//                // 두 번째 파라미터에는 돌려받을 값이 있을 경우에 0 이상을 씀
//                startActivityForResult(intent, 0);

        final EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
        final RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoAdd:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.rdoSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.rdoMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.rdoDiv:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    //세컨드 액티비티에서 setResult()로 값을 돌려주면 오버라이딩한 onActivityResult() 메소드가 실행
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //setResult()에서 보낸 값이 RESULT_OK이면 인텐트(data)에서 돌려받은 값을 토스트 메시지로 화면에 표시
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }
    }
}
