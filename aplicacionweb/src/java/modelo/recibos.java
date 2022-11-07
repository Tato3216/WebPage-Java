package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class recibos {
    private String documento;
    private int cliente;
    private String descripcion;
    private int producto;
    private int cantidad;
    private int precio;
    private String fecha;
    conexion cn;
    public recibos (){}

    public recibos(String documento, int cliente, String descripcion, int producto, int cantidad, int precio, String fecha) {
        this.documento = documento;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public int agregar(){
        int retorno=0;
        try{
        PreparedStatement   Parametro;
        String query = "INSERT INTO recibos (no_documento,id_client,descripcion,id_producto,cantidad, precio,fecha) " + "values (?,?,?,?,?,?,?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getDocumento());
        Parametro.setInt(2, getCliente());
        Parametro.setString(3, getDescripcion());
        Parametro.setInt(4, getProducto()); 
        Parametro.setInt(5, getCantidad()); 
        Parametro.setInt(6, getPrecio()); 
        Parametro.setString(7, getFecha()); 
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
        String query = "SELECT r.id_recibo as id ,r.no_documento as doc,r.descripcion,r.cantidad,r.precio,r.fecha, r.cantidad * r.precio AS total,p.nombre AS producto,p.id_producto AS id_p, t.nombres, t.id_client AS id_t "+
                " FROM recibos AS r, cliente3 AS t, productos AS p "+ 
                "WHERE r.id_producto = p.id_producto AND r.id_client = t.id_client";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Documento","Descripcion","cantidad","precio","fecha","total","producto","id_p","nombres","id_t"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[11];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("doc");
        datos[2]=consulta.getString("descripcion");
        datos[3]=consulta.getString("cantidad");
        datos[4]=consulta.getString("precio");
        datos[5]=consulta.getString("total");
        datos[6]=consulta.getString("fecha");
        datos[7]=consulta.getString("producto");
        datos[8]=consulta.getString("id_p");
        datos[9]=consulta.getString("nombres");
        datos[10]=consulta.getString("id_t");
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
            String query = "UPDATE recibos SET id_client = ? , descripcion = ? , cantidad =?, precio=?  " + " WHERE no_documento =?";    
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setInt(1, getCliente());
            Parametro.setString(2, getDescripcion());
            Parametro.setInt(3, getCantidad());  
            Parametro.setInt(4, getPrecio()); 
            Parametro.setString(5, getDocumento()); 
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
        String query = "DELETE FROM recibos " + " WHERE no_documento = ?";
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getDocumento());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }  
        return retorno;
    }
    
}
