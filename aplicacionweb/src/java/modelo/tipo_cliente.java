package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class tipo_cliente {
    private int tipoC;
    private String description;
    public conexion cn;
    public tipo_cliente (){}

    public tipo_cliente(int tipoC, String description) {
        this.tipoC = tipoC;
        this.description = description;
    }

    public int getTipoC() {
        return tipoC;
    }

    public void setTipoC(int tipoC) {
        this.tipoC = tipoC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
            
   public HashMap TipoC(){
       HashMap<String, String> dropC = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT id_tipocliente AS id, descripcion FROM tipo_cliente ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropC.put(consulta.getString("id"), consulta.getString("descripcion"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropC;
   }         
   
    
}
