package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    public Connection conexionDB;
    public String url="jdbc:sqlserver://localhost;databaseName=PrograII;user=santos;password=1234;";
    public String jdbc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public Connection Conexion = null;
    
    public void abrirConexion(){
        try{
           Class.forName(jdbc);
           conexionDB = DriverManager.getConnection(url);
           JOptionPane.showMessageDialog(null, "Conexion exitosa...!", "Estado de conexion", JOptionPane.INFORMATION_MESSAGE);
                   
        }catch(Exception e){
            System.out.println("Error al conectar a la base de datos "+e.getMessage());
        }       
    }

public void cerrarConexion(){
        try {
            conexionDB.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos "+ex.getMessage());
        }
    }

public Connection getcon(){
    return  conexionDB;
}

}
