package net.login.web;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Safa Nadeem
 */
@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String f_name = request.getParameter("f_name");
        String l_name = request.getParameter("l_name");
        String nationality = request.getParameter("nationality");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
String message;
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronics?useSSL=false", "root", "Safnad2212");

            PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?)");
            ps.setString(1, f_name);
            ps.setString(2, l_name);
            ps.setString(3, nationality);
            ps.setString(4, username);
            ps.setString(5, password);

            int i = ps.executeUpdate();
            if (i > 0) {

                message= "Signed up! ";
                 request.setAttribute("message", message);
                request.getRequestDispatcher("/signUp.jsp").forward(request, response);

            }

        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            message = "Already signed up! Please log in";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/signUp.jsp").forward(request, response);
            //response.sendRedirect("login.jsp");

        } catch (Exception ex) {
            ex.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
            //response.sendRedirect("login.jsp");
            System.out.println("ygdag");
        }
        out.close();
    }

}
