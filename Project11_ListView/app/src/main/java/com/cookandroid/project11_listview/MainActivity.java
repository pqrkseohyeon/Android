package com.cookandroid.project11_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setTitle("리스트뷰 테스트");
//
//        // 리스트뷰에 나열할 내용을 String 배열로 미리 만들어 놓는다.
//        final  String[] mid = {"히어로즈","24시","로스트","로스트룸","스몰빌","탐정몽크",
//        "빅백이론","프렌즈","덱스터","글리","가쉽걸","테이큰","슈퍼내추럴","브이"};
//
//        //리스트뷰 변수를 생성하고 XML의 <ListView>에 대응시킨다.
//
//        ListView list = (ListView) findViewById(R.id.listView1);
//
//        //ArrayAdapter<String> 형의 변수를 선언
//        // 생성자의 두 번째 파라미터로 리스트뷰의 형식(simple_list_item_1)을 선택하고,
//        // 세 번째 파라미터에는 적용할 재열(mid)을 지정한다.
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_multiple_choice, mid);
//        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        list.setAdapter(adapter); // 생성한 어레이어댑터를 9행에서 접근한 list 변수에 적용
//
//        //리스트뷰의 항복을 클릭했을 때 동작하는 리스너를 정의
//        // 추상 메소드인 onItemClick()을 오버라이딩해야 하는데
//        // 파라미터는 어댑터뷰, 뷰, 클릭한 항목의 순번, 항목의 아이디 순이다.
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                Toast.makeText(getApplicationContext(),mid[arg2],Toast.LENGTH_SHORT).show();
//            }
//        });

        // 문자열 배열 대신 ArrayList<String> 형으로 비어 있는 변수를 선언
        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView) findViewById(R.id.listView1);

        // ArrayList<String> 형 변수 midList를 ArrayAdapter() 생성자의 맨 마지막 파라미터로 사용
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, midList);
        list.setAdapter(adapter);

        final EditText edtItem = (EditText) findViewById(R.id.edtItem);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add() 메소드로 midList에 에디트텍스트의 내용을 추가한다.
                // ArrayAdapter<String> 형 변수 adapter의 notifyDataSetChanged() 메소드를 호출하면 추가된 항목이 보인다.
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //롱클릭하면 remove() 메소드로 항목이 삭제되도록 리스트뷰의 setOnItemLongClickListener() 메소드를 이용
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}