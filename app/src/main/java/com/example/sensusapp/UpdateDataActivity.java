package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensusapp.Adapter.ViewPagerAdapter;
import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Fragment.FragmentAddAnggotaKeluarga;
import com.example.sensusapp.Fragment.FragmentUpdateAnggotaKeluarga;
import com.example.sensusapp.Fragment.FragmentUpdateKartuKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDataActivity extends AppCompatActivity {

    private TextView update_nokk;
    private ViewPagerAdapter viewPagerAdapterUpdate;
    private ViewPager viewPagerUpdate;
    private TabLayout tabLayoutUpdate;
    private ImageView imageViewUpdateBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);


        update_nokk = findViewById(R.id.textview_update_data_value_nokk);
        viewPagerUpdate = findViewById(R.id.viewPager_update);
        tabLayoutUpdate= findViewById(R.id.tabLayout_update);
        imageViewUpdateBack = findViewById(R.id.button_back_update_data);

        imageViewUpdateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPagerAdapterUpdate = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapterUpdate.addFragment(new FragmentUpdateKartuKeluarga(), "Informasi Umum");
        viewPagerAdapterUpdate.addFragment(new FragmentUpdateAnggotaKeluarga(), "Anggota Keluarga");

        viewPagerUpdate.setAdapter(viewPagerAdapterUpdate);
        tabLayoutUpdate.setupWithViewPager(viewPagerUpdate);

        parseJson();

    }

    void parseJson() {
        APIservice apIservice = APIurl.createService(APIservice.class, this);
        String id = getIntent().getStringExtra("no_kk");

        Call<Result<KartuKeluarga>> resultCall = apIservice.getDetailSensus(id);

        resultCall.enqueue(new Callback<Result<KartuKeluarga>>() {
            @Override
            public void onResponse(Call<Result<KartuKeluarga>> call, Response<Result<KartuKeluarga>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    update_nokk.setText(response.body().getData().getNo_kk());
                    String id = String.valueOf(response.body().getData().getId());

                    FragmentUpdateKartuKeluarga fragmentUpdateKartuKeluarga = (FragmentUpdateKartuKeluarga) viewPagerAdapterUpdate.getItem(0);
                    FragmentUpdateAnggotaKeluarga fragmentUpdateAnggotaKeluarga = (FragmentUpdateAnggotaKeluarga) viewPagerAdapterUpdate.getItem(1);
                    ((FragmentUpdateKartuKeluarga) fragmentUpdateKartuKeluarga).setUpdateInformasiGeneral(response.body().getData());
                    ((FragmentUpdateAnggotaKeluarga) fragmentUpdateAnggotaKeluarga).setUpdateAnggota(response.body().getData().getAnggota_keluarga());
                }


            }

            @Override
            public void onFailure(Call<Result<KartuKeluarga>> call, Throwable t) {
                Toast.makeText(UpdateDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}