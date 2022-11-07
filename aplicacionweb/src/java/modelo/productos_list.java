package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class productos_list {
    private int proC;
    private String nombre;
    public conexion cn;
    public productos_list (){}

    public productos_list(int proC, String nombre) {
        this.proC = proC;
        this.nombre = nombre;
    }

    public int getProC() {
        return proC;
    }

    public void setProC(int proC) {
        this.proC = proC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
            
   public HashMap proC(){
       HashMap<String, String> dropP = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT id_producto AS id, nombre FROM productos ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropP.put(consulta.getString("id"), consulta.getString("nombre"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropP;
   }   
    
}
