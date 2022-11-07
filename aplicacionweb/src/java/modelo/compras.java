package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class compras {
    private String documento;
    private int proveedor;
    private String descripcion;
    private int producto;
    private int cantidad;
    private int precio;
    private String fecha;
    conexion cn;
    public compras (){}

    public compras(String documento, int proveedor, String descripcion, int producto, int cantidad, int precio, String fecha) {
        this.documento = documento;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha=fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
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
        String query = "INSERT INTO compras (no_documento,id_provider,descripcion,id_producto,cantidad, precio,fecha) " + "values (?,?,?,?,?,?,?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getDocumento());
        Parametro.setInt(2, getProveedor());
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
        String query = "SELECT r.id_compra as id ,r.no_documento as doc,r.descripcion,r.cantidad,r.precio, r.cantidad * r.precio AS total,r.fecha,p.nombre AS producto,p.id_producto AS id_p, t.nombre, t.id_provider AS id_t "+
                " FROM compras AS r, proveedores AS t, productos AS p "+ 
                "WHERE r.id_producto = p.id_producto AND r.id_provider = t.id_provider";
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
        datos[5]=consulta.getString("fecha");
        datos[6]=consulta.getString("total");
        datos[7]=consulta.getString("producto");
        datos[8]=consulta.getString("id_p");
        datos[9]=consulta.getString("nombre");
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
            String query = "UPDATE compras SET id_provider = ? , descripcion = ? , cantidad =?, precio=?  " + " WHERE no_documento =?";    
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setInt(1, getProveedor());
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
        String query = "DELETE FROM compras " + " WHERE no_documento = ?";
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
