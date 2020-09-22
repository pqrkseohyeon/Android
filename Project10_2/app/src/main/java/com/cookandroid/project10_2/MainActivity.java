package com.cookandroid.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 선호도 투표");

        // 그림의 투표수를 저장할 변수를 선언하고 초기화
        final  int voteCount[] = new int[9];
        for (int i=0; i<9;i++)
            voteCount[i] = 0;

        // 이미지뷰 위젯 변수 배열, 위젯 id 배열, 그림 이름 배열을 선언언
       ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3,
                R.id.iv4, R.id.iv5, R.id.iv6,R.id.iv7,
                R.id.iv8,R.id.iv9,};
        final String imgName[] = {"독서하는 소녀","꽃장식 모자 소녀","부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀","테라스의 두 자매","피아노 레슨",
                "피아노 앞의 소녀들", "해변에서"};

        // 이미지뷰의 개수만큼 반복한다.
        for(int i=0; i<imageId.length; i++){
            final  int index; // 꼭 필요함
            index = i;

            // 1개의 이미지뷰에 대해 클릭 리스너를 작성하는 거소가 동일, 배열을 사용하여 아홉번 반복한 것
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++; // 이미지뷰를 클릭할 때마다 해당 이미지 순번의 투표수(voteCount) 배열값이 하나씩 증가

                    // 이미지뷰를 클릭할 때마다 해당 이미지 순번의 이미지 이름(imgName)과 현재 투표수(voteCount) 값을 토스트 메시지로 보여준다.
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);

                //정수형 voteCount 배열을 VoteCount라는 이름으로 넘긴다.
                // 이것을 액티비티에서는 getIntArrayExtra() 메소드로 받으면 된다.
                // 또한 문자열 배열인 imgName을 지정한 ImageName은 getStringArrayExtra()메소드를 사용해서 받는다.
                intent.putExtra("VoteCount",voteCount);
                intent.putExtra("ImageName",imgName);
                startActivity(intent);
            }
        });

    }

}