package com.example.sensusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensusapp.Api.APIservice;
import com.example.sensusapp.Api.APIurl;
import com.example.sensusapp.Api.Result;
import com.example.sensusapp.Api.SharedPrefManager;
import com.example.sensusapp.Model.User;
import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private Button btnLogin;
    private EditText txtusername;
    private EditText txtpass;

    private SharedPrefManager sharedPrefManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPrefManager = SharedPrefManager.getInstance(getApplicationContext());
        Log.d("Check", sharedPrefManager.userLoggedIn() + "");
        if(sharedPrefManager.userLoggedIn()) {
           Intent intent = new Intent(this, HomeActivity.class);
           startActivity(intent);
           finish();
           return;
        }

        setContentView(R.layout.activity_main);

        txtusername = (EditText) findViewById(R.id.et_email);
        txtpass = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btnlogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }

    private void userLogin() {
//        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Mohon Tunggu");
//        progressDialog.show();

        String username = txtusername.getText().toString().trim();
        String pass = txtpass.getText().toString().trim();

        APIservice apIservice = APIurl.createService(APIservice.class, this);

        Call<Result<LoginResponse>> call = apIservice.login(username, pass);

        call.enqueue(new Callback<Result<LoginResponse>>() {
            @Override
            public void onResponse(Call<Result<LoginResponse>> call, Response<Result<LoginResponse>> response) {
                Log.d("Bryan", response.body().getCode() + "");

                if(response.body() != null && response.body().isSuccessfull()) {
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getData().getUser());
                    Log.d("token cok", response.body().getData().getToken());
                    SharedPrefManager.getInstance(getApplicationContext()).setToken(response.body().getData().getToken());
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result<LoginResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
//        call.enqueue(new Callback<Result<User>>() {
//            @Override
//            public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
////                progressDialog.dismiss();
//                Log.d("Bryan", response.body().getCode() + "");
//                if(response.body() != null && response.body().isSuccessfull()) {
//                    finish();
//                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getData());
//                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                } else {
//                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result<User>> call, Throwable t) {
////                progressDialog.dismiss();
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//                t.printStackTrace();
//
//            }
//        });
    }
}
