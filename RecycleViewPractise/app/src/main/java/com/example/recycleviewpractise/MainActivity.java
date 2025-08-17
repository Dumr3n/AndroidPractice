package com.example.recycleviewpractise;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    List<Item> itemList;
    CustomAdapter adapter;
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
        recyclerView = findViewById(R.id.recycleView);
        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.beverage, "Beverage", "The freshest beverages"));
        itemList.add(new Item(R.drawable.bread, "Bread", "The freshest bread"));
        itemList.add(new Item(R.drawable.fruit, "Fruits", "The freshest fruits"));
        itemList.add(new Item(R.drawable.milk, "Milk", "The freshest milk"));
        itemList.add(new Item(R.drawable.popcorn, "Popcorn", "The freshest popcorn"));
        itemList.add(new Item(R.drawable.vegitables, "Milk", "The freshest vegetables"));
        adapter = new CustomAdapter(itemList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You choose " + itemList.get(pos).getPrimary(), Toast.LENGTH_LONG).show();
    }
}