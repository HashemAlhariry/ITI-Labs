package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DrawTable extends HttpServlet {
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

        List<User> users = (List<User>) request.getAttribute("users");
        
        if (users.size() > 0) {
            out.println("<br>");
            out.println("<br>");
            out.println("<table style= \"  border: 1px solid black;\">");
            out.println("<tr>");
            out.println("<th> FullName </th>");
            out.println("<th> User Name </th>");
            out.println("</tr>");
            for (int i = 0; i < users.size(); i++) {
                out.println("<tr>");
                out.println("<td>");
                out.println(users.get(i).userFullName);
                out.println("</td>");

                out.println("<td>");
                out.println(users.get(i).username);
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
