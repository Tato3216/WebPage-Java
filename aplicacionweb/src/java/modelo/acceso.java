package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class acceso {
    private String nombre;
    private String frm;
    conexion cn;
    public acceso (){}

    public acceso(String nombre, String frm) {
        this.nombre = nombre;
        this.frm = frm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFrm() {
        return frm;
    }

    public void setFrm(String frm) {
        this.frm = frm;
    }
    
        public int agregar(){
        int retorno=0;
        try{
        PreparedStatement   Parametro;
        String query = "INSERT INTO acces (nombre,frm) " + "values (?,?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNombre());
        Parametro.setString(2, getFrm());
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
        String query = "SELECT id_acces as id , nombre ,frm "+
                " FROM acces "; 
//                "WHERE u.role_id = l.role_id";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Nombre","Ventana"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[3];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nombre");
        datos[2]=consulta.getString("frm");
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
            String query = "UPDATE acces SET frm = ? " + " WHERE nombre =?";    
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setString(1, getFrm()); 
            Parametro.setString(2, getNombre()); 
            retorno=Parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;            
        }
        return retorno;
    }
    
//    @Override
//    public int eliminar(){
//        int retorno=0;
//        try{
//        PreparedStatement Parametro;
//        String query = "DELETE FROM usuario " + " WHERE usuario = ?";
//        cn = new conexion();
//        cn.abrirConexion();
//        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
//        Parametro.setString(1, getUsuario());
//        retorno=Parametro.executeUpdate();
//        cn.cerrarConexion();
//        }catch(Exception ex){
//            System.out.println("Error..."+ex.getMessage());
//            retorno=0;
//        }  
//        return retorno;
//    }
    
}
