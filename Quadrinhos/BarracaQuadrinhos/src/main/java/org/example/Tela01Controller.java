package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Tela01Controller {

    @FXML
    public void switchToTela02() throws IOException {
        App.setRoot("tela02");
    }
}
