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

import com.example.sensusapp.DetailAnggotaKeluargaActivity;
import com.example.sensusapp.Fragment.FragmentKeluarga;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class AnggotaKeluargaAdapter extends RecyclerView.Adapter<AnggotaKeluargaAdapter.ViewHolder> {


    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private ArrayList<KartuKeluarga> kartuKeluargas = new ArrayList<>();
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
        final String jeniskelamin = anggotaKeluargas.get(position).getJenis_kelamin();
        final String tempat = anggotaKeluargas.get(position).getTempat_lahir();
        final String tanggal = anggotaKeluargas.get(position).getTanggal_lahir();
        final String gol = anggotaKeluargas.get(position).getGolongan_darah();
        final String agama = anggotaKeluargas.get(position).getAgama();
        final String status = anggotaKeluargas.get(position).getStatus().getStatus();
       // final String nokk = String.valueOf(kartuKeluargas.get(position).getNo_kk());

        holder.nik.setText(nik);
        holder.nama.setText(nama);

        //AnggotaKeluarga anggotaKeluarga = new AnggotaKeluarga(nik, nama, );

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AnggotaKeluarga anggotaKeluarga = new AnggotaKeluarga(
//                        nik,
//                        nama,
//                        jeniskelamin,
//                        tempat,
//                        tanggal,
//                        gol,
//                        agama,
//                        status
//                );

                AnggotaKeluarga anggotaKeluarga = anggotaKeluargas.get(position);



                Intent intent = new Intent(holder.cardView.getContext(), DetailAnggotaKeluargaActivity.class);
                intent.putExtra("anggota_keluarga", anggotaKeluarga);
                holder.cardView.getContext().startActivity(intent);
            }
        });


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
