package my.javabrains;

 


import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.DataSource;
import java.util.ArrayList;

public class SearchForm extends HttpServlet {

    public SearchForm() {

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        String name = request.getParameter("name");
        try {
            if (!name.isBlank()) {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
                Connection conn = ds.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement("select * from  user where username like ?");
                preparedStatement.setString(1, "%" + name + "%");
                ResultSet rs = preparedStatement.executeQuery();

                List<UserDao> users = new ArrayList<>();

                while (rs.next()) {

                    users.add(new UserDao(rs.getString("username"), rs.getString("userfullname")));
                }
                request.setAttribute("result",users);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }  

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
             
        }
        
    }
    public List<UserDao> connectDB(String name) {

        String nameToSearch = name;
        
        try {
            if (!nameToSearch.isBlank()) {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
                Connection conn = ds.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement("select * from  user where username like ?");
                preparedStatement.setString(1, "%" + nameToSearch + "%");
                ResultSet rs = preparedStatement.executeQuery();

                List<UserDao> users = new ArrayList<>();

                while (rs.next()) {

                    users.add(new UserDao(rs.getString("username"), rs.getString("userfullname")));
                }
                return users;

            } else {
                return null;
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    

    }

}
