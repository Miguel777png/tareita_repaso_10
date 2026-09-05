package com.example.tareatest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PublicarObjetoActivity extends AppCompatActivity {


    private Button btnBack ,button;

    private EditText txtNombre;
    private RadioGroup GrupoRadio;
    private Integer IdSeleccionado;

    private String nombre , categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_publicar_objeto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txtNombre = findViewById(R.id.txtNombre);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(PublicarObjetoActivity.this, MenuPrincipalActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP | intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        });



        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {

            nombre = txtNombre.getEditableText().toString();
            if (nombre.isEmpty()){

                txtNombre.setError("El nombre es obligatorio!");
            }




            IdSeleccionado = GrupoRadio.getCheckedRadioButtonId();
            if(IdSeleccionado != -1){

                RadioButton ObtenerRB = findViewById(IdSeleccionado);
                categoria = ObtenerRB.getText().toString();


            }else{

                Toast.makeText(this, "Por favor, selecciona una opción de categoria", Toast.LENGTH_SHORT).show();

            }

        });

    }
}