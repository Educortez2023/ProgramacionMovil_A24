package com.example.examenbienesraicesgy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examenbienesraicesgy.activity.ListBienesRaicesActivity;
import com.example.examenbienesraicesgy.activity.RegistroActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegistrar;
    Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar =findViewById(R.id.btnRegistro);
        btnListar = findViewById(R.id.btnMostrar);
        btnRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View View) {
        if(View.getId() ==R.id.btnRegistro){
            registrarBienes();
        }else if (View.getId() ==R.id.btnMostrar){
            mostrarBienes();
        }

    }

    private void mostrarBienes() {
        Intent intent = new Intent( this, ListBienesRaicesActivity.class);
        startActivity(intent);
    }

    private void registrarBienes() {
        Intent intent = new Intent( this, RegistroActivity.class);
        startActivity(intent);
    }
}