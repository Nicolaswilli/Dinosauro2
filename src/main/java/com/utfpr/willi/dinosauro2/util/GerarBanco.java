/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.util;

import com.utfpr.willi.dinosauro2.modelo.vo.*;

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

            TbEspecie especie1 = new TbEspecie();
            especie1.setNome("Torvosaurus");
            especie1.setAlimentacao("Carnívoro");
            especie1.setTamanho_medio(10.0);
            especie1.setPeso_medio(4.0);
            especie1.setEsqueleto_completo(true);
            especie1.setData_descoberta("1972");

            TbHabitat habitat1 = new TbHabitat();
            habitat1.setNome("Floresta");
            habitat1.setGeologia("Plano");
            habitat1.setLocalizacao_aproximada("Europa");
            habitat1.setTemperatura_media(30.0);

            TbLocomocao locomocao1 = new TbLocomocao();
            locomocao1.setNome("Terestre");
            locomocao1.setPostura("Bipede");

            TbPeriodo periodo1 = new TbPeriodo();
            periodo1.setNome("Jurássico");
            periodo1.setInicio(201);
            periodo1.setFim(145);
            periodo1.setEvento_final("Resfriamento global");

            TbTaxonomia taxonomia1 = new TbTaxonomia();
            taxonomia1.setNome("Theropoda");

            manager.getTransaction().begin();
            manager.persist(especie1);
            manager.persist(habitat1);
            manager.persist(locomocao1);
            manager.persist(periodo1);
            manager.persist(taxonomia1);
            manager.getTransaction().commit();
            
            TbLocomocao catLocomocao = manager.find(TbLocomocao.class, 1L);
            
            Query query = manager.createQuery("SELECT c FROM TbLocomocao c");
            List<TbLocomocao> locomocoes = query.getResultList();
            
            factory.close();
    }
    
}
