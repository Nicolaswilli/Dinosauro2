/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.rn;

import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbTaxonomiaDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import java.util.List;

/**
 *
 * @author willi
 */
public class TbTaxonomiaRN {
    
    private TbTaxonomiaDao tbTaxonomiaDao;
    
    public TbTaxonomiaRN() {
        tbTaxonomiaDao = new TbTaxonomiaDaoImpl();
    }
    
    public void salvar(TbTaxonomia taxonomia) {
        tbTaxonomiaDao.salvar(taxonomia);
    }
    
    public void excluir(TbTaxonomia taxonomia) {
        tbTaxonomiaDao.excluir(taxonomia);
    }
    
    public void atualizar(TbTaxonomia taxonomia) {
        tbTaxonomiaDao.atualizar(taxonomia);
    }
    
    public TbTaxonomia listarUm(Long id) {
        return tbTaxonomiaDao.listarUm(id);
    }
    
    public List<TbTaxonomia> listarTodos() {
        return tbTaxonomiaDao.listarTodos();
    }
    
}

