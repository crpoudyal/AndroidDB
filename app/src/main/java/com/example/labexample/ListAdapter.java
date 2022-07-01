package com.example.labexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<Integer> id;
    ArrayList<String> name;
    ArrayList<String> address;
    public ListAdapter(Activity context,ArrayList<Integer> id,ArrayList<String> name,ArrayList<String> address){
        super(context,R.layout.list_items,name);
        this.context = context;
        this.id =id;
        this.name = name;
        this.address=address;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_items,null,true);


        TextView tvId = view.findViewById(R.id.lv_id);
        TextView tvName = view.findViewById(R.id.lv_name);
        TextView tvAddress = view.findViewById(R.id.lv_address);


        tvId.setText(id.get(position).toString());
        tvName.setText(name.get(position));
        tvAddress.setText(address.get(position));


        return view;
    }
}
