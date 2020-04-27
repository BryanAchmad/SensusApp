package com.example.sensusapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private Toolbar toolbarSearch;
    private TextView textViewSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbarSearch = (Toolbar) findViewById(R.id.toolbar_search);
        imageViewBack = (ImageView) findViewById(R.id.backbutton);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
