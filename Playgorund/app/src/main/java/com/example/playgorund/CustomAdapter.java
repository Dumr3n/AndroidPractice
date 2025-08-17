package com.example.playgorund;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetList;
    Context context;

    public CustomAdapter(ArrayList<Planet> planetList, Context context) {
        super(context, R.layout.custom_list_item, planetList);
        this.planetList = planetList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);
        ViewHolder holder;
        final View result;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_list_item, parent, false);
            holder.primaryText = (TextView) convertView.findViewById(R.id.PrimaryText);
            holder.secondaryText = (TextView) convertView.findViewById(R.id.Secondarytext);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);

            result = convertView;
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        holder.primaryText.setText(planet.getPlanetName());
        holder.secondaryText.setText(planet.getMoonCount());
        holder.icon.setImageResource(planet.getPlanetImage());
        return result;
    }

    static class ViewHolder {
        ImageView icon;
        TextView primaryText;
        TextView secondaryText;
    }
}
