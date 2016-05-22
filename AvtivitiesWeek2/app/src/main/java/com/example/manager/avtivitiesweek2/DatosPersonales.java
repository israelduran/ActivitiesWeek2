package com.example.manager.avtivitiesweek2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class DatosPersonales extends AppCompatActivity
{
    //Elementos del Layout
    Button btnSiguiente;
    TextInputEditText tiNombreCompleto, tiTelefono, tiEmail, tiDescripcion;
    String nombreCompleto;
    DatePicker dpFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        //Relación Widget-JAVA
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        tiNombreCompleto = (TextInputEditText)findViewById(R.id.tiNombreCompleto);
        tiTelefono = (TextInputEditText)findViewById(R.id.tiTelefono);
        tiEmail = (TextInputEditText)findViewById(R.id.tiEmail);
        tiDescripcion = (TextInputEditText)findViewById(R.id.tiDescripcion);
        dpFechaNacimiento = (DatePicker)findViewById(R.id.dpFechaNacimiento);


        //nombreCompleto = tiNombreCompleto.getText().toString();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NOMBRE::::::::", tiNombreCompleto.getText().toString());
                Intent i = new Intent(DatosPersonales.this,ConfirmaDatos.class);
                i.putExtra("nombreCompletoParam", tiNombreCompleto.getText().toString());
                i.putExtra("telefonoParam", tiTelefono.getText().toString());
                i.putExtra("emailParam", tiEmail.getText().toString());
                i.putExtra("descripcionParam", tiDescripcion.getText().toString());
                startActivity(i);
            }
        });

        Intent intent = this.getIntent();
        if(intent != null)
        {
            String nombreEditado = intent.getStringExtra("nombreEditarParam");
            String telefonoEditado = intent.getStringExtra("telefonoEditarParam");
            String emailEditado = intent.getStringExtra("emailEditarParam");
            String descripcionEditado = intent.getStringExtra("descripcionEditarParam");
            //Asignando valores para editar
            tiNombreCompleto.setText(nombreEditado);
            tiTelefono.setText(telefonoEditado);
            tiEmail.setText(emailEditado);
            tiDescripcion.setText(descripcionEditado);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }
}
