package com.dream.spycops.controllers;

import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    public TextField email;
    @FXML
    public TextField lastName;
    @FXML
    public TextField firstName;
    @FXML
    public PasswordField password;

    @FXML
    public void cancel(ActionEvent event) {
        ViewSwitcher.switcherTo(View.MAIN); // may update this in the future
        // to first provide a pop-pop to the user asking if he wants to exist
        // or go back to the main page.
    }

    @FXML
    public void validate(ActionEvent event) {
        ViewSwitcher.switcherTo(View.HOME);
    }
}
