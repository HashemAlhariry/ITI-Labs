package com.example.urlurlconnectionwebview;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UrlConn {
    public  static String getContent(String urlName) {

        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            connection.connect();
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ": " + value);
                }
            }
            String content = "";
            try(Scanner in = new Scanner(connection.getInputStream(),"UTF-8")) {
                while (in.hasNextLine()){
                    content+=in.nextLine();
                    content+="\n";
                }
                return content;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
