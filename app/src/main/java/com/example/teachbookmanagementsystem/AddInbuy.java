package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Dao.InbuyDao;

public class AddInbuy extends AppCompatActivity {

    public EditText edid;
    public EditText edname;
    public EditText edprice;
    public EditText edtime;
    public EditText edcount;
    public Button add;
    public Button cancel;
    public String newid;
    public String newname;
    public int newprice;
    public String  newtime;
    public int newcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inbuy);
        edid = (EditText)findViewById(R.id.newbuyid);
        edname = (EditText)findViewById(R.id.newbuyname);
        edprice = (EditText)findViewById(R.id.newbuyprice);
        edtime = (EditText)findViewById(R.id.newbuytime);
        edcount = (EditText)findViewById(R.id.newbuycount);
        add = (Button)findViewById(R.id.confirmadd);
        cancel = (Button)findViewById(R.id.canceladd);
        add.setOnClickListener(confirmAddButtonListener);
        cancel.setOnClickListener(cancelAddButtonListener);
    }

    Button.OnClickListener confirmAddButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            newid = edid.getText().toString();
            newname = edname.getText().toString();
            try {
                newprice = Integer.valueOf(edprice.getText().toString()).intValue();
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            newtime = edtime.getText().toString();
            try {
                newcount = Integer.valueOf(edcount.getText().toString()).intValue();
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = InbuyDao.addInbuy(newid,newname,newprice,newtime,newcount,"上海电力大学");
                }
            }).start();
            AlertDialog.Builder builder = new AlertDialog.Builder(AddInbuy.this);
            builder.setTitle("添加结果反馈");
            builder.setMessage("添加成功!");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
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

    Button.OnClickListener cancelAddButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            edid.setText("");
            edname.setText("");
            edprice.setText("");
            edtime.setText("");
            edcount.setText("");
        }
    };
}
