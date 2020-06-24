package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.sensusapp.Model.Master.Desa;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.JenisFasilitasAirBersih;
import com.example.sensusapp.Model.Master.JenisSanitasi;
import com.example.sensusapp.Model.Master.KonsumsiAirMinum;
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


//        Bundle bundle = new Bundle();
//        bundle.putString("jumlah_anggota", editTextJumlahAnggota.toString());


        ArrayAdapter<String> adapterStatus = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, item);
        spinnerStatusRumah.setAdapter(adapterStatus);

        ArrayAdapter<String> adapterTanah = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, item);
        spinnerTanahGarapan.setAdapter(adapterTanah);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentAddAnggotaKeluarga fragmentAddAnggotaKeluarga = new FragmentAddAnggotaKeluarga();

                Bundle bundle = new Bundle();
                bundle.putInt("jumlah_anggota", Integer.parseInt(editTextJumlahAnggota.getText().toString()));
                fragmentAddAnggotaKeluarga.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout_fragment_add_data, fragmentAddAnggotaKeluarga).addToBackStack(null).commit();

            }
        });

        parseFasilitasAirBersih();
        parseKonsumsiAir();
        parseJenisSanitasi();
        parseDesa();

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
                    List<String> list = new ArrayList<String>();

                    for (int i = 0; i < desaList.size(); i++ ) {
                        list.add(desaList.get(i).getDesa());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list);
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
                    List<String> list = new ArrayList<String>();

                    for (int i = 0; i < airBersihList.size(); i++) {
                        list.add(airBersihList.get(i).getJenis());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list);
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

        Call<Result<List<KonsumsiAirMinum>>> resultCall = apIservice.konsumsi();

        resultCall.enqueue(new Callback<Result<List<KonsumsiAirMinum>>>() {
            @Override
            public void onResponse(Call<Result<List<KonsumsiAirMinum>>> call, Response<Result<List<KonsumsiAirMinum>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<KonsumsiAirMinum> airMinumList = response.body().getData();
                    List<String> list = new ArrayList<String>();

                    for (int i = 0 ; i < airMinumList.size(); i++) {
                        list.add(airMinumList.get(i).getJenis());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerKonsumsiAir.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<KonsumsiAirMinum>>> call, Throwable t) {
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
                    List<String> list = new ArrayList<String>();

                    for (int i = 0;i < sanitasiList.size(); i++){
                        list.add(sanitasiList.get(i).getJenis());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list);
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
