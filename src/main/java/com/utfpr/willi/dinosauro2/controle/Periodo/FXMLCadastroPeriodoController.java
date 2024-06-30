package com.utfpr.willi.dinosauro2.controle.Periodo;

import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastroPeriodoController implements Initializable {

    @FXML
    public TextField TextFNomePeriodo;
    @FXML
    public TextField TextfFimPeriodo;
    @FXML
    public TextField TextFEventoFinalPeriodo;
    @FXML
    public TextField TextFInicioPeriodo;
    @FXML
    public Button ButtonSalvarPeriodo;

    private TbPeriodoDao tbPeriodoDao;
    private TbPeriodo tbPeriodo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbPeriodoDao = new TbPeriodoDaoImpl();
    }

    public void salvarPeriodo() {
        if (TextFNomePeriodo.getText().isEmpty() || TextfFimPeriodo.getText().isEmpty() || TextFInicioPeriodo.getText().isEmpty() || TextFEventoFinalPeriodo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vazios");
            alert.setHeaderText(null);
            alert.setContentText("Insira todos os campos");

            alert.showAndWait();
        } else {
            this.tbPeriodo = new TbPeriodo();
            this.tbPeriodo.setNome(TextFNomePeriodo.getText());
            this.tbPeriodo.setInicio(Integer.valueOf(TextFInicioPeriodo.getText()));
            this.tbPeriodo.setFim(Integer.valueOf(TextfFimPeriodo.getText()));
            this.tbPeriodo.setEvento_final(TextFEventoFinalPeriodo.getText());

            this.tbPeriodoDao.salvar(this.tbPeriodo);
        }
    }

    public void ClickedButtonSalvar(ActionEvent actionEvent) {
        salvarPeriodo();
    }
}
