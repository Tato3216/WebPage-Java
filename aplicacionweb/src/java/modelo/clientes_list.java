package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;   
import java.sql.Statement;

public class clientes_list {
    private int tipoC;
    private String nombres;
    public conexion cn;
    public clientes_list (){}

    public clientes_list(int tipoC, String nombres) {
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
            String query = "SELECT id_client AS id, nombres FROM cliente3 ";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropT.put(consulta.getString("id"), consulta.getString("nombres"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropT;
   }   
    
}
