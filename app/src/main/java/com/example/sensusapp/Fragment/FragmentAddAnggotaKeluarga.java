package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.sensusapp.Adapter.AddAnggotaKeluargaAdapter;
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

public class FragmentAddAnggotaKeluarga extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private AddAnggotaKeluargaAdapter addAnggotaKeluargaAdapter;
    private ArrayList<AnggotaKeluarga> list;
    private List<Status> statusArrayList = new ArrayList<>();
    private List<Relasi> relasiList = new ArrayList<>();
    private List<Pendidikan> pendidikanList = new ArrayList<>();
    private List<Pekerjaan> pekerjaanList = new ArrayList<>();
    private List<Disabilitas> disabilitasList = new ArrayList<>();



    public FragmentAddAnggotaKeluarga() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_data_anggota_keluarga_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_add_detail_anggota_keluarga);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int key = bundle.getInt("jumlah_anggota", 1);
            list = new ArrayList<AnggotaKeluarga>();
            for (int i = 0 ; i < key ; i++){
                list.add(new AnggotaKeluarga());

            }

            addAnggotaKeluargaAdapter = new AddAnggotaKeluargaAdapter(list, getContext(), statusArrayList, relasiList, pendidikanList, pekerjaanList, disabilitasList);
            recyclerView.setAdapter(addAnggotaKeluargaAdapter);
        }


        parseStatus();
        parseJSON();




//
//        expandableCardView = view.findViewById(R.id.expandable_cardview_add_keluarga_layout);
//        expandableCardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
//            @Override
//            public void onExpandChanged(View v, boolean isExpanded) {
//                Toast.makeText(view.getContext(), isExpanded ? "expanded" : "Collapse", Toast.LENGTH_SHORT).show();
//            }
//        });
//        addData();
//
//        recyclerView = view.findViewById(R.id.recyclerview_add_detail_anggota_keluarga);
//        addAnggotaKeluargaAdapter = new AddAnggotaKeluargaAdapter(list, getContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(addAnggotaKeluargaAdapter);


        return view;
    }

   void parseStatus() {
       APIservice apIservice = APIurl.createService(APIservice.class, getContext());
       Call<Result<List<Status>>> resultCall = apIservice.getStatus();
       resultCall.enqueue(new Callback<Result<List<Status>>>() {


           @Override
           public void onResponse(Call<Result<List<Status>>> call, Response<Result<List<Status>>> response) {
               if (response.body() != null && response.body().isSuccessfull()){
                   List<Status> statusList = response.body().getData();
                   //List<String> list = new ArrayList<String>();

//                   for (int i = 0 ; i < statusList.size() ; i++) {
                       statusArrayList.addAll(statusList);
//                   }


                   addAnggotaKeluargaAdapter.notifyDataSetChanged();
//                   ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
//                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                   adapter.setNotifyOnChange(true);
//                   spinnerStatus.setAdapter(adapter);
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

                    addAnggotaKeluargaAdapter.notifyDataSetChanged();
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

                    addAnggotaKeluargaAdapter.notifyDataSetChanged();


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

                    addAnggotaKeluargaAdapter.notifyDataSetChanged();
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
                    addAnggotaKeluargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Result<List<Disabilitas>>> call, Throwable t) {

            }
        });
    }


}
