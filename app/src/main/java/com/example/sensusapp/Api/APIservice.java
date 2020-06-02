package com.example.sensusapp.Api;

import com.example.sensusapp.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIservice {

    @FormUrlEncoded
    @POST("login")
    Call<Result<User>> login(
            @Field("username") String username,
            @Field("password") String password
    );

}
