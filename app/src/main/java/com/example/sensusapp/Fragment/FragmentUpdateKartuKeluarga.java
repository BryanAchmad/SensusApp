package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Api.SharedPrefManager;
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

public class FragmentUpdateKartuKeluarga extends Fragment {

    private View view;
    private EditText nama;
    private EditText dusun;
    private EditText rt;
    private EditText rw;
    private EditText alamat;
    private Spinner spinnerDesa;
    private Spinner spinnerStatusRumah;
    private Spinner spinnerStatusTanah;
    private EditText jumlahtanah;
    private EditText luastanah;
    private RadioGroup radioGroupStatusKemiskinan;
    private RadioButton radioButtonKemiskinanYa;
    private RadioButton radioButtonKemiskinanTidak;
    private Spinner spinnerJenisFasilitasAirBersih;
    private Spinner spinnerJenisSanitasi;
    private Spinner spinnerKonsumsiAirMinum;
    private List<Desa> desas = new ArrayList<>();
    private List<JenisFasilitasAirBersih> jenisFasilitasAirBersihs = new ArrayList<>();
    private List<KonsumsiAirBersih> konsumsiAirMinums = new ArrayList<>();
    private List<JenisSanitasi> jenisSanitasis = new ArrayList<>();
    private static String[] item = new String[] {"Sewa", "Milik Sendiri", "Milik Orang Tua"};


    public FragmentUpdateKartuKeluarga() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.update_data_kartu_keluarga_fragment, container, false);

        nama = view.findViewById(R.id.edittext_update_data_nama);
        dusun = view.findViewById(R.id.edittext_update_data_dusun);
        alamat = view.findViewById(R.id.edittext_update_data_alamat);
        rt = view.findViewById(R.id.edittext_update_data_rt);
        rw = view.findViewById(R.id.edittext_update_data_rw);
        jumlahtanah = view.findViewById(R.id.edittext_update_data_jumlahtanahgarapan);
        luastanah = view.findViewById(R.id.edittext_update_data_luastanahgarapan);
        spinnerDesa = view.findViewById(R.id.spinner_update_data_desa);
        spinnerStatusRumah = view.findViewById(R.id.spinner_update_data_statusrumah);
        spinnerStatusTanah = view.findViewById(R.id.spinner_update_data_statustanahgarapan);
        spinnerJenisFasilitasAirBersih = view.findViewById(R.id.spinner_update_data_jenisfasilitasair);
        spinnerJenisSanitasi = view.findViewById(R.id.spinner_update_data_jenissanitasi);
        spinnerKonsumsiAirMinum = view.findViewById(R.id.spinner_update_data_konsumsiairminum);
        radioGroupStatusKemiskinan = view.findViewById(R.id.radiogroup_update_data_statuskemiskinan);
        radioButtonKemiskinanYa = view.findViewById(R.id.radiobutton_update_data_statuskemiskinan_ya);
        radioButtonKemiskinanTidak = view.findViewById(R.id.radiobutton_update_data_statuskemiskinan_tidak);

        parseDesa();
        parseFasilitasAirBersih();
        parseJenisSanitasi();
        parseKonsumsiAir();
        setSpinnerItem();

        return view;
    }

    public void setUpdateInformasiGeneral(KartuKeluarga kartuKeluarga) {
        nama.setText(kartuKeluarga.getNama());
        dusun.setText(kartuKeluarga.getDusun());
        alamat.setText(kartuKeluarga.getAddress());
        rt.setText(kartuKeluarga.getRt());
        rw.setText(kartuKeluarga.getRw());
        jumlahtanah.setText(String.valueOf(kartuKeluarga.getJumlah_tanah_garapan()));
        luastanah.setText(String.valueOf(kartuKeluarga.getLuas_tanah_garapan()));
        spinnerDesa.setSelection(kartuKeluarga.getDesa_id());

//        if (kartuKeluarga.isStatus_kemiskinan())
//            radioButtonKemiskinanYa.isChecked();
//        else
//            radioButtonKemiskinanTidak.isChecked();
    }

    void parseDesa() {
        APIservice apIservice = APIurl.createService(APIservice.class, getContext());
        String path = SharedPrefManager.getInstance(getContext()).getUser().getkecamatan_id();
        Call<Result<List<Desa>>> resultCallDesa = apIservice.getDesa(path);

        resultCallDesa.enqueue(new Callback<Result<List<Desa>>>() {
            @Override
            public void onResponse(Call<Result<List<Desa>>> call, Response<Result<List<Desa>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Desa> desaList = response.body().getData();
                    desas.addAll(desaList);

                    ArrayAdapter<Desa> desaArrayAdapter = new ArrayAdapter<Desa>(view.getContext(), android.R.layout.simple_spinner_item, desas);
                    desaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerDesa.setAdapter(desaArrayAdapter);

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
                    spinnerJenisFasilitasAirBersih.setAdapter(adapter);
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
                    spinnerKonsumsiAirMinum.setAdapter(adapter);
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
                    spinnerJenisSanitasi.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result<List<JenisSanitasi>>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Jaringan Eror", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    void setSpinnerItem() {
        ArrayAdapter<String> adapterStatusRumah = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, item);
        adapterStatusRumah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatusRumah.setAdapter(adapterStatusRumah);

        ArrayAdapter<String> adapterStatusTanah = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, item);
        adapterStatusTanah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatusTanah.setAdapter(adapterStatusTanah);
    }

}
