package com.example.shapecalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ShapesAdaptor extends ArrayAdapter<Shape> {
    Context context;
    private ArrayList<Shape> shapes;
    public ShapesAdaptor(@NonNull Context context, ArrayList<Shape> shapes) {
        super(context, R.layout.grid_item_layout, shapes);
        this.shapes = shapes;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shapes = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflator = LayoutInflater.from(getContext());
            convertView = inflator.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );
            holder.name = (TextView) convertView.findViewById(R.id.textView);
            holder.icon = (ImageView) convertView.findViewById(R.id.Icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(shapes.getShapeName());
        holder.icon.setImageResource(shapes.getShapeImg());
        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView name;
    }
}
