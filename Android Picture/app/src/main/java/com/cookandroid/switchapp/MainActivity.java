package com.cookandroid.switchapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

// 반려동물 선택을 checkBox 대신 Switch로 변경!
public class MainActivity extends AppCompatActivity {


    //멤버변수!
    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView imgPet;
    Button btnQuit, btnRerun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        // 위젯을 변수에 대입
        text1 = (TextView) findViewById(R.id.Text1);
        switchAgree = (Switch) findViewById(R.id.switchAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.Rdo80);
        radioArray[1] = (RadioButton) findViewById(R.id.Rdo90);
        radioArray[2] = (RadioButton) findViewById(R.id.Rdo100);

        imgPet = (ImageView) findViewById(R.id.ImgPet);

        btnQuit = (Button) findViewById(R.id.BtnQuit);
        btnRerun = (Button) findViewById(R.id.BtnRerun);

        // 동의함 체크박스의 체크가 변경되면
        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0,
                                         boolean arg1) {
                // 체크되면 모두 보이도록 설정
                if (switchAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                    btnQuit.setVisibility(android.view.View.VISIBLE);
                    btnRerun.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                    btnQuit.setVisibility(android.view.View.INVISIBLE);
                    btnRerun.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        // 라디오버튼을 클릭할 때, 이미지 뷰를 변경시킴 ==> 배열로 처리함.
        // 1. 라디오버튼 3개를 1개로> -> 배열로... 객체 배열로...!
        // 2. 이미지 객체를(예:R.drawable.q10) 를 1개로 -> 배열로!
        final int draw[] = {R.drawable.oreo, R.drawable.pie, R.drawable.q10};

        for (int i = 0; i < radioArray.length; i++) {
            final int index; // 왜 final 인가?
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼을 클릭하면
        btnQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        // 처음으로 버튼을 클릭하면
        btnRerun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //아래 위젯들을 화면에 '안'보이게...
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);
                btnQuit.setVisibility(android.view.View.INVISIBLE);
                btnRerun.setVisibility(android.view.View.INVISIBLE);

                switchAgree.setChecked(false);
                rGroup1.clearCheck();
                imgPet.setImageResource(0); //이미지 리셋

            }
        });

    }

}
