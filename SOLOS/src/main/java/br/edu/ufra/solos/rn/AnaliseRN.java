/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class AnaliseRN implements GenericRN<Analise> {

    private final GenericDAO<Analise> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Analise entidade) throws DAOException {
         if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Analise entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Analise obter(Object id) {
       return dao.obter(Analise.class, id);
    }

    @Override
    public List<Analise> obterTodos() {
       return dao.obterTodos(Analise.class);
    }

}
