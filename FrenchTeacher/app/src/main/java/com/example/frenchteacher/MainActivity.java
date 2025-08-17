package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button blackBtn, redBtn, yellowBtn, purpleBtn, greenBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.blackBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        greenBtn = findViewById(R.id.greenBtn);

        blackBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();
        if (clickedBtnId == R.id.blackBtn) {
            playSound(R.raw.black);
        } else if (clickedBtnId == R.id.redBtn) {
            playSound(R.raw.red);
        } else if (clickedBtnId == R.id.greenBtn) {
            playSound(R.raw.green);
        } else if (clickedBtnId == R.id.yellowBtn) {
            playSound(R.raw.yellow);
        } else if (clickedBtnId == R.id.purpleBtn) {
            playSound(R.raw.purple);
        }
    }
    public void playSound(int id ) {
        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), id);
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Id " + id + " is playing", Toast.LENGTH_LONG).show();
    }
}