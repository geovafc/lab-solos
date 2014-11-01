/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import java.util.List;

/**
 *
 * @author Dedo
 * @param <T>
 */
public class GenericRNImpl<T> implements GenericRN<T> {

    private final GenericDAO<T> dao;

    public GenericRNImpl(Class<T> clazz) {
         dao = DAOFactory.criarGenericDAO(clazz);
    }
    
    @Override
    public void salvar(T entidade) throws DAOException {
        dao.salvar(entidade);
    }

    @Override
    public void remover(T entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public T obter(Object id) {
        return dao.obter(id);
    }

    @Override
    public List<T> obterTodos() {
        return dao.obterTodos();
    }
    
}
