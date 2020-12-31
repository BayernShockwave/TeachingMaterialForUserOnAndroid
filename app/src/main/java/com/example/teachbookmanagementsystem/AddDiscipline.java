package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Dao.DisciplineDao;

public class AddDiscipline extends AppCompatActivity {

    public EditText edid;
    public EditText edname;
    public EditText edg1;
    public EditText edg2;
    public EditText edg3;
    public EditText edg4;
    public Button add;
    public Button cancel;
    public String newid;
    public String newname;
    public int newg1;
    public int newg2;
    public int newg3;
    public int newg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_discipline);
        edid = (EditText)findViewById(R.id.newdisciplineid);
        edname = (EditText)findViewById(R.id.newdisciplinename);
        edg1 = (EditText)findViewById(R.id.newdisciplineg1);
        edg2 = (EditText)findViewById(R.id.newdisciplineg2);
        edg3 = (EditText)findViewById(R.id.newdisciplineg3);
        edg4 = (EditText)findViewById(R.id.newdisciplineg4);
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
                newg1 = Integer.valueOf(edg1.getText().toString()).intValue();
                newg2 = Integer.valueOf(edg2.getText().toString()).intValue();
                newg3 = Integer.valueOf(edg3.getText().toString()).intValue();
                newg4 = Integer.valueOf(edg4.getText().toString()).intValue();
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = DisciplineDao.addDiscipline(newid,newname,newg1,newg2,newg3,newg4,"上海电力大学");
                }
            }).start();
            AlertDialog.Builder builder = new AlertDialog.Builder(AddDiscipline.this);
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
            edg1.setText("");
            edg2.setText("");
            edg3.setText("");
            edg4.setText("");
        }
    };
}
