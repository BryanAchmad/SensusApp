package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class Pendidikan implements Parcelable {
    private int id;
    private String pendidikan;

    public Pendidikan(int id, String pendidikan) {
        this.id = id;
        this.pendidikan = pendidikan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.pendidikan);
    }

    protected Pendidikan(Parcel in) {
        this.id = in.readInt();
        this.pendidikan = in.readString();
    }

    public static final Creator<Pendidikan> CREATOR = new Creator<Pendidikan>() {
        @Override
        public Pendidikan createFromParcel(Parcel source) {
            return new Pendidikan(source);
        }

        @Override
        public Pendidikan[] newArray(int size) {
            return new Pendidikan[size];
        }
    };
}
