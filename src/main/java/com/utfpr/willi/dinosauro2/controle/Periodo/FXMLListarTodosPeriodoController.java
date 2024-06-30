package com.utfpr.willi.dinosauro2.controle.Periodo;

import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
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

public class FXMLListarTodosPeriodoController implements Initializable {

    @FXML
    public TableView<TbPeriodo> TableViewTbPeriodo;
    @FXML
    public TableColumn<TbPeriodo, Long> TabColPeriodoId;
    @FXML
    public TableColumn<TbPeriodo, String> TabColPeriodoNome;
    @FXML
    public TableColumn<TbPeriodo, Integer> TabColPeriodoInicio;
    @FXML
    public TableColumn<TbPeriodo, Integer> TabColPeriodoFim;
    @FXML
    public TableColumn<TbPeriodo, String> TabColPeriodoEvetFinal;

    private List<TbPeriodo> tbPeriodoList;
    private ObservableList<TbPeriodo> observableListTbPeriodo;
    private TbPeriodoDao tbPeriodoDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbPeriodoDao = new TbPeriodoDaoImpl();
        this.carregarTabela();
    }

    public void carregarTabela() {

        TabColPeriodoId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TabColPeriodoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TabColPeriodoInicio.setCellValueFactory(new PropertyValueFactory<>("inicio"));
        TabColPeriodoFim.setCellValueFactory(new PropertyValueFactory<>("fim"));
        TabColPeriodoEvetFinal.setCellValueFactory(new PropertyValueFactory<>("evento_final"));

        tbPeriodoList = tbPeriodoDao.listarTodos();

        observableListTbPeriodo = FXCollections.observableArrayList(tbPeriodoList);
        TableViewTbPeriodo.setItems(observableListTbPeriodo);

    }
}
