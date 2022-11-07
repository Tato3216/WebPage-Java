package modelo;
import controlador.conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;   
import javax.swing.table.DefaultTableModel;

public class proveedor {
    private String nit;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    conexion cn;
    public proveedor (){}

    public proveedor(String nit, String nombres, String apellidos, String telefono, String direccion) {
        this.nit = nit;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
        public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    public int agregar(){
        int retorno=0;
        try{
            PreparedStatement   Parametro;
            String query = "INSERT INTO proveedores (nit,nombre,apellido,telefono,direccion) " + 
                    " values (?,?,?,?,?)";   

            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setString(1, getNit());
            Parametro.setString(2, getNombres());
            Parametro.setString(3, getApellidos());
            Parametro.setString(4, getTelefono());
            Parametro.setString(5, getDireccion());
            retorno=Parametro.executeUpdate();
            //System.out.println("statement result: " + retorno);
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
        String query = "SELECT id_provider as id ,nit,nombre,apellido,telefono,direccion FROM proveedores ";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Nit","Nombres","Apellidos","Telefono","Direccion"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[6];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nit");
        datos[2]=consulta.getString("nombre");
        datos[3]=consulta.getString("apellido");
        datos[4]=consulta.getString("telefono");
        datos[5]=consulta.getString("direccion");
        tabla.addRow(datos);
    }
        
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
        return tabla;
}
    
    public int actualizar(){
        int retorno = 0;
        try{
        PreparedStatement   Parametro;
        String query = "UPDATE proveedores SET nombre = ? ,apellido = ? , telefono = ? , direccion = ?  WHERE nit =?";   
        
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNombres());
        Parametro.setString(2, getApellidos());
        Parametro.setString(3, getTelefono());
        Parametro.setString(4, getDireccion());;
        Parametro.setString(5, getNit());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }
        return retorno;
    }
    
    public int eliminar(){
        int retorno = 0;
        try{
        PreparedStatement Parametro;
        String query = "DELETE FROM proveedores " + " WHERE nit = ?";
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNit());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }        
        return retorno;
    }


}

    

