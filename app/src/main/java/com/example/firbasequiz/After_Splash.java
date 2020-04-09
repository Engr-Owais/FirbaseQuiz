package com.example.firbasequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class After_Splash extends AppCompatActivity {

    private Button btnsigup;
    private Button btnsigin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after__splash);

        btnsigup = findViewById(R.id.btnSignUp);
        btnsigin = findViewById(R.id.btnLogin);
    }

    public void onCLickUp (View view)
    {
        startActivity(new Intent(After_Splash.this , test.class));
    }

    public void onCLickin (View view)
    {
        startActivity(new Intent(After_Splash.this , login_activity.class));
    }




}
