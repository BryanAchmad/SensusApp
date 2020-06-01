package com.example.sensusapp.Model;

public class KartuKeluarga {
    private String no_kk;
    private String last_update;
    private String date_update;

    public KartuKeluarga(String no_kk, String last_update, String date_update) {
        this.no_kk = no_kk;
        this.last_update = last_update;
        this.date_update = date_update;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }
}
