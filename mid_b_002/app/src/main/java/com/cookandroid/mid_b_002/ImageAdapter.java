package com.cookandroid.mid_b_002;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Integer>mID=null;

    public ImageAdapter(Context c, ArrayList<Integer> mID)
    {
        mContext = c;
        this.mID=mID;
    }


    @Override
    public int getCount() {
        return mID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView==null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4,4,4,4);

        }
        else{
            imageView = (ImageView)convertView;
        }
            imageView.setImageResource(mID.get(position));

        return imageView;
    }
}
