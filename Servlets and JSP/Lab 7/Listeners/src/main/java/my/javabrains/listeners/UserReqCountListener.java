package my.javabrains.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;


public class UserReqCountListener implements ServletRequestListener {

    public static int totalrequests = 0;
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("A new request has arrived");
        totalrequests++;
        sre.getServletContext().setAttribute("totalrequests", totalrequests);

    }

    public void requestDestroyed(ServletRequestEvent sre) {
       
    }

}
