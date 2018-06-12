package com.example.user.agenda;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListadoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ListView listarContactos;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        // crea un objeto llamado gestion de tipo DBContactos
        DBContactos gestion = new DBContactos(this);

        // Creamos un cursor para recuperar el resultado
        // del método recuperarContactos (de DBContactos.java)
        Cursor cursor_1 = gestion.recuperarContactos();

        // referenciamos nuestro ListView
        listarContactos = (ListView) this.findViewById(R.id.lvContactos);

        // utilizamos un array de tipo String
        // para hacer referencia a las columnas de la tabla Contactos
        // y poder usarlos en el adaptador
        String[] columnas = new String[]{"nombre", "email", "edad"};

        // creamos un SimpleCursorAdapter (adaptador)
        // que permite usar un Cursor (sqlite)
        // y lo asigna a la lista
        SimpleCursorAdapter sca_1 =
                new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor_1,
                columnas,
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        // establecemos en nuestro listView el adaptador
        listarContactos.setAdapter(sca_1);

        // cerramos la BDD
        gestion.close();
    }

    public void salirlist(View v) {
        this.finish();
    }


}
