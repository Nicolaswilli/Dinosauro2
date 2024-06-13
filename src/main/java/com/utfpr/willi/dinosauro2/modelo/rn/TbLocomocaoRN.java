/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.rn;

import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbLocomocaoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbLocomocao;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author willi
 */
public class TbLocomocaoRN {
    
    private TbLocomocaoDao tbLocomocaoDao;
    
    public TbLocomocaoRN() {
        tbLocomocaoDao = new TbLocomocaoDaoImpl();
    }
    
    public void salvar(TbLocomocao locomocao){
        
        try{
            tbLocomocaoDao.salvar(locomocao);
        }catch(HibernateException he){
            System.out.println("Erro: " + he);
        }
        
    }
    
    public void excluir(TbLocomocao locomocao){
        tbLocomocaoDao.excluir(locomocao);
    }
    
    public void atualizar(TbLocomocao locomocao){
        tbLocomocaoDao.atualizar(locomocao);
    }
    
    public TbLocomocao listarUm(Long id){
        return tbLocomocaoDao.listarUm(id);
    }
    
    public List<TbLocomocao> listarTodos(){
        return tbLocomocaoDao.listarTodos();
    }
    
}

