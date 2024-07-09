package org.example;

public class Estudiante {
    public String codigo_unico;
    public String nombre;
    public int edad;
    public String carrera;
    public String beca;

    /*Constructores*/

    public Estudiante() {
    }

    public Estudiante(String codigo_unico, String nombre, int edad, String carrera, String beca) {
        this.codigo_unico = codigo_unico;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.beca = beca;
    }

    /*Getters & Setters*/
    public String getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(String codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getBeca() {
        beca=beca.toLowerCase();
        if (beca.equals("si")){
            return "Si";
        }else {
            return "No";
        }
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    /*Metodos*/

    public void mostrar_estudiante(){
        System.out.println("");
        System.out.println(">>>>>  Datos del Estudiante  <<<<<<");
        System.out.println("Código único: " + this.getCodigo_unico());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Carrera: " + this.getCarrera());
        System.out.println("Tiene beca: " + this.getBeca());
    };
}
