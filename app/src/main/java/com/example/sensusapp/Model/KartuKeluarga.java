package com.example.sensusapp.Model;

import java.util.List;

public class KartuKeluarga {
    private int id;
    private String no_kk;
    private String nama;
    private String address;
    private String rt;
    private String rw;
    private String dusun;
    private String desa_id;
    private String status_rumah;
    private String status_tanah_garapan;
    private String jumlah_tanah_garapan;
    private String luas_tanah_garapan;
    private boolean status_kemiskinan;
    private int jenis_fasilitas_air_bersih_id;
    private int jenis_sanitasi_id;
    private int konsumsi_air_minum_id;
    private List<AnggotaKeluarga> anggotaKeluargas;

    public KartuKeluarga(int id, String no_kk, String nama, String address, String rt, String rw, String dusun, String desa_id, String status_rumah, String status_tanah_garapan, String jumlah_tanah_garapan, String luas_tanah_garapan, boolean status_kemiskinan, int jenis_fasilitas_air_bersih_id, int jenis_sanitasi_id, int konsumsi_air_minum_id, List<AnggotaKeluarga> anggotaKeluargas) {
        this.id = id;
        this.no_kk = no_kk;
        this.nama = nama;
        this.address = address;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa_id = desa_id;
        this.status_rumah = status_rumah;
        this.status_tanah_garapan = status_tanah_garapan;
        this.jumlah_tanah_garapan = jumlah_tanah_garapan;
        this.luas_tanah_garapan = luas_tanah_garapan;
        this.status_kemiskinan = status_kemiskinan;
        this.jenis_fasilitas_air_bersih_id = jenis_fasilitas_air_bersih_id;
        this.jenis_sanitasi_id = jenis_sanitasi_id;
        this.konsumsi_air_minum_id = konsumsi_air_minum_id;
        this.anggotaKeluargas = anggotaKeluargas;
    }

    public KartuKeluarga(int id, String no_kk, String nama) {
        this.id = id;
        this.no_kk = no_kk;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }

    public String getDesa_id() {
        return desa_id;
    }

    public void setDesa_id(String desa_id) {
        this.desa_id = desa_id;
    }

    public String getStatus_rumah() {
        return status_rumah;
    }

    public void setStatus_rumah(String status_rumah) {
        this.status_rumah = status_rumah;
    }

    public String getStatus_tanah_garapan() {
        return status_tanah_garapan;
    }

    public void setStatus_tanah_garapan(String status_tanah_garapan) {
        this.status_tanah_garapan = status_tanah_garapan;
    }

    public String getJumlah_tanah_garapan() {
        return jumlah_tanah_garapan;
    }

    public void setJumlah_tanah_garapan(String jumlah_tanah_garapan) {
        this.jumlah_tanah_garapan = jumlah_tanah_garapan;
    }

    public String getLuas_tanah_garapan() {
        return luas_tanah_garapan;
    }

    public void setLuas_tanah_garapan(String luas_tanah_garapan) {
        this.luas_tanah_garapan = luas_tanah_garapan;
    }

    public boolean isStatus_kemiskinan() {
        return status_kemiskinan;
    }

    public void setStatus_kemiskinan(boolean status_kemiskinan) {
        this.status_kemiskinan = status_kemiskinan;
    }

    public int getJenis_fasilitas_air_bersih_id() {
        return jenis_fasilitas_air_bersih_id;
    }

    public void setJenis_fasilitas_air_bersih_id(int jenis_fasilitas_air_bersih_id) {
        this.jenis_fasilitas_air_bersih_id = jenis_fasilitas_air_bersih_id;
    }

    public int getJenis_sanitasi_id() {
        return jenis_sanitasi_id;
    }

    public void setJenis_sanitasi_id(int jenis_sanitasi_id) {
        this.jenis_sanitasi_id = jenis_sanitasi_id;
    }

    public int getKonsumsi_air_minum_id() {
        return konsumsi_air_minum_id;
    }

    public void setKonsumsi_air_minum_id(int konsumsi_air_minum_id) {
        this.konsumsi_air_minum_id = konsumsi_air_minum_id;
    }

    public List<AnggotaKeluarga> getAnggotaKeluargas() {
        return anggotaKeluargas;
    }

    public void setAnggotaKeluargas(List<AnggotaKeluarga> anggotaKeluargas) {
        this.anggotaKeluargas = anggotaKeluargas;
    }
}
