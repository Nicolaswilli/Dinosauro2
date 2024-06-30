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
 * @author nicolas
 */
@Entity
public class TbHabitat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TbHabitat")
    private Long id;
    
    @Column(unique = true)
    private String nome;
    
    @Column(unique = true)
    private String localizacao_aproximada;
    
    @Column(unique = true)
    private Double temperatura_media;
    
    @Column(unique = true)
    private String geologia;

    @ManyToMany(mappedBy = "habitat")
    private List<TbEspecie> especies;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao_aproximada() {
        return localizacao_aproximada;
    }

    public void setLocalizacao_aproximada(String localizacao_aproximada) {
        this.localizacao_aproximada = localizacao_aproximada;
    }

    public Double getTemperatura_media() {
        return temperatura_media;
    }

    public void setTemperatura_media(Double temperatura_media) {
        this.temperatura_media = temperatura_media;
    }

    public String getGeologia() {
        return geologia;
    }

    public void setGeologia(String geologia) {
        this.geologia = geologia;
    }
    
}
