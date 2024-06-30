/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.utfpr.willi.dinosauro2.modelo.dao.ConexaoHibernate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javax.persistence.EntityManager;

/**
 *
 * @author willi
 */
public class FXMLPrincipalController implements Initializable {
    
    @FXML
    private MenuItem miInicio;
    @FXML
    private MenuItem miCadastroEspecie;
    @FXML
    private MenuItem miCadastroHabitat;
    @FXML
    private MenuItem miCadastroLocomocao;
    @FXML
    private MenuItem miCadastroPeriodo;
    @FXML
    private MenuItem miCadastroTaxonomia;
    @FXML
    private MenuItem miAtualizaEspecie;
    @FXML
    private MenuItem miAtualizaHabitat;
    @FXML
    private MenuItem miAtualizaLocomocao;
    @FXML
    private MenuItem miAtualizaPeriodo;
    @FXML
    private MenuItem miAtualizaTaxonomia;
    @FXML
    private MenuItem miLisTodosEspecie;
    @FXML
    private MenuItem miLisUmEspecie;
    @FXML
    private MenuItem miLisTodosHabitat;
    @FXML
    private MenuItem miLisUmHabitat;
    @FXML
    private MenuItem miLisTodosLocomocao;
    @FXML
    private MenuItem miLisUmLocomocao;
    @FXML
    private MenuItem miLisTodosPeriodo;
    @FXML
    private MenuItem miLisUmPeriodo;
    @FXML
    private MenuItem miLisTodosTaxonomia;
    @FXML
    private MenuItem miLisUmTaxonomia;
    @FXML
    private AnchorPane anchorPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManager manager = ConexaoHibernate.getInstance();
    }

    public void voltaHome(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLAnchorPanePrincipal.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    /* Cadastros*/
    public void handlerCadEspecie(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Especie/FXMLCadastroEspecie.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleCadHabitat(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Habitat/FXMLCadastroHabitat.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleCadLocomocao(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Locomocao/FXMLCadastroLocomocao.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleCadPeriodo(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Periodo/FXMLCadastroPeriodo.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleCadTaxonomia(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Taxonomia/FXMLCadastroTaxonomia.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    /* Listar Todos*/
    public void handlerListTodosEspecie(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Especie/FXMLListarTodosEspecie.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handlerListTodosHabitat(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Habitat/FXMLListarTodosHabitat.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handlerListTodosLocomocao(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Locomocao/FXMLListarTodosLocomocao.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handlerListTodosPeriodo(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Periodo/FXMLListarTodosPeriodo.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handlerListTodosTaxonomia(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Taxonomia/FXMLListarTodosTaxonomia.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    /* Atualizar - Remover*/

    public void handleAtualizarEspecie(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Especie/FXMLAtualizarRemoverEspecie.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleAtualizarHabitat(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Habitat/FXMLAtualizarRemoverHabitat.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleAtualizarLocomocao(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Locomocao/FXMLAtualizarRemoverLocomocao.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleAtualizarPeriodo(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Periodo/FXMLAtualizarRemoverPeriodo.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    public void handleAtualizarTaxonomia(ActionEvent actionEvent) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Taxonomia/FXMLAtualizarRemoverTaxonomia.fxml"));
        anchorPane.getChildren().setAll(a);
    }
}
