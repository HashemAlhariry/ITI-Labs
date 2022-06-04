package gov.iti.jets;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MainApp  extends Application {


    public static void main( String[] args ) {
       Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Menus menuItemHandler = new Menus();
        menuItemHandler.readingDomDemo();
        menuItemHandler.printAllNodes();


        MenuBar mb = new MenuBar();
        for (Menu menu:menuItemHandler.menus) {
            mb.getMenus().add(menu);
        }
        VBox vb = new VBox(mb);
        // create a scene
        Scene sc = new Scene(vb, 500, 300);
        // set the scene
        primaryStage.setScene(sc);
        primaryStage.show();
    }

}
 