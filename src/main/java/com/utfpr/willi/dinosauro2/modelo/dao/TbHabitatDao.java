/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.dao;

import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface TbHabitatDao {
    
    void salvar(TbHabitat habitat);
    
    void atualizar(TbHabitat habitat);
    
    void excluir(TbHabitat habitat);
    
    List<TbHabitat> listarTodos();

}
