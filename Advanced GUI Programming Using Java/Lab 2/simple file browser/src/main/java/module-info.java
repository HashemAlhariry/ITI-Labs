module hello.jfx {

    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires org.kordamp.ikonli.javafx;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.fontawesome5;

    opens gov.iti.jets to javafx.fxml;

    exports gov.iti.jets;

}
