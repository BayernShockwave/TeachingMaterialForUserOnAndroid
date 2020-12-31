package com.example.teachbookmanagementsystem;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMainFrame extends Activity {

    public Button checkBook;
    public Button addBook;
    public Button modifyBoook;
    public Button deleteBook;
    public Button checkDiscipline;
    public Button addDiscipline;
    public Button modifyDiscipline;
    public Button deleteDiscipline;
    public Button checkBuy;
    public Button addBuy;
    public Button modifyBuy;
    public Button deleteBuy;
    private final int SUBACTIVITY1 = 1;
    private final int SUBACTIVITY2 = 2;
    private final int SUBACTIVITY3 = 3;
    private final int SUBACTIVITY4 = 4;
    private final int SUBACTIVITY5 = 5;
    private final int SUBACTIVITY6 = 6;
    private final int SUBACTIVITY7 = 7;
    private final int SUBACTIVITY8 = 8;
    private final int SUBACTIVITY9 = 9;
    private final int SUBACTIVITY10 = 10;
    private final int SUBACTIVITY11 = 11;
    private final int SUBACTIVITY12 = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_frame);
        checkBook = (Button)findViewById(R.id.checkbook);
        addBook = (Button)findViewById(R.id.addbook);
        modifyBoook = (Button)findViewById(R.id.modifybook);
        deleteBook = (Button)findViewById(R.id.deletebook);
        checkDiscipline = (Button)findViewById(R.id.checkdiscipline);
        addDiscipline = (Button)findViewById(R.id.adddiscipline);
        modifyDiscipline = (Button)findViewById(R.id.modifydiscipline);
        deleteDiscipline = (Button)findViewById(R.id.deletediscipline);
        checkBuy = (Button)findViewById(R.id.checkbuy);
        addBuy = (Button)findViewById(R.id.addbuy);
        modifyBuy = (Button)findViewById(R.id.modifybuy);
        deleteBuy = (Button)findViewById(R.id.deletebuy);
        checkBook.setOnClickListener(checkBookButtonListener);
        addBook.setOnClickListener(addBookButtonListener);
        modifyBoook.setOnClickListener(modifyBookButtonListener);
        deleteBook.setOnClickListener(deleteBookButtonListener);
        checkDiscipline.setOnClickListener(checkDisciplineButtonListener);
        addDiscipline.setOnClickListener(addDisciplineButtonListener);
        modifyDiscipline.setOnClickListener(modifyDisciplineButtonListener);
        deleteDiscipline.setOnClickListener(deleteDisciplineButtonListener);
        checkBuy.setOnClickListener(checkBuyButtonListener);
        addBuy.setOnClickListener(addBuyButtonListener);
        modifyBuy.setOnClickListener(modifyBuyButtonListener);
        deleteBuy.setOnClickListener(deleteBuyButtonListener);
    }

    Button.OnClickListener checkBookButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,CheckBookInfo.class);
            startActivityForResult(intent,SUBACTIVITY1);
        }
    };

    Button.OnClickListener addBookButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,AddBook.class);
            startActivityForResult(intent,SUBACTIVITY2);
        }
    };

    Button.OnClickListener modifyBookButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,ModifyBook.class);
            startActivityForResult(intent,SUBACTIVITY3);
        }
    };

    Button.OnClickListener deleteBookButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,DeleteBook.class);
            startActivityForResult(intent,SUBACTIVITY4);
        }
    };

    Button.OnClickListener checkDisciplineButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,CheckDisciplineInfo.class);
            startActivityForResult(intent,SUBACTIVITY5);
        }
    };

    Button.OnClickListener addDisciplineButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,AddDiscipline.class);
            startActivityForResult(intent,SUBACTIVITY6);
        }
    };

    Button.OnClickListener modifyDisciplineButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,ModifyDiscipline.class);
            startActivityForResult(intent,SUBACTIVITY7);
        }
    };

    Button.OnClickListener deleteDisciplineButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,DeleteDisciplien.class);
            startActivityForResult(intent,SUBACTIVITY8);
        }
    };

    Button.OnClickListener checkBuyButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,CheckInbuyInfo.class);
            startActivityForResult(intent,SUBACTIVITY9);
        }
    };

    Button.OnClickListener addBuyButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,AddInbuy.class);
            startActivityForResult(intent,SUBACTIVITY10);
        }
    };

    Button.OnClickListener modifyBuyButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,ModifyInbuy.class);
            startActivityForResult(intent,SUBACTIVITY11);
        }
    };

    Button.OnClickListener deleteBuyButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserMainFrame.this,DeleteInbuy.class);
            startActivityForResult(intent,SUBACTIVITY12);
        }
    };
}
