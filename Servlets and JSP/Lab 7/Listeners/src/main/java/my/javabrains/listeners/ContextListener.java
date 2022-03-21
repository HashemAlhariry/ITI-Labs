package my.javabrains.listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent cse) {
        System.out.println("Application initialized");
        try {
            File myFile = new File("/Users/hashemalhariry/Desktop/ITI/week 18/Servlets and JSP /Lab 7/Listeners/src/main/resources/test.txt");
            if (myFile.createNewFile()) {
                String totalRequests = "0";
                cse.getServletContext().setAttribute("totalrequests", totalRequests);
            } else {
                System.out.println("file already exists");
                Scanner myReader = new Scanner(myFile);
                if (myReader.hasNextLine()) {
                    String totalRequests = myReader.nextLine();
                    cse.getServletContext().setAttribute("totalrequests", totalRequests);
                    UserReqCountListener.totalrequests = Integer.valueOf(totalRequests.trim());
                }

                myReader.close();
            }
        } catch (IOException e) {

        }
    }

    public void contextDestroyed(ServletContextEvent cse) {


        if (cse.getServletContext().getAttribute("totalrequests") != null) {
        

            try {
                BufferedWriter writer = new BufferedWriter( new FileWriter("/Users/hashemalhariry/Desktop/ITI/week 18/Servlets and JSP /Lab 7/Listeners/src/main/resources/test.txt"));
                String xyz = Integer.toString(UserReqCountListener.totalrequests);
                writer.write(xyz);
                System.out.println("it wrote on file");

                writer.close();
            } catch (IOException e) {
                System.out.println("it didn't write");
                e.printStackTrace();
            }

        } else {
            System.out.println("a7aaaaaaaaaa");
        }

    }

}
