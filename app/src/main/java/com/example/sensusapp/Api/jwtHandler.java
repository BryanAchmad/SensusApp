package com.example.sensusapp.Api;

import android.content.Context;
import android.content.Intent;

import com.example.sensusapp.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class jwtHandler implements Interceptor {

    private Context context;
    private SharedPrefManager sharedPrefManager;

    public jwtHandler(Context context) {
        sharedPrefManager = SharedPrefManager.getInstance(context);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request original = chain.request();
        Response response = chain.proceed(original);
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED){
            sharedPrefManager.logout();
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }

        return response;
    }
}
