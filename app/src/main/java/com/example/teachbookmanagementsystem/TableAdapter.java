package com.example.teachbookmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Entity.Book;

public class TableAdapter extends BaseAdapter {
    private List<Book> list;
    private LayoutInflater inflater;

    public TableAdapter(Context context,List<Book> list) {
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
        Book book = (Book)this.getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.bookinfo,null);
            viewHolder.bId = (TextView)convertView.findViewById(R.id.bookid);
            viewHolder.bName = (TextView)convertView.findViewById(R.id.bookname);
            viewHolder.bType = (TextView)convertView.findViewById(R.id.booktype);
            viewHolder.bArea = (TextView)convertView.findViewById(R.id.bookarea);
            viewHolder.bCount = (TextView)convertView.findViewById(R.id.bookcount);
            viewHolder.bPublish = (TextView)convertView.findViewById(R.id.bookpublish);
            viewHolder.bDiscipline = (TextView)convertView.findViewById(R.id.bookdiscipline);
            viewHolder.bGrade = (TextView)convertView.findViewById(R.id.bookgrade);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.bId.setText(book.getBid());
        viewHolder.bName.setText(book.getBname());
        viewHolder.bType.setText(book.getBtype());
        viewHolder.bArea.setText(book.getBarea());
        viewHolder.bCount.setText(String.valueOf(book.getBcount()));
        viewHolder.bPublish.setText(book.getBpublish());
        viewHolder.bDiscipline.setText(book.getBusediscipline());
        viewHolder.bGrade.setText(String.valueOf(book.getBusegrade()));
        return convertView;
    }

    public static class ViewHolder {
        public TextView bId;
        public TextView bName;
        public TextView bType;
        public TextView bArea;
        public TextView bCount;
        public TextView bPublish;
        public TextView bDiscipline;
        public TextView bGrade;
    }
}
