package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class Disabilitas implements Parcelable {
    private int id;
    private String kategori;

    public Disabilitas(int id, String kategori) {
        this.id = id;
        this.kategori = kategori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.kategori);
    }

    protected Disabilitas(Parcel in) {
        this.id = in.readInt();
        this.kategori = in.readString();
    }

    public static final Creator<Disabilitas> CREATOR = new Creator<Disabilitas>() {
        @Override
        public Disabilitas createFromParcel(Parcel source) {
            return new Disabilitas(source);
        }

        @Override
        public Disabilitas[] newArray(int size) {
            return new Disabilitas[size];
        }
    };
}
