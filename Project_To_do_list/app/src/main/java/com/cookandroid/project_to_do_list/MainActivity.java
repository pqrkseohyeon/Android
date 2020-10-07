package com.cookandroid.project_to_do_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String fileName;
    TextView todoTv;

    Button insertButton;
    EditText todoEdit;
    private ArrayList<Todo> todoArrayList;
    private TodoAdapter todoAdapter; // 어댑터를 사용하기 위해 정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoTv = (TextView) findViewById(R.id.textview_todo_item);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler1);

        // 리사이클러뷰에 LinearLayoutManager 객체 지정
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 상하로 움직이는 리사이클러뷰, 반드시 지정해야 함

        // 리사이클러뷰에 TodoAdapter 객체 지정.
        todoArrayList = new ArrayList<>();
        todoAdapter = new TodoAdapter(todoArrayList); // 어뎁터 안에 ArrayList 넣기
        recyclerView.setAdapter(todoAdapter); // 어뎁터를 셋팅

        insertButton = (Button) findViewById(R.id.button_insert_main);
        todoEdit = (EditText) findViewById(R.id.edit_todo_main);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo newTodo = new Todo(todoEdit.getText().toString()); // 입력한 문자열로 Todo 객체 생성
                todoArrayList.add(newTodo); // 생성한 객체를 ArrayList<Todo> 타입의 TodoArrayList에 추가
                todoAdapter.notifyDataSetChanged(); // 어뎁터에게 데이터 셋이 변경되었음을 알린다.
                todoEdit.setText(null);
            }
        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    String filename = "first";
//                    FileOutputStream outFs = openFileOutput(fileName,
//                            Context.MODE_PRIVATE);
//                    String str = todoEdit.getText().toString();
//                    outFs.write(str.getBytes());
//                    outFs.close();
//                    Toast.makeText(getApplicationContext(),
//                            fileName + " 이 저장됨", Toast.LENGTH_LONG).show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//
//            }
//        });


    }
    public void InternalStorageSave(View view){
        internalStorageSavefile();
    }

    public void internalStorageSavefile(){
        String filename = "first";
        String string = todoEdit.getText().toString();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write((string.getBytes()));
            outputStream.close();

            Toast.makeText(this, "파일 저장 성공!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(this, "파일 저장 실패!", Toast.LENGTH_LONG).show();
        }
    }



}