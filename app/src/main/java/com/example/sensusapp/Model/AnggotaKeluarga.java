package com.example.sensusapp.Model;

import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.HubunganKK;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Status;

public class AnggotaKeluarga {

    private int id;
    private String created_at;
    private String updated_at;
    private String nik;
    private int kartu_keluarga_id;
    private String nama;
    private String jenis_kelamin;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String golongan_darah;
    private String agama;
    private int status_id;
    private Status status;
    private int relasi_id;
    private HubunganKK hubunganKK;
    private int pendidikan_id;
    private Pendidikan pendidikan;
    private String status_pendidikan_sekarang;
    private int pekerjaan_id;
    private Pekerjaan pekerjaan;
    private String ibu;
    private String ayah;
    private boolean yatim;
    private boolean piatu;
    private String status_penerima_bantuan;
    private int disabilitas_id;
    private Disabilitas disabilitas;
    private String keanggotaan_ormas;

    public AnggotaKeluarga(int id, String created_at, String updated_at, String nik, int kartu_keluarga_id, String nama, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String golongan_darah, String agama, int status_id, Status status, int relasi_id, HubunganKK hubunganKK, int pendidikan_id, Pendidikan pendidikan, String status_pendidikan_sekarang, int pekerjaan_id, Pekerjaan pekerjaan, String ibu, String ayah, boolean yatim, boolean piatu, String status_penerima_bantuan, int disabilitas_id, Disabilitas disabilitas, String keanggotaan_ormas) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.nik = nik;
        this.kartu_keluarga_id = kartu_keluarga_id;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.golongan_darah = golongan_darah;
        this.agama = agama;
        this.status_id = status_id;
        this.status = status;
        this.relasi_id = relasi_id;
        this.hubunganKK = hubunganKK;
        this.pendidikan_id = pendidikan_id;
        this.pendidikan = pendidikan;
        this.status_pendidikan_sekarang = status_pendidikan_sekarang;
        this.pekerjaan_id = pekerjaan_id;
        this.pekerjaan = pekerjaan;
        this.ibu = ibu;
        this.ayah = ayah;
        this.yatim = yatim;
        this.piatu = piatu;
        this.status_penerima_bantuan = status_penerima_bantuan;
        this.disabilitas_id = disabilitas_id;
        this.disabilitas = disabilitas;
        this.keanggotaan_ormas = keanggotaan_ormas;
    }

    public AnggotaKeluarga(int id, String created_at, String updated_at, String nik, int kartu_keluarga_id, String nama, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String golongan_darah, String agama, int status_id, int relasi_id, int pendidikan_id, String status_pendidikan_sekarang, int pekerjaan_id, String ibu, String ayah, boolean yatim, boolean piatu, String status_penerima_bantuan, int disabilitas_id, String keanggotaan_ormas) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.nik = nik;
        this.kartu_keluarga_id = kartu_keluarga_id;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.golongan_darah = golongan_darah;
        this.agama = agama;
        this.status_id = status_id;
        this.relasi_id = relasi_id;
        this.pendidikan_id = pendidikan_id;
        this.status_pendidikan_sekarang = status_pendidikan_sekarang;
        this.pekerjaan_id = pekerjaan_id;
        this.ibu = ibu;
        this.ayah = ayah;
        this.yatim = yatim;
        this.piatu = piatu;
        this.status_penerima_bantuan = status_penerima_bantuan;
        this.disabilitas_id = disabilitas_id;
        this.keanggotaan_ormas = keanggotaan_ormas;
    }

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

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getKartu_keluarga_id() {
        return kartu_keluarga_id;
    }

    public void setKartu_keluarga_id(int kartu_keluarga_id) {
        this.kartu_keluarga_id = kartu_keluarga_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getGolongan_darah() {
        return golongan_darah;
    }

    public void setGolongan_darah(String golongan_darah) {
        this.golongan_darah = golongan_darah;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRelasi_id() {
        return relasi_id;
    }

    public void setRelasi_id(int relasi_id) {
        this.relasi_id = relasi_id;
    }

    public HubunganKK getHubunganKK() {
        return hubunganKK;
    }

    public void setHubunganKK(HubunganKK hubunganKK) {
        this.hubunganKK = hubunganKK;
    }

    public int getPendidikan_id() {
        return pendidikan_id;
    }

    public void setPendidikan_id(int pendidikan_id) {
        this.pendidikan_id = pendidikan_id;
    }

    public Pendidikan getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(Pendidikan pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getStatus_pendidikan_sekarang() {
        return status_pendidikan_sekarang;
    }

    public void setStatus_pendidikan_sekarang(String status_pendidikan_sekarang) {
        this.status_pendidikan_sekarang = status_pendidikan_sekarang;
    }

    public int getPekerjaan_id() {
        return pekerjaan_id;
    }

    public void setPekerjaan_id(int pekerjaan_id) {
        this.pekerjaan_id = pekerjaan_id;
    }

    public Pekerjaan getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(Pekerjaan pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getAyah() {
        return ayah;
    }

    public void setAyah(String ayah) {
        this.ayah = ayah;
    }

    public boolean isYatim() {
        return yatim;
    }

    public void setYatim(boolean yatim) {
        this.yatim = yatim;
    }

    public boolean isPiatu() {
        return piatu;
    }

    public void setPiatu(boolean piatu) {
        this.piatu = piatu;
    }

    public String getStatus_penerima_bantuan() {
        return status_penerima_bantuan;
    }

    public void setStatus_penerima_bantuan(String status_penerima_bantuan) {
        this.status_penerima_bantuan = status_penerima_bantuan;
    }

    public int getDisabilitas_id() {
        return disabilitas_id;
    }

    public void setDisabilitas_id(int disabilitas_id) {
        this.disabilitas_id = disabilitas_id;
    }

    public Disabilitas getDisabilitas() {
        return disabilitas;
    }

    public void setDisabilitas(Disabilitas disabilitas) {
        this.disabilitas = disabilitas;
    }

    public String getKeanggotaan_ormas() {
        return keanggotaan_ormas;
    }

    public void setKeanggotaan_ormas(String keanggotaan_ormas) {
        this.keanggotaan_ormas = keanggotaan_ormas;
    }
}
