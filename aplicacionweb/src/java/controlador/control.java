package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.validar;

public class control extends HttpServlet {
    validar user;
    int session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            user = new validar(request.getParameter ("txt_usuario"),request.getParameter("txt_clave"));
           if ("Ingresar".equals(request.getParameter("accion"))){
               // HttpSession session = request.getSession(true);
            if(user.validar() == false) {
                out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
                out.println("<a href='index.jsp'>Regresar...</a>");
            } else {
//                if(user.lvl.compareTo("1")==0){
                    out.println("<h1> *** Ingreso Exitoso*** </h1>");
                    response.sendRedirect("principal.jsp");
//                }
//                if(user.lvl.compareTo("2")==0){
//                    out.println("<h1> *** Ingreso Exitoso*** </h1>");
//                    response.sendRedirect("principal_admin.jsp");
//                }
//                if(user.lvl.compareTo("3")==0){
//                    out.println("<h1> *** Ingreso Exitoso*** </h1>");
//                    response.sendRedirect("principal_operaciones.jsp");
//                }
                //session.setAttribute("sessionId", user.getUsuario());
//                out.println("<a href='index.jsp'>Regresar...</a>");
              }
            }
            /*user=new usuario();
             String accion=request.getParameter("accion");
        if(accion.equals("ingresar")){
            String usuario=request.getParameter ("txt_usuario") ;
            String contraseña=request.getParameter("txt_cotraseña");
            
        }*/

           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet control at " + request.getContextPath() + "</h1>");*/
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
