package org.example.controller;

import org.example.dao.CenaDAO;
import org.example.model.Cena;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class HistoriaController {

    @FXML
    private ImageView imgCena;
    @FXML
    private Label lblTexto;
    @FXML
    private HBox hBox;

    @FXML
    private Button btnDia;
    @FXML
    private Button btnNoite;
    @FXML
    private Button btnContinuar;

    private CenaDAO cenaDAO = new CenaDAO();

    private int contador = 1;
    private String cenarioEscolhido;

    private String nomeCliente = "Cliente";
    private String nomeFarmaceutico = "Farmacêutico";
    private String nomeAprendiz = "Aprendiz";

    @FXML
    public void initialize() {
        btnDia.setVisible(true);
        btnNoite.setVisible(true);
        btnContinuar.setVisible(false);
        btnContinuar.setManaged(false);
    }

    @FXML
    private void selecionarDia() {
        iniciarHistoria("dia");
    }

    private void iniciarHistoria(String cenario) {
        this.cenarioEscolhido = cenario;
        btnDia.setVisible(false);
        btnDia.setManaged(false);
        btnNoite.setVisible(false);
        btnNoite.setManaged(false);
        btnContinuar.setVisible(true);
        btnContinuar.setManaged(true);
        carregarCena();
    }

    @FXML
    private void selecionarNoite() {
        iniciarHistoriaNoite("noite");
    }

    private void iniciarHistoriaNoite(String cenario) {
        this.cenarioEscolhido = cenario;
        btnDia.setVisible(false);
        btnDia.setManaged(false);
        btnNoite.setVisible(false);
        btnNoite.setManaged(false);
        btnContinuar.setVisible(true);
        btnContinuar.setManaged(true);
        contador = 18;
        carregarCena();
    }

    @FXML
    private void avancarCena() {
        contador++;
        carregarCena();
    }


    public void configurarNomes(String cliente, String farmaceutico, String aprendiz) {
        this.nomeCliente = cliente;
        this.nomeFarmaceutico = farmaceutico;
        this.nomeAprendiz = aprendiz;
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
                    .replace("(nome_cliente)", this.nomeCliente)
                    .replace("(nome_farmaceutico)", this.nomeFarmaceutico)
                    .replace("(nome_aprendiz)", this.nomeAprendiz);

            lblTexto.setText(textoProcessado);

            // controladores dos finais alternativos
            if (contador == 2) {
                btnContinuar.setVisible(false);
                btnDia.setVisible(true); btnDia.setText("Continuar");
                btnNoite.setVisible(true); btnNoite.setText("Moedas");
                btnDia.setOnAction(e -> avancarCena());
                btnNoite.setOnAction(e -> saltarPara(11));

            } else if (contador == 5) {
                btnContinuar.setVisible(false);
                btnDia.setVisible(true); btnDia.setText("Aceitar Ajuda");
                btnNoite.setVisible(true); btnNoite.setText("Recusar");
                btnDia.setOnAction(e -> avancarCena());
                btnNoite.setOnAction(e -> saltarPara(7));

            } else if (contador == 6 || contador == 10 || contador == 17 || contador == 21) {
                // fim de história
                btnContinuar.setVisible(false);
                btnDia.setVisible(false);
                btnNoite.setVisible(false);

            } else {
                btnContinuar.setVisible(true);
                btnDia.setVisible(false);
                btnNoite.setVisible(false);
                btnContinuar.setText("Continuar");
                btnContinuar.setOnAction(e -> avancarCena());
            }
        } else {
            lblTexto.setText("Fim da história!");
            btnContinuar.setVisible(false);
            btnDia.setVisible(false);
            btnNoite.setVisible(false);
        }

        // mantem continuidade mudando o cenario para noite
        if (contador == 14) {
            cenarioEscolhido = "noite";
        }
        System.out.println("Contador atual: " + contador);
    }


}
