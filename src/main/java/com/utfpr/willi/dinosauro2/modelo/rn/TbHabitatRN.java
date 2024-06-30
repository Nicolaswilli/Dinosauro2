/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.rn;

import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbHabitatDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbHabitat;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author willi
 */
public class TbHabitatRN {
    
    private TbHabitatDao tbHabitatDao;
    
    public TbHabitatRN(){
        tbHabitatDao = new TbHabitatDaoImpl();
    }
    
    public void salvar(TbHabitat habitat){
        
        try{
            tbHabitatDao.salvar(habitat);
        }catch(HibernateException he){
            System.out.println("Erro: " + he);
        }
    }
    
    public void excluir(TbHabitat habitat){
        tbHabitatDao.excluir(habitat);
    }
    
    public void atualizar(TbHabitat habitat){
        tbHabitatDao.atualizar(habitat);
    }

    
    public List<TbHabitat> listarTodos(){
        return tbHabitatDao.listarTodos();
    }
}
