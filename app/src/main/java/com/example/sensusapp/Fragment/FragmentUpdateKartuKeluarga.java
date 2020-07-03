package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

public class FragmentUpdateKartuKeluarga extends Fragment {

    private View view;
    private EditText nama;
    private EditText dusun;
    private EditText rt;
    private EditText rw;
    private EditText alamat;
    private Spinner spinnerDesa;
    private Spinner spinnerStatusRumah;
    private Spinner spinnerStatusTanah;
    private EditText jumlahtanah;
    private EditText luastanah;
    private RadioGroup radioGroupStatusKemiskinan;
    private RadioButton radioButtonKemiskinanYa;
    private RadioButton radioButtonKemiskinanTidak;
    private Spinner spinnerJenisFasilitasAirBersih;
    private Spinner spinnerJenisSanitasi;
    private Spinner spinnerKonsumsiAirMinum;

    public FragmentUpdateKartuKeluarga() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.update_data_kartu_keluarga_fragment, container, false);

        nama = view.findViewById(R.id.edittext_update_data_nama);
        dusun = view.findViewById(R.id.edittext_update_data_dusun);
        alamat = view.findViewById(R.id.edittext_update_data_alamat);
        rt = view.findViewById(R.id.edittext_update_data_rt);
        rw = view.findViewById(R.id.edittext_update_data_rw);
        jumlahtanah = view.findViewById(R.id.edittext_update_data_jumlahtanahgarapan);
        luastanah = view.findViewById(R.id.edittext_update_data_luastanahgarapan);
        spinnerDesa = view.findViewById(R.id.spinner_update_data_desa);
        spinnerStatusRumah = view.findViewById(R.id.spinner_update_data_statusrumah);
        spinnerStatusTanah = view.findViewById(R.id.spinner_update_data_statustanahgarapan);
        spinnerJenisFasilitasAirBersih = view.findViewById(R.id.spinner_update_data_jenisfasilitasair);
        spinnerJenisSanitasi = view.findViewById(R.id.spinner_update_data_jenissanitasi);
        spinnerKonsumsiAirMinum = view.findViewById(R.id.spinner_update_data_konsumsiairminum);
        radioGroupStatusKemiskinan = view.findViewById(R.id.radiogroup_update_data_statuskemiskinan);
        radioButtonKemiskinanYa = view.findViewById(R.id.radiobutton_update_data_statuskemiskinan_ya);
        radioButtonKemiskinanTidak = view.findViewById(R.id.radiobutton_update_data_statuskemiskinan_tidak);

        return view;
    }

    public void setUpdateInformasiGeneral(KartuKeluarga kartuKeluarga) {
        nama.setText(kartuKeluarga.getNama());
        dusun.setText(kartuKeluarga.getDusun());
        alamat.setText(kartuKeluarga.getAddress());
        rt.setText(kartuKeluarga.getRt());
        rw.setText(kartuKeluarga.getRw());
        jumlahtanah.setText(String.valueOf(kartuKeluarga.getJumlah_tanah_garapan()));
        luastanah.setText(String.valueOf(kartuKeluarga.getLuas_tanah_garapan()));
        spinnerDesa.setSelection(kartuKeluarga.getDesa_id());

//        if (kartuKeluarga.isStatus_kemiskinan())
//            radioButtonKemiskinanYa.isChecked();
//        else
//            radioButtonKemiskinanTidak.isChecked();
    }
}
