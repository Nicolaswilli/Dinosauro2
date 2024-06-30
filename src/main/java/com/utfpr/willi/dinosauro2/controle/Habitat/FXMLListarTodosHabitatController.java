package com.utfpr.willi.dinosauro2.controle.Habitat;

import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
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

public class FXMLListarTodosHabitatController implements Initializable {

    @FXML
    public TableView<TbHabitat> TableViewTbHabitat;
    @FXML
    public TableColumn<TbHabitat, Long> TabColHabitatId;
    @FXML
    public TableColumn<TbHabitat, String> TabColHabitatNome;
    @FXML
    public TableColumn<TbHabitat, String> TabColHabitatGeologia;
    @FXML
    public TableColumn<TbHabitat, String> TabColHabitatLocAprox;
    @FXML
    public TableColumn<TbHabitat, Double> TabColHabitatTempMedia;

    private List<TbHabitat> tbHabitatList;
    private ObservableList<TbHabitat> observableListTbHabitat;
    private TbHabitatDao tbHabitatDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbHabitatDao = new TbHabitatDaoImpl();
        this.carregarTabela();
    }

    public void carregarTabela() {

        TabColHabitatId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TabColHabitatNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TabColHabitatGeologia.setCellValueFactory(new PropertyValueFactory<>("geologia"));
        TabColHabitatLocAprox.setCellValueFactory(new PropertyValueFactory<>("localizacao_aproximada"));
        TabColHabitatTempMedia.setCellValueFactory(new PropertyValueFactory<>("temperatura_media"));

        tbHabitatList = tbHabitatDao.listarTodos();

        observableListTbHabitat = FXCollections.observableArrayList(tbHabitatList);
        TableViewTbHabitat.setItems(observableListTbHabitat);

    }

}
