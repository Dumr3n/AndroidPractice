package com.example.workmanageradd;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    Data data = getInputData();
    int coutingLimit = data.getInt("max_limit", 0);
    @NonNull
    @Override
    public Result doWork() {
        for (int i = 0; i < coutingLimit; i++) {
            Log.i("TAGY", "Count is "+i);
        }
        Data dataToSend = new Data.Builder().putString("msg", "Task failed succesfully!").build();
        return Result.success(dataToSend);
    }
}
