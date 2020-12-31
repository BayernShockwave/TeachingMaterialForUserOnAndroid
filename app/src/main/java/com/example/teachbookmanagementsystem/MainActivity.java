package com.example.teachbookmanagementsystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import Dao.UserDao;
import Entity.User;

public class MainActivity extends Activity {

    public Button uidClear;
    public Button upwdClear;
    public Button pwdSee;
    public Button loginButton;
    public Button forgetButton;
    public Button registerButton;
    public TextWatcher uidWachter;
    public TextWatcher upwdWachter;
    public EditText uid;
    public EditText upwd;
    public CheckBox trust;
    private final int SUBACTIVITY1 = 1 , SUBACTIVITY2 = 2 , SUBACTIVITY3 = 3;
    public String userid;
    public String userpwd;
    public boolean rs = true;
    public boolean diary = true;
    public String lastid;
    public String ipstring;
    public String datestring;
    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uidClear = (Button)findViewById(R.id.uidclear);
        upwdClear = (Button)findViewById(R.id.upwdclear);
        pwdSee = (Button)findViewById(R.id.pwdsee);
        uid = (EditText)findViewById(R.id.uid);
        upwd = (EditText)findViewById(R.id.upwd);
        trust = (CheckBox)findViewById(R.id.trust);
        loginButton = (Button)findViewById(R.id.login);
        forgetButton = (Button)findViewById(R.id.forget);
        registerButton = (Button)findViewById(R.id.register);
        uidClear.setOnClickListener(uidClearButtonListener);
        upwdClear.setOnClickListener(upwdClearButtonListener);
        //pwdSee.setOnClickListener(pwdSeeButtonListener);
        loginButton.setOnClickListener(loginButtonListener);
        forgetButton.setOnClickListener(forgetButtonListener);
        registerButton.setOnClickListener(registerButtonListener);
        pwdSee.setOnTouchListener(pwdSeeButtonListener);
        sharedPreferences = this.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        initTrust();
    }

    public void initTrust() {
        if (sharedPreferences.getBoolean("checkboxBoolean",false)) {
            uid.setText(sharedPreferences.getString("uid",null));
            upwd.setText(sharedPreferences.getString("upwd",null));
            trust.setChecked(true);
        }
    }

    public static String getPhoneIp() {
        try {
            for (Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements();) {
                NetworkInterface networkInterface = enumeration.nextElement();
                for (Enumeration<InetAddress> enumIpAddress = networkInterface.getInetAddresses(); enumIpAddress.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddress.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "127.0.0.1";
    }

    Button.OnClickListener loginButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            userid = uid.getText().toString();
            userpwd = upwd.getText().toString();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<User> userList = UserDao.allUsers();
                    for (User user : userList) {
                        //System.out.println("id" + user.getUserid());
                        //System.out.println("password" + user.getPassword());
                        //System.out.println("name" + user.getName());
                        //System.out.println("uni" + user.getUni());
                        if (userid.equals(user.getUserid()) && userpwd.equals(user.getPassword())) {
                            //System.out.println("success" + "登录成功");
                            //Toast.makeText(MainActivity.this,"登录成功!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,UserMainFrame.class);
                            startActivityForResult(intent,SUBACTIVITY1);
                        }
                        else {
                            diary = false;
                            rs = false;
                            //Toast.makeText(MainActivity.this,"登录失败!用户名或密码不正确!",Toast.LENGTH_SHORT).show();
                            //System.out.println("failed" + "登录失败");
                        }
                    }
                }
            }).start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean CheckBoxLogin = trust.isChecked();
            if (CheckBoxLogin) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("uid",userid);
                editor.putString("upwd",userpwd);
                editor.putBoolean("checkboxBoolean",true);
                editor.commit();
            }
            else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("uid",null);
                editor.putString("upwd",null);
                editor.putBoolean("checkboxBoolean",false);
                editor.commit();
            }
            //System.out.println("diary" + diary);
            //System.out.println("rs" + rs);

             if (rs == false) {
                Toast.makeText(MainActivity.this,"登录失败!用户名或密码不正确!",Toast.LENGTH_SHORT).show();
        }

            if (diary == true) {
                lastid = uid.getText().toString();
                System.out.println(lastid);
                ipstring = getPhoneIp();
                System.out.println(ipstring);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                datestring = simpleDateFormat.format(date);
                System.out.println(datestring);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i = UserDao.addDiary(lastid,ipstring,datestring);
                    }
                }).start();
            }
        }
    };

    Button.OnClickListener forgetButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,ForgetActivity.class);
            startActivityForResult(intent,SUBACTIVITY2);
        }
    };

    Button.OnClickListener registerButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivityForResult(intent,SUBACTIVITY3);
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
    }

    //Button.OnClickListener pwdSeeButtonListener  = new Button.OnClickListener() {
        //@Override
        //public void onClick(View v) {
            //upwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        //}
    //};

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
            return false;
        }
    };
}