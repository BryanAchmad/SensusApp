package com.example.sensusapp.Model.Master;

import android.os.Parcel;
import android.os.Parcelable;

public class JenisFasilitasAirBersih implements Parcelable {
    private int id;
    private String fasilitas;

    public JenisFasilitasAirBersih(int id, String fasilitas) {
        this.id = id;
        this.fasilitas = fasilitas;
    }

    protected JenisFasilitasAirBersih(Parcel in) {
        id = in.readInt();
        fasilitas = in.readString();
    }

    public static final Creator<JenisFasilitasAirBersih> CREATOR = new Creator<JenisFasilitasAirBersih>() {
        @Override
        public JenisFasilitasAirBersih createFromParcel(Parcel in) {
            return new JenisFasilitasAirBersih(in);
        }

        @Override
        public JenisFasilitasAirBersih[] newArray(int size) {
            return new JenisFasilitasAirBersih[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(fasilitas);
    }
}
