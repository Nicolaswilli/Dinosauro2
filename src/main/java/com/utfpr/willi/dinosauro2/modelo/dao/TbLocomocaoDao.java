/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface TbLocomocaoDao {
    
    void salvar(TbLocomocao locomocao);
    
    void atualizar(TbLocomocao locomocao);
    
    void excluir(TbLocomocao locomocao);
    
    List<TbLocomocao> listarTodos();

}
