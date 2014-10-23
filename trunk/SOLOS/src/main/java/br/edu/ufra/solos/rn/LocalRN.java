/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Local;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class LocalRN implements GenericRN<Local> {

    private final GenericDAO<Local> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Local entidade) throws DAOException {
        if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Local entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Local obter(Object id) {
        return dao.obter(Local.class, id);
    }

    @Override
    public List<Local> obterTodos() {
        return dao.obterTodos(Local.class);
    }
    
    
}
