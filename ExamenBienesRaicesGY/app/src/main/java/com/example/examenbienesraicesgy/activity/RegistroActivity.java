package com.example.examenbienesraicesgy.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.examenbienesraicesgy.R;
import com.example.examenbienesraicesgy.entity.BienesRaiceseEntity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    Button Registrar;
    EditText Descripcion;
    EditText Precio;
    ImageView Foto;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Registrar = findViewById(R.id.btnRegistrar);
        Descripcion = findViewById(R.id.edtDescripcion);
        Precio = findViewById(R.id.edtPrecio);
        Foto = findViewById(R.id.imgDepartamento);
        Registrar.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegistro) {
            grabarDepartamento();
        }
    }

    private void grabarDepartamento() {
        BienesRaiceseEntity objBienesRaices = new BienesRaiceseEntity();
        objBienesRaices.setObservacion(Descripcion.getText().toString());
        objBienesRaices.setPrecio(Precio.getText().toString());

        db.collection("bienesRaices")
                .add(objBienesRaices)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        mostrarMensaje("Se inserto el registro!!!");
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    private void mostrarMensaje(String mensajes) {
        Toast.makeText( this, mensajes, Toast.LENGTH_LONG).show();
    }
}