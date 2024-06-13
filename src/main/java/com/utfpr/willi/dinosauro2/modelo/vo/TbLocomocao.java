/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author willi
 */
@Entity
public class TbLocomocao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TbLocomocao")
    private Long id;
    
    @Column(unique = true)
    private String nome;
    
    @Column(unique = true)
    private String postura;
    
    @ManyToOne()
    private TbTaxonomia taxonomia;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostura() {
        return postura;
    }

    public void setPostura(String postura) {
        this.postura = postura;
    }
    
}
