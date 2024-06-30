/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface TbTaxonomiaDao {
    
    void salvar(TbTaxonomia taxonomia);
    
    void atualizar(TbTaxonomia taxonomia);
    
    void excluir(TbTaxonomia taxonomia);
    
    List<TbTaxonomia> listarTodos();

}
