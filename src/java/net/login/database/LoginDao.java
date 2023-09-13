/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.login.database;

/**
 *
 * @author Safa Nadeem
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.login.bean.LoginBean;

public class LoginDao {

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        String url = "jdbc:mysql://localhost:3306/electronics?useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String uname = loginBean.getUsername();

        try ( Connection connection = DriverManager
                .getConnection(url, "root", "Safnad2212"); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection
                        .prepareStatement("select f_name from users where username = ? and pass = ? ")) {
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            System.out.println(preparedStatement.executeQuery());
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            loginBean.setF_name(rs.getString("f_name"));
 

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }

        return status;
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
