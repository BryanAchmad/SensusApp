package com.example.sensusapp.Api;

import com.example.sensusapp.LoginResponse;
import com.example.sensusapp.Model.KartuKeluarga;
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

    @GET("sensus?")
    Call<Result<KartuKeluarga>> getDetailSensus(
            @Query("no_kk") String no_kk
    );

    @PUT("sensus/{path}")
    Call<Result<KartuKeluarga>> updateSensus(
            @Path("path") String path
    );
}
