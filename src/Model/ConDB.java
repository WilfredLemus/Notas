
package Model;
import java.sql.*;


public class ConDB {
    public String driver, url, ip, bd, usr, pass;
    public Connection conexion;
    
    public void Con() {
        driver = "oracle.jdbc.driver.OracleDriver";
        this.ip = "localhost";
        this.bd = "notas";
        this.usr = "notas";
        this.pass = "123";
        url = new String("jdbc:oracle:thin:@" + ip + ":8585:" + bd);
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", usr, pass);
            System.out.println("Conexion a Base de Datos " + bd + " Ok");
        } catch (Exception exc) {
            System.out.println("Error al tratar de abrir la base de Datos " + bd + " : " + exc);
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public Connection CerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }
    
    
    /*public static void main(String[] args) {
        ConDB dd = new ConDB();
        dd.Con();
    }*/
    
    
    
}     

