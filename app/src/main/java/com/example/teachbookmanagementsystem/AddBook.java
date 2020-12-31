package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import Dao.BookDao;

public class AddBook extends AppCompatActivity {

    public EditText bid;
    public EditText bname;
    public Spinner btype;
    public Spinner barea;
    public EditText bcount;
    public EditText bpublish;
    public EditText bdiscipline;
    public Spinner bgrade;
    public Button confirmadd;
    public Button cleanadd;
    public String newid;
    public String newname;
    public String newtype;
    public String newarea;
    public int newcount;
    public String newpublish;
    public String newdiscipline;
    public int newgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        bid = (EditText)findViewById(R.id.newbookid);
        bname = (EditText)findViewById(R.id.newbookname);
        btype = (Spinner)findViewById(R.id.newbooktype);
        barea = (Spinner)findViewById(R.id.newbookarea);
        bcount = (EditText)findViewById(R.id.newbookcount);
        bpublish = (EditText)findViewById(R.id.newbookpublish);
        bdiscipline = (EditText)findViewById(R.id.newbookdiscipline);
        bgrade = (Spinner)findViewById(R.id.newbookgrade);
        confirmadd = (Button)findViewById(R.id.confirmadd);
        cleanadd = (Button)findViewById(R.id.canceladd);
        confirmadd.setOnClickListener(confirmAddButtonListener);
        cleanadd.setOnClickListener(cancelAddButtonListener);
    }

    Button.OnClickListener confirmAddButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            newid = bid.getText().toString();
            newname = bname.getText().toString();
            newtype = btype.getSelectedItem().toString();
            newarea = barea.getSelectedItem().toString();
            try {
                newcount = Integer.valueOf(bcount.getText().toString()).intValue();
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            newpublish = bpublish.getText().toString();
            newdiscipline = bdiscipline.getText().toString();
            try {
                newgrade = Integer.valueOf(bgrade.getSelectedItem().toString()).intValue();
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(newid);
                    //System.out.println(newname);
                    //System.out.println(newtype);
                    //System.out.println(newarea);
                    //System.out.println(newcount);
                    //System.out.println(newpublish);
                    //System.out.println(newdiscipline);
                    //System.out.println(newgrade);
                    int i = BookDao.addBook(newid,newname,newtype,newarea,newcount,newpublish,"上海电力大学",newdiscipline,newgrade);
                }
            }).start();
            AlertDialog.Builder builder = new AlertDialog.Builder(AddBook.this);
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
            bid.setText("");
            bname.setText("");
            bcount.setText("");
            bpublish.setText("");
            bdiscipline.setText("");
        }
    };
}
