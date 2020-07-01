package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

public class FragmentInformasi extends Fragment {

    private View view;
    private TextView nama;
    private TextView dusun;
    private TextView rt;
    private TextView rw;
    private TextView statusrumah;
    private TextView statustanahgarapan;
    private TextView jumlahtanahgarapan;
    private TextView luastanahgarapan;
    private TextView statuskemiskinan;
    private TextView jenisfasilitasairbersih;
    private TextView jenissanitasi;
    private TextView konsumsiairminum;



    public FragmentInformasi() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.informasi_fragment, container, false);

        nama = view.findViewById(R.id.textview_detail_informasigeneral_value_nama);
        dusun = view.findViewById(R.id.textview_detail_informasigeneral_value_dusun);
        rt = view.findViewById(R.id.textview_detail_informasigeneral_value_rt);
        rw = view.findViewById(R.id.textview_detail_informasigeneral_value_rw);
        statusrumah = view.findViewById(R.id.textview_detail_informasigeneral_value_statusrumah);
        statustanahgarapan = view.findViewById(R.id.textview_detail_informasigeneral_value_statustanahgarapan);
        jumlahtanahgarapan = view.findViewById(R.id.textview_detail_informasigeneral_value_jumlahtanahgarapan);
        luastanahgarapan = view.findViewById(R.id.textview_detail_informasigeneral_value_luastanahgarapan);
        statuskemiskinan = view.findViewById(R.id.textview_detail_informasigeneral_value_statuskemiskinan);
        jenisfasilitasairbersih = view.findViewById(R.id.textview_detail_informasigeneral_value_jenisfasairbersih);
        jenissanitasi = view.findViewById(R.id.textview_detail_informasigeneral_value_jenissanitasi);
        konsumsiairminum = view.findViewById(R.id.textview_detail_informasigeneral_value_konsumsiairminum);




        return view;
    }

    public void setInformasiGeneral(KartuKeluarga kartuKeluarga) {

            nama.setText(kartuKeluarga.getNama());
            dusun.setText(kartuKeluarga.getDusun());
            rt.setText(kartuKeluarga.getRt());
            rw.setText(kartuKeluarga.getRw());
            statusrumah.setText(kartuKeluarga.getStatus_rumah());
            statustanahgarapan.setText(kartuKeluarga.getStatus_tanah_garapan());

            jumlahtanahgarapan.setText(String.valueOf(kartuKeluarga.getJumlah_tanah_garapan()));
            luastanahgarapan.setText(String.valueOf(kartuKeluarga.getLuas_tanah_garapan()));

            if(kartuKeluarga.isStatus_kemiskinan()){
                statuskemiskinan.setText("Ya");
            } else {
                statuskemiskinan.setText("Tidak");
            }

            jenisfasilitasairbersih.setText(kartuKeluarga.getJenis_fasilitas_air_bersih().getJenis());
            jenissanitasi.setText(kartuKeluarga.getJenis_sanitasi().getJenis());
            konsumsiairminum.setText(kartuKeluarga.getKonsumsi_air_minum().getJenis());

    }
}
