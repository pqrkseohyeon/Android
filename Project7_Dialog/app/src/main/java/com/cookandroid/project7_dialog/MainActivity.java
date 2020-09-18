package com.cookandroid.project7_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //멤버변수로
    boolean[] checkArray = new boolean[] {true, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 출력할 항목의 문자열 배열, 내부 클래스 안에서 사용될 것이므로 final을 붙였다.
                final String[] versionArray = new String[] {"오레오", "파이","큐(10)"};

                //각 항목이 체크되었는지를 boolean 배열로 만들었다.
//                final boolean[] checkArray = new boolean[] {true, false, false};

                // 대화상자를 생성, 현재 내부 클래스 안이므로 '액티비티명.this'로 컨텍스트를 지정
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                //제목, 메시지 내용, 아이콘 설정
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                // 두 번째 파라미터는 첫 번째 파라미터인 문자열 배열과 개수가 같은 boolean 배열이어야 한다.
                // 그래야 처음 화면이 나올 때 항목의 체크 여부를 화면에 표시할 수 있다.
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                //button1.setText(versionArray[which]);
                                if (isChecked)
                                    checkArray[which] = true;
                                else
                                    checkArray[which] = false;

                                String str1=""; // 출력할 문자를 담는다(쉼표 포함해서)
                                int cnt=0; // 선택된 갯수를 담는 변수

                                for(int i=0; i<checkArray.length; i++){
                                    if (checkArray[i])
                                    {
                                        cnt++; // 선택 될때 마다 카운팅
                                        if (cnt != 1)
                                            str1 =str1+",";

                                        str1 = str1 + versionArray[i];
                                    }
                                }

                                if(cnt == 0)
                                    str1 = "선택안됨!";

                                button1.setText(str1);
                            }
                        });


                //클릭할 경우에 동작,
//                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]); // 버튼의 글자를 배열의 which번째 문자로 변경
//
//                    }
//                });
////                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]); // 버튼의 글자를 배열의 which번째 문자로 변경
//                    }
//                });
                dlg.setPositiveButton("닫기", null);
                dlg.show(); // 대화상자를 화면에 출력
            }

        });

    }
}