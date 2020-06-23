package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.sensusapp.Model.AnggotaKeluarga;
import com.example.sensusapp.R;

import java.util.ArrayList;

public class FragmentAddAnggotaKeluarga extends Fragment {

    private RecyclerView recyclerView;

    private ArrayList<AnggotaKeluarga> list;
    ExpandableCardView expandableCardView;

    public FragmentAddAnggotaKeluarga() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_data_anggota_keluarga_fragment, container, false);
//
        expandableCardView = view.findViewById(R.id.expandable_cardview_add_keluarga_layout);
        expandableCardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(view.getContext(), isExpanded ? "expanded" : "Collapse", Toast.LENGTH_SHORT).show();
            }
        });
//        addData();
//
//        recyclerView = view.findViewById(R.id.recyclerview_add_detail_anggota_keluarga);
//        addAnggotaKeluargaAdapter = new AddAnggotaKeluargaAdapter(list, getContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(addAnggotaKeluargaAdapter);


        return view;
    }

    void addData() {

        list = new ArrayList<>();
        list.add(new AnggotaKeluarga("aaaaa","2131212"));



    }
}
