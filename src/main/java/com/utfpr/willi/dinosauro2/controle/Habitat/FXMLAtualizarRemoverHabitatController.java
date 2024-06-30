package com.utfpr.willi.dinosauro2.controle.Habitat;

import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLAtualizarRemoverHabitatController implements Initializable {

    @FXML
    public TableView<TbHabitat> TableVAtualizaHabitat;
    @FXML
    public TableColumn<TbHabitat, Long> ClomumIdAtualizaHabitat;
    @FXML
    public TableColumn<TbHabitat, String> ClomumNomeAtualizaHabitat;
    @FXML
    public TextField TextFIdAtualizaHabitat;
    @FXML
    public TextField TextFNomeAtualizaHabitat;
    @FXML
    public TextField TextFGeologiaAtualizaHabitat;
    @FXML
    public TextField TextFLocAproxAtualizaHabitat;
    @FXML
    public TextField TextFTemMediaAtualizaHabitat;
    @FXML
    public Button ButtonAtualizarHabitat;
    @FXML
    public Button ButtonRemoverHabitat;

    private List<TbHabitat> tbHabitatList;
    private ObservableList<TbHabitat> observableListTbHabitat;
    private TbHabitatDao tbHabitatDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbHabitatDao = new TbHabitatDaoImpl();
        this.carregarTabela();

        TableVAtualizaHabitat.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemAtualizaTbHabitat(newValue));
    }

    public void carregarTabela() {

        ClomumIdAtualizaHabitat.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClomumNomeAtualizaHabitat.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbHabitatList = tbHabitatDao.listarTodos();

        observableListTbHabitat = FXCollections.observableArrayList(tbHabitatList);
        TableVAtualizaHabitat.setItems(observableListTbHabitat);

    }

    private void selecionarItemAtualizaTbHabitat(TbHabitat habitat) {
        if (habitat != null) {
            TextFIdAtualizaHabitat.setText(String.valueOf(habitat.getId()));
            TextFNomeAtualizaHabitat.setText(habitat.getNome());
            TextFGeologiaAtualizaHabitat.setText(habitat.getGeologia());
            TextFLocAproxAtualizaHabitat.setText(habitat.getLocalizacao_aproximada());
            TextFTemMediaAtualizaHabitat.setText(String.valueOf(habitat.getTemperatura_media()));

        }else {
            TextFIdAtualizaHabitat.setText("");
            TextFNomeAtualizaHabitat.setText("");
            TextFGeologiaAtualizaHabitat.setText("");
            TextFLocAproxAtualizaHabitat.setText("");
            TextFTemMediaAtualizaHabitat.setText("");
        }

    }

    public void handleAtualiza(ActionEvent actionEvent) {
        TbHabitat tbEspecie = TableVAtualizaHabitat.getSelectionModel().getSelectedItem();
        if (tbEspecie != null) {
            if (TextFIdAtualizaHabitat.getText().isEmpty() || TextFNomeAtualizaHabitat.getText().isEmpty() || TextFGeologiaAtualizaHabitat.getText().isEmpty() || TextFLocAproxAtualizaHabitat.getText().isEmpty() || TextFTemMediaAtualizaHabitat.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vazios");
                alert.setHeaderText(null);
                alert.setContentText("Insira todos os campos");

                alert.showAndWait();
            }else {
                tbEspecie.setNome(TextFNomeAtualizaHabitat.getText());
                tbEspecie.setGeologia(TextFGeologiaAtualizaHabitat.getText());
                tbEspecie.setLocalizacao_aproximada(TextFLocAproxAtualizaHabitat.getText());
                tbEspecie.setTemperatura_media(Double.parseDouble(TextFTemMediaAtualizaHabitat.getText()));

                tbHabitatDao.atualizar(tbEspecie);
                carregarTabela();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selecione um item");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um item para atualizar.");

            alert.showAndWait();
        }

    }

    public void handleRemove(ActionEvent actionEvent) {
        TbHabitat tbEspecie = TableVAtualizaHabitat.getSelectionModel().getSelectedItem();
        if (tbEspecie != null) {
            tbHabitatDao.excluir(tbEspecie);
            carregarTabela();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selecione um item");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um item para remover.");

            alert.showAndWait();
        }
    }

}
