/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author nicolas
 */
@Entity
public class TbEspecie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TbEspecie")
    private Long id;
    
    @Column()
    private Double tamanho_medio;
    
    @Column()
    private String alimentacao;
    
    @Column(unique = true)
    private String nome;
    
    @Column()
    private Double peso_medio;
    
    @Column()
    private Boolean esqueleto_completo;
    
    @Column(nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date data_descoberta;
    
    @ManyToMany
    private TbHabitat habitat;
    
    @OneToMany(mappedBy = "taxonomia")
    private TbTaxonomia taxonomia;
    
    public Double getTamanho_medio() {
        return tamanho_medio;
    }

    public void setTamanho_medio(Double tamanho_medio) {
        this.tamanho_medio = tamanho_medio;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso_medio() {
        return peso_medio;
    }

    public void setPeso_medio(Double peso_medio) {
        this.peso_medio = peso_medio;
    }

    public Boolean getEsqueleto_completo() {
        return esqueleto_completo;
    }

    public void setEsqueleto_completo(Boolean esqueleto_completo) {
        this.esqueleto_completo = esqueleto_completo;
    }

    public Date getData_descoberta() {
        return data_descoberta;
    }

    public void setData_descoberta(Date data_descoberta) {
        this.data_descoberta = data_descoberta;
    }
    
}

