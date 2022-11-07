package modelo;
import java.util.HashMap;
import controlador.conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.validar;

public class interceptor {
    private int iduser;
    private String frm;
    static String role;
    static String formulario;
    conexion cn;
    validar val;
    
    public interceptor (){}
    
        public interceptor(int iduser, String frm) {
        this.iduser = iduser;
        this.frm = frm;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFrm() {
        return frm;
    }

    public void setFrm(String frm) {
        this.frm = frm;
    }
    
       public HashMap iduser(){
       HashMap<String, String> dropU = new HashMap();
       try{
           cn=new conexion();
           cn.abrirConexion();
            String query = "SELECT u.id_user AS id, a.frm FROM usuario u INNER JOIN group_role gr ON gr.role_id = u.role_id INNER JOIN acces a On a.id_acces = gr.id_acces WHERE u.usuario = '" + val.usr+"'";
           ResultSet consulta=cn.conexionDB.createStatement().executeQuery(query);
           while (consulta.next()){
           dropU.put(consulta.getString("id"),consulta.getString("frm"));
       }
            cn.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return dropU;
   } 
        
    public String getfrm(){
    return  this.formulario;
}
}



        

        
