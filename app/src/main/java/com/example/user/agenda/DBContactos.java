package com.example.user.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// clase del modelo que encapsula el acceso a la base de datos
// y que será utilizada por las Activities
public class DBContactos {

    // variable de tipo SQLite:
    // permite ejecutar instrucciones SQL con execSQL
    private SQLiteDatabase db = null;

    // variable de tipo DatabaseHelper:
    // clase que contiene todas las instrucciones para crear una base de datos
    private DatabaseHelper dbhelper = null;

    // contexto
    Context context_2;

    // constructor de la clase actual
    public DBContactos(Context context_3) {

        // pasamos el contexto context_3 al usar este constructor
        this.context_2 = context_3;

        // crea una instancia del DatabaseHelper
        dbhelper = new DatabaseHelper(context_2);

        // crea un objeto SQLiteDatabase para operar contra la base de datos
        db = dbhelper.getWritableDatabase();
    }

    // método para cerrar la base de datos;
    // el método no devolverá ningún valor (void)
    public void close() {
        dbhelper.close();
    }

    // método para insertar un registro en nuestra base de datos
    // utilizando el formato de la clase Contacto;
    // el método devolverá un valor (long = entero largo)
    public long guardarContacto(Contacto nuevoContacto) {

        // creamos un contenedor llamado contenedorValores
        // para que guarde los valores del registro
        ContentValues contenedorValores = new ContentValues();
        contenedorValores.put("nombre", nuevoContacto.getNombre());
        contenedorValores.put("email", nuevoContacto.getEmail());
        contenedorValores.put("edad", nuevoContacto.getEdad());

        // return = devuelve un valor
        // el nombre de la tabla aparece en DatabaseHelper
        return db.insert("Contactos", null, contenedorValores);
    }

    // método para buscar un contacto si introducimos un eMail
    public Contacto buscarPorEmail(String emailIntroducido) {
        Contacto contacto_1 = null;

        // creamos un cursor = objeto que devuelve un conjunto de filas
        // utilizamos los mismos campos ("_id", "nombre", etc.)
        // que aparecían en "create table contactos" de DatabaseHelper
        Cursor cursor_1 = db.query("Contactos", new String[]{
                "_id", "nombre", "email", "edad"}, "email=?", new String[]{emailIntroducido}, null, null, null);

        // busca si hay más registros coincidentes
        if (cursor_1.moveToNext()) {

            // primer campo = columnIndex: 1; segundo campo = columnIndex: 2; etc...
            contacto_1 = new Contacto(cursor_1.getString(1), cursor_1.getString(2), cursor_1.getInt(3));
        }
        return contacto_1;
    }

    public Cursor recuperarContactos() {
        return db.query("Contactos", new String[]{
                "_id", "nombre", "email", "edad"}, null, null, null, null, null);
    }
}

