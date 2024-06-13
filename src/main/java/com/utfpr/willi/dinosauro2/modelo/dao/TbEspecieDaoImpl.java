/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author willi
 */
public class TbEspecieDaoImpl implements TbEspecieDao{
    
    EntityManager manager;
    
    public TbEspecieDaoImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbEspecie especie) {
        manager.getTransaction().begin();
        manager.persist(especie);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEspecie especie) {
        manager.getTransaction().begin();
        manager.merge(especie);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEspecie especie) {
        manager.getTransaction().begin();
        manager.remove(especie);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEspecie> listarTodos() {
        List<TbEspecie> especies;
        
        TypedQuery<TbEspecie> query = manager.createQuery("SELECT e FROM TbEspecie e", TbEspecie.class);
        
        especies = query.getResultList();
        
        return especies;
    }

    @Override
    public TbEspecie listarUm(Long id) {
        TbEspecie especie;
        
        Query query = manager.createQuery("SELECT e FROM TbEspecie e WHERE e.codigo = " + id);
        
        especie = (TbEspecie)query.getSingleResult();
        
        return especie;
    }
    
}
