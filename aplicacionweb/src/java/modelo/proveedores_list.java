package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class proveedores_list {
    private int tipoC;
    private String nombres;
    public conexion cn;
    public proveedores_list (){}

    public proveedores_list(int tipoC, String nombres) {
        this.tipoC = tipoC;
        this.nombres = nombres;
    }

    public int getTipoC() {
        return tipoC;
    }

    public void setTipoC(int tipoC) {
        this.tipoC = tipoC;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
            
   public HashMap TipoC(){
       HashMap<String, String> dropT = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT id_provider AS id, nombre FROM proveedores ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropT.put(consulta.getString("id"), consulta.getString("nombre"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropT;
   } 
    
}
