package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Dao.InbuyDao;
import Entity.Inbuy;

public class CheckInbuyInfo extends AppCompatActivity {

    List<Inbuy> inbuyList = new ArrayList<Inbuy>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_inbuy_info);
        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.inbuyinfotable_title);
        viewGroup.setBackgroundColor(Color.rgb(175, 175, 175));
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Inbuy> buyList = InbuyDao.allInbuys();
                for (Inbuy inbuy : buyList) {
                    inbuyList.add(new Inbuy(inbuy.getId(),inbuy.getName(),inbuy.getPrice(),inbuy.getIntime(),inbuy.getCount(),inbuy.getUni()));
                }
            }
        }).start();
        ListView listView = (ListView)findViewById(R.id.inbuyinfotable);
        InbuyTableAdapter inbuyTableAdapter = new InbuyTableAdapter(this,inbuyList);
        listView.setAdapter(inbuyTableAdapter);
    }
}
