/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ClsAlumnos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author Win10
 */
public class ClsAlumnoJDBC implements InterfaceAlumnoJDBC <ClsAlumnos>{     
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection con;
    private static final String SQL_SELECT = "select * from tb_alumnos";
    private static final String SQL_INSERT = "insert into tb_alumnos (nombre, nota1, nota2) values(?, ?, ?)";
    private static final String SQL_UPDATE = "update tb_alumnos set nombre = ?, nota1 = ?, nota2 = ? where codigo = ?";
    private static final String SQL_SEARCH = "select * from tb_alumnos where codigo = ?";
    private static final String SQL_DELETE = "delete from tb_alumnos where codigo = ?"; 

    @Override
    public int SQLCreate(ClsAlumnos x) {
       int crear = 0;
       try{
           con = ClsConexion.getConnection();
           stmt = con.prepareStatement(SQL_INSERT);
           stmt.setString(1, x.getNombre());
           stmt.setInt(2, x.getNota1());
           stmt.setInt(3, x.getNota2());
           crear = stmt.executeUpdate();
       } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
           // ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
       }
       return crear;
    }

    @Override
    public int SQLUpdate(ClsAlumnos x) {
        int actualizar = 0;
        try{
            con = ClsConexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, x.getNombre());
            stmt.setInt(2, x.getNota1());
            stmt.setInt(3, x.getNota2());
            stmt.setInt(4, x.getCodigo());
            actualizar = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
           // ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
        }
        return actualizar;
    }

    @Override
    public int SQLDelete(int key) {
        int eliminar = 0;
        try {
            con = ClsConexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, key);
            eliminar = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
           // ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
        }
        return eliminar;
    }

    @Override
    public ClsAlumnos SQLSelectOnlyOne(int key) {
        ClsAlumnos al = new ClsAlumnos();
        try {
            con = ClsConexion.getConnection();
            stmt = con.prepareStatement(SQL_SEARCH);
            stmt.setInt(1, key);
            rs = stmt.executeQuery();
            while(rs.next()){
                al.setCodigo(rs.getInt("codigo"));
                al.setNombre(rs.getString("nombre"));
                al.setNota1(rs.getInt("nota1"));
                al.setNota2(rs.getInt("nota2"));   
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
           // ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
        }
        return al;
    }

    @Override
    public List<ClsAlumnos> SQLSelect() {
        List<ClsAlumnos> alumnos = new ArrayList<ClsAlumnos>();
        try {
            con = ClsConexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            ClsAlumnos alumno = null;
            
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                int nota1 = rs.getInt("nota1");
                int nota2 = rs.getInt("nota2");
                alumno = new ClsAlumnos(codigo, nombre, nota1, nota2);
                alumno.setCodigo(codigo);
                alumno.setNombre(nombre);
                alumno.setNota1(nota1);
                alumno.setNota2(nota2);
                alumnos.add(alumno);      
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            //ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
        }
        return alumnos;
    }
    
}
