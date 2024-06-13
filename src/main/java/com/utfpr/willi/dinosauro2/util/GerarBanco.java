/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.util;

import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author willi
 */
public class GerarBanco {
    
    public static void main(String[] args) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.utfpr.willi_Dinosauro_jar_1.0-SNAPSHOTPU");
            
            EntityManager manager = factory.createEntityManager();
            
            TbLocomocao locomocao1 = new TbLocomocao();
            locomocao1.setNome("Terestre");
            locomocao1.setPostura("Quadrupde");
            
            manager.getTransaction().begin();
            manager.persist(locomocao1);
            manager.getTransaction().commit();
            
            TbLocomocao catLocomocao = manager.find(TbLocomocao.class, 1L);
            
            Query query = manager.createQuery("SELECT c FROM TbLocomocao c");
            List<TbLocomocao> locomocoes = query.getResultList();
            
            factory.close();
    }
    
}
