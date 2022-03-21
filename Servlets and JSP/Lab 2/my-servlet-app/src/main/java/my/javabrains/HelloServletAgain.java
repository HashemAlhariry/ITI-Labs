package my.javabrains;
 

import jakarta.servlet.*;
import java.io.*;

public class HelloServletAgain implements Servlet {
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
            String userName = (String)servletContext.getAttribute("username");
            String password = (String)servletContext.getAttribute("password");
            out.print("Admin name is "+ adminName + " User name is "+ userName + " password "+ password); 
    }


    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }
   
    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    

}
