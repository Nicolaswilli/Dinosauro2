/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface TbPeriodoDao {
    
    void salvar(TbPeriodo periodo);
    
    void atualizar(TbPeriodo periodo);
    
    void excluir(TbPeriodo periodo);
    
    List<TbPeriodo> listarTodos();
    
    TbPeriodo listarUm(Long id);
    
}
