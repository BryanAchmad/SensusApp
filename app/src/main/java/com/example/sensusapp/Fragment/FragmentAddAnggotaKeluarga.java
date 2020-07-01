package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.example.sensusapp.Event.SuccessEvent;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;
import com.example.sensusapp.R;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAddAnggotaKeluarga extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private Button buttonSimpan;
    private AddAnggotaKeluargaAdapter addAnggotaKeluargaAdapter;
    private ArrayList<AnggotaKeluarga> list;
    private List<Status> statusArrayList = new ArrayList<>();
    private List<Relasi> relasiList = new ArrayList<>();
    private List<Pendidikan> pendidikanList = new ArrayList<>();
    private List<Pekerjaan> pekerjaanList = new ArrayList<>();
    private List<Disabilitas> disabilitasList = new ArrayList<>();
    private List<KartuKeluarga> kartuKeluargas = new ArrayList<>();
    private Map<String, Object> objectMap;
    private KartuKeluarga kartuKeluarga;



    public FragmentAddAnggotaKeluarga() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_data_anggota_keluarga_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_add_detail_anggota_keluarga);
        buttonSimpan = view.findViewById(R.id.button_add_detail_anggota_keluarga_simpan);


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

        Log.d("anggotaku", String.valueOf(addAnggotaKeluargaAdapter.anggotaKeluargas));
        Bundle bundle1 = this.getArguments();
        //Log.d("bundle", String.valueOf(bundle1.getParcelable("kartu_keluarga").describeContents()));
        if (bundle1 != null) {
            kartuKeluarga = bundle1.getParcelable("kartu_keluarga");
                Log.d("kartu kel", String.valueOf(kartuKeluarga));
//            assert kartuKeluarga != null;
//            Log.d("log kartu kerluarga", String.valueOf(kartuKeluarga.getNo_kk()));
//            Log.d("nama", kartuKeluarga.getNama().trim());
            kartuKeluarga.setAnggota_keluarga(addAnggotaKeluargaAdapter.anggotaKeluargas);
        }



        parseStatus();
        parseJSON();



        Log.d( " nama", kartuKeluarga.getNama());

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
                EventBus.getDefault().post(new SuccessEvent());
                getActivity().finish();
            }
        });

        return view;
    }

    void sendData() {

        APIservice apIservice = APIurl.createService(APIservice.class, getContext());

        Call<KartuKeluarga> responseBodyCall = apIservice.addSensus(kartuKeluarga);
        responseBodyCall.enqueue(new Callback<KartuKeluarga>() {
            @Override
            public void onResponse(Call<KartuKeluarga> call, Response<KartuKeluarga> response) {
                try {
                    Toast.makeText(getContext(), "sukses", Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<KartuKeluarga> call, Throwable t) {

            }
        });

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
                   addAnggotaKeluargaAdapter.notifyDataSetChanged();
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
