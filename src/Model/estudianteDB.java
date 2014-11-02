package Model;

import CompClase.Estudiante;
import java.sql.*;
import java.util.LinkedList;

public class estudianteDB {
    
   // GET DE DATOS
    
    public static LinkedList<Estudiante> getEstudiantes(){ 
        ConDB con = new ConDB();
        LinkedList<Estudiante> ListEstudiante=new LinkedList();
        String sql = "select * from estudiante";
        ResultSet resultado = null; 
        try { 
            con.Con();
            Statement sentencia; 
            sentencia = con.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            resultado = sentencia.executeQuery(sql); 
            while(resultado.next()){
            Estudiante est = new Estudiante();
            est.setCodigo(resultado.getInt("codigo"));
            est.setNombre(resultado.getString("nombre"));
            est.setTelefono(resultado.getInt("telefono"));
            est.setDireccion(resultado.getString("direccion"));
            ListEstudiante.add(est);
            }
            con.CerrarConexion();
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        
        return ListEstudiante; 
    } 
    
    public static LinkedList<Estudiante> getEstudianteCodigo(int codigo){ 
        ConDB con = new ConDB();
        LinkedList<Estudiante> ListEstudiante=new LinkedList();
        String sql = "select * from estudiante where codigo = "+codigo;
        ResultSet resultado = null; 
        try { 
            con.Con();
            Statement sentencia; 
            sentencia = con.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            resultado = sentencia.executeQuery(sql); 
            while(resultado.next()){
            Estudiante est = new Estudiante();
            est.setCodigo(resultado.getInt("codigo"));
            est.setNombre(resultado.getString("nombre"));
            est.setTelefono(resultado.getInt("telefono"));
            est.setDireccion(resultado.getString("direccion"));
            ListEstudiante.add(est);
            }
            con.CerrarConexion();
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        
        return ListEstudiante; 
    } 
    public static LinkedList<Estudiante> getEstudianteNombre(String nombre){ 
        ConDB con = new ConDB();
        LinkedList<Estudiante> ListEstudiante=new LinkedList();
        String sql = "select * from estudiante where nombre = "+nombre;
        ResultSet resultado = null; 
        try { 
            con.Con();
            Statement sentencia; 
            sentencia = con.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            resultado = sentencia.executeQuery(sql); 
            while(resultado.next()){
            Estudiante est = new Estudiante();
            est.setCodigo(resultado.getInt("codigo"));
            est.setNombre(resultado.getString("nombre"));
            est.setTelefono(resultado.getInt("telefono"));
            est.setDireccion(resultado.getString("direccion"));
            ListEstudiante.add(est);
            }
            con.CerrarConexion();
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        
        return ListEstudiante; 
    } 
    
    
    
    // INSERT NUEVO ESTUDIANTE
    
    public boolean setEstudiante(int codigo, String nombre, int telefono, String direccion){ 
        boolean ingresado = false;
        ConDB con = new ConDB();
        String sql = "insert into estudiante "
                + "values("+
                codigo+",'"
                +nombre+ "', "
                + telefono+", '"
                + direccion+"')";
        try { 
            con.Con();
            Statement sentencia; 
            sentencia = con.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeQuery(sql); 
            ingresado = true;
            con.CerrarConexion();
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return ingresado; 
        }        
        return ingresado; 
    } 
    
    // ACTUALIZAR ESTUDIANTE
    
    public boolean setEstudianteActualizar(int codigo, String nombre, int telefono, String direccion){ 
        boolean actualizado = false;
        ConDB con = new ConDB();
        String sql = "update estudiante "
                + "set "
                + "nombre= '"+nombre+ "', "
                + "telefono ="+ telefono+", "
                + "direccion='"+ direccion+"'";
        try { 
            con.Con();
            Statement sentencia; 
            sentencia = con.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeQuery(sql); 
            actualizado = true;
            con.CerrarConexion();
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return actualizado; 
        }        
        return actualizado; 
    } 
    
    
}
