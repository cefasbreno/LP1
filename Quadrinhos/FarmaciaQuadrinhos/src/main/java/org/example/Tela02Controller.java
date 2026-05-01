package org.example;

import javafx.scene.control.Button;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Tela02Controller {

    @FXML
    ImageView images;

    @FXML
    Button bt02;

    @FXML
    TextFlow textFlow;

    @FXML
    Text text;

    private int contador = 0;
    private Image actualImage;

    @FXML
    public void initialize() {
        actualImage = new Image(getClass().getResourceAsStream("/images/img1.png"));
        images.setImage(actualImage);
    }

    private String[] messages = {
            "Uma cliente entrou na loja. Ela chama um funcionário.",
            "O gerente operacional Jooj da Silva está atendendo a cliente...",
            "Ele efetuou uma venda!",
            "O funcionário de registro 1 está passando os produtos no caixa...",
            "A venda foi de 20 unidades de dipirona com valor de 3.0R$, totalizando 60.0R$",
            "O gerente operacional coloca os produtos na sacola e entrega a cliente.",
            "A não! A sacola estava furada e os 20 dipironas caem no chão!",
            "A aprendiz vê a situação e rapidamente ajuda Jooj da Silva a pegar os produtos!",
            "A cliente fica encantada com a agilidade da aprendiz e a parabeniza pela boa ação.",
            "Jooj da Silva está anotando a venda que acabou de fazer no quadro de vendas...",
            "Mais um ponto para o registro 1, certamente ganhará o prêmio ao final do mês!"
    };

    @FXML
    public void ContarHistoria() {
        contador++;
        System.out.println(contador);

        if (contador == 1) {
            actualImage = new Image(getClass().getResourceAsStream("/images/img2.png"));
            images.setImage(actualImage);
        }

        if (contador == 5) {
            actualImage = new Image(getClass().getResourceAsStream("/images/img3.png"));
            images.setImage(actualImage);
        }

        if (contador == 7) {
            actualImage = new Image(getClass().getResourceAsStream("/images/img4.png"));
            images.setImage(actualImage);
        }

        if (contador == 8) {
            actualImage = new Image(getClass().getResourceAsStream("/images/img5.png"));
            images.setImage(actualImage);
        }

        if (contador == 9) {
            actualImage = new Image(getClass().getResourceAsStream("/images/img6.png"));
            images.setImage(actualImage);
        }

        text.setText(messages[contador]);

    }
}