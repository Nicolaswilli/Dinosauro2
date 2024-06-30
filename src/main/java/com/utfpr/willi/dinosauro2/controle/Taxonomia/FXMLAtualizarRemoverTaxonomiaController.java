package com.utfpr.willi.dinosauro2.controle.Taxonomia;

import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
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

public class FXMLAtualizarRemoverTaxonomiaController implements Initializable {

    @FXML
    public TableView<TbTaxonomia> TableVAtualizaTaxonomia;
    @FXML
    public TableColumn<TbTaxonomia, Long> ClomumIdAtualizaTaxonomia;
    @FXML
    public TableColumn<TbTaxonomia, String> ClomumNomeAtualizaTaxonomia;
    @FXML
    public TextField TextFNomeAtualizaTaxonomia;
    @FXML
    public TextField TextFIdAtualizaTaxonomia;
    @FXML
    public Button ButtonRemoverTaxonomia;
    @FXML
    public Button ButtonAtualizarTaxonomia;


    private List<TbTaxonomia> tbTaxonomiaList;
    private ObservableList<TbTaxonomia> observableListTbTaxonomia;
    private TbTaxonomiaDao tbTaxonomiaDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbTaxonomiaDao = new TbTaxonomiaDaoImpl();
        this.carregarTabela();

        TableVAtualizaTaxonomia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemAtualizaTbTaxonomia(newValue));
    }

    public void carregarTabela() {

        ClomumIdAtualizaTaxonomia.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClomumNomeAtualizaTaxonomia.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbTaxonomiaList = tbTaxonomiaDao.listarTodos();

        observableListTbTaxonomia = FXCollections.observableArrayList(tbTaxonomiaList);
        TableVAtualizaTaxonomia.setItems(observableListTbTaxonomia);

    }

    private void selecionarItemAtualizaTbTaxonomia(TbTaxonomia especie) {
        if (especie != null) {
            TextFIdAtualizaTaxonomia.setText(String.valueOf(especie.getId()));
            TextFNomeAtualizaTaxonomia.setText(especie.getNome());
        }else {
            TextFIdAtualizaTaxonomia.setText("");
            TextFNomeAtualizaTaxonomia.setText("");
        }

    }

    public void handleAtualiza(ActionEvent actionEvent) {
        TbTaxonomia tbTaxonomia = TableVAtualizaTaxonomia.getSelectionModel().getSelectedItem();
        if (tbTaxonomia != null) {
            if (TextFNomeAtualizaTaxonomia.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vazios");
                alert.setHeaderText(null);
                alert.setContentText("Insira todos os campos");

                alert.showAndWait();
            }else {
                tbTaxonomia.setNome(TextFNomeAtualizaTaxonomia.getText());

                tbTaxonomiaDao.atualizar(tbTaxonomia);
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
        TbTaxonomia tbTaxonomia = TableVAtualizaTaxonomia.getSelectionModel().getSelectedItem();
        if (tbTaxonomia != null) {
            tbTaxonomiaDao.excluir(tbTaxonomia);
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
