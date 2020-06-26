package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class Relasi implements Parcelable {
    private int id;
    private String relasi;

    public Relasi(int id, String relasi) {
        this.id = id;
        this.relasi = relasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelasi() {
        return relasi;
    }

    public void setRelasi(String relasi) {
        this.relasi = relasi;
    }

    @Override
    public String toString() {
        return relasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.relasi);
    }

    protected Relasi(Parcel in) {
        this.id = in.readInt();
        this.relasi = in.readString();
    }

    public static final Creator<Relasi> CREATOR = new Creator<Relasi>() {
        @Override
        public Relasi createFromParcel(Parcel source) {
            return new Relasi(source);
        }

        @Override
        public Relasi[] newArray(int size) {
            return new Relasi[size];
        }
    };
}
