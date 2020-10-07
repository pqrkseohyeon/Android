package com.cookandroid.project12_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 1. DB 헬퍼 -> DDL -> 정의(Create, Drop, Alter) - Definition
    MyDBHelper myHelper; // 새로 생성한 myDBHelper 클래스 변수
    EditText edtName, edtNumber, edtNameResult, edtNumberResult; // 에디트텍스트에 대응할 변수 4개
    Button btnInit, btnInsert, btnSelect, btnUpdate, btnDelete; // 버튼에 대응할 변수 3개
    //2. LiteDB 클래스 -> 조작(DML) -> select, insert,update,delete -> Manipulation
    SQLiteDatabase sqlDB; //SQLiteDatabase  클래스 변수

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        //myDBHelper 인스턴스를 생성한다. 이때 myDBHelper() 생성자가 실행되어 groupDB 파일이 생성된다.
        // 이 줄에서, 객체가 만들어지면, 1.DB만들고, 2.테이블을 만든다!
        myHelper = new MyDBHelper(this);

        //이벤트1 -> 초기화
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //헬퍼 객체에서 -> DB
                sqlDB = myHelper.getWritableDatabase(); // 쓰기용 데이터베이스로 연다
                //onUpgrade() 메소드를 호출한다. groupTBL 테이블이 있으면 삭제한 후 새로 생성한다.
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close(); // DB 닫는다
            }
        });

        //이벤트2 -> 입력(insert) 입력을 클릭하면 값이 입력되는 리스너
        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); // groupDB를 쓰기용으로 연다.

                //에디트텍스트의 값으로 Insert문을 생성한 다음 execSQL() 메소드로 실행한다.
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + edtName.getText().toString() + "' , "
                        + edtNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show(); // 입력이 성공하면 토스트 메시지를 보여준다.
            }
        });

        //이벤트3 -> 수정(update) -> 특징:execSQL()메소드를 사용한다.
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                sqlDB = myHelper.getWritableDatabase();

                String query = "";
                query = " update ";
                query += "       groupTBL ";
                query += " set ";
                query += "       gNumber = " + edtNumber.getText().toString();
                query += " where ";
                query += "       gName = '" + edtName.getText().toString() + "';";


                sqlDB.execSQL(query);

//                if (edtName.getText().toString() != "") {
//                        sqlDB.execSQL("UPDATE groupTBL SET gNumber ="
//                            + edtNumber.getText() + " WHERE gName = '"
//                            + edtName.getText().toString() + "';");
//                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "수정됨",
                        Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });


        // 이벤트4 -> 삭제(delete)
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (edtName.getText().toString() != "") {
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"
                            + edtName.getText().toString() + "';");

                }
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "삭제됨",
                        Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });


        // 이벤트5 -> 조회(select)
        //특징1:
        //특징2:
        //조회를 클릭할 때, 테이블에 입력된 내용이 모두 아래쪽 에디트텍스트에 출력되는 리스너
        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();

                //커서를 선언, 모든 테이블을 조회한 후 커서에 대입한다.
                // 즉, 테이블에 입력된 모든 행 테이터가 커서 변수에 들어 있는 상태가 되며, 현재는 첫 번째 행을 가리키고 있다.
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                //에디트텍스트의 헤더에 출력될 내용을 미리 변수에 넣는다. "\r\n"은 행을 넘겨서 다음 행에 출력
                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                // 행 데이터의 개수만큼 반복
                while (cursor.moveToNext()) { // moveToNext() 메소드는 커서 변수의 다음 행으로 넘어간다. 다음 행 없으면 false 반환하여 while문 끝남

                    //getString(열 번호)는 현재 커서의 열 번호 데이터 값을 반환하여 문자열 변수에 계속 누적한다.
                    strNames += cursor.getString(0) + "\r\n"; //0번째 열(그룹 이름 열)
                    strNumbers += cursor.getString(1) + "\r\n"; // 1번째 열(인원)
                }

                //누적한 문자열을 에디트텍스트에 출력, 각 열의 데이터가 한 행씩 넘어가면서 보인다.
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                //커서와 DB를 닫는다.
                cursor.close();
                sqlDB.close();
            }
        });
    }
    // 우선 onCreate() 메소드 밖에 SQLiteOpenHelper  클래스에서 상속받은 클래스를 정의한 수 생성자를 수정한다.
    // SQLiteOpenHelper 클래스를 상속받은 myDBHelper를 정의한다.
    public class MyDBHelper extends SQLiteOpenHelper {

        //1. 생성자 -> 액티비티(context) 받아서, <DB이름> 설정
        public MyDBHelper(Context context) { // 생성자를 정의,
            //super()의 두번째 파라미터에는 새로 생성될 데이터베이스의 파일명을 지정하면 된다.
            // 마지막 파라미터는 데이터베이스 버전으로 처음에는 1을 지정한다.
            super(context, "groupDB", null, 1);
        }

        //추상 메소드를 오버라이딩(자동 완성)
        // 테이블을 생성하는 SQL문은 SQLiteDatabase 클래스의 execSQL() 메소드로 실행한다.
        // onUpgrade() 에서 호출되거나 데이터를 입력할 때 혹은 테이블이 없을 때 처음 1회 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) { //2. 테이블 생성(DB이름 아님!)
            // PRIMARY KEY 구문은 gNAME  열을 기본 키로 지정하겠다는 의미, 이렇게 지정하면 그룹 이름을 반드시 입력해야 하며, 같은 그룹 이름을 입력할 수도 없다.
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        // 테이블을 삭제하고 새로 생성한다. 초기화할 때 호출한다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");//일단 삭제 후
            onCreate(db); //생성(create table...)
        }
    }
}
