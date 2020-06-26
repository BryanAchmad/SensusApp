package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class Pekerjaan implements Parcelable {
    private int id;
    private String pekerjaan;

    public Pekerjaan(int id, String pekerjaan) {
        this.id = id;
        this.pekerjaan = pekerjaan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    @Override
    public String toString() {
        return pekerjaan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.pekerjaan);
    }

    protected Pekerjaan(Parcel in) {
        this.id = in.readInt();
        this.pekerjaan = in.readString();
    }

    public static final Creator<Pekerjaan> CREATOR = new Creator<Pekerjaan>() {
        @Override
        public Pekerjaan createFromParcel(Parcel source) {
            return new Pekerjaan(source);
        }

        @Override
        public Pekerjaan[] newArray(int size) {
            return new Pekerjaan[size];
        }
    };
}
