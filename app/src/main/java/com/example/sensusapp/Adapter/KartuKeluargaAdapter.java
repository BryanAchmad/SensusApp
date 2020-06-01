package com.example.sensusapp.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class KartuKeluargaAdapter extends RecyclerView.Adapter<KartuKeluargaAdapter.KartuKeluargaViewHolder> {

    private ArrayList<KartuKeluarga> datalist;

    public KartuKeluargaAdapter(ArrayList<KartuKeluarga> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public KartuKeluargaAdapter.KartuKeluargaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_kartukeluarga, parent, false);
        return new KartuKeluargaAdapter.KartuKeluargaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KartuKeluargaAdapter.KartuKeluargaViewHolder holder, int position) {
        holder.txttgl.setText(datalist.get(position).getDate_update());
        holder.txtkk.setText(datalist.get(position).getNo_kk());
        holder.txtjam.setText(datalist.get(position).getLast_update());
    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() : 0;
    }


    public class KartuKeluargaViewHolder extends RecyclerView.ViewHolder{
        private TextView txttgl, txtkk, txtjam;

        public KartuKeluargaViewHolder(@NonNull View itemView) {
            super(itemView);
            txttgl = (TextView) itemView.findViewById(R.id.tglupdate);
            txtkk = (TextView) itemView.findViewById(R.id.no_kk);
            txtjam = (TextView) itemView.findViewById(R.id.jamupdate);
        }
    }
}
