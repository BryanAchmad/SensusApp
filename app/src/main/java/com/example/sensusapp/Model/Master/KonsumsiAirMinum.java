package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class KonsumsiAirMinum implements Parcelable {
    private int id;
    private String air;

    protected KonsumsiAirMinum(Parcel in) {
        id = in.readInt();
        air = in.readString();
    }

    public static final Creator<KonsumsiAirMinum> CREATOR = new Creator<KonsumsiAirMinum>() {
        @Override
        public KonsumsiAirMinum createFromParcel(Parcel in) {
            return new KonsumsiAirMinum(in);
        }

        @Override
        public KonsumsiAirMinum[] newArray(int size) {
            return new KonsumsiAirMinum[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(air);
    }

    public KonsumsiAirMinum(int id, String air) {
        this.id = id;
        this.air = air;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }
}
