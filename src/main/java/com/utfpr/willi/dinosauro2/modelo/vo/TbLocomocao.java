/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.persistence.*;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "TbLocomocao")
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

    public Long getId() {
        return id;
    }

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
