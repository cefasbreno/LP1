package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.dao.CenaDAO;
import org.example.model.Cena;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HistoriaController {

    @FXML private ImageView imgCena;
    @FXML private Label lblTexto;
    @FXML private Button btn010;
    @FXML private Button btn020;
    @FXML private Button btnContinuar;

    private CenaDAO cenaDAO = new CenaDAO();
    private int contador = 1;
    private String cenarioEscolhido = "normal";

    private String nomeDona = "";
    private String nomeAjudante1 = "";
    private String nomeAjudante2 = "";

    @FXML
    public void initialize() {
        btn010.setVisible(true);
        btn010.setText("Iniciar História");
        btn020.setVisible(false);
        btnContinuar.setVisible(false);

        // Ação inicial do botão
        btn010.setOnAction(e -> iniciarHistoria());
    }

    public void configurarNomes(String dona, String ajudante1, String ajudante2) {
        this.nomeDona = dona;
        this.nomeAjudante1 = ajudante1;
        this.nomeAjudante2 = ajudante2;
    }

    @FXML
    private EventHandler<ActionEvent> selecionarChuva() {
        btn010.setVisible(false);
        btn020.setVisible(false);
        btnContinuar.setVisible(true);
        this.cenarioEscolhido = "chuva";
        contador = 11;
        carregarCena();
        return null;
    }

    private void iniciarHistoria() {
        btn010.setVisible(false);
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
        Cena cena = cenaDAO.buscarCena(contador, cenarioEscolhido);

        if (cena != null) {
            String path = "/imagens/" + cena.getImagem();
            imgCena.setImage(new Image(getClass().getResourceAsStream(path)));

            String textoProcessado = cena.getTexto()
                    .replace("(nome_dona)", this.nomeDona)
                    .replace("(nome_ajudante1)", this.nomeAjudante1)
                    .replace("(nome_ajudante2)", this.nomeAjudante2);

            lblTexto.setText(textoProcessado);

            // LOGICA DE ESCOLHA
            if (contador == 1) {
                // Exemplo: No início, você decide o rumo da história
                btnContinuar.setVisible(false);
                btn010.setVisible(true);
                btn010.setText("Dia Normal");
                btn010.setOnAction(e -> avancarCena()); // Vai para cena 2

                btn020.setVisible(true);
                btn020.setText("Chuva");
                btn020.setOnAction(e -> selecionarChuva()); // Chama o método de chuva

            } else if (contador == 2) {
                // Decisão final
                btnContinuar.setVisible(false);
                btn010.setVisible(true);
                btn010.setText("Final Normal");
                btn020.setVisible(true);
                btn020.setText("Final Crianças");

                btn010.setOnAction(e -> saltarPara(3));
                btn020.setOnAction(e -> saltarPara(6));

            } else if (contador == 5 || contador == 10 || contador == 13) {
                btnContinuar.setVisible(false);
                btn010.setVisible(false);
                btn020.setVisible(false);
            } else {
                btnContinuar.setVisible(true);
                btn010.setVisible(false);
                btn020.setVisible(false);
                btnContinuar.setText("Continuar");
                btnContinuar.setOnAction(e -> avancarCena());
            }
        }
        System.out.println("contador");
    }
}