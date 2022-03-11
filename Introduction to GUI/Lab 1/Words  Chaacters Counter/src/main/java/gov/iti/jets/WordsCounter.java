package gov.iti.jets;

import javax.swing.*;
import java.awt.event.*;

 

public class WordsCounter extends JFrame  {

 

    private JButton wordsButton;
    private JButton charsButton;
    private JTextArea textArea;

    String urlToSearch;
    String ipForSearchedURL;

    WordsCounter(String title) {

        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);

        charsButton = new JButton("CHARACTERS");
        wordsButton = new JButton("WORDS");

        textArea = new JTextArea();

        wordsButton.addActionListener(this::wordsFunction);
        charsButton.addActionListener(this::charFunction);

        charsButton.setBounds(168, 300, 120, 30);
        wordsButton.setBounds(290, 300, 120, 30);
        textArea.setBounds(115, 25, 350, 250);
      

        add(wordsButton);
        add(textArea);
        add(charsButton);
    }

    public static void main(String[] args) {

        WordsCounter guiipFinder = new WordsCounter("Words - Characters COUNTER");
        guiipFinder.setBounds(600, 250, 600, 400);
        guiipFinder.setVisible(true);

    } 

    private  void wordsFunction(ActionEvent e){
        int counter=0;
        String[] newStr =  textArea.getText().replaceAll("(\\r|\\n)", " ").split("\\s+");

        for(int i =0;i<newStr.length;i++){
            if(!newStr[i].isBlank() && newStr[i].length()>=2  && !isNumeric(newStr[i])) {

                boolean checkDigits=false;
                for(int j =0;j<newStr[i].length();j++){
                    if(Character.isDigit(newStr[i].charAt(j))){
                       checkDigits=true;
                    }
                  }
                if(!checkDigits)
                  counter++;
            }
        }

        JOptionPane.showMessageDialog(this, "Total Words " + counter);

    }


    private  void charFunction(ActionEvent e){
         String newStr =  textArea.getText().replaceAll("(\\r|\\n|\\s+)", "");
        

         int count=0;
        for(int i =0;i<newStr.length();i++){
          if(!Character.isDigit(newStr.charAt(i))){
              count++;
          }
        }

        JOptionPane.showMessageDialog(this, "Total Charcters " + count);

    }
    
    public  boolean isNumeric(String string) {
   
        if(string == null || string.equals("")) {
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

