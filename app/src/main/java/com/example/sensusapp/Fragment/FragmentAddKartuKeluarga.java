package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Api.SharedPrefManager;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Desa;
import com.example.sensusapp.Model.Master.JenisFasilitasAirBersih;
import com.example.sensusapp.Model.Master.JenisSanitasi;
import com.example.sensusapp.Model.Master.KonsumsiAirBersih;
import com.example.sensusapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAddKartuKeluarga extends Fragment {

    private View view;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button buttonNext;
    private Spinner spinnerFasilitasAirBersih;
    private Spinner spinnerKonsumsiAir;
    private Spinner spinnerSanitasi;
    private Spinner spinnerDesa;
    private Spinner spinnerStatusRumah;
    private Spinner spinnerTanahGarapan;
    private EditText editTextJumlahAnggota;
    private EditText editTextNokk;
    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextDusun;
    private EditText editTextRT;
    private EditText editTextRW;
    private EditText editTextJumlahTanahGarapan;
    private EditText editTextLuasTanahGarapan;
    private RadioGroup radioGroupStatusKemiskinan;
    private RadioButton statuskemiskinan;
    private List<Desa> desas = new ArrayList<>();
    private List<JenisFasilitasAirBersih> jenisFasilitasAirBersihs = new ArrayList<>();
    private List<KonsumsiAirBersih> konsumsiAirMinums = new ArrayList<>();
    private List<JenisSanitasi> jenisSanitasis = new ArrayList<>();
    private KartuKeluarga kartuKeluarga;
    public int desa;
    public int fasilitas;
    public int konsumsiair;
    public int sanitasi;
    private int jumlahtanahgarapan = 0;
    private int luastanahgarapan = 0;
    //private AnggotaKeluarga anggotaKeluarga;

    private SharedPrefManager sharedPrefManager;
    private static String[] item = new String[] {"Sewa", "Milik Sendiri", "Milik Orang Tua"};

    public FragmentAddKartuKeluarga() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_data_kartu_keluarga_fragment, container, false);

        buttonNext = view.findViewById(R.id.button_next_add_data);
        spinnerFasilitasAirBersih = view.findViewById(R.id.spinner_add_data_jenisfasilitasair);
        spinnerKonsumsiAir = view.findViewById(R.id.spinner_add_data_konsumsiairminum);
        spinnerSanitasi= view.findViewById(R.id.spinner_add_data_jenissanitasi);
        spinnerDesa = view.findViewById(R.id.spinner_add_data_desa);
        spinnerStatusRumah = view.findViewById(R.id.spinner_add_data_statusrumah);
        spinnerTanahGarapan = view.findViewById(R.id.spinner_add_data_statustanahgarapan);
        editTextJumlahAnggota = view.findViewById(R.id.edittext_add_data_jumlahanggota);
        editTextNokk = view.findViewById(R.id.edittext_add_data_nokk);
        editTextNama = view.findViewById(R.id.edittext_add_data_nama);
        editTextAlamat = view.findViewById(R.id.edittext_add_data_alamat);
        editTextDusun = view.findViewById(R.id.edittext_add_data_dusun);
        editTextRT = view.findViewById(R.id.edittext_add_data_rt);
        editTextRW = view.findViewById(R.id.edittext_add_data_rw);
        editTextJumlahTanahGarapan = view.findViewById(R.id.edittext_add_data_jumlahtanahgarapan);
        editTextLuasTanahGarapan = view.findViewById(R.id.edittext_add_data_luastanahgarapan);
        radioGroupStatusKemiskinan = view.findViewById(R.id.radiogroup_add_data_statuskemiskinan);

        parseFasilitasAirBersih();
        parseKonsumsiAir();
        parseJenisSanitasi();
        parseDesa();


        ArrayAdapter<String> adapterStatus = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, item);
        spinnerStatusRumah.setAdapter(adapterStatus);

        ArrayAdapter<String> adapterTanah = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, item);
        spinnerTanahGarapan.setAdapter(adapterTanah);






        spinnerDesa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                desa = desas.get(pos).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerFasilitasAirBersih.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                fasilitas = jenisFasilitasAirBersihs.get(pos).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerKonsumsiAir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                konsumsiair = konsumsiAirMinums.get(pos).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSanitasi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                sanitasi = jenisSanitasis.get(pos).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String statusrumah = spinnerStatusRumah.getSelectedItem().toString();
        String statustanahgarapan = spinnerTanahGarapan.getSelectedItem().toString();





       // KartuKeluarga kartuKeluarga = new KartuKeluarga(nokk)


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentAddAnggotaKeluarga fragmentAddAnggotaKeluarga = new FragmentAddAnggotaKeluarga();

                Bundle bundle = new Bundle();
                bundle.putInt("jumlah_anggota", Integer.parseInt(editTextJumlahAnggota.getText().toString()));
                //Log.d("kaka ku", String.valueOf(kartuKeluarga));



                int selectedstatuskemiskinan = radioGroupStatusKemiskinan.getCheckedRadioButtonId();
                statuskemiskinan = view.findViewById(selectedstatuskemiskinan);
                boolean statusmiskin;
                if (statuskemiskinan.getText().toString().equals("Ya")){
                    statusmiskin = true;
                } else {
                    statusmiskin = false;
                }

                String nokk = editTextNokk.getText().toString();
                String nama = editTextNama.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String dusun = editTextDusun.getText().toString();
                String rt = editTextRT.getText().toString();
                String rw = editTextRW.getText().toString();


                if (editTextJumlahTanahGarapan.length() > 0){
                    jumlahtanahgarapan = Integer.parseInt(editTextJumlahTanahGarapan.getText().toString());
                }


                if (editTextLuasTanahGarapan.length() > 0) {
                    luastanahgarapan = Integer.parseInt(editTextLuasTanahGarapan.getText().toString());
                }

                kartuKeluarga = new KartuKeluarga(
                        nokk,
                        nama,
                        alamat,
                        rt, rw,
                        dusun,
                        desa,
                        statusrumah,
                        statustanahgarapan,
                        jumlahtanahgarapan,
                        luastanahgarapan,
                        statusmiskin,
                        fasilitas,
                        sanitasi,
                        konsumsiair,
                        new ArrayList<AnggotaKeluarga>());
                bundle.putParcelable("kartu_keluarga", kartuKeluarga);


                Log.d( " nama", kartuKeluarga.getNama());
                fragmentAddAnggotaKeluarga.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout_fragment_add_data, fragmentAddAnggotaKeluarga).addToBackStack(null).commit();
                Log.d( " nokk", kartuKeluarga.getNo_kk());
            }
        });


        return view;
    }



    void parseDesa() {
        APIservice apIservice = APIurl.createService(APIservice.class, getContext());

        //String path = sharedPrefManager.getUser().getkecamatan_id();
        String path = SharedPrefManager.getInstance(getContext()).getUser().getkecamatan_id();

        Call<Result<List<Desa>>> resultCall = apIservice.getDesa(path);

        resultCall.enqueue(new Callback<Result<List<Desa>>>() {
            @Override
            public void onResponse(Call<Result<List<Desa>>> call, Response<Result<List<Desa>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Desa> desaList = response.body().getData();
                   // List<Desa> list = new ArrayList<>();

                    desas.addAll(desaList);

//                    for (int i = 0; i < desaList.size(); i++ ) {
//                        list.add(desaList.get(i).getDesa());
//                    }

                    ArrayAdapter<Desa> adapter = new ArrayAdapter<Desa>(view.getContext(), android.R.layout.simple_spinner_item, desas);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerDesa.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<Desa>>> call, Throwable t) {

            }
        });
    }

    void parseFasilitasAirBersih() {
        APIservice apIservice = APIurl.createService(APIservice.class, getContext());
        Call<Result<List<JenisFasilitasAirBersih>>> resultCall = apIservice.fasilitasair();

        resultCall.enqueue(new Callback<Result<List<JenisFasilitasAirBersih>>>() {
            @Override
            public void onResponse(Call<Result<List<JenisFasilitasAirBersih>>> call, Response<Result<List<JenisFasilitasAirBersih>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<JenisFasilitasAirBersih> airBersihList  = response.body().getData();
                    //List<String> list = new ArrayList<String>();

//                    for (int i = 0; i < airBersihList.size(); i++) {
//                        list.add(airBersihList.get(i).getJenis());
//                    }

                    jenisFasilitasAirBersihs.addAll(airBersihList);

                    ArrayAdapter<JenisFasilitasAirBersih> adapter = new ArrayAdapter<JenisFasilitasAirBersih>(view.getContext(), android.R.layout.simple_spinner_item, jenisFasilitasAirBersihs);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerFasilitasAirBersih.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<JenisFasilitasAirBersih>>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Jaringan Eror", Toast.LENGTH_SHORT ).show();
            }
        });

    }

    void parseKonsumsiAir(){
        APIservice apIservice = APIurl.createService(APIservice.class, view.getContext());

        Call<Result<List<KonsumsiAirBersih>>> resultCall = apIservice.konsumsi();

        resultCall.enqueue(new Callback<Result<List<KonsumsiAirBersih>>>() {
            @Override
            public void onResponse(Call<Result<List<KonsumsiAirBersih>>> call, Response<Result<List<KonsumsiAirBersih>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<KonsumsiAirBersih> airMinumList = response.body().getData();
                    //List<String> list = new ArrayList<String>();

//                    for (int i = 0 ; i < airMinumList.size(); i++) {
//                        list.add(airMinumList.get(i).getJenis());
//                    }

                    konsumsiAirMinums.addAll(airMinumList);
                    ArrayAdapter<KonsumsiAirBersih> adapter = new ArrayAdapter<KonsumsiAirBersih>(view.getContext(), android.R.layout.simple_spinner_item, konsumsiAirMinums);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerKonsumsiAir.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<KonsumsiAirBersih>>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Jaringan Eror", Toast.LENGTH_SHORT ).show();
            }
        });

    }

    void parseJenisSanitasi() {
        APIservice apIservice = APIurl.createService(APIservice.class, view.getContext());

        Call<Result<List<JenisSanitasi>>> resultCall = apIservice.sanitasi();

        resultCall.enqueue(new Callback<Result<List<JenisSanitasi>>>() {
            @Override
            public void onResponse(Call<Result<List<JenisSanitasi>>> call, Response<Result<List<JenisSanitasi>>> response) {
                if (response.body()!= null && response.body().isSuccessfull()) {
                    List<JenisSanitasi> sanitasiList = response.body().getData();
                    //List<String> list = new ArrayList<String>();
//
//                    for (int i = 0;i < sanitasiList.size(); i++){
//                        list.add(sanitasiList.get(i).getJenis());
//                    }

                    jenisSanitasis.addAll(sanitasiList);

                    ArrayAdapter<JenisSanitasi> adapter = new ArrayAdapter<JenisSanitasi>(view.getContext(), android.R.layout.simple_spinner_item, jenisSanitasis);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerSanitasi.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<JenisSanitasi>>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Jaringan Eror", Toast.LENGTH_SHORT ).show();
            }
        });
    }


}
