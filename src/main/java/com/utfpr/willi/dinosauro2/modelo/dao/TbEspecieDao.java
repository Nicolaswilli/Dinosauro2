/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
import java.util.List;

/**
 *
 * @author willi
 */
public interface TbEspecieDao {
    
    void salvar(TbEspecie especie);
    
    void atualizar(TbEspecie especie);
    
    void excluir(TbEspecie especie);
    
    List<TbEspecie> listarTodos();
    
}

