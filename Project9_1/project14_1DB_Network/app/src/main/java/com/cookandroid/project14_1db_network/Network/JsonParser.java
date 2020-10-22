package com.cookandroid.project14_1db_network.Network;

import com.cookandroid.project14_1db_network.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    static public int getUserInfoJson(String res, ArrayList<UserInfo> userList) throws JSONException{
        String strID;
        String strName;
        String strPhone;
        String strGrade;
        String strWriteTime;

        JSONObject rootJSON = new JSONObject(res);//josn형태의 스트링을 -> 객체로 변환해서 담기
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for (int i=0; i<jsonArray.length();i++) {
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);
            if (jsonObj.getString("ID").toString().equals("null")) {
                strID = "-";
            } else {
                strID = jsonObj.getString("ID").toString();
            }
            if (jsonObj.getString("NAME").toString().equals("null")) {
                strName = "-";
            } else {
                strName = jsonObj.getString("NAME").toString();
            }
            if (jsonObj.getString("PHONE").toString().equals("null")) {
                strPhone = "-";
            } else{
                strPhone = jsonObj.getString("PHONE").toString();
            }
            if(jsonObj.getString("GRADE").toString().equals("null")) {
                strGrade = "-";
            } else {
                strGrade = jsonObj.getString("GRADE").toString();
            }
            if(jsonObj.getString("WRITE_TIME").toString().equals("null")) {
                strWriteTime = "-";
            }  else {
                strWriteTime = jsonObj.getString("WRITE_TIME").toString();
                String temp[] = strWriteTime.split(" ");
                strWriteTime = temp[0] + "\n" + temp[1];
            }
            userList.add(new UserInfo(strID,strName,strPhone,strGrade,strWriteTime));
        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}