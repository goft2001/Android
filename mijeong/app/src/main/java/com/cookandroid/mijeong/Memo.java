package com.cookandroid.mijeong;
public class Memo {
    String title = "";
    String memo = "";

    Memo(){}
    Memo(String title, String memo){
        this.title = title;
        this.memo = memo;
    }

    void setMemo(String title, String memo){
        this.title = title;
        this.memo = memo;
    }
}