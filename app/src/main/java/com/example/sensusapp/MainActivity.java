package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Model.User;
import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnLogin;
    private AppCompatTextView txtusername;
    private AppCompatTextView txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusername = (AppCompatTextView) findViewById(R.id.et_email);
        txtpass = (AppCompatTextView) findViewById(R.id.et_password);
        btnLogin = (AppCompatButton) findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userLogin() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Mohon Tunggu");
        progressDialog.show();

        String username = txtusername.getText().toString().trim();
        String pass = txtpass.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIurl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice apIservice = retrofit.create(APIservice.class);

        Call<Result<User>> call = apIservice.login(username, pass);

        call.enqueue(new Callback<Result<User>>() {
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
                progressDialog.dismiss();

                if(response.body() != null && response.body().isSuccessfull()) {
                    finish();

                }
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t) {

            }
        });
    }
}
