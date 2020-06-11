package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensusapp.Adapter.ViewPagerAdapter;
import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Fragment.FragmentInformasi;
import com.example.sensusapp.Fragment.FragmentKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageViewBackButton;
    private TextView txtNoKK;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tabLayout = findViewById(R.id.tabLayout_detail);
        viewPager = findViewById(R.id.viewPager_detail);
        imageViewBackButton = findViewById(R.id.button_back_detail);
        txtNoKK = findViewById(R.id.txt_no_kartu_keluarga);

        imageViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentInformasi(), "Informasi Umum");
        adapter.addFragment(new FragmentKeluarga(), "Anggota Keluarga");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        parseJSON();
    }

    void parseJSON() {
        APIservice apIservice = APIurl.createService(APIservice.class, this);
        String path = getIntent().getStringExtra("no_kk");
        Call<Result<KartuKeluarga>> resultCall = apIservice.getDetailSensus(path);

        resultCall.enqueue(new Callback<Result<KartuKeluarga>>() {
            @Override
            public void onResponse(Call<Result<KartuKeluarga>> call, Response<Result<KartuKeluarga>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {

                    txtNoKK.setText(response.body().getData().getNo_kk());
                    Log.d("sanitasi", response.body().getData().getJenis_sanitasi().getJenis());

                    FragmentInformasi activeFragment = (FragmentInformasi) adapter.getItem(0);
                    FragmentKeluarga fragmentKeluarga = (FragmentKeluarga) adapter.getItem(1);
                    ((FragmentInformasi) activeFragment).setInformasiGeneral(response.body().getData());
                    ((FragmentKeluarga) fragmentKeluarga).setInformasiKeluarga(response.body().getData().getAnggota_keluarga());



                }
            }

            @Override
            public void onFailure(Call<Result<KartuKeluarga>> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
