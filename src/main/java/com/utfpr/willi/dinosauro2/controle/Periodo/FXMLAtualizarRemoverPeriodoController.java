package com.utfpr.willi.dinosauro2.controle.Periodo;

import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
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

public class FXMLAtualizarRemoverPeriodoController implements Initializable {

    @FXML
    public TableView<TbPeriodo> TableVAtualizaPeriodo;
    @FXML
    public TableColumn<TbPeriodo, Long> ClomumIdAtualizaPeriodo;
    @FXML
    public TableColumn<TbPeriodo, String> ClomumNomeAtualizaPeriodo;
    @FXML
    public TextField TextFEventFinalAtualizaPeriodo;
    @FXML
    public TextField TextFFimAtualizaPeriodo;
    @FXML
    public TextField TextFInicioAtualizaPeriodo;
    @FXML
    public TextField TextFNomeAtualizaPeriodo;
    @FXML
    public TextField TextFIdAtualizaPeriodo;
    @FXML
    public Button ButtonRemoverPeriodo;
    @FXML
    public Button ButtonAtualizarPeriodo;

    private List<TbPeriodo> tbPeriodoList;
    private ObservableList<TbPeriodo> observableListTbPeriodo;
    private TbPeriodoDao tbPeridoDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbPeridoDao = new TbPeriodoDaoImpl();
        this.carregarTabela();

        TableVAtualizaPeriodo.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemAtualizaTbPeriodo(newValue));
    }

    public void carregarTabela() {

        ClomumIdAtualizaPeriodo.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClomumNomeAtualizaPeriodo.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbPeriodoList = tbPeridoDao.listarTodos();

        observableListTbPeriodo = FXCollections.observableArrayList(tbPeriodoList);
        TableVAtualizaPeriodo.setItems(observableListTbPeriodo);

    }

    private void selecionarItemAtualizaTbPeriodo(TbPeriodo periodo) {
        if (periodo != null) {
            TextFIdAtualizaPeriodo.setText(String.valueOf(periodo.getId()));
            TextFNomeAtualizaPeriodo.setText(periodo.getNome());
            TextFInicioAtualizaPeriodo.setText(String.valueOf(periodo.getInicio()));
            TextFFimAtualizaPeriodo.setText(String.valueOf(periodo.getFim()));
            TextFEventFinalAtualizaPeriodo.setText(periodo.getEvento_final());

        }else {
            TextFIdAtualizaPeriodo.setText("");
            TextFNomeAtualizaPeriodo.setText("");
            TextFInicioAtualizaPeriodo.setText("");
            TextFFimAtualizaPeriodo.setText("");
            TextFEventFinalAtualizaPeriodo.setText("");
        }

    }

    public void handleAtualiza(ActionEvent actionEvent) {
        TbPeriodo tbPeriodo = TableVAtualizaPeriodo.getSelectionModel().getSelectedItem();
        if (tbPeriodo != null) {
            if (TextFNomeAtualizaPeriodo.getText().isEmpty() || TextFInicioAtualizaPeriodo.getText().isEmpty() || TextFFimAtualizaPeriodo.getText().isEmpty() || TextFEventFinalAtualizaPeriodo.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vazios");
                alert.setHeaderText(null);
                alert.setContentText("Insira todos os campos");

                alert.showAndWait();
            }else {
                tbPeriodo.setNome(TextFNomeAtualizaPeriodo.getText());
                tbPeriodo.setInicio(Integer.parseInt(TextFInicioAtualizaPeriodo.getText()));
                tbPeriodo.setFim(Integer.parseInt(TextFFimAtualizaPeriodo.getText()));
                tbPeriodo.setEvento_final(TextFEventFinalAtualizaPeriodo.getText());

                tbPeridoDao.atualizar(tbPeriodo);
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
        TbPeriodo tbPeriodo = TableVAtualizaPeriodo.getSelectionModel().getSelectedItem();
        if (tbPeriodo != null) {
            tbPeridoDao.excluir(tbPeriodo);
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
