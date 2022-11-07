package modelo;
import controlador.conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;   
import javax.swing.table.DefaultTableModel;

public class cliente extends persona{
    private String nit;
    private int Tipo_cli;
    conexion cn;
    public cliente (){}
    public cliente(String nit){
        this.nit = nit;
    }

    public cliente(int Tipo_cli,String nit, String nombres, String apellidos,String telefono, String direccion,  String fecha_nacimiento) {
        super(nombres, apellidos, telefono,direccion,  fecha_nacimiento);
        this.nit = nit;
        this.Tipo_cli = Tipo_cli;
    }

    public String getNit(){
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }   
    
    public int getTipo_cli(){
    return Tipo_cli;
    }

    public void settipo_cli(int Tipo_cli) {
    this.Tipo_cli = Tipo_cli;
    }

    @Override
    public int agregar(){
        int retorno=0;
        try{
            PreparedStatement   Parametro;
            String query = "INSERT INTO cliente3 (nit,nombres,apellidos,telefono,direccion,fecha_nacimiento,id_tipocliente) " + 
                    " values (?,?,?,?,?,?,?)";   

            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setString(1, getNit());
            Parametro.setString(2, getNombres());
            Parametro.setString(3, getApellidos());
            Parametro.setString(4, getTelefono());
            Parametro.setString(5, getDireccion());
            Parametro.setString(6, getFecha_nacimiento());    
            Parametro.setInt(7, getTipo_cli());
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
        String query = "SELECT c.id_client as id ,c.nit,c.nombres,c.apellidos,c.telefono,c.direccion,c.fecha_nacimiento,tc.descripcion,tc.id_tipocliente "+
                " FROM cliente3 AS c, tipo_cliente AS tc "+ 
                "WHERE c.id_tipocliente= tc.id_tipocliente";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Nit","Nombres","Apellidos","Telefono","Direccion","Nacimiento","Descripcion","idtipocli"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[9];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nit");
        datos[2]=consulta.getString("nombres");
        datos[3]=consulta.getString("apellidos");
        datos[4]=consulta.getString("telefono");
        datos[5]=consulta.getString("direccion");
        datos[6]=consulta.getString("fecha_nacimiento");
        datos[7]=consulta.getString("descripcion");
        datos[8]=consulta.getString("id_tipocliente");
        tabla.addRow(datos);
    }
        
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
        return tabla;
}
    
    @Override
    public int actualizar(){
        int retorno = 0;
        try{
        PreparedStatement   Parametro;
        String query = "UPDATE cliente3 SET nombres = ? ,apellidos = ? , telefono = ? , direccion = ? , fecha_nacimiento = ?, id_tipocliente = ?  " +
                " WHERE nit =?";   
        
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNombres());
        Parametro.setString(2, getApellidos());
        Parametro.setString(3, getTelefono());
        Parametro.setString(4, getDireccion());
        Parametro.setString(5, getFecha_nacimiento());
        Parametro.setInt(6, getTipo_cli());
        Parametro.setString(7, getNit());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }
        return retorno;
    }
    
    @Override
    public int eliminar(){
        int retorno = 0;
        try{
        PreparedStatement Parametro;
        String query = "DELETE FROM cliente3 " + " WHERE nit = ?";
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

