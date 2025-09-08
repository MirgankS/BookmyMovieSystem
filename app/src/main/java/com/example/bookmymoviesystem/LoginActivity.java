package com.example.bookmymoviesystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private TextView signupLink, forgotPassword;
    private CheckBox rememberMe;
    private EditText usernameInput, passwordInput; // keep only for UI design

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Views
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.editTextTextPassword2);
        loginButton = findViewById(R.id.logeen);
        signupLink = findViewById(R.id.signupLink);
        forgotPassword = findViewById(R.id.forgotPassword);
        rememberMe = findViewById(R.id.rememberMe);

        // 🔹 Login button click → directly go to MainActivity
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // closes login so user can’t go back
        });

        // 🔹 Sign up link (optional)
        signupLink.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, Signup.class))
        );

        // 🔹 Forgot password click (placeholder)
        forgotPassword.setOnClickListener(v ->
                passwordInput.setError("Forgot password not implemented")
        );
    }
}
