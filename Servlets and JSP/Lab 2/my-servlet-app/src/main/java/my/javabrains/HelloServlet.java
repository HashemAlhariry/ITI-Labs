package my.javabrains;

import jakarta.servlet.*;
import java.io.*;

public class HelloServlet implements Servlet {
    ServletConfig Myconfig;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.Myconfig=config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            ServletContext servletContext = Myconfig.getServletContext();
            String adminName = servletContext.getInitParameter("admin");
            out.print("Admin name is "+ adminName);
            servletContext.setAttribute("username", "etch");
            servletContext.setAttribute("password","1234hashem");
    }

    @Override
    public void destroy() {
        return;
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