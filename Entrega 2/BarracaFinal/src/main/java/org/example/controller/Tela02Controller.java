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
import org.example.dao.PersonagensDAO;
import org.example.model.Personagens;

public class Tela02Controller {

    @FXML private TextField txtDona;
    @FXML private TextField txtAjudante1;
    @FXML private TextField txtAjudante2;
    @FXML private TableView<Personagens> tblView;
    @FXML private TableColumn<Personagens, Integer> colID;
    @FXML private TableColumn<Personagens, String> colDona;
    @FXML private TableColumn<Personagens, String> colAjudante1;
    @FXML private TableColumn<Personagens, String> colAjudante2;

    private final PersonagensDAO personagensDAO = new PersonagensDAO();

    @FXML
    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDona.setCellValueFactory(new PropertyValueFactory<>("dona"));
        colAjudante1.setCellValueFactory(new PropertyValueFactory<>("ajudante1"));
        colAjudante2.setCellValueFactory(new PropertyValueFactory<>("ajudante2"));

        atualizarTabela();

        tblView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtDona.setText(newVal.getDona());
                txtAjudante1.setText(newVal.getAjudante1());
                txtAjudante2.setText(newVal.getAjudante2());
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

            // Passa os novos nomes para a história
            controller.configurarNomes(selecionado.getDona(), selecionado.getAjudante1(), selecionado.getAjudante2());

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
            personagensDAO.salvarPersonagens(txtDona.getText(), txtAjudante1.getText(), txtAjudante2.getText());
        } else {
            personagensDAO.atualizarPersonagens(sel.getId(), txtDona.getText(), txtAjudante1.getText(), txtAjudante2.getText());
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
        txtDona.clear();
        txtAjudante1.clear();
        txtAjudante2.clear();
    }
}