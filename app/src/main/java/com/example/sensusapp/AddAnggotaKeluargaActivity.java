package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAnggotaKeluargaActivity extends AppCompatActivity {

    private Spinner spinnerStatus;
    private Spinner spinnerRelasi;
    private Spinner spinnerPendidikan;
    private Spinner spinnerPekerjaan;
    private Spinner spinnerDisabilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_anggota_keluarga);

        spinnerStatus = findViewById(R.id.spinner_add_anggota_keluarga_value_status);
        spinnerRelasi = findViewById(R.id.spinner_add_anggota_keluarga_value_relasi);
        spinnerPendidikan = findViewById(R.id.spinner_add_anggota_keluarga_value_pendidikan);
        spinnerPekerjaan = findViewById(R.id.spinner_add_anggota_keluarga_value_pekerjaan);
        spinnerDisabilitas = findViewById(R.id.spinner_add_anggota_keluarga_value_disabilitas);


        parseJSON();
    }

    void parseJSON() {
        APIservice apIservice = APIurl.createService(APIservice.class, this);

        Call<Result<List<Status>>> statusCall = apIservice.getStatus();
        statusCall.enqueue(new Callback<Result<List<Status>>>() {
            @Override
            public void onResponse(Call<Result<List<Status>>> call, Response<Result<List<Status>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Status> statusList = response.body().getData();
                    List<Status> list = new ArrayList<>();

                    for (int i = 0; i < statusList.size(); i++) {
                        list.addAll(statusList);
                    }

                    ArrayAdapter<Status> statusArrayAdapter = new ArrayAdapter<Status>(AddAnggotaKeluargaActivity.this, android.R.layout.simple_spinner_item, list);
                    statusArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerStatus.setAdapter(statusArrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Status>>> call, Throwable t) {

            }
        });

        Call<Result<List<Relasi>>> relasiCall = apIservice.getRelasi();
        relasiCall.enqueue(new Callback<Result<List<Relasi>>>() {
            @Override
            public void onResponse(Call<Result<List<Relasi>>> call, Response<Result<List<Relasi>>> response) {
                if (response.body() != null && response.body().isSuccessfull()){
                    List<Relasi> relasiList = response.body().getData();
                    List<Relasi> list = new ArrayList<>();

                    for (int i = 0 ; i<relasiList.size() ; i++) {
                        list.addAll(relasiList);
                    }

                    ArrayAdapter<Relasi> relasiArrayAdapter = new ArrayAdapter<Relasi>(AddAnggotaKeluargaActivity.this, android.R.layout.simple_spinner_item, list);
                    relasiArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRelasi.setAdapter(relasiArrayAdapter);
                }

            }

            @Override
            public void onFailure(Call<Result<List<Relasi>>> call, Throwable t) {

            }
        });

        Call<Result<List<Pendidikan>>> pendidikanResultCall = apIservice.pendidikan();
        pendidikanResultCall.enqueue(new Callback<Result<List<Pendidikan>>>() {
            @Override
            public void onResponse(Call<Result<List<Pendidikan>>> call, Response<Result<List<Pendidikan>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Pendidikan> pendidikanList = response.body().getData();
                    List<Pendidikan> list = new ArrayList<>();

                    for (int i = 0 ; i< pendidikanList.size() ; i++) {
                        list.addAll(pendidikanList);
                    }

                    ArrayAdapter<Pendidikan> pendidikanArrayAdapter = new ArrayAdapter<Pendidikan>(AddAnggotaKeluargaActivity.this, android.R.layout.simple_spinner_item, list);
                    pendidikanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPendidikan.setAdapter(pendidikanArrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Pendidikan>>> call, Throwable t) {

            }
        });

        Call<Result<List<Pekerjaan>>> pekerjaanResultCall = apIservice.pekerjaan();
        pekerjaanResultCall.enqueue(new Callback<Result<List<Pekerjaan>>>() {
            @Override
            public void onResponse(Call<Result<List<Pekerjaan>>> call, Response<Result<List<Pekerjaan>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Pekerjaan> pekerjaanList = response.body().getData();
                    List<Pekerjaan> list = new ArrayList<>();

                    for (int i = 0 ; i < pekerjaanList.size() ; i++) {
                        list.addAll(pekerjaanList);
                    }

                    ArrayAdapter<Pekerjaan> pekerjaanArrayAdapter = new ArrayAdapter<Pekerjaan>(AddAnggotaKeluargaActivity.this, android.R.layout.simple_spinner_item, list);
                    pekerjaanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPekerjaan.setAdapter(pekerjaanArrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Pekerjaan>>> call, Throwable t) {

            }
        });

        Call<Result<List<Disabilitas>>> disabilitasResultCall = apIservice.disabilitas();
        disabilitasResultCall.enqueue(new Callback<Result<List<Disabilitas>>>() {
            @Override
            public void onResponse(Call<Result<List<Disabilitas>>> call, Response<Result<List<Disabilitas>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Disabilitas> disabilitasList = response.body().getData();
                    List<Disabilitas> list = new ArrayList<>();

                    for (int i = 0 ; i<disabilitasList.size() ; i++){
                        list.addAll(disabilitasList);
                    }

                    ArrayAdapter<Disabilitas> disabilitasArrayAdapter = new ArrayAdapter<Disabilitas>(AddAnggotaKeluargaActivity.this, android.R.layout.simple_spinner_item, list);
                    disabilitasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerDisabilitas.setAdapter(disabilitasArrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Disabilitas>>> call, Throwable t) {

            }
        });
    }
}