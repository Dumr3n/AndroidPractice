package com.example.cardbiewpractise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.cardViewHolder> {
    private List<cardViewClass> cardList;
    public cardClickListener listener;

    public void setClickListener(cardClickListener listener) {
        this.listener = listener;
    }

    public cardAdapter(List<cardViewClass> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public cardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        return new cardViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewHolder holder, int position) {
        holder.title.setText(cardList.get(position).getTitle());
        holder.icon.setImageResource(cardList.get(position).getSportImg());
    }

    public class cardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView icon;
        TextView title;
        public cardViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(v, getAdapterPosition());
            }
        }
    }
}
