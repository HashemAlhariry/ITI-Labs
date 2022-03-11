module com.example.urlurlconnectionwebview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.urlurlconnectionwebview to javafx.fxml;
    exports com.example.urlurlconnectionwebview;
}