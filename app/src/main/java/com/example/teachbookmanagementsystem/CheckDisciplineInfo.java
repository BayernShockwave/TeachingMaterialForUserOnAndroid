package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Dao.DisciplineDao;
import Entity.Discipline;

public class CheckDisciplineInfo extends AppCompatActivity {

    List<Discipline> disciplineList = new ArrayList<Discipline>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_discipline_info);
        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.disciplineinfotable_title);
        viewGroup.setBackgroundColor(Color.rgb(175, 175, 175));
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Discipline> disList = DisciplineDao.allDisciplines();
                for (Discipline discipline : disList) {
                    disciplineList.add(new Discipline(discipline.getId(),discipline.getName(),discipline.getG1(),discipline.getG2(),discipline.getG3(),discipline.getG4(),discipline.getUni()));
                }
            }
        }).start();
        ListView listView = (ListView)findViewById(R.id.disciplineinfotable);
        DisciplineTableAdapter disciplineTableAdapter = new DisciplineTableAdapter(this,disciplineList);
        listView.setAdapter(disciplineTableAdapter);
    }
}
