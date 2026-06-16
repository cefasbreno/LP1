package org.example.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.dao.PersonagemDAO;
import org.example.model.Personagem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Tela02Controller {

    @FXML private TextField txtFarmaceutico;
    @FXML private TextField txtAprendiz;
    @FXML private TextField txtCliente;

    @FXML private TableView<Personagem> tblView;
    @FXML private TableColumn<Personagem, Integer> colID;
    @FXML private TableColumn<Personagem, String> colFarmaceutico;
    @FXML private TableColumn<Personagem, String> colAprendiz;
    @FXML private TableColumn<Personagem, String> colCliente;

    private final PersonagemDAO personagemDAO = new PersonagemDAO();

    @FXML
    public void initialize() {

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFarmaceutico.setCellValueFactory(new PropertyValueFactory<>("farmaceutico"));
        colAprendiz.setCellValueFactory(new PropertyValueFactory<>("aprendiz"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        atualizarTabela();

        // Listener simples para preencher os campos editáveis ao clicar na tabela
        tblView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtFarmaceutico.setText(newVal.getFarmaceutico());
                txtAprendiz.setText(newVal.getAprendiz());
                txtCliente.setText(newVal.getCliente());
            }
        });
    }

    @FXML
    private void avancarParaHistoria(javafx.event.ActionEvent event) {
        try {
            // pega o objeto da linha selecionada na tabela
            Personagem selecionado = tblView.getSelectionModel().getSelectedItem();

            if (selecionado == null) {
                System.out.println("Selecione um personagem na tabela para continuar!");
                return;
            }

            // carrega a tela da história
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/historia.fxml"));
            Parent root = loader.load();

            HistoriaController controller = loader.getController();
            controller.configurarNomes(
                    selecionado.getCliente(),
                    selecionado.getFarmaceutico(),
                    selecionado.getAprendiz()
            );

            // trocar tela
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a tela de história.");
        }
    }

    private void atualizarTabela() {
        tblView.setItems(FXCollections.observableArrayList(personagemDAO.listarTodos()));
    }

    @FXML
    private void Atualizar() {
        Personagem selecionado = tblView.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            personagemDAO.salvarPersonagens(txtFarmaceutico.getText(), txtAprendiz.getText(), txtCliente.getText());
        } else {
            personagemDAO.atualizarPersonagem(selecionado.getId(), txtFarmaceutico.getText(), txtAprendiz.getText(), txtCliente.getText());
        }
        atualizarTabela();
        limparCampos();
    }

    @FXML
    private void Deletar() {
        Personagem selecionado = tblView.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            personagemDAO.deletarPersonagem(selecionado.getId());
            atualizarTabela();
            limparCampos();
        }
    }

    private void limparCampos() {
        txtFarmaceutico.clear();
        txtAprendiz.clear();
        txtCliente.clear();
    }
}