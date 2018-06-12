package com.example.user.agenda;

import java.io.Serializable;

public class Contacto implements Serializable {

    // atributos de la clase Contacto
    private String nombre;
    private String email;
    private int edad;

    // constructor de la clase Contacto
    public Contacto(String nombre_1, String email_1, int edad_1) {
        this.nombre = nombre_1;
        this.email = email_1;
        this.edad = edad_1;
    }

    // Getters & Setters de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre_1) {
        this.nombre = nombre_1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_1) {
        this.email = email_1;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad_1) {
        this.edad = edad_1;
    }
}
