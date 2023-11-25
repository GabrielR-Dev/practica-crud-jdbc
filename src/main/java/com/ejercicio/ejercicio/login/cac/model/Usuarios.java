package com.ejercicio.ejercicio.login.cac.model;
import java.time.LocalDate;


public class Usuarios {
    
    private int id;
    private String nombre;
    private String contracenia;
    private String apellido;
    private int edad;
    private String provincia;
    private LocalDate fecha; 

    public Usuarios() {
    }


    public Usuarios(String nombre, String contracenia, String apellido, int edad, String provincia) {
        this.nombre = nombre;
        this.contracenia = contracenia;
        this.apellido = apellido;
        this.edad = edad;
        this.provincia = provincia;
        this.fecha = LocalDate.now();
    }
   public Usuarios(String nombre, String apellido, int edad, String provincia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.provincia = provincia;
        this.fecha = LocalDate.now();
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

    public String getContracenia() {
        return contracenia;
    }

    public void setContracenia(String contracenia) {
        this.contracenia = contracenia;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

 

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", provincia=" + provincia + '}';
    }
    
    
    
}
