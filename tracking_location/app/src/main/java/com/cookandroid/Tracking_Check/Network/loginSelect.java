package com.cookandroid.Tracking_Check.Network;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.cookandroid.Tracking_Check.MapsActivity;
import com.cookandroid.Tracking_Check.UserInfo;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class loginSelect extends AsyncTask<String,Void,String> {
    Activity act;

    private URL Url;
    private String URL_Adress = "http://10.100.206.37:9999/trackingMember/loginDB_select.jsp";

    public loginSelect(Activity act) {
        this.act = act;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";

        try {
            Url = new URL(URL_Adress);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            //전송 모드 설정
            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            //content-type 설정
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&pwd").append("=").append(strings[1]);


            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line + "\n");
            }
            res = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Get result", res);
        return res;




    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        Log.i("get :",s);

        ArrayList<UserInfo> userList = new ArrayList<UserInfo>(); // 데이터 받을 곳

        int res = 0;
        try{
            res = JsonParser.getUserInfoJson(s, userList);
        } catch (JSONException e){
            e.printStackTrace();
        }

        if(res==0){
            Toast.makeText(act, "로그인 실패", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(act, "로그인 성공", Toast.LENGTH_SHORT).show();
             Intent in = new Intent(act,  MapsActivity.class);
             act.startActivity(in);

        }

    }

}