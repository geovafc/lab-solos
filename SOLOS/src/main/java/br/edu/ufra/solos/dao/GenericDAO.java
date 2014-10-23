/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.dao.DAOException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public interface GenericDAO<T> {

    void criar(T entidade) throws DAOException;
    
    void alterar(T entidade) throws DAOException;

    void remover(T entidade) throws DAOException;

    T obter(Class<T> clazz, Object id);

    List<T> obterTodos(Class<T> clazz);
    
    EntityManager getEntityManager();
}
