package com.cookandroid.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum; // 이미지 파일의 순번으로 사용할 변수
    //SD 카드에서 읽어올 이미지 파일의 배열과 파일명을 저장할 문자열 변수를 선언
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        //SD 카드에서 파일을 읽어 listFiles() 메소드로 배열을 만든다.
        imageFiles = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum <= 0){
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다",
                            Toast.LENGTH_SHORT).show();
                }else{
                    curNum --;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 배열은 0부터 시작하므로 '그림의 개수 -1'로 한다.
                if(curNum >= imageFiles.length-1){
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다",
                            Toast.LENGTH_SHORT).show();
                }else {
                    //<이전 그림>을 클릭하면 curNum을 하나 감소시키고
                    // <다음 그림>을 클릭하면 curNum을 하나 증가시킨다.
                    curNum ++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });
    }
}