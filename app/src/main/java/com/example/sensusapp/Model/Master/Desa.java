package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class Desa {
    private int id;
    private String desa;
    private int id_kecamatan;

    public Desa(int id, String desa, int id_kecamatan) {
        this.id = id;
        this.desa = desa;
        this.id_kecamatan = id_kecamatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public int getId_kecamatan() {
        return id_kecamatan;
    }

    public void setId_kecamatan(int id_kecamatan) {
        this.id_kecamatan = id_kecamatan;
    }
}
