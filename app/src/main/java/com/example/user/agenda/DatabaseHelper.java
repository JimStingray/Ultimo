package com.example.user.agenda;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// nuestra clase DatabaseHelper hereda (extends) métodos de SQLiteOpenHelper
// para poder usar sentencias de SQL
public class DatabaseHelper extends SQLiteOpenHelper {

    // definimos 2 constantes: DATABASE_NAME y DATABASE_VERSION
    private static final String DATABASE_NAME = "Contactos";
    private static final int DATABASE_VERSION = 1;

    // usamos la constante DATABASE_CREATE_CONTACTOS para almacenar
    // una instrucción SQL para crear la tabla contactos;
    // las constantes siempre deben escribirse en mayúsculas
    private static final String DATABASE_CREATE_CONTACTOS =
            "create table contactos (_id integer primary key autoincrement, " +
                    "nombre text not null, email text not null, edad integer not null)";

    // usamos la constante DATABASE_DELETE_CONTACTOS para eliminar la tabla contactos
    private static final String DATABASE_DELETE_CONTACTOS = "drop table if exists contactos";

    // constructor de la clase DatabaseHelper
    public DatabaseHelper(Context context_1) {

        // crea la base de datos
        // super: hace referencia a la súperclase SQLiteOpenHelper
        super(context_1, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // se llama, de manera automática, al crear la base de datos
    @Override     // Override = sobreescribir
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    // este método es llamado de manera automática si, a la hora de crear el DataBaseHelper,
    // se pasa de una versión anterior a otra más actualizada
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // reconstruimos la tabla
        deleteTables(db);
        createTables(db);
    }

    // métodos para crear y eliminar nuestra tabla
    private void createTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CONTACTOS);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_DELETE_CONTACTOS);
    }
}
