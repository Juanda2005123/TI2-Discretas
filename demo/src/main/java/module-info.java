module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ui to javafx.fxml;
    exports com.example.ui;
    exports com.example.control;
    opens com.example.control to javafx.fxml;
    exports com.example.control.screen;
    opens com.example.control.screen to javafx.fxml;
    exports com.example.control.part;
    opens com.example.control.part to javafx.fxml;
}