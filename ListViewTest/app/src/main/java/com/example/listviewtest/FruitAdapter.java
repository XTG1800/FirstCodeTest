package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resID;

    public FruitAdapter(Context context, int resourceID, List<Fruit> objects) {
        super(context, resourceID, objects);
        resID = resourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resID, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruit_text = (TextView) view.findViewById(R.id.text_view_fruit);
            viewHolder.fruit_image = (ImageView) view.findViewById(R.id.image_view_fruit);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruit_text.setText(fruit.getFruitName());
        viewHolder.fruit_image.setImageResource(fruit.getFruitImage());
        return view;
    }

    class ViewHolder {
        TextView fruit_text;
        ImageView fruit_image;
    }

}
