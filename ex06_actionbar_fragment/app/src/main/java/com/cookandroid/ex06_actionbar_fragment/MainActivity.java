package com.cookandroid.ex06_actionbar_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    //1-멤버변수 ->
    // 1)탭 만들기 -> 액션바에 붙이고
    // 2)콘텐츠 만들기 -> 프레그먼트
    ActionBar.Tab tabSong, tabArtist, tabAlbum;

    //3-메소드
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar(); // 상단에 표시할 액션바 준비

        //탭호스트와 같이 탭의 모양을 가지도록 설정
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        tabSong = bar.newTab(); // 탭을 액션바에 생성
        tabSong.setText("음악별"); // 탭의 글자 설정
        tabSong.setTabListener(this); // 탭을 터치하면 작동하는 리스너 지정
        bar.addTab(tabSong); // 탭을 액션바에 추가가

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);

    }

    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    public void onTabSelected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if(myFrags[tab.getPosition()] == null){
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else // 기본에 만들어진 프레그먼트가 이미 있다. 프레그먼트 배열안에..
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    //4-내부(inner) 클래스
    // 프레그먼트 -> 콘텐츠
//    public static class MyTabFragment extends Fragment{
//        //멤버변수로 왜냐하면 view에서 써야한다.
//        String tabName;
//
//        // 1)프래그먼트 생성 메소드
//        @Override
//        public void onCreate(@Nullable Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            //안드로이드 운영체제(OS)와 통신하기 위해 연결
//            Bundle data = getArguments();
//            tabName = data.getString("tabName");
//        }
//
//        // 2)프래그먼트 안에 들어가는 뷰 생성 메소드
//        // 뷰를 만든다. 디자인 activity_main.xml과 같은역할
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            //레이아웃과 위젯들로 구성
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT);
//            //LinearLayout baseLayout = new LinearLayout(MainActivity.this); //생성자 매개변수 -> (위치->액티비티)
//            LinearLayout baseLayout = new LinearLayout(super.getActivity()); //생성자 매개변수 -> (위치->액티비티)
//            baseLayout.setOrientation(LinearLayout.VERTICAL);
//            baseLayout.setLayoutParams(params);
//
//            if(tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
//            if(tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN);
//            if(tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);
//
//            return baseLayout;
//        }
//    }

}