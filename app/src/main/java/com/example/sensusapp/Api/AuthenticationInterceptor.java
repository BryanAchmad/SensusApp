package com.example.sensusapp.Api;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {
    private String authToken;
    private SharedPrefManager sharedPrefManager;

    public AuthenticationInterceptor(Context context) {
       sharedPrefManager = SharedPrefManager.getInstance(context);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", sharedPrefManager.getToken());

        Request request = builder.build();
        return chain.proceed(request);
    }
}
