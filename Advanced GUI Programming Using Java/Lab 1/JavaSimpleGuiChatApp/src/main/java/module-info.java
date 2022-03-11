module com.example.javasimpleguichatapp {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.javasimpleguichatapp to javafx.fxml;
    exports com.example.javasimpleguichatapp;
}