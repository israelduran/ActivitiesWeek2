package com.example.manager.avtivitiesweek2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity
{
    TextView idNombreVariable, idTelefonoVariable, idEmailVariable, idDescripcionVariable;
    Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);

        //Relación Widget-Java
        btnEditarDatos = (Button)findViewById(R.id.btnEditarDatos);
        idNombreVariable = (TextView)findViewById(R.id.idNombreVariable);
        idTelefonoVariable = (TextView)findViewById(R.id.idTelefonoVariable);
        idEmailVariable = (TextView)findViewById(R.id.idEmailVariable);
        idDescripcionVariable = (TextView)findViewById(R.id.idDescripcionVariable);

        //Recepción de datos de la clase DatosPersonales
        Bundle datos = getIntent().getExtras();
        String nombreCompleto = datos.getString("nombreCompletoParam");
        String telefono = datos.getString("telefonoParam");
        String email = datos.getString("emailParam");
        String descripcion = datos.getString("descripcionParam");

        //Asignación de valores a los campos
        idNombreVariable.setText(nombreCompleto);
        idTelefonoVariable.setText(telefono);
        idEmailVariable.setText(email);
        idDescripcionVariable.setText(descripcion);

        //Regreso a la pantalla anterior
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmaDatos.this,DatosPersonales.class);
                i.putExtra("nombreEditarParam", idNombreVariable.getText().toString());
                i.putExtra("telefonoEditarParam", idTelefonoVariable.getText().toString());
                i.putExtra("emailEditarParam", idEmailVariable.getText().toString());
                i.putExtra("descripcionEditarParam", idDescripcionVariable.getText().toString());
                startActivity(i);
            }
        });
    }
}
