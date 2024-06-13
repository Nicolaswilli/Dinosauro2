/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicolas
 */
public class TbHabitatDaoImpl implements TbHabitatDao{
    
    EntityManager manager;
    
    public TbHabitatDaoImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbHabitat habitat) {
        manager.getTransaction().begin();
        manager.persist(habitat);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbHabitat habitat) {
        manager.getTransaction().begin();
        manager.merge(habitat);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbHabitat habitat) {
        manager.getTransaction().begin();
        manager.remove(habitat);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbHabitat> listarTodos() {
        List<TbHabitat> habitates;
        
        TypedQuery<TbHabitat> query = manager.createQuery("SELECT h FROM TbHabitat h", TbHabitat.class);
        
        habitates = query.getResultList();
        
        return habitates;
    }

    @Override
    public TbHabitat listarUm(Long id) {
        TbHabitat habitat;
        
        Query query = manager.createQuery("SELECT h FROM TbHabitat h WHERE h.codigo = " + id);
        
        habitat = (TbHabitat)query.getSingleResult();
        
        return habitat;
    }
    
}
