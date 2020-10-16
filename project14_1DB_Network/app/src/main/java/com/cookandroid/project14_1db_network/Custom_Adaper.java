package com.cookandroid.project14_1db_network;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.project14_1db_network.Network.NetworkDelete;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Custom_Adaper extends BaseAdapter {
    private Activity mAct;
  LayoutInflater mInflator;
  ArrayList<UserInfo> mUserInfoObjArr;
  int mListLayout;

    public Custom_Adaper(Activity a, int listLayout, ArrayList<UserInfo> userInfoObjArrayListT) {
        mAct = a;
        mListLayout = listLayout;
        mUserInfoObjArr = userInfoObjArrayListT;
        mInflator = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            view=mInflator.inflate(mListLayout,viewGroup,false);
        final TextView tvID = (TextView)view.findViewById(R.id.tv_id);
        tvID.setText(mUserInfoObjArr.get(i).id);
        final TextView tvName = (TextView)view.findViewById(R.id.tv_name);
        tvName.setText(mUserInfoObjArr.get(i).name);
        final TextView tvPhone =(TextView)view.findViewById(R.id.tv_phone);
        tvPhone.setText(mUserInfoObjArr.get(i).phone);
        final TextView tvGrade = (TextView)view.findViewById(R.id.tv_grade);
        tvGrade.setText(mUserInfoObjArr.get(i).grade);
        final TextView tvWriteTime = (TextView)view.findViewById(R.id.tv_write_time);
        tvWriteTime.setText(mUserInfoObjArr.get(i).writeTime);

        Button updateButton = (Button)view.findViewById(R.id.btnUpdate);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button deleteButton = (Button)view.findViewById(R.id.btn_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = tvID.getText().toString();
                AlertDialog.Builder ad =new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID : " + userid + "를(을) 정말 삭제하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       new NetworkDelete(Custom_Adaper.this).execute(tvID.getText().toString());
                    }
                });

                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mAct,"취소하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        return view;
    }
}
