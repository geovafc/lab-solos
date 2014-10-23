/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public interface GenericRN<T> extends Serializable {

    void salvar(T entidade) throws DAOException;

    void remover(T entidade) throws DAOException;

    T obter(Object id);

    List<T> obterTodos();
}
