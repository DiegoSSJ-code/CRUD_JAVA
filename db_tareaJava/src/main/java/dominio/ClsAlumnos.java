/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Win10
 */
public class ClsAlumnos {
    private int codigo;
    private String nombre;
    private int nota1;
    private int nota2;
    
    public ClsAlumnos(String nom, int not1, int not2){
        this.nombre = nom;
        this.nota1 = not1;
        this.nota2 = not2;
    }
    
    public ClsAlumnos(int c, String n, int n1, int n2){
        this.codigo = c;
        this.nombre = n;
        this.nota1 = n1;
        this.nota2 = n2;
    }
    
    public ClsAlumnos(){
        
    }

    @Override
    public String toString() {
        return "ClsAlumnos{" + "codigo=" + codigo + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
    
    
            
}
