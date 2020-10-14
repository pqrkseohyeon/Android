package com.cookandroid.clientnetdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Button refreshBtn, addBtn;
    private ListView listView;
    //private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

    }


}