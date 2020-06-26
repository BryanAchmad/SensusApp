package com.example.sensusapp.Adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;
import com.example.sensusapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAnggotaKeluargaAdapter extends RecyclerView.Adapter<AddAnggotaKeluargaAdapter.ViewHolder> {

    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private Context context;
    private List<Status> statusArrayList;
    private List<Relasi> relasiList;
    private List<Pendidikan> pendidikanList;
    private List<Pekerjaan> pekerjaanList;
    private List<Disabilitas> disabilitasList;
    private String[] statusPendidikanItem = new String[] {"BERSEKOLAH", "TIDAK BERSEKOLAH"};


    public AddAnggotaKeluargaAdapter(ArrayList<AnggotaKeluarga> anggotaKeluargas,
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
                final EditText editTextnik;
                final EditText editTextnama;
                final RadioGroup radioGroupJenisKelamin;
                final RadioButton radioButtonLaki;
                final RadioButton radioButtonPerempuan;
                final EditText editTextTempatLahir;
                final EditText editTextGolonganDarah;
                final EditText editTextAgama;
                final Spinner spinnerStatus;
                final Spinner spinnerRelasi;
                final Spinner spinnerPendidikan;
                final Spinner spinnerStatusPendidikan;
                final Spinner spinnerPekerjaan;
                final EditText editTextiIbu;
                final EditText editTextAyah;
                final RadioGroup radioGroupYatim;
                final RadioButton radioButtonYatimYa;
                final RadioButton radioButtonYatimTidak;
                final RadioGroup radioGroupPiatu;
                final RadioButton radioButtonPiatuYa;
                final RadioButton radioButtonPiatuTidak;
                final RadioGroup radioGroupStatusPenerimaBantuan;
                final RadioButton radioButtonStatusPenerimaBantuanYa;
                final RadioButton radioButtonStatusPenerimaBantuanTidak;
                final Spinner spinnerDisabilitas;
                final RadioGroup radioGroupOrmas;
                final RadioButton radioButtonOrmasYa;
                final RadioButton radioButtonOrmasTidak;

                final RadioButton jeniskelaminSelected;
                final RadioButton yatimSelected;
                final RadioButton PiatuSelected;
                final RadioButton statusbantuanSelected;
                final RadioButton ormasSelected;

                final Calendar calendar = Calendar.getInstance();

                editTextnik = v.findViewById(R.id.expand_edittext_add_data_value_nik);
                editTextnama = v.findViewById(R.id.expand_edittext_add_data_value_nama);
                editTextTempatLahir = v.findViewById(R.id.expand_edittext_add_data_value_tempatlahir);
                editTextGolonganDarah = v.findViewById(R.id.expand_edittext_add_data_value_goldar);
                editTextAgama = v.findViewById(R.id.expand_edittext_add_data_value_agama);
                editTextiIbu = v.findViewById(R.id.expand_edittext_add_data_value_ibu);
                editTextAyah = v.findViewById(R.id.expand_edittext_add_data_value_ayah);
                editTextTanggalLahir = v.findViewById(R.id.expand_edittext_add_data_value_tanggallahir);

                spinnerStatus = v.findViewById(R.id.expand_spinner_add_data_value_status);
                spinnerRelasi = v.findViewById(R.id.expand_spinner_add_data_value_relasi);
                spinnerPendidikan = v.findViewById(R.id.expand_spinner_add_data_value_pendidikan);
                spinnerStatusPendidikan = v.findViewById(R.id.expand_spinner_add_data_value_statuspendidikan);
                spinnerPekerjaan = v.findViewById(R.id.expand_spinner_add_data_value_pekerjaan);
                spinnerDisabilitas = v.findViewById(R.id.expand_spinner_add_data_value_disabilitas);

                radioGroupJenisKelamin = v.findViewById(R.id.expand_radiogroup_add_data_value_jeniskelamin);
                radioGroupYatim = v.findViewById(R.id.expand_radiogroup_add_data_value_yatim);
                radioGroupPiatu = v.findViewById(R.id.expand_radiogroup_add_data_value_piatu);
                radioGroupStatusPenerimaBantuan = v.findViewById(R.id.expand_radiogroup_add_data_value_statuspenerimabantuan);
                radioGroupOrmas = v.findViewById(R.id.expand_radiogroup_add_data_value_ormas);

                radioButtonLaki = v.findViewById(R.id.expand_radiobutton_add_data_value_jeniskelamin_laki);
                radioButtonPerempuan = v.findViewById(R.id.expand_radiobutton_add_data_value_jeniskelamin_pr);
                radioButtonYatimYa = v.findViewById(R.id.expand_radiobutton_add_data_value_yatim_ya);
                radioButtonYatimTidak = v.findViewById(R.id.expand_radiobutton_add_data_value_yatim_tidak);
                radioButtonPiatuYa = v.findViewById(R.id.expand_radiobutton_add_data_value_piatu_ya);
                radioButtonPiatuTidak = v.findViewById(R.id.expand_radiobutton_add_data_value_piatu_tidak);
                radioButtonStatusPenerimaBantuanYa = v.findViewById(R.id.expand_radiobutton_add_data_value_statuspenerimabantuan_ya);
                radioButtonStatusPenerimaBantuanTidak = v.findViewById(R.id.expand_radiobutton_add_data_value_statuspenerimabantuan_tidak);
                radioButtonOrmasYa = v.findViewById(R.id.expand_radiobutton_add_data_value_ormas_ya);
                radioButtonOrmasTidak = v.findViewById(R.id.expand_radiobutton_add_data_value_ormas_tidak);

                //radiogroup jeniskelamin
                int idJenisKelamin = radioGroupJenisKelamin.getCheckedRadioButtonId();
                jeniskelaminSelected = v.findViewById(idJenisKelamin);
                anggotaKeluargas.get(position).setJenis_kelamin(jeniskelaminSelected.getText().toString());

                //radiogroup yatim
                int idYatim = radioGroupYatim.getCheckedRadioButtonId();
                yatimSelected = v.findViewById(idYatim);
                if (yatimSelected.getText().toString().equals("Ya")){
                    anggotaKeluargas.get(position).setYatim(true);
                } else {
                    anggotaKeluargas.get(position).setYatim(false);
                }

                //radiogroup piatu
                int idPiatu = radioGroupPiatu.getCheckedRadioButtonId();
                PiatuSelected = v.findViewById(idPiatu);
                if (PiatuSelected.getText().toString().equals("Ya")){
                    anggotaKeluargas.get(position).setPiatu(true);
                } else {
                    anggotaKeluargas.get(position).setPiatu(false);
                }

                //radiogroup statusbantuan
                int idStatusBantuan = radioGroupStatusPenerimaBantuan.getCheckedRadioButtonId();
                statusbantuanSelected = v.findViewById(idStatusBantuan);
                anggotaKeluargas.get(position).setStatus_penerima_bantuan(statusbantuanSelected.getText().toString());

                //radiogroup ormas
                int idOrmas = radioGroupOrmas.getCheckedRadioButtonId();
                ormasSelected = v.findViewById(idOrmas);
                anggotaKeluargas.get(position).setKeanggotaan_ormas(ormasSelected.getText().toString());


                //spinner status pendidikan
                ArrayAdapter<String> statusPendidikanAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, statusPendidikanItem);
                statusPendidikanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerStatusPendidikan.setAdapter(statusPendidikanAdapter);

                //SpinnerStatus
                ArrayAdapter<Status> adapterStatus = new ArrayAdapter<Status>(context, android.R.layout.simple_spinner_item, statusArrayList);
                adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerStatus.setAdapter(adapterStatus);


                spinnerStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        anggotaKeluargas.get(position).setStatus(statusArrayList.get(pos));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //SpinnerRelasi
                ArrayAdapter<Relasi> relasiArrayAdapter = new ArrayAdapter<Relasi>(context, android.R.layout.simple_spinner_item, relasiList);
                relasiArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerRelasi.setAdapter(relasiArrayAdapter);

                spinnerRelasi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        anggotaKeluargas.get(position).setRelasi(relasiList.get(pos));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //SpinnerPendidikan
                ArrayAdapter<Pendidikan> pendidikanArrayAdapter = new ArrayAdapter<Pendidikan>(context, android.R.layout.simple_spinner_item, pendidikanList);
                pendidikanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerPendidikan.setAdapter(pendidikanArrayAdapter);

                spinnerPendidikan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        anggotaKeluargas.get(position).setPendidikan(pendidikanList.get(pos));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //SpinnerPekerjaan
                ArrayAdapter<Pekerjaan> pekerjaanArrayAdapter = new ArrayAdapter<Pekerjaan>(context, android.R.layout.simple_spinner_item, pekerjaanList);
                pekerjaanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerPekerjaan.setAdapter(pekerjaanArrayAdapter);

                spinnerPekerjaan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        anggotaKeluargas.get(position).setPekerjaan(pekerjaanList.get(pos));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //SpinnerDisabilitas
                ArrayAdapter<Disabilitas> disabilitasArrayAdapter = new ArrayAdapter<Disabilitas>(context, android.R.layout.simple_spinner_item, disabilitasList);
                disabilitasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDisabilitas.setAdapter(disabilitasArrayAdapter);

                spinnerDisabilitas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        anggotaKeluargas.get(position).setDisabilitas(disabilitasList.get(pos));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //edittext nik
                editTextnik.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setNik(s.toString());
                    }
                });

                //edittext nama
                editTextnama.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setNama(s.toString());

                    }
                });

                //edittext tempatlahir
                editTextTempatLahir.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setTempat_lahir(s.toString());
                    }
                });

                //edittext goldar
                editTextGolonganDarah.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setGolongan_darah(s.toString());
                    }
                });

                //edittext agama
                editTextAgama.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setAgama(s.toString());
                    }
                });

                //edittext ibu
                editTextiIbu.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setIbu(s.toString());
                    }
                });

                //edittext ayah
                editTextAyah.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setAyah(s.toString());
                    }
                });

                //set DatePicker at edittext tanggalLahir
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

                editTextTanggalLahir.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        anggotaKeluargas.get(position).setTanggal_lahir(s.toString());
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
