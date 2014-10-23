/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Faturamento;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class FaturamentoRN implements GenericRN<Faturamento> {

    private final GenericDAO<Faturamento> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Faturamento entidade) throws DAOException {
        if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Faturamento entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Faturamento obter(Object id) {
        return dao.obter(Faturamento.class, id);
    }

    @Override
    public List<Faturamento> obterTodos() {
        return dao.obterTodos(Faturamento.class);
    }

}
