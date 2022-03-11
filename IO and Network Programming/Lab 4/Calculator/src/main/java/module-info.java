module hello.jfx {

 
    requires java.rmi;
    
    opens gov.iti.jets to javafx.fxml;
    exports gov.iti.jets;

}
