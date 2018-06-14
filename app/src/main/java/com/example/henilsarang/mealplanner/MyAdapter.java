package com.example.henilsarang.mealplanner;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henilsarang.mealplanner.R;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String>{

    String [] titles;
    int [] images;
    String [] descriptions;
    Context mContext;

    public MyAdapter (Context context, String[] titles, int[] images, String[] descriptions){
        super(context, R.layout.single_row);
        this.titles = titles;
        this.images = images;
        this.descriptions = descriptions;
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        if (convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.single_row, parent, false);
            mViewHolder.image = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            mViewHolder.description = (TextView) convertView.findViewById(R.id.tvDescription);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.image.setImageResource(images[position]);
        mViewHolder.title.setText(titles[position]);
        mViewHolder.description.setText(descriptions[position]);


        return  convertView;

    }

    static class ViewHolder{
        ImageView image;
        TextView title;
        TextView description;

    }
}

