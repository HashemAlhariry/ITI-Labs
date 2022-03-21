package my.javabrains;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String check = request.getParameter("hint");
        String cookieChecker = request.getParameter("cookie");

        // check user if logged in before or not firstly
        // if yes redirect to welcome user servlet
        // no continue

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("checker")!=null) {
            response.sendRedirect("/cookiesAndSession/WelcomeUser");
        }

        out.println("<html style='display: table; margin: auto;'>");
        out.println("<body style= 'display: table-cell; vertical-align: middle;'>");
        out.println("<h1> Login Form</h1>");
        out.println("<h2>Please enter the user details</h2>");
        if (check != null) {
            out.print("Login Failed");
        }
        if (cookieChecker != null) {
            out.print("Please accept cookies to login");
        }
        out.println("<FORM method= POST>");
        out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<br>");
        out.println("<br>");
        out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<input type=checkbox name=checkbox  ");
        out.println(" <label for=checkbox>Remember me</label>");
        out.println("<br>");
        out.println("<br>");
        out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.print("</body>");
        out.print("</html>");

        // testing cookie
        Cookie cookie = new Cookie("testCookie", "one");
        response.addCookie(cookie);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String checkbox = request.getParameter("checkbox");

            // check here for the db
            try {

                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
                Connection conn = ds.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement("select * from user where username = ? and password = ?");
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loggedIn", new String("true"));
                    session.setAttribute("userName", userName);
                    session.setAttribute("checker", checkbox);
                    Cookie cookie = new Cookie("sessionId", session.getId());
                    response.addCookie(cookie);
                    response.sendRedirect("/cookiesAndSession/WelcomeUser");

                } else {
                    response.sendRedirect("/cookiesAndSession/LoginServlet?hint");
                }

            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }

        } else {
            response.sendRedirect("/cookiesAndSession/LoginServlet?cookie");
        }

    }
}
