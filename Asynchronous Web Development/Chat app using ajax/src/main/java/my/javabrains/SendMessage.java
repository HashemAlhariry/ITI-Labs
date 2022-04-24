package my.javabrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SendMessage extends HttpServlet {

    static ArrayList<MessageDto> messages = new ArrayList<>();

    static {

        messages.add(new MessageDto("System", "Hello Every one"));
        messages.add(new MessageDto("System", "Have a good day"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // return all message to the index

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        // add them to the message array
        Gson gson = new Gson();
        String messageJson = gson.toJson(messages);
        out.print(messageJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String message = request.getParameter("message");
        System.out.println(name + " " + message);
        MessageDto messageDto = new MessageDto(name, message);
        messages.add(messageDto);

    }

}
