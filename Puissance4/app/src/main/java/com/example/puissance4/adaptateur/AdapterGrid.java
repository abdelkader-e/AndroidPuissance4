package com.example.puissance4.adaptateur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.puissance4.R;

public class AdapterGrid extends BaseAdapter {

    Context context;
    LayoutInflater inflater;

    int  plateauJetonView[];

    public AdapterGrid(Context context, int[] plateauJetonView) {
        this.context = context;
        this.plateauJetonView = plateauJetonView;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return this.plateauJetonView.length;
    }

    @Override
    public Integer getItem(int position) {
        return this.plateauJetonView[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.inflater.inflate(R.layout.layout_jeton,null);
        ImageView imJeton= convertView.findViewById(R.id.imgJeton);
        imJeton.setImageResource(this.plateauJetonView[position]);
        return convertView;
    }
}
