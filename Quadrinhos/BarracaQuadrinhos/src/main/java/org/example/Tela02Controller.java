package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Tela02Controller {

    @FXML
    Button bt02;

    @FXML
    ImageView images;

    @FXML
    TextFlow textFlow;

    @FXML
    Text actualMessage;

    private int contador = 0;
    private Image actualImage;

    @FXML
    public void initialize() {
        actualImage = new Image(getClass().getResourceAsStream("/imagesBarraca/img1.png"));
        images.setImage(actualImage);
    }

    private String[] messages = {
        "Os funcionários chegam cedo à feira e começam a montar a barraca.",
        "Eles montam 3 mesas, uma de cada categoria: Grandes, Médias e Pequenas.",
        "Os funcionários separam as frutas e a distribuição ficou assim: Mesa 1: Melancia, jaca e melão. Mesa 2: Maracujá, abacaxi e abacate. Mesa 3: Laranja, limão e maçã.",
        "Houve um erro de cálculo e parece que vieram laranjas a mais!",
        "Realmente! vieram 36 laranjas a mais, e os funcionários ficam em dúvida...",
        "A chefe resolve a situação com a ideia de colocar algumas frutas na bancada de frutas maiores.",
        "As 36 laranjas excedentes são colocadas em 3 sacos.",
        "Parece que o peso a mais de 36 laranjas gerou uma fadiga excessiva na mesa de frutas grandes e ela cedeu...",
        "Que prejuízo! Todas as frutas da mesa grande caíram no chão!",
        "Os funcionários contornaram a situação vendendo as frutas no chão, mas o dinheiro extra ficou para o conserto da mesa."
    };

    @FXML
    public void ContarHistoria() {
        contador += 1;
        System.out.println(contador);

        if (contador == 1) {
            actualImage = new Image(String.valueOf(getClass().getResource("/imagesBarraca/img1.png")));
            images.setImage(actualImage);
        }

        if (contador == 2) {
            actualImage = new Image(String.valueOf(getClass().getResource("/imagesBarraca/img2.png")));
            images.setImage(actualImage);
        }

        if (contador == 7) {
            actualImage = new Image(String.valueOf(getClass().getResource("/imagesBarraca/img3.png")));
            images.setImage(actualImage);
        }

        if (contador == 9) {
            actualImage = new Image(String.valueOf(getClass().getResource("/imagesBarraca/img4.png")));
            images.setImage(actualImage);
        }

        if (contador == 10) {
            actualImage = new Image(String.valueOf(getClass().getResource("/imagesBarraca/img5.png")));
            images.setImage(actualImage);
        }

        actualMessage.setText(messages[contador]);

    }

}
