/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.rn;

import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbEspecieDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbEspecie;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author willi
 */
public class TbEspecieRN {
    
    private TbEspecieDao tbEspecieDao;
    
    public TbEspecieRN() {
        tbEspecieDao = new TbEspecieDaoImpl();
    }
    
    public void salvar(TbEspecie especie){
        
        try{
            tbEspecieDao.salvar(especie);
        }catch(HibernateException he){
            System.out.println("Erro: " + he);
        }
        
    }
    
    public void excluir(TbEspecie especie){
        tbEspecieDao.excluir(especie);
    }
    
    public void atualizar(TbEspecie especie){
        tbEspecieDao.atualizar(especie);
    }

    
    public List<TbEspecie> listarTodos(){
        return tbEspecieDao.listarTodos();
    }
}
