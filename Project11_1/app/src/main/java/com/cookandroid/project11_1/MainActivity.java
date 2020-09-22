package com.cookandroid.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("그리드뷰 영화 포스터(개선)");

        final GridView gv = (GridView) findViewById(R.id.gridView1);

        //  밑에서 정의한 MyGridAdapter 변수를 생성한 후 activity_main.xml의 그리드뷰에 적용
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    // BaseAdapter의 상속을 받은 MyGridAdapter를 정의한다.
    public class MyGridAdapter extends BaseAdapter{

        //컨텍스트 변수를 선언, 위에서 넘긴 this 컨텍스트를 생성자에서 받은 다음 context 변수에 대입
        // 이는 context 변수를 다른 메소드에서 사용하기 위합이다.
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        //BaseAdapter의 추상 메소드를 자동 완성시킨다.
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        //영화 포스터 그림 파일의 아이디를 배열로 지정한다.
        Integer[] posterID = {
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10,
//                R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,
//                R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,
//                R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,
//                R.drawable.mov20,
//                R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,
//                R.drawable.mov24,R.drawable.mov25,R.drawable.mov26,
//                R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,
//                R.drawable.mov30,
//                R.drawable.mov31,R.drawable.mov32,R.drawable.mov33,
//                R.drawable.mov34,R.drawable.mov35,R.drawable.mov36,
//                R.drawable.mov37,R.drawable.mov38,R.drawable.mov39,
//                R.drawable.mov40
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10,
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10,
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10
        };

        String[] posterTitle = { "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
                "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타",
                "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이",
                "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이",
                "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드",
                "웰컴투동막골", "헬보이", "빽투더퓨처" };


        //이 부분이 실제 영하 포스터의 개수(40개)만큼 반복,
        // 영화 포스터를 그리드뷰의 각 칸마다 보여주는 기능을 한다.
        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            ImageView imageview = new ImageView(context); // 이미지뷰 변수 생성
            imageview.setLayoutParams(new GridView.LayoutParams(120,200)); // 이미지뷰 크기 지정
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER); // 이미지뷰를 각 그리드뷰 칸의 중앙에 배치
            imageview.setPadding(5,5,5,5); // 공백 설정

            imageview.setImageResource(posterID[position]); //이미지뷰에 영화 포스터 1개(파라미터로 넘어온 position 위치)를 적용

            final int pos = position;
//            imageview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    View dialogView = (View) View.inflate(MainActivity.this,
//                            R.layout.dialog,null);
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
//                    ivPoster.setImageResource(posterID[pos]);
//                    dlg.setTitle("큰 포스트");
//                    dlg.setView(dialogView);
//                    dlg.setNegativeButton("닫기" ,null);
//                    dlg.show();
//                }
//            });
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(
                            MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageview;
        }
    }

}
