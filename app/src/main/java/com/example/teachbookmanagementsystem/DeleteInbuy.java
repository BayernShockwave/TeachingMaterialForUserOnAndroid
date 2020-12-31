package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import Dao.InbuyDao;
import Entity.Inbuy;

public class DeleteInbuy extends AppCompatActivity {

    public EditText deleteIbId;
    public EditText deleteIbName;
    public TextView ibInfo;
    public Button confirmDelete;
    public Button cancelDelete;
    public String iid;
    public String iname;
    public int iprice;
    public Date itime;
    public int icount;
    public String iuni;
    public String deleteIbInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_inbuy);
        deleteIbId = (EditText)findViewById(R.id.deleteinbuyid);
        deleteIbName = (EditText)findViewById(R.id.deleteinbuyname);
        ibInfo = (TextView)findViewById(R.id.inbuyinfo);
        confirmDelete = (Button)findViewById(R.id.confirmdelete);
        cancelDelete = (Button)findViewById(R.id.canceldelete);
        confirmDelete.setOnClickListener(confirmDeleteButtonListener);
        cancelDelete.setOnClickListener(cancelDeleteButtonListener);

        deleteIbId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, final int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Inbuy> inbuyList = InbuyDao.selectInbuyById(deleteIbId.getText().toString());
                        for (Inbuy inbuy : inbuyList) {
                            iid = inbuy.getId();
                            iname = inbuy.getName();
                            iprice = inbuy.getPrice();
                            itime = inbuy.getIntime();
                            icount = inbuy.getCount();
                            iuni = inbuy.getUni();
                            deleteIbInfo = "订购编号:" + iid + "\t" + "教材名称:" + iname + "\t" + "教材单价:" + iprice + "\t" + "订购日期:" + itime + "\t" + "订购数量" + icount + "\t" + "订购学校:" + iuni;
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ibInfo.setText(deleteIbInfo);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmDeleteButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteInbuy.this);
            builder.setTitle("是否确认删除");
            builder.setMessage("您是否确认要删除" + iname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int a = InbuyDao.deleteInbuyById(iid);
                            int b = InbuyDao.deleteInbuyByName(iname);
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

    Button.OnClickListener cancelDeleteButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            deleteIbId.setText("");
            deleteIbName.setText("");
            ibInfo.setText("");
        }
    };
}
