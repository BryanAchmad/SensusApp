package com.example.sensusapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class AddAnggotaKeluargaAdapter extends RecyclerView.Adapter<AddAnggotaKeluargaAdapter.ViewHolder> {

    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private Context context;

    public AddAnggotaKeluargaAdapter(ArrayList<AnggotaKeluarga> anggotaKeluargas, Context context) {
        this.anggotaKeluargas = anggotaKeluargas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_add_anggota_keluarga, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
