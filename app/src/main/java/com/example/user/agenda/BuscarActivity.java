package com.example.user.agenda;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }


    public void buscarEmail(View view) {
        String email = ((EditText) this.findViewById(R.id.edtEmailBuscar)).getText().toString();

        // creamos un objeto del tipo Contacto y valor nulo
        Contacto contactoEncontrado = null;

        // creamos un objeto del tipo DBContactos
        // y lo utilizamos para lanzar el método buscarPorEmail
        DBContactos gestion = new DBContactos(this);
        contactoEncontrado = gestion.buscarPorEmail(email);

        // usamos el método mostrarDato para ver el resultado de la búsqueda
        mostrarDato(contactoEncontrado);

        // cerramos la base de datos
        gestion.close();
    }

    public void salirEmail(View view) {
        this.finish();
    }

    // método que muestra el contacto buscado
    // o indica que no lo ha encontrado
    private void mostrarDato(Contacto contactoEncontrado_2) {

        // si no encuentra el contacto buscado
        if (contactoEncontrado_2 == null) {

            // crea un cuadro de diálogo mostrando un error
            AlertDialog.Builder mensajeNoEncontrado = new AlertDialog.Builder(this);
            mensajeNoEncontrado.setMessage("Contacto no encontrado. ¿Desea realizar otra búsqueda?");
            // si utilizara otros idiomas, sería:
            // mensajeNoEncontrado.setMessage(R.string.error_message);

            // si no desea realizar otra búsqueda, salimos de la actividad
            mensajeNoEncontrado.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // abandona la actividad
                            BuscarActivity.this.finish();
                        }
                    });

            // si desea realizar otra búsqueda, entonces no se define ningún escuchador
            mensajeNoEncontrado.setPositiveButton(android.R.string.yes, null);
            mensajeNoEncontrado.show();

        // si encuentra el contacto buscado
        } else {

            String datos = "Nombre: " + contactoEncontrado_2.getNombre() +
                    "\n Email: " + contactoEncontrado_2.getEmail() +
                    "\n Edad: " + contactoEncontrado_2.getEdad();

            // muestra el contacto en una Toast = notificación pop up
            Toast.makeText(this, datos, Toast.LENGTH_LONG).show();

        }

    }
}
