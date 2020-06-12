package com.example.sensusapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.DetailActivity;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<KartuKeluarga> kartuKeluargas = new ArrayList<>();
    private Context context;

    public SearchAdapter(ArrayList<KartuKeluarga> kartuKeluargas, Context context) {
        this.kartuKeluargas = kartuKeluargas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kartu_keluarga_search, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String nokk = kartuKeluargas.get(position).getNo_kk();
        final String nama = kartuKeluargas.get(position).getNama();

        holder.txtnokk.setText(nokk);
        holder.txtnama.setText(nama);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(), DetailActivity.class);
                intent.putExtra("no_kk", nokk);
                holder.cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kartuKeluargas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnokk, txtnama;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnokk = itemView.findViewById(R.id.textview_search_kartu_keluarga_nokk);
            txtnama = itemView.findViewById(R.id.textview_search_kartu_keluarga_nama);
            cardView = itemView.findViewById(R.id.cardview_list_kartu_keluarga_search);
        }
    }
}
