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
import java.util.List;

/**
 *
 * @author willi
 */
@Entity
public class TbPeriodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TbPeriodo")
    private Long id;
    
    @Column(unique = true)
    private String nome;
    
    @Column()
    private Integer inicio;
    
    @Column()
    private Integer fim;
    
    @Column()
    private String evento_final;
    
    @ManyToMany
    private List<TbTaxonomia> taxonomia;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getFim() {
        return fim;
    }

    public void setFim(Integer fim) {
        this.fim = fim;
    }

    public String getEvento_final() {
        return evento_final;
    }

    public void setEvento_final(String evento_final) {
        this.evento_final = evento_final;
    }
    
}
