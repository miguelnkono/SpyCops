package com.dream.spycops.controllers;

import com.dream.spycops.dbUtils.DbUtils;
import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.dream.spycops.Utils.ShowAlert.showAlert;

public class LoginController {

    @FXML
    public TextField name;
    @FXML
    public PasswordField password;

    @FXML
    public void login(ActionEvent event) {
        if (!name.getText().isEmpty() || !password.getText().isEmpty()) {
            if (DbUtils.loginCop(name.getText(), password.getText())) {
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome back!");
                ViewSwitcher.switcherTo(View.HOME);
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password. Please try again.");
        }
    }

    @FXML
    public void signup(ActionEvent event) {
        ViewSwitcher.switcherTo(View.REGISTER);
    }
}
