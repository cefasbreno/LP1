package org.example.controller;

import org.example.dao.CenaDAO;
import org.example.model.Cena;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HistoriaController {

    @FXML
    private ImageView imgCena;
    @FXML
    private Label lblTexto;
    @FXML
    private Button btn010;      // Usado como Opção 1
    @FXML
    private Button btn020;    // Usado como Opção 2
    @FXML
    private Button btnContinuar;

    // Usando o CenaDAO que atende à sua tabela 'barbearia'
    private CenaDAO cenaDAO = new CenaDAO();

    private int contador = 1;
    private String cenarioEscolhido = "normal"; // Cenário inicial da barbearia

    private String nomeCliente = "";
    private String nomeBarbeiro = "";

    @FXML
    public void initialize() {
        btn010.setVisible(true);
        btn010.setText("Iniciar História");
        btn020.setVisible(true);
        btnContinuar.setVisible(false);
    }

    public void configurarNomes(String cliente, String barbeiro, String ignorado) {
        this.nomeCliente = cliente;
        this.nomeBarbeiro = barbeiro;
    }

    @FXML
    private void selecionarDia() {
        btn010.setVisible(false);
        btn020.setVisible(false);
        btnContinuar.setVisible(true);
        carregarCena();
    }

    @FXML
    private void selecionarCopa() {
        btn010.setVisible(false);
        btn020.setVisible(false);
        btnContinuar.setVisible(true);
        this.cenarioEscolhido = "copa";
        contador = 10;
        carregarCena();
    }

    @FXML
    private void avancarCena() {
        contador++;
        carregarCena();
    }

    private void saltarPara(int novoContador) {
        this.contador = novoContador;
        carregarCena();
    }

    private void carregarCena() {
        // Como o cenário é sempre normal, esta busca será sempre consistente
        Cena cena = cenaDAO.buscarCena(contador, cenarioEscolhido);

        if (cena != null) {
            String path = "/imagens/" + cena.getImagem();
            imgCena.setImage(new Image(getClass().getResourceAsStream(path)));

            String textoProcessado = cena.getTexto()
                    .replace("(nome_cliente)", this.nomeCliente)
                    .replace("(nome_barbeiro)", this.nomeBarbeiro);

            lblTexto.setText(textoProcessado);

            // LOGICA DOS BOTÕES
            if (contador == 2) {
                // Configuração dos botões de escolha
                btnContinuar.setVisible(false);
                btn010.setVisible(true);
                btn010.setText("Final feliz");
                btn020.setVisible(true);
                btn020.setText("Final triste");

                // Ação: Pular para o ID do final correspondente (ex: 3 e 10)
                btn010.setOnAction(e -> saltarPara(3));
                btn020.setOnAction(e -> saltarPara(7));

            } else if (contador == 6 || contador == 9 || contador == 13) {
                // Finais
                btnContinuar.setVisible(false);
                btn010.setVisible(false);
                btn020.setVisible(false);
            } else {
                // Fluxo normal: mostra apenas o botão Continuar
                btnContinuar.setVisible(true);
                btn010.setVisible(false);
                btn020.setVisible(false);
                btnContinuar.setText("Continuar");
                btnContinuar.setOnAction(e -> avancarCena());
            }
        } else {
            lblTexto.setText("Fim da história!");
            btnContinuar.setVisible(false);
            btn010.setVisible(false);
            btn020.setVisible(false);
        }

        System.out.println("Contador atual: " + contador);
    }
}