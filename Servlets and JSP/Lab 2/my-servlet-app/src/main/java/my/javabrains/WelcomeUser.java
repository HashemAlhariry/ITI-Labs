package my.javabrains;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class WelcomeUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (userName != null) {
            out.println("userName is:" + userName);
        }
        if (password != null) {
            out.println("password is:" + password);
        }
        out.println("</body>");
        out.println("</html>");

    }

}
