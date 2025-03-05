module com.dream.spycops {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dream.spycops to javafx.fxml;
    exports com.dream.spycops;
    exports com.dream.spycops.controllers;
    opens com.dream.spycops.controllers to javafx.fxml;
}