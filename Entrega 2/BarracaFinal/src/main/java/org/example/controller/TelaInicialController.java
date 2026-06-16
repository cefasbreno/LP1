package org.example.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import org.example.App;

public class TelaInicialController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("tela02");
    }
}
