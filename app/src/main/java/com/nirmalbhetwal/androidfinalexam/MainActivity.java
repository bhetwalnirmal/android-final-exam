package com.nirmalbhetwal.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword;
    Button loginButton;
    final String validUsername = "user1";
    final String validPassword = "password1";

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
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            Intent intent = new Intent(MainActivity.this, DestinationDetails.class);

            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Please enter valid username or password", Toast.LENGTH_LONG).show();
        }
    }

    private boolean authenticate (String username, String password) {
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true;
        }

        return false;
    }
}