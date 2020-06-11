package com.example.sensusapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.Fragment.FragmentKeluarga;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class AnggotaKeluargaAdapter extends RecyclerView.Adapter<AnggotaKeluargaAdapter.ViewHolder> {


    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private Context context;
    private KartuKeluargaAdapter adapter;

    public AnggotaKeluargaAdapter(ArrayList<AnggotaKeluarga> anggotaKeluargas, Context context) {
        this.anggotaKeluargas = anggotaKeluargas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_anggota_keluarga, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        final String nama = kartuKeluargas.get(position).getAnggota_keluarga().get(position).getNama();
//        final String nik = kartuKeluargas.get(position).getAnggota_keluarga().get(position).getNik();

        final String nik = anggotaKeluargas.get(position).getNik();
        final String nama = anggotaKeluargas.get(position).getNama();

        holder.nik.setText(nik);
        holder.nama.setText(nama);


    }

    @Override
    public int getItemCount() {
        return anggotaKeluargas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nik, nama;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nik = (TextView) itemView.findViewById(R.id.textview_detail_keluarga_nik);
            nama = (TextView) itemView.findViewById(R.id.textview_detail_keluarga_nama);
            cardView = (CardView) itemView.findViewById(R.id.cardview_detail_kartu_keluarga);
        }
    }
}
