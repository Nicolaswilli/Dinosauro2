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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author willi
 */
@Entity
public class TbTaxonomia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TbTaxonomia")
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @ManyToOne
    private TbEspecie especie;
    
    @OneToMany(mappedBy = "taxonomia")
    private List<TbLocomocao> tbLocomocao;
    
    @ManyToMany
    private List<TbPeriodo> periodo;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
