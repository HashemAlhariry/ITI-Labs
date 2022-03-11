package gov.iti.jets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Controller implements Initializable {
    
    private final FileChooser fileChooser = new FileChooser();
    @FXML
    private TextArea textArea;

    public void handleButtonClicked(){
  
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
    }


    @FXML 
    void saveFile(){
        PrintWriter writer;
        try {
            writer = new PrintWriter("file.txt", "UTF-8");
            writer.println(textArea.getText());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
             System.out.println("Error Saving File");
            e.printStackTrace();
        }
          
    }
  

    @FXML
    public void loadFile()
    {

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("Files","*.txt"));
        File file =  fileChooser.showOpenDialog(null);
        if(file!=null){
            try (FileReader fr = new FileReader(file.getAbsolutePath())) {
                int c;
                String temp="";
                while ((c = fr.read()) != -1)
                         temp+=((char)c);
                
                   textArea.appendText(temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Invalid File");
        }

    }

}
