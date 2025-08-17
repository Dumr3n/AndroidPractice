package com.example.shapecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculate extends AppCompatActivity {
    EditText firstVal, secondVal;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("shape");
        firstVal = findViewById(R.id.firstVal);
        secondVal = findViewById(R.id.secondVal);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.button);


        switch (name) {
            case "Sphere":
                secondVal.setVisibility(View.INVISIBLE);
                firstVal.setHint("r:");
                title.setText("Sphere Volume");
                break;
            case "Cube":
                secondVal.setVisibility(View.INVISIBLE);
                firstVal.setHint("a:");;
                title.setText("Cube Volume");
                break;
            case "Cylinder":
                firstVal.setHint("r:");
                secondVal.setHint("h:");
                title.setText("Cylinder Volume");
                break;
            case "Prism":
                firstVal.setHint("a:");
                secondVal.setHint("h:");
                title.setText("Cylinder Volume");
                break;
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res;
                String firstVar, secondVar;
                switch (name) {
                    case "Sphere":
                        firstVar = firstVal.getText().toString();
                        int r = Integer.parseInt(firstVar);
                        res = (4./3.) * 3.1415926 *r*r*r;
                        result.setText("V = "+res+" m^3");
                        break;
                    case "Cube":
                        firstVar = firstVal.getText().toString();
                        int a = Integer.parseInt(firstVar);
                        res = a*a*a;
                        result.setText("V = "+res+" m^3");
                        break;
                    case "Cylinder":
                        firstVar = firstVal.getText().toString();
                        secondVar = secondVal.getText().toString();
                        int rc = Integer.parseInt(firstVar);
                        int hc = Integer.parseInt(secondVar);
                        res = 3.1415926 * rc *rc *hc;
                        result.setText("V = "+res+" m^3");
                        break;
                    case "Prism":
                        firstVar = firstVal.getText().toString();
                        secondVar = secondVal.getText().toString();
                        int ap = Integer.parseInt(firstVar);
                        int hp = Integer.parseInt(secondVar);
                        res = ap *hp;
                        result.setText("V = "+res+" m^3");
                        break;
                }

            }
        });
    }
}