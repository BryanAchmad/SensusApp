package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_fragment_add_data, new FragmentAddAnggotaKeluarga()).addToBackStack(null).commit();
            }
        });

        parseFasilitasAirBersih();
        parseKonsumsiAir();
        parseJenisSanitasi();

        return view;
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
