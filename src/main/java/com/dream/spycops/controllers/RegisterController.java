package com.dream.spycops.controllers;

import com.dream.spycops.dbUtils.DbUtils;
import com.dream.spycops.models.Cop;
import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.dream.spycops.Utils.ShowAlert.showAlert;

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
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            System.out.println("need to fill all the fields to ");
            showAlert(Alert.AlertType.WARNING, "Incomplete Form", "Please fill all the fields before submitting.");
        } else {
            Cop cop = new Cop(firstName.getText(), lastName.getText(),
                    email.getText(), password.getText());
            DbUtils.registerCops(cop);
            ViewSwitcher.switcherTo(View.HOME);
        }

    }
}
