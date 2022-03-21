package my.javabrains;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

public class SendRedirect extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String check = request.getParameter("hint");

        out.print("<html>");
        out.print("<body>");
        if (check != null) {
            out.print("Login Failed");
        }
        out.println("<FORM method= POST>");
        out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.print("</body>");
        out.print("</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName.equals("hashem") && password.equals("password")) {
            response.sendRedirect("/lab2/welcomeUser?username=" + userName + "&password=" + password);
        } else {

            response.sendRedirect("/lab2/sendredirect?hint=1");

        }
    }
}
