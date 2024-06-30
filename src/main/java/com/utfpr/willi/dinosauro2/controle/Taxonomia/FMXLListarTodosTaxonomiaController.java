package com.utfpr.willi.dinosauro2.controle.Taxonomia;

import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
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

public class FMXLListarTodosTaxonomiaController implements Initializable {

    @FXML
    public TableView<TbTaxonomia> TableViewTbTaxonomia;
    @FXML
    public TableColumn<TbTaxonomia, Long> TabColTaxonomiaId;
    @FXML
    public TableColumn<TbTaxonomia, String> TabColTaxonomiaNome;

    private List<TbTaxonomia> tbTaxonomiaList;
    private ObservableList<TbTaxonomia> observableListTbTaxonomia;
    private TbTaxonomiaDao tbTaxonomiaDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbTaxonomiaDao = new TbTaxonomiaDaoImpl();
        this.carregarTabela();
    }

    public void carregarTabela() {

        TabColTaxonomiaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TabColTaxonomiaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tbTaxonomiaList = tbTaxonomiaDao.listarTodos();

        observableListTbTaxonomia = FXCollections.observableArrayList(tbTaxonomiaList);
        TableViewTbTaxonomia.setItems(observableListTbTaxonomia);

    }

}
