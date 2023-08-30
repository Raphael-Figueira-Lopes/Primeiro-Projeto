/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "informa", urlPatterns = "/formula")
public class NewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       String nome = request.getParameter("tnome");
       String email = request.getParameter("tmail");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ola "+nome+", vamos ler seu recado</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public class LoginInfo extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public LoginInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @param request
         * @param response
         * @throws javax.servlet.ServletException
         * @throws java.io.IOException
         * @see HttpServlet#doGet(HttpServletRequest request,HttpServletResponse response)
         */
        @Override
        protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException, IOException {
                doPost(request, response);
        // TODO Auto-generated constructor stub
        }

        /**
         * @param request
         * @param response
         * @throws javax.servlet.ServletException
         * @throws java.io.IOException
         * @see HttpServlet#doPost(HttpServletRequest request,HttpServletResponse response)
         */
        @Override
        protected void doPost(HttpServletRequest request,HttpServletResponse response)
 throws ServletException, IOException {
        // TODO Auto-generated constructor stub
            String id = request.getParameter("name");
            String pass = request.getParameter("password");
            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                RequestDispatcher rd = null;
                request.setAttribute(id, "name");
                if(id.equals("name") && pass.equals("pass")){
                    rd = request.getRequestDispatcher("/WelcomeServlet");
                    rd.forward(request, response);
                }
                else{
                    out.println("<b>InvalidLogin Info.</b>");
                    rd = request.getRequestDispatcher("/LoginInfo.jsp");
                    rd.include(request, response);
                }
            }

        }
    }
}


