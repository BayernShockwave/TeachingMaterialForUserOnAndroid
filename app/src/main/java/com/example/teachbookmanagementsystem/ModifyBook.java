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

import java.util.ArrayList;
import java.util.List;

import Dao.BookDao;
import Entity.Book;

public class ModifyBook extends AppCompatActivity {

    public EditText updateBookId;
    public EditText updateBookName;
    public TextView bookInfo;
    public Button confirmUpdate;
    public Button cancelUpdate;
    public String bid;
    public String bname;
    public String btype;
    public String barea;
    public int bcount;
    public String bpublish;
    public String useuni;
    public String usediscipline;
    public int usegrade;
    public String updateBookInfo;
    private final int SUBACTIVITY1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_book);
        updateBookId = (EditText)findViewById(R.id.updatebookid);
        updateBookName = (EditText)findViewById(R.id.updatebookname);
        bookInfo = (TextView)findViewById(R.id.bookinfo);
        confirmUpdate = (Button)findViewById(R.id.confirmupdate);
        cancelUpdate = (Button)findViewById(R.id.cancelupdate);
        confirmUpdate.setOnClickListener(confirmUpdateButtonListener);
        cancelUpdate.setOnClickListener(cancelUpdateButtonListener);

        updateBookId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, final int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Book> bookList = BookDao.selectBooksById(updateBookId.getText().toString());
                        for (Book book : bookList) {
                            bid = book.getBid();
                            bname = book.getBname();
                            btype = book.getBtype();
                            barea = book.getBarea();
                            bcount = book.getBcount();
                            bpublish = book.getBpublish();
                            useuni = book.getBuseuni();
                            usediscipline = book.getBusediscipline();
                            usegrade = book.getBusegrade();
                            updateBookInfo ="教材编号:" + bid + "\t" + "教材名称:" + bname + "\t" + "教材类型:" + btype + "\t" + "教材分区:" + barea + "\t" + "教材库存:" + bcount + "\t" + "教材出版社:" + bpublish + "\t" + "使用学校:" + useuni + "\t" + "使用专业:" + usediscipline + "\t" + "教材年级:" + usegrade;
                            //System.out.println("1"+updateBookInfo);
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("2"+updateBookInfo);
                bookInfo.setText(updateBookInfo);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        updateBookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Book> bookList = BookDao.selectBooksByName(updateBookName.getText().toString());
                        for (Book book : bookList) {
                            bid = book.getBid();
                            bname = book.getBname();
                            btype = book.getBtype();
                            barea = book.getBarea();
                            bcount = book.getBcount();
                            bpublish = book.getBpublish();
                            useuni = book.getBuseuni();
                            usediscipline = book.getBusediscipline();
                            usegrade = book.getBusegrade();
                            updateBookInfo ="教材编号:" + bid + "\t" + "教材名称:" + bname + "\t" + "教材类型:" + btype + "\t" + "教材分区:" + barea + "\t" + "教材库存:" + bcount + "\t" + "教材出版社:" + bpublish + "\t" + "使用学校:" + useuni + "\t" + "使用专业:" + usediscipline + "\t" + "教材年级:" + usegrade;
                            //System.out.println("1"+updateBookInfo);
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("2"+updateBookInfo);
                bookInfo.setText(updateBookInfo);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmUpdateButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ModifyBook.this);
            builder.setTitle("是否确认修改");
            builder.setMessage("您是否确认要修改" + bname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ModifyBook.this,ModifyBookResult.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("id",bid);
                            bundle.putString("name",bname);
                            bundle.putString("type",btype);
                            bundle.putString("area",barea);
                            bundle.putString("count",String.valueOf(bcount));
                            bundle.putString("publish",bpublish);
                            bundle.putString("uni",useuni);
                            bundle.putString("discipline",usediscipline);
                            bundle.putString("grade",String.valueOf(usegrade));
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
            updateBookId.setText("");
            updateBookName.setText("");
            bookInfo.setText("");
        }
    };
}
