package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import Dao.InbuyDao;

public class ModifyInbuyResult extends AppCompatActivity {

    public String iupid;
    public String iupname;
    public int iupprice;
    public Date iuptime;
    public int iupcount;
    public String iupuni;
    public String iid;
    public String iname;
    public int iprice;
    public String itime;
    public int icount;
    public String iuni;
    public EditText upid;
    public EditText upname;
    public EditText upprice;
    public EditText uptime;
    public EditText upcount;
    public EditText upuni;
    public Button confirmup;
    public Button cancelup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_inbuy_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        iid = bundle.getString("id");
        iname = bundle.getString("name");
        iprice = bundle.getInt("price");
        itime = bundle.getString("time");
        icount = bundle.getInt("count");
        iuni = bundle.getString("uni");
        upid = (EditText) findViewById(R.id.upinbuyid);
        upname = (EditText) findViewById(R.id.upinbuyname);
        upprice = (EditText) findViewById(R.id.upinbuyprice);
        uptime = (EditText) findViewById(R.id.upinbuytime);
        upcount = (EditText) findViewById(R.id.upinbuycount);
        confirmup = (Button)findViewById(R.id.confirmup);
        cancelup = (Button)findViewById(R.id.cancelup);
        upid.setText(iid);
        upname.setText(iname);
        upprice.setText(String.valueOf(iprice));
        uptime.setText(itime);
        upcount.setText(String.valueOf(icount));
        confirmup.setOnClickListener(confirmUpButtonListener);
        cancelup.setOnClickListener(cancelUpButtonListener);

        upid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                iupid = upid.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                iupname = upname.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    iprice = Integer.valueOf(upprice.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        uptime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itime = uptime.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upcount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    icount = Integer.valueOf(upcount.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(iupid);
                    //System.out.println(iupname);
                    //System.out.println(iprice);
                    //System.out.println(itime);
                    //System.out.println(icount);
                    //System.out.println(iuni);
                    int i = InbuyDao.updateInbuy(iupid,iupname,iprice,itime,icount,iuni);
                }
            }).start();
        }
    };

    Button.OnClickListener cancelUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            upid.setText(iid);
            upname.setText(iname);
            upprice.setText(String.valueOf(iprice));
            uptime.setText(itime);
            upcount.setText(String.valueOf(icount));
        }
    };
}
