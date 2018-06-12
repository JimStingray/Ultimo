package com.example.user.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgregarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }

    // método que inserta el registro en la BDD
    public void guardar(View v) {

        //recogemos los datos introducidos
        String nombre_introducido =
                ((EditText) this.findViewById(R.id.edtNombre)).getText().toString();
        String email_introducido =
                ((EditText) this.findViewById(R.id.edtEmail)).getText().toString();
        // int = entero, valor primitivo; Integer = clase int
        int edad_introducida =
                Integer.parseInt(((EditText) this.findViewById(R.id.edtEdad)).getText().toString());

        // creamos un objeto de tipo Contacto
        Contacto nuevoContacto = new Contacto(nombre_introducido, email_introducido, edad_introducida);

        // creamos un objeto de tipo DBContactos
        DBContactos gestion = new DBContactos(this);

        // añadimos el nuevo contacto
        gestion.guardarContacto(nuevoContacto);

        //cerramos la BDD con el método close
        gestion.close();

        //finalizamos la actividad
        this.finish();
    }
}