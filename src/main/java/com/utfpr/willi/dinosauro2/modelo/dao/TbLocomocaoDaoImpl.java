/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicolas
 */
public class TbLocomocaoDaoImpl implements TbLocomocaoDao{
    
    EntityManager manager;
    
    public TbLocomocaoDaoImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbLocomocao locomocao) {
        manager.getTransaction().begin();
        manager.persist(locomocao);
        manager.getTransaction().commit();
       
    }

    @Override
    public void atualizar(TbLocomocao locomocao) {
        manager.getTransaction().begin();
        manager.merge(locomocao);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbLocomocao locomocao) {
        manager.getTransaction().begin();
        manager.remove(locomocao);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbLocomocao> listarTodos() {
        List<TbLocomocao> locomocoes;
        
        TypedQuery<TbLocomocao> query = manager.createQuery("SELECT l FROM TbLocomocao l", TbLocomocao.class);
        
        locomocoes = query.getResultList();
        
        return locomocoes;
    }

}
