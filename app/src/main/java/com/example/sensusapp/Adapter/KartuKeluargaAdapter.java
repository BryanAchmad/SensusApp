package com.example.sensusapp.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;
import java.util.Calendar;

public class KartuKeluargaAdapter extends RecyclerView.Adapter<KartuKeluargaAdapter.ViewHolder> {

    private ArrayList<KartuKeluarga> datalist = new ArrayList<>();
    private Context context;

    public KartuKeluargaAdapter(ArrayList<KartuKeluarga> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kartukeluarga, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //final String id = datalist.get(position).getId()+"";
        final String id = String.valueOf(datalist.get(position).getId());
        final String no_kk = datalist.get(position).getNo_kk();
        final String nama = datalist.get(position).getNama();

        holder.id.setText(id);
        holder.no_kk.setText(no_kk);
        holder.nama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id, no_kk, nama;
        private CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.tglupdate);
            no_kk = (TextView) itemView.findViewById(R.id.no_kk);
            nama = (TextView) itemView.findViewById(R.id.jamupdate);
            cardview = (CardView) itemView.findViewById(R.id.cardview_home_last);

        }
    }


//    @NonNull
//    @Override
//    public KartuKeluargaAdapter.KartuKeluargaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.list_kartukeluarga, parent, false);
//        return new KartuKeluargaAdapter.KartuKeluargaViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull KartuKeluargaAdapter.KartuKeluargaViewHolder holder, int position) {
//        holder.txttgl.setText(datalist.get(position).getId());
//        holder.txtkk.setText(datalist.get(position).getNo_kk());
//        holder.txtjam.setText(datalist.get(position).getNama());
//    }
//
//    @Override
//    public int getItemCount() {
//        return (datalist != null) ? datalist.size() : 0;
//    }
//
//
//    public class KartuKeluargaViewHolder extends RecyclerView.ViewHolder{
//        private TextView txttgl, txtkk, txtjam;
//
//        public KartuKeluargaViewHolder(@NonNull View itemView) {
//            super(itemView);
//            txttgl = (TextView) itemView.findViewById(R.id.tglupdate);
//            txtkk = (TextView) itemView.findViewById(R.id.no_kk);
//            txtjam = (TextView) itemView.findViewById(R.id.jamupdate);
//        }
//    }
}
