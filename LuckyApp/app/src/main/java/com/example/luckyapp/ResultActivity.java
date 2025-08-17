package com.example.luckyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    TextView num;
    Button shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num = findViewById(R.id.LuckyNum);
        shareButton = findViewById(R.id.shareButton);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        String randomNum = Integer.toString(generateRandomNum());
        num.setText(randomNum);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNum);
            }
        });

    }

    public int generateRandomNum() {
        int result;
        Random random = new Random();

        int upperLimit = 999;
        result = random.nextInt(upperLimit);
        return result;
    }

    public void shareData(String name, String num) {
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today");
        send.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + num);
        startActivity(Intent.createChooser(send, "Choose a platform"));
    }

}