package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class accesorol {
    private int acces;
    private int role;
    private int idr;
    conexion cn;
    public accesorol (){}

    public accesorol(int acces, int role, int idr) {
        this.acces = acces;
        this.role = role;
        this.idr = idr;
    }

    public int getAcces() {
        return acces;
    }

    public void setAcces(int acces) {
        this.acces = acces;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
       public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }
    
       public int agregar(){
        int retorno=0;
        try{
        PreparedStatement   Parametro;
        String query = "INSERT INTO group_role (role_id ,id_acces) values (?,?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setInt(2, getRole());
        Parametro.setInt(1, getAcces()); 
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }
        return retorno;
    }    
    
  public DefaultTableModel leer()
{
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn= new conexion();
        cn.abrirConexion();
        String query = "SELECT g.group_role_id AS id, r.nombre AS nombrer, a.nombre AS nombrea,G.id_acces AS id_a, G.role_id AS id_r FROM group_role AS G\n" +
        "INNER JOIN role r ON r.role_id = G.role_id\n" +
        "INNER JOIN acces a ON a.id_acces = G.id_acces"; ;
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","ROL","Ventana","id_a","id_r"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[5];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nombrer");
        datos[2]=consulta.getString("nombrea");
        datos[3]=consulta.getString("id_a");
        datos[4]=consulta.getString("id_r");
        tabla.addRow(datos);
    }
        
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
        return tabla;
}

    
//    @Override
    public int actualizar(){
        int retorno =0;
        try{
            PreparedStatement   Parametro;
            String query = "UPDATE group_role SET role_id = ?, id_acces = ?  WHERE group_role_id =?";    
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setInt(2, getRole());
            Parametro.setInt(1, getAcces());
            Parametro.setInt(3, getIdr());  
            retorno=Parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;            
        }
        return retorno;
    }
    
//    @Override
    public int eliminar(){
        int retorno=0;
        try{
        PreparedStatement Parametro;
        String query = "DELETE FROM group_role WHERE group_role_id = ?";
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setInt(1, getIdr());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }  
        return retorno;
    }
    
}
