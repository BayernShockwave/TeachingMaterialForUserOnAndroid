package com.example.teachbookmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Entity.Discipline;

public class DisciplineTableAdapter extends BaseAdapter {
    private List<Discipline> list;
    private LayoutInflater inflater;

    public DisciplineTableAdapter(Context context, List<Discipline> list) {
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
        Discipline discipline = (Discipline) this.getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.disciplineinfo,null);
            viewHolder.dId = (TextView)convertView.findViewById(R.id.disciplineid);
            viewHolder.dName = (TextView)convertView.findViewById(R.id.disciplinename);
            viewHolder.dg1 = (TextView)convertView.findViewById(R.id.grade1count);
            viewHolder.dg2 = (TextView)convertView.findViewById(R.id.grade2count);
            viewHolder.dg3 = (TextView)convertView.findViewById(R.id.grade3count);
            viewHolder.dg4 = (TextView)convertView.findViewById(R.id.grade4count);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.dId.setText(discipline.getId());
        viewHolder.dName.setText(discipline.getName());
        viewHolder.dg1.setText(String.valueOf(discipline.getG1()));
        viewHolder.dg2.setText(String.valueOf(discipline.getG2()));
        viewHolder.dg3.setText(String.valueOf(discipline.getG3()));
        viewHolder.dg4.setText(String.valueOf(discipline.getG4()));
        return convertView;
    }

    public static class ViewHolder {
        public TextView dId;
        public TextView dName;
        public TextView dg1;
        public TextView dg2;
        public TextView dg3;
        public TextView dg4;
    }
}
