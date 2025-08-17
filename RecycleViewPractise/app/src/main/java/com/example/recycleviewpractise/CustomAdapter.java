package com.example.recycleviewpractise;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<Item> itemList;
    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener listener){
        this.clickListener = listener;
    }

    public CustomAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.primaryText.setText(item.getPrimary());
        holder.descriptionText.setText(item.getDecription());
        holder.icon.setImageResource(item.getItemIcon());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView primaryText, descriptionText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            primaryText = itemView.findViewById(R.id.PrimaryText);
            descriptionText = itemView.findViewById(R.id.DescText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           if (clickListener != null) {
               clickListener.onClick(v, getAdapterPosition());
           }
        }
    }
}
