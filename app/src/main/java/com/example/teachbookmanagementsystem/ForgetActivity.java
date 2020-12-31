package com.example.teachbookmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import Dao.EmailDao;

public class ForgetActivity extends Activity {

    public EditText userid;
    public EditText useremail;
    public EditText username;
    public Button send;
    public Button clean;
    public String id;
    public String email;
    public String request = "找回密码";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);
        userid = (EditText)findViewById(R.id.uid);
        useremail = (EditText)findViewById(R.id.uem);
        username = (EditText)findViewById(R.id.uname);
        send = (Button)findViewById(R.id.sendemail);
        clean = (Button)findViewById(R.id.clean);
        send.setOnClickListener(sendButtonListener);
        clean.setOnClickListener(cleanButtonListener);
    }

    Button.OnClickListener sendButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            id = userid.getText().toString();
            email = useremail.getText().toString();
            //System.out.println(id);
            //System.out.println(email);
            //System.out.println(request);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = EmailDao.addRequest(id,email,request);
                }
            }).start();
        }
    };

    Button.OnClickListener cleanButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            userid.setText("");
            useremail.setText("");
            username.setText("");
        }
    };
}
