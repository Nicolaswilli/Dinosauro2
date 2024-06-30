package com.utfpr.willi.dinosauro2.controle.Taxonomia;

import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastroTaxonomiaController implements Initializable {

    @FXML
    public TextField TextFNomeTaxonomia;
    @FXML
    public Button ButtonSalvarTaxonomia;

    private TbTaxonomiaDao tbTaxonomiaDao;
    private TbTaxonomia tbTaxonomia;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbTaxonomiaDao = new TbTaxonomiaDaoImpl();
    }

    public void salvarTaxonomia() {
        if (TextFNomeTaxonomia.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vazios");
            alert.setHeaderText(null);
            alert.setContentText("Insira todos os campos");

            alert.showAndWait();
        } else {
            this.tbTaxonomia = new TbTaxonomia();
            this.tbTaxonomia.setNome(TextFNomeTaxonomia.getText());

            this.tbTaxonomiaDao.salvar(this.tbTaxonomia);
        }
    }

    public void ClickedButtonSalvar(ActionEvent actionEvent) {
        salvarTaxonomia();
    }
}
