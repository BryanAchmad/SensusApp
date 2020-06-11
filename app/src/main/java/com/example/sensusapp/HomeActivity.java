package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sensusapp.Adapter.KartuKeluargaAdapter;
import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Api.SharedPrefManager;
import com.example.sensusapp.Model.KartuKeluarga;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KartuKeluargaAdapter adapter;
    private CardView cardViewSearch;
    private ArrayList<KartuKeluarga> kartuKeluargas = new ArrayList<>();
    private Button btnTambahData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerDataKK);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new KartuKeluargaAdapter(list);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        parseJSON();
        cardViewSearch = (CardView) findViewById(R.id.button_search);
        btnTambahData = (Button) findViewById(R.id.button_tambah_data);

        cardViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddDataActivity.class);
                startActivity(intent);
            }
        });

    }

    void parseJSON(){

        APIservice apIservice = APIurl.createService(APIservice.class, this);
//        Call<Result<KartuKeluarga>> call = apIservice.sensus();
        Call<Result<List<KartuKeluarga>>> call = apIservice.sensus();

        call.enqueue(new Callback<Result<List<KartuKeluarga>>>() {
            @Override
            public void onResponse(Call<Result<List<KartuKeluarga>>> call, Response<Result<List<KartuKeluarga>>> response) {
               // Log.d("iki  lo datane", SharedPrefManager.getInstance().getToken()+"");
                if(response.body() != null && response.body().isSuccessfull()) {
                    kartuKeluargas.addAll(response.body().getData());
                    adapter = new KartuKeluargaAdapter(kartuKeluargas, HomeActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<KartuKeluarga>>> call, Throwable t) {
                Toast.makeText(HomeActivity.this,"Oops! Something went wrong!",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

//
//        list = new ArrayList<>();
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));
//        list.add(new KartuKeluarga("09809810293800", "08:00 WIB", "20 Jan 2020"));

    }
}
