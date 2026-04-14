package org.example;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;

public class TertiaryController {

    @FXML
    private Text texto;

    private int passoAtual = 0;

    // A lista com as frases da sua história baseada no console
    private final String[] mensagens = {
            "Um cliente entrou na loja. Ele chama um funcionário.",
            "O gerente operacional Jooj da Silva está atendendo o cliente...",
            "Ele efetuou uma venda!",
            "O funcionário de registro 1 está passando os produtos no caixa...",
            "A venda foi de 20 unidades de dipirona com valor de 3.0R$, totalizando 60.0R$",
            "O gerente operacional coloca os produtos na sacola e entrega ao cliente.",
            "A não! A sacola estava furada e os 20 dipironas caem no chão!",
            "O aprendiz vê a situação e rapidamente ajuda Jooj da Silva a pegar os produtos!",
            "O cliente fica encantado com a agilidade do aprendiz e o parabeniza pela boa ação.",
            "Jooj da Silva está anotando a venda que acabou de fazer no quadro de vendas...",
            "Mais um ponto para o registro 1, certamente ganhará o prêmio ao final do mês!"
    };

    @FXML
    private void btnContinuarHistoria() throws IOException {
        if (passoAtual < mensagens.length) {
            // Atualiza o texto da tela com a mensagem atual
            texto.setText(mensagens[passoAtual]);
            passoAtual++;
        }
    }
}