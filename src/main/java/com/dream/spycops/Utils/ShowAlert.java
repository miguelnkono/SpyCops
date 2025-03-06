package com.dream.spycops.Utils;

import javafx.scene.control.Alert;

public class ShowAlert {
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for the user to close it
    }
}
