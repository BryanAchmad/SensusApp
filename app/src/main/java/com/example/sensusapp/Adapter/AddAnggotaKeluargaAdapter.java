package com.example.sensusapp.Adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
        int urutan = position+1;
        holder.expandableCardView.setTitle("Anggota Keluarga" + urutan);


        holder.expandableCardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                final EditText editTextTanggalLahir;
                final Calendar calendar = Calendar.getInstance();

                editTextTanggalLahir = v.findViewById(R.id.expand_edittext_add_data_value_tanggallahir);
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        editTextTanggalLahir.setText(sdf.format(calendar.getTime()));
                    }
                };

                editTextTanggalLahir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(v.getContext(), date, calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return anggotaKeluargas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ExpandableCardView expandableCardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableCardView = itemView.findViewById(R.id.expandable_cardview_add_keluarga_layout);

        }
    }



}
