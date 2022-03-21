package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");

        out.println("<FORM action=LoginServlet method= GET>");
        out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Login>");
        out.println("</FORM>");

        out.println("<br>");
        out.println("<br>");

        out.println("<FORM action=RegistrationServlet method= GET>");
        out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Signup>");
        out.println("</FORM");
      
        out.print("</body>");
        out.print("</html>");

    }

}
