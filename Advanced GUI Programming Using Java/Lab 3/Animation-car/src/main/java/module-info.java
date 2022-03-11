module hello.jfx {


    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens gov.iti.jets to javafx.fxml;

    exports gov.iti.jets;

}
