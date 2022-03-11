module usermodule {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    //----------------
    opens userpackage to javafx.fxml;
    requires mysql.connector.java;
    //----------------
    requires java.naming;
    exports userpackage;
    exports userpackage.controller;

    opens userpackage.controller to javafx.fxml;

}