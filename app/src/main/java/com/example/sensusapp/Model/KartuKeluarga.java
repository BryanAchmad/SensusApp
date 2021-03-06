package com.example.sensusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.sensusapp.Model.Master.Desa;
import com.example.sensusapp.Model.Master.JenisFasilitasAirBersih;
import com.example.sensusapp.Model.Master.JenisSanitasi;
import com.example.sensusapp.Model.Master.KonsumsiAirBersih;

import java.util.List;

public class KartuKeluarga implements Parcelable {
    private int id;
    private String created_at;
    private String updated_at;
    private String no_kk;
    private String nama;
    private String address;
    private String rt;
    private String rw;
    private String dusun;
    private int desa_id;
    private Desa desa;
    private String status_rumah;
    private String status_tanah_garapan;
    private int jumlah_tanah_garapan;
    private int luas_tanah_garapan;
    private boolean status_kemiskinan;
    private int jenis_fasilitas_air_bersih_id;
    private JenisFasilitasAirBersih jenis_fasilitas_air_bersih;
    private int jenis_sanitasi_id;
    private JenisSanitasi jenis_sanitasi;
    private int konsumsi_air_minum_id;
    private KonsumsiAirBersih konsumsi_air_minum;
    private List<AnggotaKeluarga> anggota_keluarga;

    public KartuKeluarga(String no_kk, String nama, String address, String rt, String rw, String dusun, int desa_id, String status_rumah, String status_tanah_garapan, int jumlah_tanah_garapan, int luas_tanah_garapan, boolean status_kemiskinan, int jenis_fasilitas_air_bersih_id, int jenis_sanitasi_id, int konsumsi_air_minum_id, List<AnggotaKeluarga> anggota_keluarga) {
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
        this.anggota_keluarga = anggota_keluarga;
    }
    //    public KartuKeluarga(String no_kk, String nama, String address, String rt, String rw, String dusun, int desa_id, String status_rumah, String status_tanah_garapan, int jumlah_tanah_garapan, int luas_tanah_garapan, boolean status_kemiskinan, int jenis_fasilitas_air_bersih_id, int jenis_sanitasi_id, int konsumsi_air_minum_id, List<AnggotaKeluarga> anggota_keluarga) {
//        this.no_kk = no_kk;
//        this.nama = nama;
//        this.address = address;
//        this.rt = rt;
//        this.rw = rw;
//        this.dusun = dusun;
//        this.desa_id = desa_id;
//        this.status_rumah = status_rumah;
//        this.status_tanah_garapan = status_tanah_garapan;
//        this.jumlah_tanah_garapan = jumlah_tanah_garapan;
//        this.luas_tanah_garapan = luas_tanah_garapan;
//        this.status_kemiskinan = status_kemiskinan;
//        this.jenis_fasilitas_air_bersih_id = jenis_fasilitas_air_bersih_id;
//        this.jenis_sanitasi_id = jenis_sanitasi_id;
//        this.konsumsi_air_minum_id = konsumsi_air_minum_id;
//        this.anggota_keluarga = anggota_keluarga;
//    }

    public KartuKeluarga(int id, String created_at, String updated_at, String no_kk, String nama, String address, String rt, String rw, String dusun, int desa_id, Desa desa, String status_rumah, String status_tanah_garapan, int jumlah_tanah_garapan, int luas_tanah_garapan, boolean status_kemiskinan, int jenis_fasilitas_air_bersih_id, JenisFasilitasAirBersih jenis_fasilitas_air_bersih, int jenis_sanitasi_id, JenisSanitasi jenis_sanitasi, int konsumsi_air_minum_id, KonsumsiAirBersih konsumsi_air_minum, List<AnggotaKeluarga> anggota_keluarga) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.no_kk = no_kk;
        this.nama = nama;
        this.address = address;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa_id = desa_id;
        this.desa = desa;
        this.status_rumah = status_rumah;
        this.status_tanah_garapan = status_tanah_garapan;
        this.jumlah_tanah_garapan = jumlah_tanah_garapan;
        this.luas_tanah_garapan = luas_tanah_garapan;
        this.status_kemiskinan = status_kemiskinan;
        this.jenis_fasilitas_air_bersih_id = jenis_fasilitas_air_bersih_id;
        this.jenis_fasilitas_air_bersih = jenis_fasilitas_air_bersih;
        this.jenis_sanitasi_id = jenis_sanitasi_id;
        this.jenis_sanitasi = jenis_sanitasi;
        this.konsumsi_air_minum_id = konsumsi_air_minum_id;
        this.konsumsi_air_minum = konsumsi_air_minum;
        this.anggota_keluarga = anggota_keluarga;
    }

    protected KartuKeluarga(Parcel in) {
        id = in.readInt();
        created_at = in.readString();
        updated_at = in.readString();
        no_kk = in.readString();
        nama = in.readString();
        address = in.readString();
        rt = in.readString();
        rw = in.readString();
        dusun = in.readString();
        desa_id = in.readInt();
        status_rumah = in.readString();
        status_tanah_garapan = in.readString();
        jumlah_tanah_garapan = in.readInt();
        luas_tanah_garapan = in.readInt();
        status_kemiskinan = in.readByte() != 0;
        jenis_fasilitas_air_bersih_id = in.readInt();
        jenis_sanitasi_id = in.readInt();
        konsumsi_air_minum_id = in.readInt();
        anggota_keluarga = in.createTypedArrayList(AnggotaKeluarga.CREATOR);
    }

    public static final Creator<KartuKeluarga> CREATOR = new Creator<KartuKeluarga>() {
        @Override
        public KartuKeluarga createFromParcel(Parcel in) {
            return new KartuKeluarga(in);
        }

        @Override
        public KartuKeluarga[] newArray(int size) {
            return new KartuKeluarga[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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

    public int getDesa_id() {
        return desa_id;
    }

    public void setDesa_id(int desa_id) {
        this.desa_id = desa_id;
    }

    public Desa getDesa() {
        return desa;
    }

    public void setDesa(Desa desa) {
        this.desa = desa;
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

    public int getJumlah_tanah_garapan() {
        return jumlah_tanah_garapan;
    }

    public void setJumlah_tanah_garapan(int jumlah_tanah_garapan) {
        this.jumlah_tanah_garapan = jumlah_tanah_garapan;
    }

    public int getLuas_tanah_garapan() {
        return luas_tanah_garapan;
    }

    public void setLuas_tanah_garapan(int luas_tanah_garapan) {
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

    public JenisFasilitasAirBersih getJenis_fasilitas_air_bersih() {
        return jenis_fasilitas_air_bersih;
    }

    public void setJenis_fasilitas_air_bersih(JenisFasilitasAirBersih jenis_fasilitas_air_bersih) {
        this.jenis_fasilitas_air_bersih = jenis_fasilitas_air_bersih;
    }

    public int getJenis_sanitasi_id() {
        return jenis_sanitasi_id;
    }

    public void setJenis_sanitasi_id(int jenis_sanitasi_id) {
        this.jenis_sanitasi_id = jenis_sanitasi_id;
    }

    public JenisSanitasi getJenis_sanitasi() {
        return jenis_sanitasi;
    }

    public void setJenis_sanitasi(JenisSanitasi jenis_sanitasi) {
        this.jenis_sanitasi = jenis_sanitasi;
    }

    public int getKonsumsi_air_minum_id() {
        return konsumsi_air_minum_id;
    }

    public void setKonsumsi_air_minum_id(int konsumsi_air_minum_id) {
        this.konsumsi_air_minum_id = konsumsi_air_minum_id;
    }

    public KonsumsiAirBersih getKonsumsi_air_minum() {
        return konsumsi_air_minum;
    }

    public void setKonsumsi_air_minum(KonsumsiAirBersih konsumsi_air_minum) {
        this.konsumsi_air_minum = konsumsi_air_minum;
    }

    public List<AnggotaKeluarga> getAnggota_keluarga() {
        return anggota_keluarga;
    }

    public void setAnggota_keluarga(List<AnggotaKeluarga> anggota_keluarga) {
        this.anggota_keluarga = anggota_keluarga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(no_kk);
        dest.writeString(nama);
        dest.writeString(address);
        dest.writeString(rt);
        dest.writeString(rw);
        dest.writeString(dusun);
        dest.writeInt(desa_id);
        dest.writeString(status_rumah);
        dest.writeString(status_tanah_garapan);
        dest.writeInt(jumlah_tanah_garapan);
        dest.writeInt(luas_tanah_garapan);
        dest.writeByte((byte) (status_kemiskinan ? 1 : 0));
        dest.writeInt(jenis_fasilitas_air_bersih_id);
        dest.writeInt(jenis_sanitasi_id);
        dest.writeInt(konsumsi_air_minum_id);
        dest.writeTypedList(anggota_keluarga);
    }
}
