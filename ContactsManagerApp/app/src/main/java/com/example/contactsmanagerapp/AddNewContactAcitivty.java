package com.example.contactsmanagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactsmanagerapp.databinding.ActivityAddNewContactAcitivtyBinding;

public class AddNewContactAcitivty extends AppCompatActivity {
    private ActivityAddNewContactAcitivtyBinding binding;
    private AddNewContactClickHandler handler;
    private Contacts contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact_acitivty);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        contacts = new Contacts();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact_acitivty);
        handler = new AddNewContactClickHandler(contacts, this, myViewModel);
        binding.setContact(contacts);
        binding.setClickHandler(handler);
    }
}