package com.example.tareatest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleObjetoActivity extends AppCompatActivity {



    private Button btnBack;
    private Intent IntentRecibido;
    private String nombrerecibido,categoria_recibida,detallenombre,detallecategoria;
    private TextView txtDetalleNombre,txtDetalleCategoria;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_objeto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtDetalleNombre = findViewById(R.id.txtDetalleNombre);
        txtDetalleCategoria = findViewById(R.id.txtDetalleCategoria);


        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {

            Intent intent = new Intent(DetalleObjetoActivity.this
            , MenuPrincipalActivity.class);

            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        });


        IntentRecibido = getIntent();
        if (IntentRecibido != null){

            nombrerecibido = IntentRecibido.getStringExtra("CLAVE_NOMBRE");
            categoria_recibida = IntentRecibido.getStringExtra("CLAVE_CATEG");

            if(nombrerecibido != null && nombrerecibido.isEmpty() != true) detallenombre = nombrerecibido;
            if(categoria_recibida != null && categoria_recibida.isEmpty() != true) detallecategoria = categoria_recibida;

            txtDetalleNombre.setText(detallenombre);
            txtDetalleCategoria.setText(detallecategoria);

        }



    }
}