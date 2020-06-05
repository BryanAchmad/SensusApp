package com.example.sensusapp.Api;

import com.example.sensusapp.LoginResponse;
import com.example.sensusapp.Model.KartuKeluarga;
import com.example.sensusapp.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIservice {

    @FormUrlEncoded
    @POST("login")
    Call<Result<LoginResponse>> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("sensus/")
    Call<Result<List<KartuKeluarga>>> sensus();

}
