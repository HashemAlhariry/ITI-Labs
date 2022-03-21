package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.InitialContext;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;

public class SQLTool extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
       
        out.println("<html style='display: table; margin: auto;'>");
        out.println("<body style= 'display: table-cell; vertical-align: middle;'>");
        out.println("<h1>SQL Tool</h1>");
        out.println("<h2>Please Type your sql statement</h2>");
        out.println("<FORM method= POST>");
        out.println("<br>");
        out.println("<br>");
        out.println("<INPUT TYPE=TEXTAREA NAME=name style=\" width: 300px; height: 150px;\">");
        out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</body>");
        out.println("</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nameToSearch = request.getParameter("name");

        PrintWriter out = response.getWriter();
        try {
            if (!nameToSearch.isBlank()) {

                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
                Connection conn = ds.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(nameToSearch);
              

                if(nameToSearch.toLowerCase().contains("select")){
                    ResultSet rs = preparedStatement.executeQuery();
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    List<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
                    int count = rsMetaData.getColumnCount();
                    request.setAttribute("columncount", count);
                    for (int i = 1; i <= count; i++) {
                        ArrayList<String> column = new ArrayList<>();
                        column.add(rsMetaData.getColumnName(i));
                        columns.add(column);
                    }
                    while (rs.next()) {
                        for (int i = 0; i < columns.size(); i++) {
                            columns.get(i).add(rs.getString(columns.get(i).get(0)));
                        }
                    }
    
                    request.setAttribute("columns", columns);
    
                    RequestDispatcher rd = request.getServletContext().getNamedDispatcher("DrawRest");
                    rd.include(request, response);
                }
                else{
                    preparedStatement.executeUpdate();  
                    response.sendRedirect("/lab4/SQLTool");
                }
                
            } else {
                doGet(request, response);
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/lab4/SQLTool");
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendRedirect("/lab4/SQLTool");
        }

    }

}
