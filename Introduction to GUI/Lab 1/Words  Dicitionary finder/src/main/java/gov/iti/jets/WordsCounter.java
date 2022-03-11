package gov.iti.jets;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.*;

public class WordsCounter extends JFrame {

    BufferedReader reader;
    StringBuffer responseContent = new StringBuffer();
    String line = "";

    private static HttpURLConnection connection;
    private JButton wordsButton;
 
    private JTextArea textArea;

    String urlToSearch;
    String ipForSearchedURL;

    WordsCounter(String title) {

        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);

  
        wordsButton = new JButton("WORDS");

        textArea = new JTextArea();

        wordsButton.addActionListener(this::wordsFunction);
      

   
        wordsButton.setBounds(240, 300, 120, 30);
        textArea.setBounds(115, 25, 350, 250);

        add(wordsButton);
        add(textArea);
         
    }

    public static void main(String[] args) {

        WordsCounter guiipFinder = new WordsCounter("Dictionary - Words Meaning");
        guiipFinder.setBounds(600, 250, 600, 400);
        guiipFinder.setVisible(true);

    }

    private void wordsFunction(ActionEvent e) {
        int counter = 0;
        String[] newStr = textArea.getText().replaceAll("(\\r|\\n)", " ").split("\\s+");

        for (int i = 0; i < newStr.length; i++) {
            if (!newStr[i].isBlank() && newStr[i].length() >= 2 && !isNumeric(newStr[i])) {

                boolean checkDigits = false;
                for (int j = 0; j < newStr[i].length(); j++) {
                    if (Character.isDigit(newStr[i].charAt(j))) {
                        checkDigits = true;
                    }
                }
                if (!checkDigits)
                    counter++;
            }
        }
        String allMeaning="";
        for (int i = 0; i < newStr.length; i++) {
   
            try {

                URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + newStr[i]);
                System.out.print(url);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                int status = connection.getResponseCode();

                if (status >= 300) {
                    System.out.print("STATUS" + status);
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                }
                String temp = newStr[i].toUpperCase() +": "+parse(responseContent.toString()) +"\n";
                allMeaning += temp;
                responseContent=new StringBuffer();

            } catch (MalformedURLException e1) {
                // e1.printStackTrace();
            } catch (NullPointerException e1) {
                // e1.printStackTrace();
            } catch (IOException e1) {
                // e1.printStackTrace();
            }


        }
        JOptionPane.showMessageDialog(this,allMeaning);

    }

    public static String parse(String responseBody) {

        try{

        
        JSONArray response = new JSONArray(responseBody);
        JSONObject jsonObject = response.getJSONObject(0);
        JSONArray meanings = jsonObject.getJSONArray("meanings");
        return  meanings.getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition");
        }catch(org.json.JSONException e){
            return "";
        }

    }

    private void charFunction(ActionEvent e) {
        String newStr = textArea.getText().replaceAll("(\\r|\\n|\\s+)", "");

        int count = 0;
        for (int i = 0; i < newStr.length(); i++) {
            if (!Character.isDigit(newStr.charAt(i))) {
                count++;
            }
        }

        JOptionPane.showMessageDialog(this, "Total Charcters " + count);

    }

    public boolean isNumeric(String string) {

        if (string == null || string.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

}
