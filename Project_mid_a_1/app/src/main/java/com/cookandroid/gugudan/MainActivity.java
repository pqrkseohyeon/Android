package com.cookandroid.gugudan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1=(EditText) findViewById(R.id.edt1);
        final EditText edt2=(EditText) findViewById(R.id.edt2);
        final EditText edt3=(EditText) findViewById(R.id.edt3);

        final ListView list1=(ListView) findViewById(R.id.list1);

        Button btnRandom=(Button) findViewById(R.id.btnRandom);
        Button btnOK=(Button) findViewById(R.id.btnOK);

        btnRandom.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int rand1=new Random().nextInt(8)*2;
                int rand2=new Random().nextInt(8)*2;
                edt1.setText(String.valueOf(rand1));
                edt2.setText(String.valueOf(rand2));
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String str1=edt1.getText().toString();
                String str2=edt2.getText().toString();
                String str3=edt3.getText().toString();
                int a1=Integer.parseInt(str1);
                int a2=Integer.parseInt(str2);
                int a3=Integer.parseInt(str3);
                int a4=a1*a2;

                if(a3==a4){
                    Toast.makeText(MainActivity.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"틀렸습니다!", Toast.LENGTH_SHORT).show();
                    String[] values=new String[9];
                    for(int i=0;i<9;i++){
                        values[i]=String.valueOf(a1)+"X"+(i+1)+"="+(a1*(i+1));
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, values);
                    list1.setAdapter(adapter);
                }

            }
        });


    }
}