package com.example.databindingpractise;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ClikcHandler {
    Context context;

    public ClikcHandler(Context context) {
        this.context = context;
    }
    public void onButton1Clicked(View view) {
        Toast.makeText(context, "First button clicked!", Toast.LENGTH_LONG).show();
    }
}
