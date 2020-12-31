package com.example.teachbookmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Entity.Discipline;
import Entity.Inbuy;

public class InbuyTableAdapter extends BaseAdapter {
    private List<Inbuy> list;
    private LayoutInflater inflater;
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public InbuyTableAdapter(Context context, List<Inbuy> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if(list!=null){
            ret = list.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Inbuy inbuy = (Inbuy)this.getItem(position);
        InbuyTableAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new InbuyTableAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.inbuyinfo,null);
            viewHolder.iId = (TextView)convertView.findViewById(R.id.buyid);
            viewHolder.iName = (TextView)convertView.findViewById(R.id.buyname);
            viewHolder.iPrice = (TextView)convertView.findViewById(R.id.buyprice);
            viewHolder.iTime = (TextView)convertView.findViewById(R.id.buytime);
            viewHolder.iCount = (TextView)convertView.findViewById(R.id.buycount);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (InbuyTableAdapter.ViewHolder)convertView.getTag();
        }
        viewHolder.iId.setText(inbuy.getId());
        viewHolder.iName.setText(inbuy.getName());
        viewHolder.iPrice.setText(String.valueOf(inbuy.getPrice()));
        viewHolder.iTime.setText(simpleDateFormat.format(inbuy.getIntime()));
        viewHolder.iCount.setText(String.valueOf(inbuy.getCount()));
        return convertView;
    }

    public static class ViewHolder {
        public TextView iId;
        public TextView iName;
        public TextView iPrice;
        public TextView iTime;
        public TextView iCount;
    }
}
