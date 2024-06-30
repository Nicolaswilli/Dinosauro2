/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.willi.dinosauro2.modelo.rn;

import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDao;
import com.utfpr.willi.dinosauro2.modelo.dao.TbPeriodoDaoImpl;
import com.utfpr.willi.dinosauro2.modelo.vo.TbPeriodo;
import java.util.List;

/**
 *
 * @author willi
 */
public class TbPeriodoRN {
    
    private TbPeriodoDao tbPeriodoDao;
    
    public TbPeriodoRN() {
        tbPeriodoDao = new TbPeriodoDaoImpl();
    }
    
    public void salvar(TbPeriodo periodo) {
        tbPeriodoDao.salvar(periodo);
    }
    
    public void excluir(TbPeriodo periodo) {
        tbPeriodoDao.excluir(periodo);
    }
    
    public void atualizar(TbPeriodo periodo) {
        tbPeriodoDao.atualizar(periodo);
    }

    public List<TbPeriodo> listarTodos() {
        return tbPeriodoDao.listarTodos();
    }
    
}

