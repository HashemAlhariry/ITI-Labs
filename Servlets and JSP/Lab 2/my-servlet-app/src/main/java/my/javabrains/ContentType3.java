package my.javabrains;

import jakarta.servlet.*;
import java.io.*;

public class ContentType3 implements Servlet {
    ServletConfig Myconfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.Myconfig = config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("application/msword");
		PrintWriter out = response.getWriter();
		out.println("HASHEM");
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
