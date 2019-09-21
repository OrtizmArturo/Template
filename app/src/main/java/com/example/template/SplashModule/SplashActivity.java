package com.example.template.SplashModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.template.Delegate.DelegateActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Inicializar lo que falte en caso de ser necesario.
        //      Tal vez hacer un delay para mostrar splashScreen

        Intent homeIntent = new Intent(getApplicationContext(), DelegateActivity.class);
        this.startActivity(homeIntent);
        this.finish();

    }
}
