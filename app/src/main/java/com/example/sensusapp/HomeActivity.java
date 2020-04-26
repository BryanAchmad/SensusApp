package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KartuKeluargaAdapter adapter;
    private ArrayList<KartuKeluarga> list;

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
