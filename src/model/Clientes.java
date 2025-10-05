package model;

import java.io.Serializable;

public class Clientes implements Serializable {

    private static final Long seriarizableVersionUID = 1234L;
    private int id;
    private String nombre;
    private String email;

    public Clientes() {
        super();
    }

    public Clientes(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%d, %s,%s", id, nombre, email);
    }
}
