package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class rol {
    private String nombre;
    conexion cn;
    public rol (){}

    public rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        public int agregar(){
        int retorno=0;
        try{
        PreparedStatement   Parametro;
        String query = "INSERT INTO role (nombre) " + " values (?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNombre());
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
        String query = "SELECT role_id as id , nombre "+
                " FROM role " ; 
//                "WHERE u.role_id = l.role_id";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Nombre"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[2];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nombre");
        tabla.addRow(datos);
    }
        
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
        return tabla;
}

    
//    @Override
//    public int actualizar(){
//        int retorno =0;
//        try{
//            PreparedStatement   Parametro;
//            String query = "UPDATE role SET nombre = ? " + " WHERE role_id =?";    
//            cn = new conexion();
//            cn.abrirConexion();
//            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
//            Parametro.setString(1, getNombre()); 
//            retorno=Parametro.executeUpdate();
//            cn.cerrarConexion();
//        }catch(Exception ex){
//            System.out.println("Error..."+ex.getMessage());
//            retorno=0;            
//        }
//        return retorno;
//    }
    
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
