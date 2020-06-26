package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Fragment.FragmentAddKartuKeluarga;
import com.example.sensusapp.Model.Master.Status;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDataActivity extends AppCompatActivity {

    private ImageView imageViewbtnback;
    private Spinner spinnerStatusRumah;
    private Context context;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_fragment_add_data, new FragmentAddKartuKeluarga()).commit();
        imageViewbtnback = (ImageView) findViewById(R.id.backbutton_add_data);
//        spinnerStatusRumah = (Spinner) findViewById(R.id.spinner_add_data_statusrumah);


        imageViewbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onBackPressed();
            }
        });




    }

    void parseJSON() {
        APIservice apIservice = APIurl.createService(APIservice.class, this);

        Call<Result<List<Status>>> call = apIservice.getStatus();

        call.enqueue(new Callback<Result<List<Status>>>() {
            @Override
            public void onResponse(Call<Result<List<Status>>> call, Response<Result<List<Status>>> response) {
                if(response.body() != null && response.body().isSuccessfull()) {
                    List<Status> statusList = response.body().getData();
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; i < statusList.size(); i++) {
                        list.add(statusList.get(i).getStatus());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddDataActivity.this, android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerStatusRumah.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Status>>> call, Throwable t) {
                Toast.makeText( AddDataActivity.this, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }


}