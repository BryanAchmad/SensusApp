package com.example.sensusapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sensusapp.R;

public class FragmentAddAnggotaKeluarga extends Fragment {

    public FragmentAddAnggotaKeluarga() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_data_anggota_keluarga_fragment, container, false);


        return view;
    }
}
