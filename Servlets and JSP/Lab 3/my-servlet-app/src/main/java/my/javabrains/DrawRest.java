package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DrawRest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
      
        PrintWriter out = response.getWriter();
        out.println("<html style='display: table; margin: auto;'>");
        out.println("<body style= 'display: table-cell; vertical-align: middle;'>");
        out.println("<h1>SQL Tool</h1>");
        out.println("<h2>Please Type your sql statement</h2>");
        out.println("<FORM method= POST>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>  Name: <INPUT TYPE=TEXTAREA NAME=name style=\" width: 300px; height: 150px;\">");
        out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</body>");
        out.println("</html>");

        List<ArrayList<String>> columns  = (List<ArrayList<String>>) request.getAttribute("columns");

        if (columns.size() > 0) {

            out.println("<br>");
            out.println("<br>");
            out.println("<table style= \"  border: 1px solid black; border-spacing: 15px 15px;\">");
            out.println("<tr>");
            for(int i=0;i<columns.size();i++){
                out.println("<th>"+ columns.get(i).get(0)+ "</th>");
            }
            out.println("</tr>");
            
          
            for(int i=1;i<columns.get(0).size();i++){
                out.println("<tr>");
                for (int j = 0; j < columns.size(); j++) {
                    out.println("<td>");
                    out.println(columns.get(j).get(i));
                    out.println("</td>");
                }
                out.println("</tr>");
            }
         
            out.println("</table>");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
