package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.compras;

public class srv_compras extends HttpServlet {
    compras cp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srv_compras</title>");            
            out.println("</head>");
            out.println("<body>");
            cp= new compras(request.getParameter("txt_documento"),Integer.valueOf(request.getParameter("Drop_clientes")),request.getParameter("txt_descripcion"),Integer.valueOf(request.getParameter("Drop_productos")),Integer.valueOf(request.getParameter("txt_cantidad")),Integer.valueOf(request.getParameter("txt_precio")),request.getParameter("txt_fecha"));
            if ("agregar".equals(request.getParameter("btn_agregar"))){
                if (cp.agregar()>0){
                    response.sendRedirect("Compras.jsp");
                    out.println("<h1> *** Ingreso Exitoso*** </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }else{
                    out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }
                }
            
            if ("Modificar".equals(request.getParameter("btn_modificar"))){
                if (cp.actualizar()>0){
                    response.sendRedirect("Compras.jsp");
                    out.println("<h1> *** Modificado *** </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }else{
                    out.println("<h1> xxxxxxx No se Modificos xxxxxxxxxxxx </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }
                }
            
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                if (cp.eliminar()>0){
                    response.sendRedirect("Compras.jsp");
                    out.println("<h1> *** Eliminado *** </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }else{
                    out.println("<h1> xxxxxxx No se pudo Eliminar xxxxxxxxxxxx </h1>");
                    out.println("<a href='Compras.jsp'>Regresar...</a>");
                }
                }
            if ("Salir".equals(request.getParameter("btncerrar"))){ 
                response.sendRedirect("principal.jsp");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
