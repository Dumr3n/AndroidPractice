package com.example.playgorund;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        EditText myEditText =findViewById(R.id.edit);
        String myText = myEditText.getText().toString();
        System.out.println(myText);
        Button myBtn = findViewById(R.id.button);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText("My own text!");
                Toast.makeText(MainActivity.this, "You clicked da button!", Toast.LENGTH_LONG).show();
            }
        });

        Toast.makeText(MainActivity.this, "OnCreateToast to show!", Toast.LENGTH_LONG).show();

        Button switchBtn = findViewById(R.id.SwitchButton);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondAct();
            }
        });

        Button googleBtn = findViewById(R.id.googlebtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToGoogle();
            }
        });

        Button switchBty = findViewById(R.id.listviewbtn);
        switchBty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToListView();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "OnStartToast to show!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "OnResumeToast to show!", Toast.LENGTH_LONG).show();
    }

    public void goToSecondAct() {
        Intent newIntent = new Intent(this, SecondaryACt.class);
        startActivity(newIntent);
    }

    public void GoToGoogle() {
        Uri newUrl = Uri.parse("https://www.google.com/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, newUrl);
        startActivity(webIntent);
    }

    public void goToListView() {
        Intent newIntent = new Intent(this, listView.class);
        startActivity(newIntent);
    }
}