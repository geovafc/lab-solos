/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public interface GenericDAO<T> extends Serializable{

    public void salvar(T entidade) throws DAOException;

    public void remover(T entidade) throws DAOException;
    
    public void salvarNoContext(Object entidade);
    
    public void removerDoContext(Object entidade);

    public T obter(Object id);

    public List<T> obterTodos();
    
    public EntityManager getEntityManager();
}
