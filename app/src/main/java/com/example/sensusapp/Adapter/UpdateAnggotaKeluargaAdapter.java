package com.example.sensusapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;
import com.example.sensusapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpdateAnggotaKeluargaAdapter extends RecyclerView.Adapter<UpdateAnggotaKeluargaAdapter.ViewHolder> {

    public ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private Context context;
    private List<Status> statusArrayList;
    private List<Relasi> relasiList;
    private List<Pendidikan> pendidikanList;
    private List<Pekerjaan> pekerjaanList;
    private List<Disabilitas> disabilitasList;
    private String[] statusPendidikanItem = new String[] {"BERSEKOLAH", "TIDAK BERSEKOLAH"};

    public UpdateAnggotaKeluargaAdapter(ArrayList<AnggotaKeluarga> anggotaKeluargas,
                                        Context context,
                                        List<Status> statusArrayList,
                                        List<Relasi> relasiList,
                                        List<Pendidikan> pendidikanList,
                                        List<Pekerjaan> pekerjaanList,
                                        List<Disabilitas> disabilitasList
    ) {
        this.anggotaKeluargas = anggotaKeluargas;
        this.context = context;
        this.statusArrayList = statusArrayList;
        this.relasiList = relasiList;
        this.pendidikanList = pendidikanList;
        this.pekerjaanList = pekerjaanList;
        this.disabilitasList = disabilitasList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_update_anggota_keluarga, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int urutan = position+1;
        holder.expandableCardViewUpdate.setTitle("Anggota Keluarga " + urutan);

        holder.expandableCardViewUpdate.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                final EditText editTextTanggalLahirUpdate;
                final EditText editTextnikUpdate;
                final EditText editTextnamaUpdate;
                final RadioGroup radioGroupJenisKelaminUpdate;
                final RadioButton radioButtonLakiUpdate;
                final RadioButton radioButtonPerempuanUpdate;
                final EditText editTextTempatLahirUpdate;
                final EditText editTextGolonganDarahUpdate;
                final EditText editTextAgamaUpdate;
                final EditText editTextOrmasUpdate;
                final Spinner spinnerStatusUpdate;
                final Spinner spinnerRelasiUpdate;
                final Spinner spinnerPendidikanUpdate;
                final Spinner spinnerStatusPendidikanUpdate;
                final Spinner spinnerPekerjaanUpdate;
                final EditText editTextiIbuUpdate;
                final EditText editTextAyahUpdate;
                final RadioGroup radioGroupYatimUpdate;
                final RadioButton radioButtonYatimYaUpdate;
                final RadioButton radioButtonYatimTidakUpdate;
                final RadioGroup radioGroupPiatuUpdate;
                final RadioButton radioButtonPiatuYaUpdate;
                final RadioButton radioButtonPiatuTidakUpdate;
                final RadioGroup radioGroupStatusPenerimaBantuanUpdate;
                final RadioButton radioButtonStatusPenerimaBantuanYaUpdate;
                final RadioButton radioButtonStatusPenerimaBantuanTidakUpdate;
                final Spinner spinnerDisabilitasUpdate;
                final RadioGroup radioGroupOrmasUpdate;
                final RadioButton radioButtonOrmasYaUpdate;
                final RadioButton radioButtonOrmasTidakUpdate;

                final RadioButton jeniskelaminSelectedUpdate;
                final RadioButton yatimSelectedUpdate;
                final RadioButton PiatuSelectedUpdate;
                final RadioButton statusbantuanSelectedUpdate;
                final RadioButton ormasSelectedUpdate;

                final Calendar calendarUpdate = Calendar.getInstance();

                editTextnikUpdate = v.findViewById(R.id.expand_edittext_update_data_value_nik);
                editTextnamaUpdate = v.findViewById(R.id.expand_edittext_update_data_value_nama);
                editTextTempatLahirUpdate = v.findViewById(R.id.expand_edittext_update_data_value_tempatlahir);
                editTextGolonganDarahUpdate = v.findViewById(R.id.expand_edittext_update_data_value_goldar);
                editTextAgamaUpdate = v.findViewById(R.id.expand_edittext_update_data_value_agama);
                editTextiIbuUpdate = v.findViewById(R.id.expand_edittext_update_data_value_ibu);
                editTextAyahUpdate = v.findViewById(R.id.expand_edittext_update_data_value_ayah);
                editTextTanggalLahirUpdate = v.findViewById(R.id.expand_edittext_update_data_value_tanggallahir);
                editTextOrmasUpdate = v.findViewById(R.id.expand_edittext_update_data_value_ormas_value);

                spinnerStatusUpdate = v.findViewById(R.id.expand_spinner_update_data_value_status);
                spinnerRelasiUpdate = v.findViewById(R.id.expand_spinner_update_data_value_relasi);
                spinnerPendidikanUpdate = v.findViewById(R.id.expand_spinner_update_data_value_pendidikan);
                spinnerStatusPendidikanUpdate = v.findViewById(R.id.expand_spinner_update_data_value_statuspendidikan);
                spinnerPekerjaanUpdate = v.findViewById(R.id.expand_spinner_update_data_value_pekerjaan);
                spinnerDisabilitasUpdate = v.findViewById(R.id.expand_spinner_update_data_value_disabilitas);

                radioGroupJenisKelaminUpdate = v.findViewById(R.id.expand_radiogroup_update_data_value_jeniskelamin);
                radioGroupYatimUpdate = v.findViewById(R.id.expand_radiogroup_update_data_value_yatim);
                radioGroupPiatuUpdate = v.findViewById(R.id.expand_radiogroup_update_data_value_piatu);
                radioGroupStatusPenerimaBantuanUpdate = v.findViewById(R.id.expand_radiogroup_update_data_value_statuspenerimabantuan);
                radioGroupOrmasUpdate = v.findViewById(R.id.expand_radiogroup_update_data_value_ormas);

                //spinner status
                ArrayAdapter<Status> statusArrayAdapter = new ArrayAdapter<Status>(context, android.R.layout.simple_spinner_item, statusArrayList);
                statusArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerStatusUpdate.setAdapter(statusArrayAdapter);
                Log.d("Ngentot", statusArrayAdapter + "");

                //spinner Relasi
                ArrayAdapter<Relasi> relasiArrayAdapter = new ArrayAdapter<Relasi>(context, android.R.layout.simple_spinner_item, relasiList);
                relasiArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerRelasiUpdate.setAdapter(relasiArrayAdapter);

                //spinner Pendidikan
                ArrayAdapter<Pendidikan> pendidikanArrayAdapter = new ArrayAdapter<Pendidikan>(context, android.R.layout.simple_spinner_item, pendidikanList);
                pendidikanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerPendidikanUpdate.setAdapter(pendidikanArrayAdapter);

                //spinner Pekerjaan
                ArrayAdapter<Pekerjaan> pekerjaanArrayAdapter = new ArrayAdapter<Pekerjaan>(context, android.R.layout.simple_spinner_item, pekerjaanList);
                pekerjaanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerPekerjaanUpdate.setAdapter(pekerjaanArrayAdapter);

                //Spinner Disabilitas
                ArrayAdapter<Disabilitas> disabilitasArrayAdapter = new ArrayAdapter<Disabilitas>(context, android.R.layout.simple_spinner_item, disabilitasList);
                disabilitasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDisabilitasUpdate.setAdapter(disabilitasArrayAdapter);

                //spinner status pendidikan
                ArrayAdapter<String> statuspendidikanArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, statusPendidikanItem);
                statuspendidikanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerStatusPendidikanUpdate.setAdapter(statuspendidikanArrayAdapter);

                editTextnamaUpdate.setText(anggotaKeluargas.get(position).getNama());


            }
        });
    }

    @Override
    public int getItemCount() {
        return anggotaKeluargas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ExpandableCardView expandableCardViewUpdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableCardViewUpdate = itemView.findViewById(R.id.expandable_cardview_update_keluarga_layout);
        }
    }
}
