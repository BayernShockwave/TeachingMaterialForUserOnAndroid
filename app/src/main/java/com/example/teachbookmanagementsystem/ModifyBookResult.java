package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import Dao.BookDao;

public class ModifyBookResult extends AppCompatActivity {

    public String bupid;
    public String bupname;
    public String buptype;
    public String buparea;
    public int bupcount;
    public String buppublish;
    public String upuseuni;
    public String upusediscipline;
    public int upusegrade;
    public String bid;
    public String bname;
    public String btype;
    public String barea;
    public int bcount;
    public String bpublish;
    public String useuni;
    public String usediscipline;
    public int usegrade;
    public EditText upid;
    public EditText upname;
    public Spinner uptype;
    public Spinner uparea;
    public EditText upcount;
    public EditText uppublish;
    public EditText updiscipline;
    public Spinner upgrade;
    public Button confirmup;
    public Button cancelup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_book_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bid = bundle.getString("id");
        bname = bundle.getString("name");
        btype = bundle.getString("type");
        barea = bundle.getString("area");
        bcount = bundle.getInt("count");
        bpublish = bundle.getString("publish");
        useuni = bundle.getString("uni");
        usediscipline = bundle.getString("discipline");
        usegrade = bundle.getInt("grade");
        //System.out.println(bid+bname+btype+barea+bcount+bpublish+useuni+usediscipline+usegrade);
        upid = (EditText) findViewById(R.id.upbookid);
        upname = (EditText) findViewById(R.id.upbookname);
        uptype = (Spinner)findViewById(R.id.upbooktype);
        uparea = (Spinner)findViewById(R.id.upbookarea);
        upcount = (EditText) findViewById(R.id.upbookcount);
        uppublish = (EditText) findViewById(R.id.upbookpublish);
        updiscipline = (EditText) findViewById(R.id.upbookdiscipline);
        upgrade = (Spinner)findViewById(R.id.upbookgrade);
        confirmup = (Button)findViewById(R.id.confirmup);
        cancelup = (Button)findViewById(R.id.cancelup);
        upid.setText(bid);
        upname.setText(bname);
        uptype.setSelection(0,true);
        uparea.setSelection(0,true);
        upcount.setText(String.valueOf(bcount));
        uppublish.setText(bpublish);
        updiscipline.setText(usediscipline);
        upgrade.setSelection(0,true);
        confirmup.setOnClickListener(confirmUpButtonListener);
        cancelup.setOnClickListener(cancelUpButtonListener);

        upid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bupid = upid.getText().toString();
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
                bupname = upname.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        uptype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                buptype = uptype.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        uparea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                buparea = uparea.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        upcount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    bupcount = Integer.valueOf(upcount.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        uppublish.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buppublish = uppublish.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        updiscipline.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                upusediscipline = updiscipline.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upgrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    upusegrade = Integer.valueOf(upgrade.getSelectedItem().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    Button.OnClickListener confirmUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(bupid);
                    //System.out.println(bupname);
                    //System.out.println(buptype);
                    //System.out.println(buparea);
                    //System.out.println(bupcount);
                    //System.out.println(buppublish);
                    //System.out.println(upusediscipline);
                    //System.out.println(upusegrade);
                    int i = BookDao.updateBook(bupid,bupname,buptype,buparea,bupcount,buppublish,useuni,upusediscipline,upusegrade);
                }
            }).start();
        }
    };

    Button.OnClickListener cancelUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            upid.setText(bid);
            upname.setText(bname);
            uptype.setSelection(0,true);
            uparea.setSelection(0,true);
            upcount.setText(String.valueOf(bcount));
            uppublish.setText(bpublish);
            updiscipline.setText(usediscipline);
            upgrade.setSelection(0,true);
        }
    };
}
