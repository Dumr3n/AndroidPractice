package com.example.contactsmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanagerapp.databinding.ContactListViewBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapte extends RecyclerView.Adapter<MyAdapte.MyHolder> {

    private ArrayList<Contacts> contacts;

    public MyAdapte(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListViewBinding contactListViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_view,
                parent,
                false);

        return new MyHolder(contactListViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Contacts currentContanct = contacts.get(position);
        holder.contactListViewBinding.setContact(currentContanct);
    }

    @Override
    public int getItemCount() {
        if (contacts != null) {
            return contacts.size();
        }
        return 0;
    }
    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }
    class MyHolder extends RecyclerView.ViewHolder {

        private ContactListViewBinding contactListViewBinding;

        public MyHolder(@NonNull ContactListViewBinding contactListViewBinding) {
            super(contactListViewBinding.getRoot());
            this.contactListViewBinding = contactListViewBinding;
        }
    }
}
