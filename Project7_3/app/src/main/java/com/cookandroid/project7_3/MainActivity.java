package com.cookandroid.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView; // 중요, 응용을 많이함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("사용자 정보 입력(수정)");

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. 뷰 만들기
                dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.dialog1, null); // dialog1.xml 파일을 인플레이트하여 dialogView에 대입

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                //2.뷰 꽂기, 확장한(inflate) 뷰를 꽂는다!
                dlg.setView(dialogView); // 인플레이트한 뷰를 대화상자로 사용, dialog1.xml의 내용이 대화상자로 나타나게 된다.

                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtEmail.setText(tvEmail.getText().toString());

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                tvName.setText(dlgEdtName.getText().toString());
                                tvEmail.setText(dlgEdtEmail.getText().toString());
                            }
                        });

                // 대화상자의 <취소>를 클릭했을 때 toast1.xml이 토스트 메시지로 나오도록 설정
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = new Toast(MainActivity.this); // 빈토스트 생성
                                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                                        .getDefaultDisplay();
                                int xOffset = (int) (Math.random() * display.getWidth());
                                int yOffset = (int) (Math.random() * display.getHeight());

                                toast.setGravity(Gravity.TOP | Gravity.LEFT,
                                        xOffset,yOffset);

                                //1. 뷰 만들기
                                toastView = (View) View.inflate(MainActivity.this,
                                        R.layout.toast1, null);
                                toastText = (TextView) toastView.findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다"); // 토스트(toast1.xml)의 텍스트뷰에 접근하여 문자열을 변경
                                //2. 뷰 꽂기
                                toast.setView(toastView);
                                toast.show(); // 토스트를 화면에 출력
                            }
                        });

                dlg.show();
            }
        });
    }
}