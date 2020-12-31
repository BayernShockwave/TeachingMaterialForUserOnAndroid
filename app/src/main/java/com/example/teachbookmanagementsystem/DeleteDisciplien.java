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

import java.util.List;

import Dao.DisciplineDao;
import Entity.Discipline;

public class DeleteDisciplien extends AppCompatActivity {

    public EditText deleteDisId;
    public EditText deleteDisName;
    public TextView disInfo;
    public Button confirmDelete;
    public Button cancelDelete;
    public String did;
    public String dname;
    public int dg1;
    public int dg2;
    public int dg3;
    public int dg4;
    public String duni;
    public String deleteDisInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_disciplien);
        deleteDisId = (EditText)findViewById(R.id.deletedisciplineid);
        deleteDisName = (EditText)findViewById(R.id.deletedisciplinename);
        disInfo = (TextView)findViewById(R.id.disciplineinfo);
        confirmDelete = (Button)findViewById(R.id.confirmdelete);
        cancelDelete = (Button)findViewById(R.id.canceldelete);
        confirmDelete.setOnClickListener(confirmDeleteButtonListener);
        cancelDelete.setOnClickListener(cancelDeleteButtonListener);

        deleteDisId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, final int count) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Discipline> disciplineList = DisciplineDao.selectDisciplineById(deleteDisId.getText().toString());
                        for (Discipline discipline : disciplineList) {
                            did = discipline.getId();
                            dname = discipline.getName();
                            dg1 = discipline.getG1();
                            dg2 = discipline.getG2();
                            dg3 = discipline.getG3();
                            dg4 = discipline.getG4();
                            duni = discipline.getUni();
                            deleteDisInfo = "专业编号:" + did + "\t" + "专业名称:" + dname + "\t" + "大一年级人数:" + dg1 + "\t" + "大二年级人数:" + dg2 + "\t" + "大三年级人数:" + dg3 + "\t" + "大四年级人数:" + dg4 + "\t" + "开设学校:" + duni;
                        }
                    }
                }).start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                disInfo.setText(deleteDisInfo);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    Button.OnClickListener confirmDeleteButtonListener  = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DeleteDisciplien.this);
            builder.setTitle("是否确认删除");
            builder.setMessage("您是否确认要删除" + dname);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int a = DisciplineDao.deleteDisciplineById(did);
                            int b = DisciplineDao.deleteDisciplineByName(dname);
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
            deleteDisId.setText("");
            deleteDisName.setText("");
            disInfo.setText("");
        }
    };
}
