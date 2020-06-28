package com.example.sensusapp.Api;

import com.example.sensusapp.LoginResponse;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Desa;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.JenisFasilitasAirBersih;
import com.example.sensusapp.Model.Master.JenisSanitasi;
import com.example.sensusapp.Model.Master.KonsumsiAirBersih;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIservice {

    @FormUrlEncoded
    @POST("login")
    Call<Result<LoginResponse>> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("sensus/")
    Call<Result<List<KartuKeluarga>>> sensus();

    @GET("master/status")
    Call<Result<List<Status>>> getStatus();

    @GET("master/relasi")
    Call<Result<List<Relasi>>> getRelasi();

    @GET("master/disabilitas")
    Call<Result<List<Disabilitas>>> disabilitas();

    @GET("master/fasilitas_air_bersih")
    Call<Result<List<JenisFasilitasAirBersih>>> fasilitasair();

    @GET("master/konsumsi_air_bersih")
    Call<Result<List<KonsumsiAirBersih>>> konsumsi();

    @GET("master/pekerjaan")
    Call<Result<List<Pekerjaan>>> pekerjaan();

    @GET("master/pendidikan")
    Call<Result<List<Pendidikan>>> pendidikan();

    @GET("master/relasi")
    Call<Result<List<Relasi>>> relasi();

    @GET("master/sanitasi")
    Call<Result<List<JenisSanitasi>>> sanitasi();



    @GET("sensus?")
    Call<Result<KartuKeluarga>> getDetailSensus(
            @Query("no_kk") String no_kk
    );

    @PUT("sensus/{path}")
    Call<Result<KartuKeluarga>> updateSensus(
            @Path("path") String path
    );

    @GET("wilayah/desa?")
    Call<Result<List<Desa>>> getDesa(
            @Query("kecamatan_id") String kecamatan_id
    );

//    @POST("/sensus")
//    Call<ResponseBody> addSen2sus(
//            @Field("no_kk") String no_kk,
//            @Field("nama") String nama,
//            @Field("address") String alamat,
//            @Field("rt") String rt,
//            @Field("rw") String rw,
//            @Field("dusun") String dusun,
//            @Field("desa_id") int desa_id,
//            @Field("status_rumah") String status_rumah,
//            @Field("status_tanah_garapan") String status_tanah_garapan,
//            @Field("luas_tanah_garapan") int luas_tanah_garapan,
//            @Field("status_kemiskinan") boolean status_kemiskinan,
//            @Field("jenis_fasilitas_air_bersih_id") int jenis_fasilitas_air_bersih_id,
//            @Field("jenis_sanitasi_id") int jenis_sanitasi_id,
//            @Field("konsumsi_air_minum_id") int konsumsi_air_minum,
//            @Field("anggota_keluarga") AnggotaKeluarga anggotaKeluarga
//            );

    @POST("/sensus")
    Call<ResponseBody> addSensus(
            @Body RequestBody param
            );
}
