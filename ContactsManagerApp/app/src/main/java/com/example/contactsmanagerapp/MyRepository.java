package com.example.contactsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRepository {
    private final ContantDAO contantDAO;
    ExecutorService executor;
    Handler handler;
    public MyRepository(Application application) {
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contantDAO = contactDatabase.getContantDAO();
    }
    public void addContact(Contacts contact) {
         executor.execute(new Runnable() {
             @Override
             public void run() {
                 contantDAO.insert(contact);
             }
         });
    }


    public void deleteContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contantDAO.delete(contact);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contantDAO.getAllContacts();
    }
}
