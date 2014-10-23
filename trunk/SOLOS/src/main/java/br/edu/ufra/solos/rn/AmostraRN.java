/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Amostra;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class AmostraRN implements GenericRN<Amostra> {

    private final GenericDAO<Amostra> dao = DAOFactory.criarGenericDAO();
    
    @Override
    public void salvar(Amostra entidade) throws DAOException {
        if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Amostra entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Amostra obter(Object id) {
        return dao.obter(Amostra.class, id);
    }

    @Override
    public List<Amostra> obterTodos() {
        return dao.obterTodos(Amostra.class);
    }
    
}
