package com.nirmalbhetwal.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the edit texts
        etUsername = (EditText) findViewById(R.id.editTextUserName);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        // initialize the login button
        loginButton = (Button) findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        
    }
}