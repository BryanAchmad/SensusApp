package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.Adapter.AnggotaKeluargaAdapter;
import com.example.sensusapp.Adapter.KartuKeluargaAdapter;
import com.example.sensusapp.DetailActivity;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentKeluarga extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private AnggotaKeluargaAdapter adapter;
    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private CardView cardView;
    private TextView txtNik;
    private TextView txtNama;

    public FragmentKeluarga() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.keluarga_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_detail_keluarga);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        txtNik = view.findViewById(R.id.textview_detail_keluarga_nik);
        txtNama = view.findViewById(R.id.textview_detail_keluarga_nama);



        return view;
    }

    public void setInformasiKeluarga(List<AnggotaKeluarga> anggotaKeluarga) {
       // Log.d("kartukeluarga", String.valueOf(kartuKeluarga));
        anggotaKeluargas.addAll(anggotaKeluarga);
        adapter = new AnggotaKeluargaAdapter(anggotaKeluargas, getContext());
        recyclerView.setAdapter(adapter);

//        txtNik.setText(kartuKeluarga.getAnggota_keluarga().get(3).getNik());
//        txtNama.setText(kartuKeluarga.getAnggota_keluarga().get(5).getNama());
    }
}
