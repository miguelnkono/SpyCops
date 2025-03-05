package com.dream.spycops.controllers;

import com.dream.spycops.routes.View;
import com.dream.spycops.routes.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConnectionPage {

    @FXML
    public Button btn_connecter;
    @FXML
    public Button btn_enregistrer;

    @FXML
    public void enregistrement(ActionEvent event) {
        ViewSwitcher.switcherTo(View.REGISTER);
    }

    @FXML
    public void connexion(ActionEvent event) {
        ViewSwitcher.switcherTo(View.LOGIN);
    }
}
