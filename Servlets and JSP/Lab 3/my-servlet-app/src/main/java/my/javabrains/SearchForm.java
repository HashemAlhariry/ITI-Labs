package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

public class SearchForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<html style='display: table; margin: auto;'>");
        out.println("<body style= 'display: table-cell; vertical-align: middle;'>");
        out.println("<h1>Search Form</h1>");
        out.println("<h2>Please enter user name</h2>");
        out.println("<FORM method= POST>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>  Name: <INPUT TYPE=TEXT NAME=name>");
        out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameToSearch = request.getParameter("name");
        
        PrintWriter out = response.getWriter();
        try {
                if(!nameToSearch.isBlank()){
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from  user where username like ?");
            preparedStatement.setString(1, "%" + nameToSearch + "%");
            ResultSet rs = preparedStatement.executeQuery();

            boolean checkUserIsFound = false;
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                checkUserIsFound = true;
                users.add(new User(rs.getString("username"), rs.getString("userfullname")));
            }
            request.setAttribute("users", users);
            RequestDispatcher rd = request.getServletContext().getNamedDispatcher("DrawTable");
            rd.include(request, response);
            if (!checkUserIsFound) {
                // user not found
            }
        }else{
            doGet(request, response);
        }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            out.print(e);
        }

    }

}
