package com.example.sensusapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class AnggotaKeluargaAdapter extends RecyclerView.Adapter<AnggotaKeluargaAdapter.ViewHolder> {


    private ArrayList<KartuKeluarga> kartuKeluargas = new ArrayList<>();
    private Context context;

    public AnggotaKeluargaAdapter(ArrayList<KartuKeluarga> kartuKeluargas, Context context) {
        this.kartuKeluargas = kartuKeluargas;
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
        final String nama = kartuKeluargas.get(position).getAnggotaKeluargas().get(5).getNama();
        final String nik = kartuKeluargas.get(position).getAnggotaKeluargas().get(3).getNik();

        holder.nik.setText(nik);
        holder.nama.setText(nama);


    }

    @Override
    public int getItemCount() {
        return kartuKeluargas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nik, nama;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nik = (TextView) itemView.findViewById(R.id.textview_detail_keluarga_nik);
            nama = (TextView) itemView.findViewById(R.id.textview_detail_keluarga_nama);
        }
    }
}
