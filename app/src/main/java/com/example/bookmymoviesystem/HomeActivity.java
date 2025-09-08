package com.example.bookmymoviesystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmymoviesystem.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Load the Home fragment only the first time
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new com.example.bookmymoviesystem.Home()) // Home is your Fragment class
                    .commit();
        }
    }
}
