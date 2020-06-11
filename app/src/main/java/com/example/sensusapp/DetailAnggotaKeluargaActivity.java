package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAnggotaKeluargaActivity extends AppCompatActivity {

    private TextView txtnik;
    private TextView txtnama;
    private TextView txtjenis_kelamin;
    private TextView txttempat_lahir;
    private TextView txttanggal_lahir;
    private TextView txtgolongan_darah;
    private TextView txtagama;
    private TextView txtstatus;
    private TextView txtrelasi;
    private TextView txtpendidikan;
    private TextView txtstatus_pendidikan_sekarang;
    private TextView txtpekerjaan;
    private TextView txtibu;
    private TextView txtayah;
    private TextView txtyatim;
    private TextView txtpiatu;
    private TextView txtstatus_penerima_bantuan;
    private TextView txtdisabilitas;
    private TextView txtkeanggotaan_ormas;

    private ImageView imageViewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anggota_keluarga);

        imageViewButton = findViewById(R.id.backbutton_detail_anggota);

        txtnik = findViewById(R.id.textview_detail_anggota_value_nik);
        txtnama = findViewById(R.id.textview_detail_anggota_value_nama);
        txtjenis_kelamin = findViewById(R.id.textview_detail_anggota_value_jeniskelamin);
        txttempat_lahir = findViewById(R.id.textview_detail_anggota_value_tempatlahir);
        txttanggal_lahir = findViewById(R.id.textview_detail_anggota_value_tanggallahir);
        txtgolongan_darah = findViewById(R.id.textview_detail_anggota_value_goldar);
        txtagama = findViewById(R.id.textview_detail_anggota_value_agama);
        txtstatus = findViewById(R.id.textview_detail_anggota_value_status);
        txtrelasi = findViewById(R.id.textview_detail_anggota_value_relasi);
        txtpendidikan = findViewById(R.id.textview_detail_anggota_value_pendidikan);
        txtstatus_pendidikan_sekarang = findViewById(R.id.textview_detail_anggota_value_statuspendidikan);
        txtpekerjaan = findViewById(R.id.textview_detail_anggota_value_pekerjaan);
        txtibu = findViewById(R.id.textview_detail_anggota_value_ibu);
        txtayah = findViewById(R.id.textview_detail_anggota_value_ayah);
        txtyatim = findViewById(R.id.textview_detail_anggota_value_yatim);
        txtpiatu = findViewById(R.id.textview_detail_anggota_value_piatu);
        txtstatus_penerima_bantuan = findViewById(R.id.textview_detail_anggota_value_statusbantuan);
        txtdisabilitas = findViewById(R.id.textview_detail_anggota_value_disabilitas);
        txtkeanggotaan_ormas = findViewById(R.id.textview_detail_anggota_value_ormas);

        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        parseJSON();


    }

    void parseJSON() {
        AnggotaKeluarga anggotaKeluarga = getIntent().getParcelableExtra("anggota_keluarga");
        txtnik.setText(anggotaKeluarga.getNik());
        txtnama.setText(anggotaKeluarga.getNama());

        if (anggotaKeluarga.getJenis_kelamin() == "P") {
            txtjenis_kelamin.setText("Perempuan");
        } else {
            txtjenis_kelamin.setText("Laki - laki");
        }

        txttempat_lahir.setText(anggotaKeluarga.getTempat_lahir());
        txttanggal_lahir.setText(anggotaKeluarga.getTanggal_lahir());
        txtgolongan_darah.setText(anggotaKeluarga.getGolongan_darah());
        txtagama.setText(anggotaKeluarga.getAgama());
        txtstatus.setText(anggotaKeluarga.getStatus().getStatus());
        txtrelasi.setText(anggotaKeluarga.getRelasi().getRelasi());
        txtpendidikan.setText(anggotaKeluarga.getPendidikan().getPendidikan());
        txtstatus_pendidikan_sekarang.setText(anggotaKeluarga.getStatus_pendidikan_sekarang());
        txtpekerjaan.setText(anggotaKeluarga.getPekerjaan().getPekerjaan());
        txtibu.setText(anggotaKeluarga.getIbu());
        txtayah.setText(anggotaKeluarga.getAyah());

        if (anggotaKeluarga.isYatim()){
            txtyatim.setText("Ya");
        } else {
            txtyatim.setText("Tidak");
        }

        if (anggotaKeluarga.isPiatu()){
            txtpiatu.setText("Ya");
        } else {
            txtpiatu.setText("Tidak");
        }

        txtstatus_penerima_bantuan.setText(anggotaKeluarga.getStatus_penerima_bantuan());
        txtdisabilitas.setText(anggotaKeluarga.getDisabilitas().getKategori());
        txtkeanggotaan_ormas.setText(anggotaKeluarga.getKeanggotaan_ormas());

    }
}