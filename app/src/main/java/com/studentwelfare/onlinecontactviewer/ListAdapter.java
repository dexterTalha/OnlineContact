package com.studentwelfare.onlinecontactviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter{


    List list = new ArrayList();

    public ListAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    public void add(DataPack object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View view = convertView;
        Holder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_layout,parent, false);
            holder = new Holder();
            holder.nam = view.findViewById(R.id.txt_name_list);
            holder.mob = view.findViewById(R.id.txt_mobile_list);
            holder.em = view.findViewById(R.id.txt_email_list);
            view.setTag(holder);

        }else{
            holder = (Holder)view.getTag();
        }

        DataPack d = (DataPack) getItem(position);

        assert d != null;
        holder.nam.setText(d.getName());
        holder.mob.setText(d.getMobile());
        holder.em.setText(d.getEmail());

        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public static class Holder{
        TextView mob, nam, em;
    }

}
