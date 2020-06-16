package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.KartuKeluarga;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDataActivity extends AppCompatActivity {

    private TextView update_nik;
    private EditText update_nama;
    private EditText update_dusun;
    private EditText update_rt;
    private EditText update_rw;
    private EditText update_statusrumah;
    private EditText update_statustanahgarapan;
    private EditText update_jumlahtanahgarapan;
    private EditText update_luastanahgarapan;
    private EditText update_statuskemiskinan;
    private EditText update_jenisfasilitasairbersih;
    private EditText update_jenissanitasi;
    private EditText update_konsumsiairminum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        update_nik = findViewById(R.id.textview_update_data_value_nik);
        update_nama = findViewById(R.id.edittext_update_data_nama);
        update_dusun = findViewById(R.id.edittext_update_data_dusun);
        update_rt = findViewById(R.id.edittext_update_data_rt);
        update_rw = findViewById(R.id.edittext_update_data_alamat);
        update_statusrumah = findViewById(R.id.edittext_update_data_alamat);
        update_statustanahgarapan = findViewById(R.id.edittext_update_data_alamat);
        update_jumlahtanahgarapan = findViewById(R.id.edittext_update_data_alamat);
        update_luastanahgarapan = findViewById(R.id.edittext_update_data_alamat);
        update_statuskemiskinan = findViewById(R.id.edittext_update_data_alamat);
        update_jenisfasilitasairbersih = findViewById(R.id.edittext_update_data_alamat);
        update_jenissanitasi = findViewById(R.id.edittext_update_data_alamat);
        update_konsumsiairminum = findViewById(R.id.edittext_update_data_alamat);


    }

    void parseJson() {
        APIservice apIservice = APIurl.createService(APIservice.class, this);
        String id = getIntent().getStringExtra("id");

        Call<Result<KartuKeluarga>> resultCall = apIservice.updateSensus(id);

        resultCall.enqueue(new Callback<Result<KartuKeluarga>>() {
            @Override
            public void onResponse(Call<Result<KartuKeluarga>> call, Response<Result<KartuKeluarga>> response) {

            }

            @Override
            public void onFailure(Call<Result<KartuKeluarga>> call, Throwable t) {

            }
        });
    }
}