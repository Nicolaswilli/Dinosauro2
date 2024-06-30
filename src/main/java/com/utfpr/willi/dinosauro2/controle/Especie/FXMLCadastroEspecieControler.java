package com.utfpr.willi.dinosauro2.controle.Especie;

import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastroEspecieControler implements Initializable {

    @FXML
    public TextField TextFNomeEspecie;
    @FXML
    public TextField TextFDataDescoberta;
    @FXML
    public TextField TextFAlimEspecie;
    @FXML
    public TextField TextFTamEspecie;
    @FXML
    public TextField TextFPesoEspecie;
    @FXML
    public CheckBox CheckBoxEsqueletoCompleto;
    @FXML
    public Button ButtonSalvarEspecie;


    private TbEspecieDao tbEspecieDao;
    private TbEspecie tbEspecie;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbEspecieDao = new TbEspecieDaoImpl();
    }

    public void salvarEspecie() {
        if (TextFNomeEspecie.getText().isEmpty() || TextFDataDescoberta.getText().isEmpty() || TextFAlimEspecie.getText().isEmpty() || TextFTamEspecie.getText().isEmpty() || TextFPesoEspecie.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vazios");
            alert.setHeaderText(null);
            alert.setContentText("Insira todos os campos");

            alert.showAndWait();
        } else {
            this.tbEspecie = new TbEspecie();
            this.tbEspecie.setNome(TextFNomeEspecie.getText());
            this.tbEspecie.setData_descoberta(TextFDataDescoberta.getText());
            this.tbEspecie.setAlimentacao(TextFAlimEspecie.getText());
            this.tbEspecie.setTamanho_medio(Double.parseDouble(TextFTamEspecie.getText()));
            this.tbEspecie.setPeso_medio(Double.parseDouble(TextFPesoEspecie.getText()));
            if (CheckBoxEsqueletoCompleto.isSelected()) {
                this.tbEspecie.setEsqueleto_completo(true);
            } else {
                this.tbEspecie.setEsqueleto_completo(false);
            }

            this.tbEspecieDao.salvar(this.tbEspecie);
        }
    }

    public void ClickedButtonSalvar(ActionEvent actionEvent) {
        salvarEspecie();
    }

}
