package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensusapp.Adapter.UpdateAnggotaKeluargaAdapter;
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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentUpdateAnggotaKeluarga extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private UpdateAnggotaKeluargaAdapter updateAnggotaKeluargaAdapter;
    private ArrayList<AnggotaKeluarga> anggotaKeluargas = new ArrayList<>();
    private List<Status> statusArrayList = new ArrayList<>();
    private List<Relasi> relasiList = new ArrayList<>();
    private List<Pendidikan> pendidikanList = new ArrayList<>();
    private List<Pekerjaan> pekerjaanList = new ArrayList<>();
    private List<Disabilitas> disabilitasList = new ArrayList<>();

    public FragmentUpdateAnggotaKeluarga() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.update_data_anggota_keluarga_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_update_detail_anggota_keluarga);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        parseJSON();
        parseStatus();

        return view;
    }

    public void setUpdateAnggota(List<AnggotaKeluarga> anggotaKeluarga) {
        anggotaKeluargas.addAll(anggotaKeluarga);
        updateAnggotaKeluargaAdapter = new UpdateAnggotaKeluargaAdapter(anggotaKeluargas, getContext(), statusArrayList, relasiList, pendidikanList, pekerjaanList, disabilitasList);
        recyclerView.setAdapter(updateAnggotaKeluargaAdapter);
    }

    void parseStatus() {
        APIservice apIservice = APIurl.createService(APIservice.class, getContext());
        Call<Result<List<Status>>> resultCall = apIservice.getStatus();
        resultCall.enqueue(new Callback<Result<List<Status>>>() {


            @Override
            public void onResponse(Call<Result<List<Status>>> call, Response<Result<List<Status>>> response) {
                if (response.body() != null && response.body().isSuccessfull()){
                    List<Status> statusList = response.body().getData();
                    statusArrayList.addAll(statusList);
                    updateAnggotaKeluargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Result<List<Status>>> call, Throwable t) {

            }
        });
    }

    void parseJSON() {
        APIservice apIservice = APIurl.createService(APIservice.class, getContext());
        Call<Result<List<Relasi>>> resultCall = apIservice.getRelasi();

        resultCall.enqueue(new Callback<Result<List<Relasi>>>() {
            @Override
            public void onResponse(Call<Result<List<Relasi>>> call, Response<Result<List<Relasi>>> response) {
                if (response.body() != null && response.body().isSuccessfull()){
                    List<Relasi> relasis = response.body().getData();
                    relasiList.addAll(relasis);
                    updateAnggotaKeluargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Result<List<Relasi>>> call, Throwable t) {

            }
        });

        Call<Result<List<Pendidikan>>> pendidikanResultCall = apIservice.pendidikan();
        pendidikanResultCall.enqueue(new Callback<Result<List<Pendidikan>>>() {
            @Override
            public void onResponse(Call<Result<List<Pendidikan>>> call, Response<Result<List<Pendidikan>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Pendidikan> pendidikans = response.body().getData();
                    pendidikanList.addAll(pendidikans);
                    updateAnggotaKeluargaAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<Result<List<Pendidikan>>> call, Throwable t) {

            }
        });

        Call<Result<List<Pekerjaan>>> pekerjaanrResultCall = apIservice.pekerjaan();
        pekerjaanrResultCall.enqueue(new Callback<Result<List<Pekerjaan>>>() {
            @Override
            public void onResponse(Call<Result<List<Pekerjaan>>> call, Response<Result<List<Pekerjaan>>> response) {
                if (response.body() != null && response.body().isSuccessfull()){
                    List<Pekerjaan> pekerjaans = response.body().getData();
                    pekerjaanList.addAll(pekerjaans);
                    updateAnggotaKeluargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Result<List<Pekerjaan>>> call, Throwable t) {

            }
        });

        Call<Result<List<Disabilitas>>> disabilitasResultCall = apIservice.disabilitas();
        disabilitasResultCall.enqueue(new Callback<Result<List<Disabilitas>>>() {
            @Override
            public void onResponse(Call<Result<List<Disabilitas>>> call, Response<Result<List<Disabilitas>>> response) {
                if (response.body() != null && response.body().isSuccessfull()) {
                    List<Disabilitas> disabilitas = response.body().getData();
                    disabilitasList.addAll(disabilitas);
                    updateAnggotaKeluargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Result<List<Disabilitas>>> call, Throwable t) {

            }
        });
    }
}
