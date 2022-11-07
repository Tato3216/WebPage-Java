    package controlador;

    import java.io.IOException;
    import java.io.PrintWriter;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import modelo.cliente;   
    import modelo.usuario;

    public class srv_clientes_admin extends HttpServlet {
        cliente cli;


        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet srv_clientes_admin</title>");            
                out.println("</head>");
                out.println("<body>");
                cli= new cliente(Integer.valueOf(request.getParameter("Drop_Tipo")),request.getParameter("txt_nit"),request.getParameter("txt_name"),request.getParameter("txt_lastname"),request.getParameter("txt_cel"),request.getParameter("txt_direccion"),request.getParameter("txt_fecha"));
                if ("agregar".equals(request.getParameter("btn_agregar"))){
                    if (cli.agregar()>0){
                        response.sendRedirect("Clientes_admin.jsp");
                        out.println("<h1> *** Ingreso Exitoso*** </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }else{
                        out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }
                    }

                if ("Modificar".equals(request.getParameter("btn_modificar"))){
                    if (cli.actualizar()>0){
                        response.sendRedirect("Clientes_admin.jsp");
                        out.println("<h1> *** Modificado *** </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }else{
                        out.println("<h1> xxxxxxx No se Modificos xxxxxxxxxxxx </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }
                    }

                if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                    if (cli.eliminar()>0){
                        response.sendRedirect("Clientes_admin.jsp");
                        out.println("<h1> *** Eliminado *** </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }else{
                        out.println("<h1> xxxxxxx No se pudo Eliminar xxxxxxxxxxxx </h1>");
                        out.println("<a href='Clientes_admin.jsp'>Regresar...</a>");
                    }
                    }
                if ("Cerrar".equals(request.getParameter("btn_cerrar"))){
                    response.sendRedirect("principal_admin.jsp");
                }
    //            out.println("<h1>Servlet srv_clientes_admin at " + request.getContextPath() + "</h1>");
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
