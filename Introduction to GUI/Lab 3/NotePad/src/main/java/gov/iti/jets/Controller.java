package gov.iti.jets;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class Controller implements Initializable {
    
    private MenuItem menuItem;

    public void handleButtonClicked(){
            System.out.println("HEY FROM MENU ITEM");

    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            System.out.println("Loading user Data");
    }


}
