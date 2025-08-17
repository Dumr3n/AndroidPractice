package com.example.cardbiewpractise;

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

public class MainActivity extends AppCompatActivity implements cardClickListener{
    private RecyclerView recyclerView;
    private List<cardViewClass> cardList;
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
        recyclerView = findViewById(R.id.recyclerView);
        cardList = new ArrayList<>();
        cardList.add(new cardViewClass(R.drawable.basketball, "Basketball"));
        cardList.add(new cardViewClass(R.drawable.football, "Football"));
        cardList.add(new cardViewClass(R.drawable.ping, "Ping"));
        cardList.add(new cardViewClass(R.drawable.tennis, "Tennis"));
        cardList.add(new cardViewClass(R.drawable.volley, "Volley"));
        cardAdapter adapter = new cardAdapter(cardList);
        RecyclerView.LayoutManager linearManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearManager);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You choose" + cardList.get(pos).getTitle(), Toast.LENGTH_LONG).show();
    }
}