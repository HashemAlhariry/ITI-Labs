package gov.iti.jets;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp  extends Application
{
    
    
    public static void main( String[] args ) {
       Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
     
        BorderPane pane = FXMLLoader.load(getClass().getResource("/NotePadFXML.fxml"));
        Scene scene = new Scene(pane,600,380);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
 