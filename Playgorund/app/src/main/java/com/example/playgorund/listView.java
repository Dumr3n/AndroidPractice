package com.example.playgorund;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class listView extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        planetArrayList = new ArrayList<Planet>();
        planetArrayList.add(new Planet(R.drawable.mercury, "0 Moons", "Mercury"));
        planetArrayList.add(new Planet(R.drawable.venus, "0 Moons", "Venus"));
        planetArrayList.add(new Planet(R.drawable.earth, "1 Moon", "Earth"));
        planetArrayList.add(new Planet(R.drawable.mars, "1 Moon", "Mars"));
        planetArrayList.add(new Planet(R.drawable.jupiter, "79 Moons", "Jupiter"));
        planetArrayList.add(new Planet(R.drawable.saturn, "83 Moons", "Saturn"));
        planetArrayList.add(new Planet(R.drawable.uranus, "27 Moons", "Uranus"));
        planetArrayList.add(new Planet(R.drawable.neptune, "14 Moons", "Neptune"));
        planetArrayList.add(new Planet(R.drawable.pluto, "1 Moon", "Pluto"));

        CustomAdapter adapter = new CustomAdapter(planetArrayList, this);
        listView.setAdapter(adapter);
    }


}