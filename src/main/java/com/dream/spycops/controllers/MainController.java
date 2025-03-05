package com.dream.spycops.controllers;

import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        ViewSwitcher.switcherTo(View.MAIN);
    }
}