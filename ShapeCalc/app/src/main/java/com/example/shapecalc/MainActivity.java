package com.example.shapecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    ArrayList<Shape> shapeList;

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

        gridView = findViewById(R.id.gridView);
        shapeList = new ArrayList<>();
        shapeList.add(new Shape("Sphere", R.drawable.sphere));
        shapeList.add(new Shape("Cube", R.drawable.cube));
        shapeList.add(new Shape("Cylinder", R.drawable.cylinder));
        shapeList.add(new Shape("Prism", R.drawable.prism));

        ShapesAdaptor adapter = new ShapesAdaptor(getApplicationContext(), shapeList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Calculate.class);
                i.putExtra("shape", shapeList.get(position).getShapeName());
                startActivity(i);
            }
        });
    }
}