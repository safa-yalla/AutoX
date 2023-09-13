package net.login.web;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

/**
 *
 * @author Safa Nadeem
 */
@WebServlet("/insurance")
public class InsuranceServlet extends HttpServlet {

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
        String vin_no = request.getParameter("vin_no");
        String policy_no = request.getParameter("policy_no");
        String type_of_insurance = request.getParameter("type_of_insurance");
        String issue_date = request.getParameter("issue_date");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date exp = cal.getTime();
        String exp_date = dateFormat.format(exp);

        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronics?useSSL=false", "root", "Safnad2212");

            PreparedStatement ps = con.prepareStatement("insert into insurance values(?,?,?,?,?)");
            ps.setString(1, vin_no);
            ps.setString(2, policy_no);
            ps.setString(3, type_of_insurance);
            ps.setString(4, issue_date);
            ps.setString(5, exp_date);

            int i = ps.executeUpdate();
            if (i > 0) {

                String message = "Done!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/insurance.jsp").forward(request, response);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("insurance.jsp");
            rd.include(request, response);
            //response.sendRedirect("login.jsp");
        }
        out.close();
    }

}
