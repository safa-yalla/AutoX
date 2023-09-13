/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package net.login.web;
/**
 *
 * @author Safa Nadeem
 */
import java.io.IOException;
import static java.lang.System.out;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.login.bean.LoginBean;
import net.login.database.LoginDao;


@WebServlet("/loginApp")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    String message;
    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        HttpSession sess = request.getSession(); 
        Cookie ck = new Cookie("username", username);
        ck.setMaxAge(60 * 60 * 24);
        ck.setPath("/Vehicle_Management");
        response.addCookie(ck);
        out.print("Hello " + ck.getValue());
        sess.setAttribute("username", username);

        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
//                response.sendRedirect("index.html");
                message = loginBean.getF_name();
                request.setAttribute("message", message);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
            } 
            else {
                message = "Not a valid username and password.";
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
                 request.setAttribute("message", message);
        request.getRequestDispatcher("/loginApp.jsp").forward(request, response);
            }
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}