/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;

/**
 *
 * @author nicolas
 */
public class ConexaoHibernate {
    
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    public static EntityManager getInstance(){
        
        if(manager == null){
            synchronized(ConexaoHibernate.class){
                if(manager == null){
                    try{
                        factory = Persistence.createEntityManagerFactory("com.utfpr.willi_Dinosauro_jar_1.0-SNAPSHOTPU");
                        manager = factory.createEntityManager();
                    }catch(HibernateException he){
                        System.err.println(he.getMessage());
                    }
                }
            }
        }
        
        return manager;
    }
    
    public static void close(){
        manager.close();
        factory.close();
    }
    
}