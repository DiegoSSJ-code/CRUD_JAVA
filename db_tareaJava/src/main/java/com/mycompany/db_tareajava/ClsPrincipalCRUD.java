/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db_tareajava;

import datos.ClsAlumnoJDBC;
import dominio.*;
import java.util.*;

/**
 *
 * @author Win10
 */
public class ClsPrincipalCRUD {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    public static ClsAlumnoJDBC al = new ClsAlumnoJDBC();
  
    public static void main(String[] args) {
        while (opcion != 0){
            try{
                System.out.println("Elige opcion:\n1.- Ver lista completa de alumnos"
                + "\n2.- Agregar alumno\n"
                + "3.- Actualizar alumno\n"
                + "4.- Borrar alumno\n"
                + "5.- Buscar alumno\n"        
                + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        LeerTodo();
                        break;
                    case 2:
                        Crear();
                        break;
                    case 3:
                        Actualizar();
                        break;
                    case 4:
                        eliminar();
                        break;
                    case 5:
                        buscarCod();
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
            }
        }
    
    private static void LeerTodo(){
        ClsAlumnoJDBC alJDBC = new ClsAlumnoJDBC();
        List<ClsAlumnos> todos = alJDBC.SQLSelect();
        
        for(ClsAlumnos alum : todos){
            System.out.println("Alumnos: "+alum);
        }
    }
    
    private static void Crear(){
        String nombre = "";
        int nota1 = 0;
        int nota2 = 0;
        System.out.println("Ingrese el nombre del alumno: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese la nota numero 1: ");
        nota1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la nota numero 2: ");
        nota2 = Integer.parseInt(scanner.nextLine());
        ClsAlumnos alumno = new ClsAlumnos(nombre, nota1, nota2);   
        System.out.println(al.SQLCreate(alumno));
        System.out.println("AGREGADO CON EXITO :)");
    }

    private static void Actualizar() {
        int codigo = 0;
        String nombre = "";
        int nota1 = 0;
        int nota2 = 0;
        System.out.println("Ingrese el codigo del alumno que desea actualizar: ");
        codigo = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo nombre del alumno: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese la nueva nota numero 1: ");
        nota1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la nueva nota numero 2: ");
        nota2 = Integer.parseInt(scanner.nextLine());
        ClsAlumnos alumno = new ClsAlumnos(codigo, nombre, nota1, nota2);   
        System.out.println(al.SQLCreate(alumno));
        System.out.println("ACTUALIZADO CON EXITO :)");
    }

    private static void eliminar() {
       int cod = 0;
        System.out.println("Ingrese el codigo del alumno que desea eliminar: ");
        cod = Integer.parseInt(scanner.nextLine());
        System.out.println(al.SQLDelete(cod));
        System.out.println("ELIMINADO CON EXITO :)");
    }

    private static void buscarCod() {
        int cod = 0;
        System.out.println("Ingrese el codigo del alumno que desea buscar: ");
        System.out.println(al.SQLSelectOnlyOne(cod));
        System.out.println("ENCONTRADO");
    }
    
}
