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
    private Button bt02;

    @FXML
    private ImageView images;

    @FXML
    private Text text;

    @FXML
    private TextFlow textFlow;

    private int contador = 0;
    private Image actualImage;

    @FXML
    public void initialize() {
        actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img1.png"));
        images.setImage(actualImage);
    }

    private String[] messages = {
        "O cliente Bruno está fazendo o cadastro na plataforma.",
        "Na plataforma, ele seleciona o nível de barbeiro desejado, escolhe seu tipo de corte e especifica preferências.",
        "O cliente agora está selecionando um horário para cortar o cabelo...",
        "Feito! Ele escolhe cortar o cabelo às 14:00 da tarde com o barbeiro Roberval.",
        "O barbeiro atende à notificação e confirma o agendamento.",
        "Roberval recebe o cliente no horário combinado e prepara-se para cortar o cabelo.",
        "O cliente Bruno pede o corte no estilo de tranças nagô, justamente a especialidade do barbeiro.",
        "Roberval é tão experiente nesse corte que é sempre recomendado pela plataforma.",
        "O barbeiro começa a cortar o cabelo e termina o serviço às 16:00.",
        "Bruno analisa o resultado final e aprova, partindo para o pagamento.",
        "Roberval recebe o pagamento no caixa.",
        "O cliente ficou tão satisfeito com o corte que avaliou o barbeiro em 5 estrelas na plataforma.",
    };

    @FXML
    public void ContarHistoria() {
        contador++;
        System.out.println(contador);

        if (contador == 4) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img2.png"));
            images.setImage(actualImage);
        }

        if (contador == 5) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img3.png"));
            images.setImage(actualImage);
        }

        if (contador == 6) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img4.png"));
            images.setImage(actualImage);
        }

        if (contador == 7) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img5.png"));
            images.setImage(actualImage);
        }

        if (contador == 9) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img6.png"));
            images.setImage(actualImage);
        }

        if (contador == 11) {
            actualImage = new Image(getClass().getResourceAsStream("/imagesBarbearia/img7.png"));
            images.setImage(actualImage);
        }

        text.setText(messages[contador]);

    }

}
