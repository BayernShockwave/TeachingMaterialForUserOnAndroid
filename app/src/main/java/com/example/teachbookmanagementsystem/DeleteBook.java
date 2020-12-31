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

import java.util.ArrayList;
import java.util.List;

import Dao.BookDao;
import Entity.Book;

public class DeleteBook extends AppCompatActivity {

    public EditText deleteBookId;
    public EditText deleteBookName;
    public TextView bookInfo;
    public Button confirmDelete;
    public Button cancelDelete;
    public Book book;
    public List<Book> bList = new ArrayList<Book>();
    public String bid;
    public String bname;
    public String btype;
    public String barea;
    public int bcount;
    public String bpublish;
    public String useuni;
    public String usediscipline;
    public int usegrade;
    public String deleteBookInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);
        deleteBookId = (EditText)findViewById(R.id.deletebookid);
        deleteBookName = (EditText)findViewById(R.id.deletebookname);
        bookInfo = (TextView)findViewById(R.id.bookinfo);
        confirmDelete = (Button)findViewById(R.id.confirmdelete);
        cancelDelete = (Button)findViewById(R.id.canceldelete);
        confirmDelete.setOnClickListener(confirmDeleteButtonListener);
        cancelDelete.setOnClickListener(cancelDeleteButtonListener);

        deleteBookId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, final int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Book> bookList = BookDao.selectBooksById(deleteBookId.getText().toString());
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
                            deleteBookInfo ="教材编号:" + bid + "\t" + "教材名称:" + bname + "\t" + "教材类型:" + btype + "\t" + "教材分区:" + barea + "\t" + "教材库存:" + bcount + "\t" + "教材出版社:" + bpublish + "\t" + "使用学校:" + useuni + "\t" + "使用专业:" + usediscipline + "\t" + "教材年级:" + usegrade;
                            System.out.println("1"+deleteBookInfo);
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"+deleteBookInfo);
                bookInfo.setText(deleteBookInfo);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        deleteBookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Book> bookList = BookDao.selectBooksByName(deleteBookName.getText().toString());
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
                            deleteBookInfo ="教材编号:" + bid + "\t" + "教材名称:" + bname + "\t" + "教材类型:" + btype + "\t" + "教材分区:" + barea + "\t" + "教材库存:" + bcount + "\t" + "教材出版社:" + bpublish + "\t" + "使用学校:" + useuni + "\t" + "使用专业:" + usediscipline + "\t" + "教材年级:" + usegrade;
                            System.out.println("1"+deleteBookInfo);
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"+deleteBookInfo);
                bookInfo.setText(deleteBookInfo);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmDeleteButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DeleteBook.this);
            builder.setTitle("是否确认删除");
            builder.setMessage("您是否确认要删除" + bname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int a = BookDao.deleteBookById(bid);
                            int b = BookDao.deleteBookById(bname);
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
            deleteBookId.setText("");
            deleteBookName.setText("");
            bookInfo.setText("");
        }
    };
}
