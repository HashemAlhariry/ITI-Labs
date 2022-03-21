package my.javabrains;

import jakarta.servlet.*;
import java.io.*;

public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("I am inside the init method");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<br>Welcome to Servlets and JSP Course");
        System.out.println("I am inside the service method");
    }

    @Override
    public void destroy() {
        System.out.println("I am inside the destroy method");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}