package com.cookandroid.clientnetdb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.clientnetdb.Network.NetworkDelete;
import com.cookandroid.clientnetdb.Network.NetworkUpdate;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<UserInfo> mUserInfoObjArr;
    int mListLayout;

    public Custom_Adapter(Activity a, int listLayout, ArrayList<UserInfo> UserInfoObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mUserInfoObjArr = UserInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<UserInfo> arrayList){
        mUserInfoObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mUserInfoObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mUserInfoObjArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = mInflater.inflate(mListLayout, viewGroup, false);

        final TextView tvID = (TextView) view.findViewById(R.id.tv_id);
        tvID.setText(mUserInfoObjArr.get(i).id);

        final TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(mUserInfoObjArr.get(i).name);

        final TextView tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvPhone.setText(mUserInfoObjArr.get(i).phone);

        final TextView tvGrade = (TextView) view.findViewById(R.id.tv_grade);
        tvGrade.setText(mUserInfoObjArr.get(i).grade);

        final TextView tvWriteTime = (TextView) view.findViewById(R.id.tv_write_time);
        tvWriteTime.setText(mUserInfoObjArr.get(i).writeTime);

        Button updateButton = (Button) view.findViewById(R.id.btn_Update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = mAct.getLayoutInflater().inflate(R.layout.dialog_update,null);
                EditText edtID = v.findViewById(R.id.edtID2);
                EditText edtName = v.findViewById(R.id.edtNAME);
                EditText edtPhone = v.findViewById(R.id.edtPhone);
                EditText edtGrade = v.findViewById(R.id.edtGrade);

                edtID.setText(tvID.getText().toString());
                edtName.setText(tvName.getText().toString());
                edtPhone.setText(tvPhone.getText().toString());
                edtGrade.setText(tvGrade.getText().toString());

                edtID.setFocusable(false);

                new AlertDialog.Builder((Context) mAct)
                        .setTitle("멤버 수정")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String id = tvID.getText().toString();
                                String name = ((EditText)v.findViewById(R.id.edtNAME)).getText().toString();
                                String phone = ((EditText)v.findViewById(R.id.edtPhone)).getText().toString();
                                String grade = ((EditText)v.findViewById(R.id.edtGrade)).getText().toString();

                                new NetworkUpdate(Custom_Adapter.this).execute(id,name,phone,grade);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false).show();

            }
        });



        Button deleteBUtton = (Button) view.findViewById(R.id.btn_delete);
        deleteBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = tvID.getText().toString();
                AlertDialog.Builder ad = new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID: "+userID+"를(을) 정말 삭제하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        new NetworkDelete(Custom_Adapter.this).execute(tvID.getText().toString());
                    }
                });
                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(mAct,"취소하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });
        return view;
    }
}
