package gov.iti.jets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Controller implements Initializable {
    
    private final FileChooser fileChooser = new FileChooser();
    @FXML
    private TextArea textArea;

    private Path path = Paths.get("file.txt");

    public void handleButtonClicked(){
  
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
    }

    @FXML 
    void saveFile(){
        String saveToFile =  textArea.getText();
        byte [] inputBytes = saveToFile.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(inputBytes);
        FileChannel channelWrite;
        try {
            channelWrite = FileChannel.open(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            channelWrite.write(byteBuffer);
            channelWrite.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
   /*
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
    */
   /*
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
    */

    @FXML
    public void loadFile()
    {
        try (FileChannel channelRead = FileChannel.open(path)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                channelRead.read(byteBuffer);
                byte[] byteArray =byteBuffer.array();
                String fileContenString = new String(byteArray).trim();
                System.out.println("File Content" +fileContenString);
                textArea.appendText(fileContenString);
                channelRead.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
     
}
