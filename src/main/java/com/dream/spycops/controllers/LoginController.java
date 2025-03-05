package com.dream.spycops.controllers;

import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    public TextField name;
    @FXML
    public PasswordField password;

    @FXML
    public void login(ActionEvent event) {
        ViewSwitcher.switcherTo(View.HOME);
    }

    @FXML
    public void signup(ActionEvent event) {
        ViewSwitcher.switcherTo(View.REGISTER);
    }
}
