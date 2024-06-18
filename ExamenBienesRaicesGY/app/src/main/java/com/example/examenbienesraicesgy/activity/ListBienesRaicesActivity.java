package com.example.examenbienesraicesgy.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenbienesraicesgy.R;

public class ListBienesRaicesActivity extends AppCompatActivity {
    
    RecyclerView ListadoElemento;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_bienes_raices);
        ListadoElemento=findViewById(R.id.rvListadoBienesRacies);
        cargarListado();
        
    }

    private void cargarListado() {
    }
}