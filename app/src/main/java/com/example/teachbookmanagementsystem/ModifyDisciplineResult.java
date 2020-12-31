package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Dao.DisciplineDao;

public class ModifyDisciplineResult extends AppCompatActivity {

    public String dupid;
    public String dupname;
    public int dupg1;
    public int dupg2;
    public int dupg3;
    public int dupg4;
    public String dupuni;
    public String did;
    public String dname;
    public int dg1;
    public int dg2;
    public int dg3;
    public int dg4;
    public String duni;
    public EditText upid;
    public EditText upname;
    public EditText upg1;
    public EditText upg2;
    public EditText upg3;
    public EditText upg4;
    public EditText upuni;
    public Button confirmup;
    public Button cancelup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_discipline_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        did = bundle.getString("id");
        dname = bundle.getString("name");
        dg1 = bundle.getInt("g1");
        dg2 = bundle.getInt("g2");
        dg3 = bundle.getInt("g3");
        dg4 = bundle.getInt("g4");
        duni = bundle.getString("uni");
        upid = (EditText) findViewById(R.id.updisciplineid);
        upname = (EditText) findViewById(R.id.updisciplinename);
        upg1 = (EditText) findViewById(R.id.updisciplineg1);
        upg2 = (EditText) findViewById(R.id.updisciplineg2);
        upg3 = (EditText) findViewById(R.id.updisciplineg3);
        upg4 = (EditText) findViewById(R.id.updisciplineg4);
        confirmup = (Button)findViewById(R.id.confirmup);
        cancelup = (Button)findViewById(R.id.cancelup);
        upid.setText(did);
        upname.setText(dname);
        upg1.setText(String.valueOf(dg1));
        upg2.setText(String.valueOf(dg2));
        upg3.setText(String.valueOf(dg3));
        upg4.setText(String.valueOf(dg4));
        confirmup.setOnClickListener(confirmUpButtonListener);
        cancelup.setOnClickListener(cancelUpButtonListener);

        upid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dupid = upid.getText().toString();
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
                dupname = upname.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upg1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    dg1 = Integer.valueOf(upg1.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upg2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    dg2 = Integer.valueOf(upg2.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upg3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    dg3 = Integer.valueOf(upg3.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        upg4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    dg4 = Integer.valueOf(upg4.getText().toString()).intValue();
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(dupid);
                    //System.out.println(dupname);
                    //System.out.println(dg1);
                    //System.out.println(dg2);
                    //System.out.println(dg3);
                    //System.out.println(dg4);
                    int i = DisciplineDao.updateDiscipline(dupid,dupname,dg1,dg2,dg3,dg4,duni);
                }
            }).start();
        }
    };

    Button.OnClickListener cancelUpButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            upid.setText(did);
            upname.setText(dname);
            upg1.setText(String.valueOf(dg1));
            upg2.setText(String.valueOf(dg2));
            upg3.setText(String.valueOf(dg3));
            upg4.setText(String.valueOf(dg4));
        }
    };
}
