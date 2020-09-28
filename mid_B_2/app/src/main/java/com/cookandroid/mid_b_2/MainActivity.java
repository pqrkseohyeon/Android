package com.cookandroid.mid_b_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String wants="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("mid_B_2");

        final EditText edit1=(EditText) findViewById(R.id.edit1);
        final EditText edit2=(EditText) findViewById(R.id.edit2);
        final EditText edit3=(EditText) findViewById(R.id.edit3);
        final EditText edit4=(EditText) findViewById(R.id.edit4);
        final EditText edit5=(EditText) findViewById(R.id.edit5);

        final Button btn1=(Button) findViewById(R.id.btn1);

        Spinner spin1=(Spinner) findViewById(R.id.spinner);
        final CheckBox ch1=(CheckBox) findViewById(R.id.ch1);
        final CheckBox ch2=(CheckBox) findViewById(R.id.ch2);
        final CheckBox ch3=(CheckBox) findViewById(R.id.ch3);
        final CheckBox ch4=(CheckBox) findViewById(R.id.ch4);

        final TextView tv1=(TextView) findViewById(R.id.tv1);
        final TextView tv2=(TextView) findViewById(R.id.tv2);
        final TextView tv3=(TextView) findViewById(R.id.tv3);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(
                this,R.array.wants_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wants = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch1.isChecked()){
                    edit2.setFocusableInTouchMode(true);

                }else {
                    edit2.setFocusable(false);
                    edit2.setText("");
                }
            }
        });

        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch2.isChecked()){
                    edit3.setFocusableInTouchMode(true);

                }else {
                    edit3.setFocusable(false);
                    edit3.setText("");
                }
            }
        });
        ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch3.isChecked()){
                    edit4.setFocusableInTouchMode(true);

                }else {
                    edit4.setFocusable(false);
                    edit4.setText("");
                }
            }
        });
        ch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch4.isChecked()){
                    edit5.setFocusableInTouchMode(true);

                }else {
                    edit5.setFocusable(false);
                    edit5.setText("");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(v.getWindowToken(),0);

                ArrayList<Integer> m10=new ArrayList<Integer>();

                int a0=0;//잠자기

                int a1=0;
                int a2=0;
                int a3=0;
                int a4=0;

                int sum=0;

                if(edit1.getText().toString().equals("")) {
                    tv1.setText("1.나는 ?시간 잠을 잡니다.");
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("수면시간")
                            .setView(getLayoutInflater().inflate(R.layout.cus,null))
                            .show();
                }else{
                    String s0=edit1.getText().toString();
                    a0=Integer.parseInt(s0);
                    tv1.setText("1.나는"+a0+"시간 잠을 잡니다!");
                }
                if(ch1.isChecked()&& !edit2.getText().toString().equals("")) {
                    String s1 = edit2.getText().toString();
                    a1 = Integer.parseInt(s1);
                    m10.add(R.drawable.programming);
                }else
                    a1=0;
                if(ch2.isChecked()&& !edit3.getText().toString().equals("")) {
                    String s2 = edit3.getText().toString();
                    a2 = Integer.parseInt(s2);
                    m10.add(R.drawable.book_reading);
                }else
                    a2=0;
                if(ch3.isChecked()&& !edit4.getText().toString().equals("")) {
                    String s3 = edit4.getText().toString();
                    a3 = Integer.parseInt(s3);
                    m10.add(R.drawable.engligh_study);
                }else
                    a3=0;
                if(ch4.isChecked()&& !edit5.getText().toString().equals("")) {
                    String s4 = edit5.getText().toString();
                    a4 = Integer.parseInt(s4);
                    m10.add(R.drawable.work_out);
                }else
                    a4=0;

                sum=a1+a2+a3+a4;

                tv2.setText("2.나는 꿈을 위해 "+sum+"시간 투자합니다");
                tv3.setText("3.나의 이상형은 "+wants+"입니다");

                GridView gv1=(GridView) findViewById(R.id.gridView);
                gv1.setAdapter(new ImageAdapter(MainActivity.this,m10));
            }
        });

    }
}