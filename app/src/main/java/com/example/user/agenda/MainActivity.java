package com.example.user.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // método para asociar el botón Añadir
    // usando la propiedad onClick
    public void abrirAgregar(View view){
        Intent intent = new Intent(this, AgregarActivity.class);
        this.startActivity(intent);

    }


    // método para asociar el botón Buscar
    // usando la propiedad onClick
    public void abrirBuscar(View view){
        Intent intent = new Intent(this, BuscarActivity.class);
        this.startActivity(intent);

    }


    // método para asociar el botón Ver Todos
    // usando la propiedad onClick
    public void abrirListarTodos(View view){
        Intent intent = new Intent(this, ListadoActivity.class);
        this.startActivity(intent);

    }

}
