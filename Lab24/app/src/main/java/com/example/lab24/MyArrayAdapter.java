package com.example.lab24;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Tygia> {
    Activity context;
    int resource;
    List<Tygia> objects;

    public MyArrayAdapter(Activity context, int resource, List<Tygia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);
        Tygia tygia = this.objects.get(position);
        ImageView imgHinh = (ImageView) item.findViewById(R.id.imghinh);
        TextView txtType = (TextView) item.findViewById(R.id.txtType);
        TextView txtBuyTM = (TextView) item.findViewById(R.id.txtBuyTM);
        TextView txtSellTM = (TextView) item.findViewById(R.id.txtSellTM);
        TextView txtBuyCK = (TextView) item.findViewById(R.id.txtBuyCK);
        TextView txtSellCK = (TextView) item.findViewById(R.id.txtSellCK);
        imgHinh.setImageBitmap(tygia.getBitmap());
        txtType.setText(tygia.getType());
        txtBuyTM.setText(tygia.getBuyCash());    // Updated from getMuatienmat()
        txtSellTM.setText(tygia.getSellCash());  // Updated from getBantuenmat()
        txtBuyCK.setText(tygia.getBuyCheck());   // Updated from getMuack()
        txtSellCK.setText(tygia.getSellCheck()); // Updated from getBanck()

        return item;
    }
}