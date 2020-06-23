package com.example.sensusapp.Api;

import android.service.autofill.Sanitizer;

import com.example.sensusapp.LoginResponse;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.Master.Disabilitas;
import com.example.sensusapp.Model.Master.JenisFasilitasAirBersih;
import com.example.sensusapp.Model.Master.JenisSanitasi;
import com.example.sensusapp.Model.Master.KonsumsiAirMinum;
import com.example.sensusapp.Model.Master.Pekerjaan;
import com.example.sensusapp.Model.Master.Pendidikan;
import com.example.sensusapp.Model.Master.Relasi;
import com.example.sensusapp.Model.Master.Status;
import com.example.sensusapp.Model.User;

import java.util.List;

import retrofit2.Call;
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
    Call<Result<List<Status>>> status();

    @GET("master/disabilitas")
    Call<Result<List<Disabilitas>>> disabilitas();

    @GET("master/fasilitas_air_bersih")
    Call<Result<List<JenisFasilitasAirBersih>>> fasilitasair();

    @GET("master/konsumsi_air_bersih")
    Call<Result<List<KonsumsiAirMinum>>> konsumsi();

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
}
