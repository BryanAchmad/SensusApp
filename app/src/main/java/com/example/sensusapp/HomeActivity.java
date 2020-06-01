package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sensusapp.Adapter.KartuKeluargaAdapter;
import com.example.sensusapp.Model.KartuKeluarga;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KartuKeluargaAdapter adapter;
    private ArrayList<KartuKeluarga> list;
    private CardView cardViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerDataKK);
        adapter = new KartuKeluargaAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        cardViewSearch = (CardView) findViewById(R.id.button_search);

        cardViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }

    void addData(){
        list = new ArrayList<>();
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));

    }
}
