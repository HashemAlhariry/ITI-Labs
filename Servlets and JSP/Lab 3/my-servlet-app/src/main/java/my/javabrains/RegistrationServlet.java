package my.javabrains;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.DataSource;

public class RegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String check = request.getParameter("hint");


        out.println("<html style='display: table; margin: auto;'>");
        out.println("<body style= 'display: table-cell; vertical-align: middle;'>");
        out.println("<h1> Registeration Form</h1>");
        out.println("<h2>Please enter the user details</h2>");
        if (check != null) {
            out.print("Login Failed");
        }
        out.println("<FORM method= POST>");
 

        out.println("<br>");
        out.println("<br>");
        out.println("<br> Full Name: <INPUT TYPE=TEXT NAME=fullName>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br> Username: <INPUT TYPE=TEXT NAME=userName>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br> Password: <INPUT TYPE=PASSWORD NAME=password>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br> <INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");

        out.println("</body>");
        out.println("</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        PrintWriter out = response.getWriter();

        // check here for the db
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into  user values(?,?,?)");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, password);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                response.sendRedirect("/lab4/SearchForm");
            }
            else{
                response.sendRedirect("/lab4/RegistrationServlet?hint");
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            out.print(e);
        }

    }

}
