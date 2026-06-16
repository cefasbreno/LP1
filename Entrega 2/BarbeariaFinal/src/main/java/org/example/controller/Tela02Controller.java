package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.controller.HistoriaController;
import org.example.dao.PersonagensDAO;
import org.example.model.Personagens; // Importação correta

public class Tela02Controller {

    @FXML private TextField txtBarbeiro;
    @FXML private TextField txtCliente;
    @FXML private TableView<Personagens> tblView;
    @FXML private TableColumn<Personagens, Integer> colID;
    @FXML private TableColumn<Personagens, String> colBarbeiro;
    @FXML private TableColumn<Personagens, String> colCliente;

    private final PersonagensDAO personagensDAO = new PersonagensDAO();

    @FXML
    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBarbeiro.setCellValueFactory(new PropertyValueFactory<>("barbeiro"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        atualizarTabela();

        tblView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtBarbeiro.setText(newVal.getBarbeiro());
                txtCliente.setText(newVal.getCliente());
            }
        });
    }

    @FXML
    private void avancarParaHistoria(ActionEvent event) {
        try {
            Personagens selecionado = tblView.getSelectionModel().getSelectedItem();
            if (selecionado == null) return;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/historia.fxml"));
            Parent root = loader.load();
            HistoriaController controller = loader.getController();

            // Passa para a história: Cliente, Barbeiro, null (para aprendiz)
            controller.configurarNomes(selecionado.getCliente(), selecionado.getBarbeiro(), "");

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Atualizar() {
        Personagens sel = tblView.getSelectionModel().getSelectedItem();
        if (sel == null) {
            personagensDAO.salvarPersonagens(txtBarbeiro.getText(), txtCliente.getText());
        } else {
            personagensDAO.atualizarPersonagens(sel.getId(), txtBarbeiro.getText(), txtCliente.getText());
        }
        atualizarTabela();
        limparCampos();
    }

    @FXML
    private void Deletar() {
        Personagens sel = tblView.getSelectionModel().getSelectedItem();
        if (sel != null) {
            personagensDAO.deletarPersonagens(sel.getId());
            atualizarTabela();
            limparCampos();
        }
    }

    private void atualizarTabela() {
        tblView.setItems(FXCollections.observableArrayList(personagensDAO.listarTodos()));
    }

    private void limparCampos() {
        txtBarbeiro.clear();
        txtCliente.clear();
    }
}