package com.cookandroid.ch14_google_map.Network;

import com.cookandroid.ch14_google_map.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    static public int getUserInfoJson(String res, ArrayList<UserInfo> userList) throws JSONException{
        String strID;
        String strName;
        String strPhone;
        String strpwd;

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

            if(jsonObj.getString("PWD").toString().equals("null")) {
                strpwd = "-";
            }  else {
                strpwd = jsonObj.getString("PHONE").toString();
            }
            userList.add(new UserInfo(strName,strID,strPhone,strpwd));
        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}