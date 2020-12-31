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

import java.util.List;

import Dao.DisciplineDao;
import Entity.Discipline;

public class ModifyDiscipline extends AppCompatActivity {

    public EditText updateDisId;
    public EditText updateDisName;
    public TextView disInfo;
    public Button confirmUpdate;
    public Button cancelUpdate;
    public String did;
    public String dname;
    public int d1c;
    public int d2c;
    public int d3c;
    public int d4c;
    public String duni;
    public String updateDisInfo;
    private final int SUBACTIVITY1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_discipline);
        updateDisId = (EditText)findViewById(R.id.updatedisciplineid);
        updateDisName = (EditText)findViewById(R.id.updatedisciplinename);
        disInfo = (TextView)findViewById(R.id.disciplineinfo);
        confirmUpdate = (Button)findViewById(R.id.confirmupdate);
        cancelUpdate = (Button)findViewById(R.id.cancelupdate);
        confirmUpdate.setOnClickListener(confirmUpdateButtonListener);
        cancelUpdate.setOnClickListener(cancelUpdateButtonListener);

        updateDisId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Discipline> disciplineList = DisciplineDao.selectDisciplineById(updateDisId.getText().toString());
                        for (Discipline discipline : disciplineList) {
                            did = discipline.getId();
                            dname = discipline.getName();
                            d1c = discipline.getG1();
                            d2c = discipline.getG2();
                            d3c = discipline.getG3();
                            d4c = discipline.getG4();
                            duni = discipline.getUni();
                            updateDisInfo = "专业编号:" + did + "\t" + "专业名称:" + dname + "\t" + "大一年级人数:" + d1c + "\t" + "大二年级人数:" + d2c + "\t" + "大三年级人数:" + d3c + "\t" + "大四年级人数:" + d4c + "\t" + "开设学校:" + duni;
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                disInfo.setText(updateDisInfo);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        updateDisName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                            List<Discipline> disciplineList = DisciplineDao.selectDisciplineByName(updateDisName.getText().toString());
                        for (Discipline discipline : disciplineList) {
                            did = discipline.getId();
                            dname = discipline.getName();
                            d1c = discipline.getG1();
                            d2c = discipline.getG2();
                            d3c = discipline.getG3();
                            d4c = discipline.getG4();
                            duni = discipline.getUni();
                            updateDisInfo = "专业编号:" + did + "\t" + "专业名称:" + dname + "\t" + "大一年级人数:" + d1c + "\t" + "大二年级人数:" + d2c + "\t" + "大三年级人数:" + d3c + "\t" + "大四年级人数:" + d4c + "\t" + "开设学校:" + duni;
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("2"+updateBookInfo);
                disInfo.setText(updateDisInfo);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmUpdateButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ModifyDiscipline.this);
            builder.setTitle("是否确认修改");
            builder.setMessage("您是否确认要修改" + dname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ModifyDiscipline.this,ModifyDisciplineResult.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("id",did);
                            bundle.putString("name",dname);
                            bundle.putString("g1",String.valueOf(d1c));
                            bundle.putString("g2",String.valueOf(d2c));
                            bundle.putString("g3",String.valueOf(d3c));
                            bundle.putString("g4",String.valueOf(d4c));
                            bundle.putString("uni",duni);
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
            updateDisId.setText("");
            updateDisName.setText("");
            disInfo.setText("");
        }
    };
}
