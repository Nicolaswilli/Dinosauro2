/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbTaxonomia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicolas
 */
public class TbTaxonomiaDaoImpl implements TbTaxonomiaDao{

    EntityManager manager;

    public TbTaxonomiaDaoImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbTaxonomia taxonomia) {
        manager.getTransaction().begin();
        manager.persist(taxonomia);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbTaxonomia taxonomia) {
        manager.getTransaction().begin();
        manager.merge(taxonomia);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbTaxonomia taxonomia) {
        manager.getTransaction().begin();
        manager.remove(taxonomia);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbTaxonomia> listarTodos() {
        List<TbTaxonomia> taxonomias;
        
        TypedQuery<TbTaxonomia> query = manager.createQuery("SELECT t FROM TbLocomocao t", TbTaxonomia.class);
        
        taxonomias = query.getResultList();
        
        return taxonomias;
    }

    @Override
    public TbTaxonomia listarUm(Long id) {
        TbTaxonomia taxonomia;
        
        Query query = manager.createQuery("SELECT t FROM TbLocomocao t WHERE t.codigo = " + id);
        
        taxonomia = (TbTaxonomia)query.getSingleResult();
        
        return taxonomia;
    }
    
}
