package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Coneccion con la base de datos*/
        String url="jdbc:mysql://localhost:3306/bdestudiantes";
        String user="root";
        String password="123456";

        /*Formulario de registro*/
        System.out.println("EJRCICIO 1");
        Scanner sc= new Scanner(System.in);
        Estudiante estudiante=new Estudiante();

        System.out.println("Insertar un NUEVO ESTUDIANTE");
        System.out.print("Código del estudiante: ");
        String codigo = sc.nextLine();
        estudiante.setCodigo_unico(codigo);

        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();
        estudiante.setNombre(nombre);

        System.out.print("Edad del Estudiante: ");
        int edad = sc.nextInt();
        estudiante.setEdad(edad);

        System.out.println("Carrera del Estudiante ");
        System.out.print("A) Desarrollo de Software. ");
        System.out.print("B) Electromecánica. ");
        System.out.print("C) Aguas y Sanamiento. ");
        System.out.print("D) Redes y Telecominicaciones. ");
        System.out.print("-) Ninguna : ");
        String carrera = sc.next();
        carrera=carrera.toUpperCase();

        if (carrera.equals("A")){
            carrera="Desarrollo de Software";
        }else if (carrera.equals("B")){
            carrera="Electromecánica";
        }else if (carrera.equals("C")){
            carrera="Aguas y Sanamiento";
        }else if (carrera.equals("D")){
            carrera="Redes y Telecominicaciones";
        }else {
            carrera="Retirado";
        }

        estudiante.setCarrera(carrera);

        System.out.print("Posee Beca (Si/No): ");
        String beca = sc.next();
        estudiante.setBeca(beca);

        estudiante.mostrar_estudiante();

        /*Inserción a la database*/

        String sql="insert into estudiantes (codigo_unico,nombre,edad,carrera,beca) values (?,?,?,?,?)";


        try (Connection connection= DriverManager.getConnection(url,user,password)){
            System.out.println("Connected to database");
            System.out.println("Ingresado Datos...");
            PreparedStatement CadenaPreparada= connection.prepareStatement(sql);

            CadenaPreparada.setString(1, estudiante.getCodigo_unico());
            CadenaPreparada.setString(2, estudiante.getNombre());
            CadenaPreparada.setInt(3,estudiante.getEdad());
            CadenaPreparada.setString(4, estudiante.getCarrera());
            CadenaPreparada.setString(5, estudiante.getBeca());

            CadenaPreparada.executeUpdate();

            System.out.println("Ingreso Exitoso...");

        }
        catch (SQLException e1){
            System.out.println(e1.getMessage());
        }





    }
}