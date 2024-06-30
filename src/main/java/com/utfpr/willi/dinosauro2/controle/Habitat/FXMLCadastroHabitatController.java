package com.utfpr.willi.dinosauro2.controle.Habitat;

import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastroHabitatController implements Initializable {

    @FXML
    public TextField TextFNomeHabitat;
    @FXML
    public TextField TextFTempHabitat;
    @FXML
    public TextField TextFLocAproxHabitat;
    @FXML
    public TextField TextFGeologiaHabitat;
    @FXML
    public Button ButtonSalvarHabitat;

    private TbHabitatDao tbHabitatDao;
    private TbHabitat tbHabitat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbHabitatDao = new TbHabitatDaoImpl();
    }

    public void salvarHabitat() {
        if (TextFNomeHabitat.getText().isEmpty() || TextFTempHabitat.getText().isEmpty() || TextFLocAproxHabitat.getText().isEmpty() || TextFGeologiaHabitat.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vazios");
            alert.setHeaderText(null);
            alert.setContentText("Insira todos os campos");

            alert.showAndWait();
        } else {
            this.tbHabitat = new TbHabitat();
            this.tbHabitat.setNome(TextFNomeHabitat.getText());
            this.tbHabitat.setTemperatura_media(Double.parseDouble(TextFTempHabitat.getText()));
            this.tbHabitat.setLocalizacao_aproximada(TextFLocAproxHabitat.getText());
            this.tbHabitat.setGeologia(TextFGeologiaHabitat.getText());

            this.tbHabitatDao.salvar(this.tbHabitat);
        }
    }

    public void ClickedButtonSalvar(ActionEvent actionEvent) {
        salvarHabitat();
    }
}
