package com.utfpr.willi.dinosauro2.controle.Locomocao;

import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLListarTodosLocomocaoController implements Initializable {

    @FXML
    public TableView<TbLocomocao> TableViewTbLocomocao;
    @FXML
    public TableColumn<TbLocomocao, Long> TabColLocomocaoId;
    @FXML
    public TableColumn<TbLocomocao, String> TabColLocomocaoNome;
    @FXML
    public TableColumn<TbLocomocao, String> TabColLocomocaoPostura;

    private List<TbLocomocao> tbLocomocaoList;
    private ObservableList<TbLocomocao> observableListTbLocomocao;
    private TbLocomocaoDao tbLocomocaoDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbLocomocaoDao = new TbLocomocaoDaoImpl();
        this.carregarTabela();
    }

    public void carregarTabela() {

        TabColLocomocaoId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TabColLocomocaoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TabColLocomocaoPostura.setCellValueFactory(new PropertyValueFactory<>("postura"));

        tbLocomocaoList = tbLocomocaoDao.listarTodos();

        observableListTbLocomocao = FXCollections.observableArrayList(tbLocomocaoList);
        TableViewTbLocomocao.setItems(observableListTbLocomocao);

    }


}
