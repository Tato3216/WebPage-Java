package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class accesos_list {
    private int accesU;
    private String nombre;
    public conexion cn;
    public accesos_list (){}   

    public accesos_list(int accesU, String nombre) {
        this.accesU = accesU;
        this.nombre = nombre;
    }

    public int getAccesU() {
        return accesU;
    }

    public void setAccesU(int accesU) {
        this.accesU = accesU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
       public HashMap AccesU(){
       HashMap<String, String> dropB = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT id_acces AS id, nombre FROM acces ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropB.put(consulta.getString("id"), consulta.getString("nombre"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropB;
   } 
    
}
