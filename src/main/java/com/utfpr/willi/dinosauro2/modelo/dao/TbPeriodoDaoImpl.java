/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicolas
 */
public class TbPeriodoDaoImpl implements TbPeriodoDao{
    
    EntityManager manager;

    public TbPeriodoDaoImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbPeriodo periodo) {
        manager.getTransaction().begin();
        manager.persist(periodo);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbPeriodo periodo) {
        manager.getTransaction().begin();
        manager.merge(periodo);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbPeriodo periodo) {
        manager.getTransaction().begin();
        manager.remove(periodo);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbPeriodo> listarTodos() {
        List<TbPeriodo> periodos;
        
        TypedQuery<TbPeriodo> query = manager.createQuery("SELECT p FROM TbPeriodo p", TbPeriodo.class);
        
        periodos = query.getResultList();
        
        return periodos;
    }

}
