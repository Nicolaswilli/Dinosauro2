package com.utfpr.willi.dinosauro2.controle.Especie;

import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class FXMListarTodosEspecieController implements Initializable {

    @FXML
    public TableView<TbEspecie> TableViewTbEspecie;
    @FXML
    public TableColumn<TbEspecie, Long> TabColEspecieId;
    @FXML
    public TableColumn<TbEspecie, String> TabColEspecieNome;
    @FXML
    public TableColumn<TbEspecie, String> TabColEspecieAlimentacao;
    @FXML
    public TableColumn<TbEspecie, Double> TabColEspecieTamMedio;
    @FXML
    public TableColumn<TbEspecie, Double> TabColEspeciePesoMedio;
    @FXML
    public TableColumn<TbEspecie, Date> TabColEspecieIdDataDesco;
    @FXML
    public TableColumn<TbEspecie, Boolean> TabColEspecieEsqueletoCompleto;

    private List<TbEspecie> tbEspecieList;
    private ObservableList<TbEspecie> observableListTbEspecie;
    private TbEspecieDao tbEspecieDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbEspecieDao = new TbEspecieDaoImpl();
        this.carregarTabela();
    }

    public void carregarTabela() {

        TabColEspecieId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TabColEspecieNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TabColEspecieAlimentacao.setCellValueFactory(new PropertyValueFactory<>("alimentacao"));
        TabColEspecieTamMedio.setCellValueFactory(new PropertyValueFactory<>("tamanho_medio"));
        TabColEspeciePesoMedio.setCellValueFactory(new PropertyValueFactory<>("peso_medio"));
        TabColEspecieIdDataDesco.setCellValueFactory(new PropertyValueFactory<>("data_descoberta"));
        TabColEspecieEsqueletoCompleto.setCellValueFactory(new PropertyValueFactory<>("esqueleto_completo"));

        tbEspecieList = tbEspecieDao.listarTodos();

        observableListTbEspecie = FXCollections.observableArrayList(tbEspecieList);
        TableViewTbEspecie.setItems(observableListTbEspecie);

    }

}
