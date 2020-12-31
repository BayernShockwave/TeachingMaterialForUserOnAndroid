package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Dao.InbuyDao;
import Entity.Inbuy;

public class ModifyInbuy extends AppCompatActivity {

    public EditText updateInbuyId;
    public EditText updateInbuyName;
    public TextView inbuyInfo;
    public Button confirmUpdate;
    public Button cancelUpdate;
    public String iid;
    public String iname;
    public int iprice;
    public Date itime;
    public int icount;
    public String iuni;
    public String updateInbuyInfo;
    private final int SUBACTIVITY1 = 1;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_inbuy);
        updateInbuyId = (EditText)findViewById(R.id.updateinbuyid);
        updateInbuyName = (EditText)findViewById(R.id.updateinbuyname);
        inbuyInfo = (TextView)findViewById(R.id.inbuyinfo);
        confirmUpdate = (Button)findViewById(R.id.confirmupdate);
        cancelUpdate = (Button)findViewById(R.id.cancelupdate);
        confirmUpdate.setOnClickListener(confirmUpdateButtonListener);
        cancelUpdate.setOnClickListener(cancelUpdateButtonListener);

        updateInbuyId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Inbuy> inbuyList = InbuyDao.selectInbuyById(updateInbuyId.getText().toString());
                        for (Inbuy inbuy : inbuyList) {
                            iid = inbuy.getId();
                            iname = inbuy.getName();
                            iprice = inbuy.getPrice();
                            itime = inbuy.getIntime();
                            icount = inbuy.getCount();
                            iuni = inbuy.getUni();
                            updateInbuyInfo = "订单编号:" + iid + "\t" + "教材名称:" + iname + "\t" + "教材单价:" + iprice + "\t" + "购入时间:" + itime + "\t" + "购入数量:" + icount + "\t" + "购入学校:" + iuni;
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                };
                inbuyInfo.setText(updateInbuyInfo);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmUpdateButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ModifyInbuy.this);
            builder.setTitle("是否确认修改");
            builder.setMessage("您是否确认要修改" + iname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ModifyInbuy.this,ModifyInbuyResult.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("id",iid);
                            bundle.putString("name",iname);
                            bundle.putString("price",String.valueOf(iprice));
                            bundle.putString("time",simpleDateFormat.format(itime));
                            bundle.putString("count",String.valueOf(icount));
                            bundle.putString("uni",iuni);
                            intent.putExtras(bundle);
                            startActivityForResult(intent,SUBACTIVITY1);
                        }
                    }).start();
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

    Button.OnClickListener cancelUpdateButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateInbuyId.setText("");
            updateInbuyName.setText("");
            inbuyInfo.setText("");
        }
    };
}
