package com.example.sensusapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensusapp.Adapter.KartuKeluargaAdapter;
import com.example.sensusapp.Adapter.SearchAdapter;
import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.KartuKeluarga;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private Toolbar toolbarSearch;
    private TextView textViewSearch;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private ArrayList<KartuKeluarga> kartuKeluargas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbarSearch = (Toolbar) findViewById(R.id.toolbar_search);
        imageViewBack = (ImageView) findViewById(R.id.backbutton);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_data_sensus);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        parseJSON();

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                if(response.body() != null && response.body().isSuccessfull()) {
                    kartuKeluargas.addAll(response.body().getData());
                    searchAdapter = new SearchAdapter(kartuKeluargas, SearchActivity.this);
                    recyclerView.setAdapter(searchAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<KartuKeluarga>>> call, Throwable t) {
                Toast.makeText(SearchActivity.this,"Oops! Something went wrong!",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }


}
