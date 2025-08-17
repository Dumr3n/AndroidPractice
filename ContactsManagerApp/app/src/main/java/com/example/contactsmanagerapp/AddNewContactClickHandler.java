package com.example.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contacts contact;
    MyViewModel viewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel viewModel) {
        this.contact = contact;
        this.context = context;
        this.viewModel = viewModel;
    }
    public void onSumbitBtnClickedd(View view) {
        if (contact.getName() == null || contact.getEmail() == null) {
            Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_LONG).show();
        } else{
            Intent i = new Intent(context, MainActivity.class);
//            i.putExtra("name", contact.getName());
//            i.putExtra("email", contact.getEmail());
            viewModel.addNewContact(contact);
            context.startActivity(i);
        }
    }
    Context context;

}
