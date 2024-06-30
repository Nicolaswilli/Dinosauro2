package com.utfpr.willi.dinosauro2.controle.Especie;

import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
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

public class FXMLAtualizarRemoverEspecieController implements Initializable {

    @FXML
    public TableView<TbEspecie> TableVAtualizaEspecie;
    @FXML
    public TableColumn<TbEspecie, Long> ClomumIdAtualizaEspecie;
    @FXML
    public TableColumn<TbEspecie, String> ClomumNomeAtualizaEspecie;
    @FXML
    public TextField TextFIdAtualizaEspecie;
    @FXML
    public TextField TextFNomeAtualizaEspecie;
    @FXML
    public TextField TextFAlimenAtualizaEspecie;
    @FXML
    public TextField TextFDataAtualizaEspecie;
    @FXML
    public TextField TextFPesoAtualizaEspecie;
    @FXML
    public TextField TextFTamAtualizaEspecie;
    @FXML
    public CheckBox CheckBoxEsqueletoCompleto;
    @FXML
    public Button ButtonAtualizarEspecie;
    @FXML
    public Button ButtonRemoverEspecie;


    private List<TbEspecie> tbEspecieList;
    private ObservableList<TbEspecie> observableListTbEspecie;
    private TbEspecieDao tbEspecieDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbEspecieDao = new TbEspecieDaoImpl();
        this.carregarTabela();

        TableVAtualizaEspecie.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemAtualizaTbEspecie(newValue));
    }

    public void carregarTabela() {

        ClomumIdAtualizaEspecie.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClomumNomeAtualizaEspecie.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbEspecieList = tbEspecieDao.listarTodos();

        observableListTbEspecie = FXCollections.observableArrayList(tbEspecieList);
        TableVAtualizaEspecie.setItems(observableListTbEspecie);

    }

    private void selecionarItemAtualizaTbEspecie(TbEspecie especie) {
        if (especie != null) {
            TextFIdAtualizaEspecie.setText(String.valueOf(especie.getId()));
            TextFNomeAtualizaEspecie.setText(especie.getNome());
            TextFAlimenAtualizaEspecie.setText(especie.getAlimentacao());
            TextFDataAtualizaEspecie.setText(String.valueOf(especie.getData_descoberta()));
            TextFPesoAtualizaEspecie.setText(String.valueOf(especie.getPeso_medio()));
            TextFTamAtualizaEspecie.setText(String.valueOf(especie.getTamanho_medio()));
            CheckBoxEsqueletoCompleto.setSelected(especie.getEsqueleto_completo());
        }else {
            TextFIdAtualizaEspecie.setText("");
            TextFNomeAtualizaEspecie.setText("");
            TextFAlimenAtualizaEspecie.setText("");
            TextFDataAtualizaEspecie.setText("");
            TextFPesoAtualizaEspecie.setText("");
            TextFTamAtualizaEspecie.setText("");
            CheckBoxEsqueletoCompleto.setSelected(false);
        }

    }

    public void handleAtualiza(ActionEvent actionEvent) {
        TbEspecie tbEspecie = TableVAtualizaEspecie.getSelectionModel().getSelectedItem();
        if (tbEspecie != null) {
            if (TextFNomeAtualizaEspecie.getText().isEmpty() || TextFDataAtualizaEspecie.getText().isEmpty() || TextFAlimenAtualizaEspecie.getText().isEmpty() || TextFTamAtualizaEspecie.getText().isEmpty() || TextFPesoAtualizaEspecie.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vazios");
                alert.setHeaderText(null);
                alert.setContentText("Insira todos os campos");

                alert.showAndWait();
            }else {
                tbEspecie.setNome(TextFNomeAtualizaEspecie.getText());
                tbEspecie.setAlimentacao(TextFAlimenAtualizaEspecie.getText());
                tbEspecie.setData_descoberta(TextFDataAtualizaEspecie.getText());
                tbEspecie.setPeso_medio(Double.parseDouble(TextFPesoAtualizaEspecie.getText()));
                tbEspecie.setTamanho_medio(Double.parseDouble(TextFTamAtualizaEspecie.getText()));
                if (CheckBoxEsqueletoCompleto.isSelected()) {
                    tbEspecie.setEsqueleto_completo(true);
                } else {
                    tbEspecie.setEsqueleto_completo(false);
                }

                tbEspecieDao.atualizar(tbEspecie);
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
        TbEspecie tbEspecie = TableVAtualizaEspecie.getSelectionModel().getSelectedItem();
        if (tbEspecie != null) {
            tbEspecieDao.excluir(tbEspecie);
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
