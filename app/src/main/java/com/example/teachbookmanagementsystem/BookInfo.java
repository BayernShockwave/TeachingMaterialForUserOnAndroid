package com.example.teachbookmanagementsystem;

import android.app.Activity;

import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Dao.BookDao;
import Entity.Book;

public class BookInfo extends Activity {

    public String discipline;
    public String grade;
    public String type;
    public String area;
    public String count;
    public String publish;
    List<Book> bList = new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        discipline = bundle.getString("discipline");
        grade = bundle.getString("grade");
        type = bundle.getString("type");
        area = bundle.getString("area");
        count = bundle.getString("count");
        publish = bundle.getString("publish");
        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.bookinfotable_title);
        viewGroup.setBackgroundColor(Color.rgb(175, 175, 175));
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Book> bookList = BookDao.allBooks();
                for (Book book : bookList) {
                    bList.add(new Book(book.getBid(),book.getBname(),book.getBtype(),book.getBarea(),book.getBcount(),book.getBpublish(),book.getBuseuni(),book.getBusediscipline(),book.getBusegrade()));
                }
            }
        }).start();
        ListView listView = (ListView)findViewById(R.id.bookinfotable);
        TableAdapter tableAdapter = new TableAdapter(this,bList);
        listView.setAdapter(tableAdapter);
    }
}
