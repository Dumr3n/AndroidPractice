package com.example.viewmodepractise;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewMOdel extends ViewModel {
    private MutableLiveData<Integer> counter = new MutableLiveData<>();
    public void increaseCounter(View view){
        int currentVal = counter.getValue() != null ? counter.getValue() : 0;
        counter.setValue(++currentVal);
    }
    public LiveData<Integer> getCounter(){
        return counter;
    }
}
