package my.javabrains;
 
import jakarta.servlet.*;
import java.io.*;

public class ContentType1 implements Servlet {
    ServletConfig Myconfig;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.Myconfig=config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		out.println("\t jan\t feb\t march \t total");
		out.println("salary \t100 \t200 \t300 \t=sum(B2:D2)");
        
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
