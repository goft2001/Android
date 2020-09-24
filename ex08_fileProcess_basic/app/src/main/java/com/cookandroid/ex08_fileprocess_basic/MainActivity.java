package com.cookandroid.ex08_fileprocess_basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,
                new String[] {
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MODE_PRIVATE);

        Button btnRead;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);

        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    FileInputStream inFs = new FileInputStream( "/storage/emulated/0/sd_card.txt");

                    byte[] txt = new byte[inFs.available()];
                    android.util.Log.i("a", "12123"+txt);
                    inFs.read(txt);                    edtSD.setText(new String(txt));
                    inFs.close();
                } catch (IOException e) {
                }
            }
        });

        //2.디렉토리 (sd카드)


        Button btnMkdir, btnRmdir;
        btnMkdir = (Button) findViewById(R.id.btnMkdir);
        btnRmdir = (Button) findViewById(R.id.btnRmdir);

        final String strSDpath = Environment.getExternalStorageDirectory()
                .getAbsolutePath();



        final File myDir = new File(strSDpath + "/mydir");

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                android.util.Log.i("a", "1111111->"+strSDpath);
                myDir.mkdir();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myDir.delete();
            }
        });

        //3.파일 목록 (sd 카드)
        Button btnFilelist;
        final EditText edtFilelist;
        btnFilelist = (Button) findViewById(R.id.btnFilelist);
        edtFilelist = (EditText) findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sysDir = Environment.getRootDirectory()
                        .getAbsolutePath();
                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;
                for (int i = 0; i < sysFiles.length; i++) {
                    if (sysFiles[i].isDirectory() == true)
                        strFname = "<폴더> " + sysFiles[i].toString();
                    else
                        strFname = "<파일> " + sysFiles[i].toString();

                    edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
                }
            }
        });


    }

}
