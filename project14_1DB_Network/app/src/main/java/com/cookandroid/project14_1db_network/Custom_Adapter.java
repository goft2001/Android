package com.cookandroid.project14_1db_network;



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

import com.cookandroid.project14_1db_network.Network.NetworkDelete;
import com.cookandroid.project14_1db_network.Network.NetworkUpdate;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {

    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<UserInfo> mUserInfoObjArr;
    int mListLayout;
    private Custom_Adapter adapter;

    public Custom_Adapter(Activity a, int listLayout, ArrayList<UserInfo> userInfoObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mUserInfoObjArr = userInfoObjArrayListT;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if(view==null)
            view = mInflater.inflate(mListLayout,viewGroup,false);

        final TextView tvID = view.findViewById(R.id.tv_id);
        final TextView tvName = view.findViewById(R.id.tv_name);
        final TextView tvPhone = view.findViewById(R.id.tv_phone);
        final TextView tvGrade = view.findViewById(R.id.tv_grade);
        final TextView tvWriteTime = view.findViewById(R.id.tv_write_time);


        tvID.setText(mUserInfoObjArr.get(i).id);
        tvName.setText(mUserInfoObjArr.get(i).name);
        tvPhone.setText(mUserInfoObjArr.get(i).phone);
        tvGrade.setText(mUserInfoObjArr.get(i).grade);
        tvWriteTime.setText(mUserInfoObjArr.get(i).writeTime);

        Button updateButton = view.findViewById(R.id.btn_Update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View v1 = mAct.getLayoutInflater().inflate(R.layout.dialog_add, null);
                final EditText edt1, edt2, edt3, edt4;
                edt1 = (EditText) v1.findViewById(R.id.edtID);
                edt2 = (EditText) v1.findViewById(R.id.edtNAME);
                edt3 = (EditText) v1.findViewById(R.id.edtPhone);
                edt4 = (EditText) v1.findViewById(R.id.edtGrade);

                edt1.setText(tvID.getText().toString());
                edt2.setText(tvName.getText().toString());
                edt3.setText(tvPhone.getText().toString());
                edt4.setText(tvGrade.getText().toString());

                edt1.setFocusable(false);

                new AlertDialog.Builder(mAct)
                        .setTitle("수정")
                        .setView(v1)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String id = edt1.getText().toString();
                                String name = edt2.getText().toString();
                                String phone = edt3.getText().toString();
                                String grade = edt4.getText().toString();

                                new NetworkUpdate(Custom_Adapter.this).execute(id,name,phone,grade);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();

                // new NetworkUpdate(Custom_Adapter.this).execute(id,name,phone,grade);

            }
        });
        Button deleteButton = view.findViewById(R.id.btn_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = tvID.getText().toString();
                AlertDialog.Builder ad = new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID: "+userID+"를(을) 정말 삭제하시겠습니까");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        new NetworkDelete(Custom_Adapter.this).execute(tvID.getText().toString());
                    }
                });

                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(mAct, "취소하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });


        return view;
    }
}
