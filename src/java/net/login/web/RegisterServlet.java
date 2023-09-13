/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package net.login.web;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.login.web.LoginServlet;

/**
 *
 * @author Safa Nadeem
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal = Calendar.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        cal.add(Calendar.YEAR, 6);
        Date exp = cal.getTime();
        String exp_date = dateFormat.format(exp);
        String message;
        int vin_no = Integer.parseInt(request.getParameter("vin_no"));
        String plate_no = (String) request.getParameter("plate_no");
        String manufacturer = (String) request.getParameter("manufacturer");
        String model_no = (String) request.getParameter("model_no");
        String reg_date = (String) request.getParameter("reg_date");


        HttpSession sess = request.getSession(false); //use false to use the existing session
        String uname = (String) sess.getAttribute("username");
        System.out.print(uname);
        if (sess.getAttribute("username") == null) {
            message = "Please log in to register your vehicle";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronics?useSSL=false", "root", "Safnad2212");
            // create the prepared statement object
            PreparedStatement ps = con.prepareStatement("insert into registered values(?,?,?,?,?,?,?)");

            ps.setString(1, uname);
            ps.setInt(2, vin_no);
            ps.setString(3, plate_no);
            ps.setString(4, manufacturer);
            ps.setString(5, model_no);
            ps.setString(6, reg_date);
            ps.setString(7, exp_date);

            int i = ps.executeUpdate();
            if (i > 0) {
                message = "Successfully registered";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/register.jsp").forward(request, response);

            }

        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            message = "Please log in or sign up to register your vehicle";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            //response.sendRedirect("login.jsp");

        } catch (Exception ex) {
            ex.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
            //response.sendRedirect("login.jsp");

        }
        out.close();
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {

            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
