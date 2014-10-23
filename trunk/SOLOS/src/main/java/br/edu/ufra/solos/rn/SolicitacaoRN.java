/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Solicitacao;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class SolicitacaoRN implements GenericRN<Solicitacao> {

    private final GenericDAO<Solicitacao> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Solicitacao entidade) throws DAOException {
        if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Solicitacao entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Solicitacao obter(Object id) {
        return dao.obter(Solicitacao.class, id);
    }

    @Override
    public List<Solicitacao> obterTodos() {
        return dao.obterTodos(Solicitacao.class);
    }
    
}
