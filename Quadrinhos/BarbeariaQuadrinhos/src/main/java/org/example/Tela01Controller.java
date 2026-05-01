package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Tela01Controller {

    @FXML
    private Button bt01;

    @FXML
    private void switchToTela02() throws IOException {
        App.setRoot("tela02");
    }
}
