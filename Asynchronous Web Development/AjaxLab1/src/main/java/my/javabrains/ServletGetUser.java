package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletGetUser extends HttpServlet {

    private static String USERNAME = "Hashem";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("uName");
        PrintWriter out = response.getWriter();
        System.out.println("name:" + name);
    

        if (USERNAME.equals(name)) {
            out.println("Valid");
        } else {
            out.println("Invalid");
        }

    }

}
