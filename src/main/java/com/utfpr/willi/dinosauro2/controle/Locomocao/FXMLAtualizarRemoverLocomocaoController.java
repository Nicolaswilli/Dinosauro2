package com.utfpr.willi.dinosauro2.controle.Locomocao;

import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
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

public class FXMLAtualizarRemoverLocomocaoController implements Initializable {

    @FXML
    public TableView<TbLocomocao> TableVAtualizaLocomocao;
    @FXML
    public TableColumn<TbLocomocao, Long> ClomumIdAtualizaLocomocao;
    @FXML
    public TableColumn<TbLocomocao, String> ClomumNomeAtualizaLocomocao;
    @FXML
    public TextField TextFIdAtualizaLocomocao;
    @FXML
    public TextField TextFNomeAtualizaLocomocao;
    @FXML
    public TextField TextFPosturaAtualizaLocomocao;
    @FXML
    public Button ButtonRemoverLocomocao;
    @FXML
    public Button ButtonAtualizarLocomocao;

    private List<TbLocomocao> tbLocomocaoList;
    private ObservableList<TbLocomocao> observableListTbLocomocao;
    private TbLocomocaoDao tbLocomocaoDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbLocomocaoDao = new TbLocomocaoDaoImpl();
        this.carregarTabela();

        TableVAtualizaLocomocao.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemAtualizaTbLocomocao(newValue));
    }

    public void carregarTabela() {

        ClomumIdAtualizaLocomocao.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClomumNomeAtualizaLocomocao.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbLocomocaoList = tbLocomocaoDao.listarTodos();

        observableListTbLocomocao = FXCollections.observableArrayList(tbLocomocaoList);
        TableVAtualizaLocomocao.setItems(observableListTbLocomocao);

    }

    private void selecionarItemAtualizaTbLocomocao(TbLocomocao locomocao) {
        if (locomocao != null) {
            TextFIdAtualizaLocomocao.setText(String.valueOf(locomocao.getId()));
            TextFNomeAtualizaLocomocao.setText(locomocao.getNome());
            TextFPosturaAtualizaLocomocao.setText(locomocao.getPostura());


        }else {
            TextFIdAtualizaLocomocao.setText("");
            TextFNomeAtualizaLocomocao.setText("");
            TextFPosturaAtualizaLocomocao.setText("");
        }

    }

    public void handleAtualiza(ActionEvent actionEvent) {
        TbLocomocao tbLocomocao = TableVAtualizaLocomocao.getSelectionModel().getSelectedItem();
        if (tbLocomocao != null) {
            if (TextFNomeAtualizaLocomocao.getText().isEmpty() || TextFPosturaAtualizaLocomocao.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vazios");
                alert.setHeaderText(null);
                alert.setContentText("Insira todos os campos");

                alert.showAndWait();
            }else {
                tbLocomocao.setNome(TextFNomeAtualizaLocomocao.getText());
                tbLocomocao.setPostura(TextFPosturaAtualizaLocomocao.getText());

                tbLocomocaoDao.atualizar(tbLocomocao);
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
        TbLocomocao tbLocomocao = TableVAtualizaLocomocao.getSelectionModel().getSelectedItem();
        if (tbLocomocao != null) {
            tbLocomocaoDao.excluir(tbLocomocao);
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
