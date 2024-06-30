package com.utfpr.willi.dinosauro2.controle.Locomocao;

import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastroLocomocaoController implements Initializable {

    @FXML
    public TextField TextFNomeLocomocao;
    @FXML
    public TextField TextFPosturaLocomocao;
    @FXML
    public Button ButtonSalvarHabitat;

    private TbLocomocaoDao tbLocomocaoDao;
    private TbLocomocao tbLocomocao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tbLocomocaoDao = new TbLocomocaoDaoImpl();
    }

    public void salvarLocomocao() {
        if (TextFNomeLocomocao.getText().isEmpty() || TextFPosturaLocomocao.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vazios");
            alert.setHeaderText(null);
            alert.setContentText("Insira todos os campos");

            alert.showAndWait();
        } else {
            this.tbLocomocao = new TbLocomocao();
            this.tbLocomocao.setNome(TextFNomeLocomocao.getText());
            this.tbLocomocao.setPostura(TextFPosturaLocomocao.getText());

            this.tbLocomocaoDao.salvar(this.tbLocomocao);
        }
    }

    public void ClickedButtonSalvar(ActionEvent actionEvent) {
        salvarLocomocao();
    }
}
