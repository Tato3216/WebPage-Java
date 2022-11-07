package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class roles_list {
    private int rolU;
    private String nombre;
    public conexion cn;
    public roles_list (){}    

    public roles_list(int rolU, String nombre) {
        this.rolU = rolU;
        this.nombre = nombre;
    }

    public int getRolU() {
        return rolU;
    }

    public void setRolU(int rolU) {
        this.rolU = rolU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
       public HashMap RolU(){
       HashMap<String, String> dropC = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT role_id AS id, nombre FROM role ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropC.put(consulta.getString("id"), consulta.getString("nombre"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropC;
   } 
    
}
