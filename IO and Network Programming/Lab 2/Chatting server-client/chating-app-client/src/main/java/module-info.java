module com.example.chatingappclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatingappclient to javafx.fxml;
    exports com.example.chatingappclient;
}