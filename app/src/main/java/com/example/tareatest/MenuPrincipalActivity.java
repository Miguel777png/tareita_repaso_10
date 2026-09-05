package com.example.tareatest;


import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MenuPrincipalActivity extends AppCompatActivity {
    private Button btntrueque , btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btntrueque = findViewById(R.id.btntrueque);
        btntrueque.setOnClickListener(v -> {
            Intent intent = new Intent(MenuPrincipalActivity.this, PublicarObjetoActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP | intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();


        });



        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(v -> {

            Intent intent = new Intent(MenuPrincipalActivity.this, DetalleObjetoActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();



        });





    }













}