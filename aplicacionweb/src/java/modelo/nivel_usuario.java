package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class nivel_usuario {
    private int nivelId;
    private String nivel;
    public conexion cn;
    public nivel_usuario (){}

    public nivel_usuario(int nivelId, String nivel) {
        this.nivelId = nivelId;
        this.nivel = nivel;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
            
   public HashMap NivelU(){
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
