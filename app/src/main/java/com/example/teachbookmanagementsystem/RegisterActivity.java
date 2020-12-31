package com.example.teachbookmanagementsystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import Dao.UserDao;

public class RegisterActivity extends Activity {

    public EditText uid;
    public EditText upwd;
    public EditText usecondpwd;
    public Spinner uuni;
    public EditText uname;
    public Button add;
    public Button pwdsee;
    public Button secondpwdsee;
    public Button uidClear;
    public Button upwdClear;
    public Button usecondpwdClear;
    public Button unameClear;
    public TextWatcher uidWachter;
    public TextWatcher upwdWachter;
    public TextWatcher usecondpwdWachter;
    public TextWatcher unameWachter;
    private final int SUBACTIVITY1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        uid = (EditText)findViewById(R.id.uid);
        upwd = (EditText)findViewById(R.id.upwd);
        usecondpwd = (EditText)findViewById(R.id.usecondpwd);
        uuni = (Spinner)findViewById(R.id.uuni);
        uname = (EditText)findViewById(R.id.uname);
        add = (Button)findViewById(R.id.adduser);
        pwdsee = (Button)findViewById(R.id.pwdsee);
        secondpwdsee = (Button)findViewById(R.id.secondpwdsee);
        uidClear = (Button)findViewById(R.id.uidclear);
        upwdClear = (Button)findViewById(R.id.upwdclear);
        usecondpwdClear = (Button)findViewById(R.id.usecondpwdclear);
        unameClear = (Button)findViewById(R.id.unameclear);
        add.setOnClickListener(addUserButtonListener);
        pwdsee.setOnTouchListener(pwdSeeButtonListener);
        secondpwdsee.setOnTouchListener(pwdSeeButtonListener);
        uidClear.setOnClickListener(uidClearButtonListener);
        upwdClear.setOnClickListener(upwdClearButtonListener);
        usecondpwdClear.setOnClickListener(usecondpwdClearButtonListener);
        unameClear.setOnClickListener(unameClearButtonListener);
    }

    Button.OnTouchListener pwdSeeButtonListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            //int vis = pwdSee.getInputType();
            if (v.getId() == R.id.pwdsee) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //System.out.println("dc");
                    upwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //System.out.println("sz");
                    upwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
            else if (v.getId() == R.id.secondpwdsee) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //System.out.println("dc");
                    usecondpwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //System.out.println("sz");
                    usecondpwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
            return false;
        }
    };

    Button.OnClickListener uidClearButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            uid.setText("");
            upwd.setText("");
            initWatcher();
            uid.addTextChangedListener(uidWachter);
        }
    };

    Button.OnClickListener upwdClearButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            upwd.setText("");
            initWatcher();
            upwd.addTextChangedListener(upwdWachter);
        }
    };

    Button.OnClickListener usecondpwdClearButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            usecondpwd.setText("");
            initWatcher();
            usecondpwd.addTextChangedListener(usecondpwdWachter);
        }
    };

    Button.OnClickListener unameClearButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            uname.setText("");
            initWatcher();
            uname.addTextChangedListener(unameWachter);
        }
    };

    private void initWatcher() {
        uidWachter = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    uidClear.setVisibility(View.VISIBLE);
                }
                else {
                    uidClear.setVisibility(View.INVISIBLE);
                }
            }
        };

        upwdWachter = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    upwdClear.setVisibility(View.VISIBLE);
                }
                else {
                    upwdClear.setVisibility(View.INVISIBLE);
                }
            }
        };

        usecondpwdWachter = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    usecondpwdClear.setVisibility(View.VISIBLE);
                }
                else {
                    usecondpwdClear.setVisibility(View.INVISIBLE);
                }
            }
        };

        unameWachter = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    unameClear.setVisibility(View.VISIBLE);
                }
                else {
                    unameClear.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    Button.OnClickListener addUserButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String struid = uid.getText().toString();
            final String strupwd = upwd.getText().toString();
            String strusecondpwd = usecondpwd.getText().toString();
            final String struni = uuni.getSelectedItem().toString();
            final String struname = uname.getText().toString();
            //System.out.println(struid);
            //System.out.println(strupwd);
            //System.out.println(strusecondpwd);
            //System.out.println(struni);
            //System.out.println(struname);
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("注册结果反馈");
            if (strupwd.equals(strusecondpwd)) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i = UserDao.addUser(struid,strupwd,struname,struni);
                    }
                }).start();
                builder.setMessage("注册成功!欢迎" + struname + "!");
            }
            else {
                builder.setMessage("注册失败!两次输入密码不一致!");
            }
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivityForResult(intent,SUBACTIVITY1);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
    };
}