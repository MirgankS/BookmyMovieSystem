package com.example.bookmymoviesystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmymoviesystem.R;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Delay for 3 seconds, then go to LoginActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash.this, com.example.bookmymoviesystem.LoginActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3000 ms = 3 seconds
    }
}
