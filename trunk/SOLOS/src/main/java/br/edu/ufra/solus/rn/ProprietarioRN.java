/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.rn;

import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.dao.DAOFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class ProprietarioRN implements GenericRN<Proprietario> {

    private final GenericDAO<Proprietario> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Proprietario entity) throws DAOException {
        dao.salvar(entity);
    }

    @Override
    public void remover(Proprietario entity) throws DAOException {
        dao.remover(entity);
    }

    @Override
    public Proprietario obter(Object id) {
        return dao.obter(Proprietario.class, id);
    }

    @Override
    public List<Proprietario> obterTodos() {
        return dao.obterTodos(Proprietario.class);
    }

}
