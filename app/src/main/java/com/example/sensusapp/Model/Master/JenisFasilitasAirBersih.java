package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class JenisFasilitasAirBersih {
    private int id;
    private String jenis;

    public JenisFasilitasAirBersih(int id, String jenis) {
        this.id = id;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return jenis;
    }
}
