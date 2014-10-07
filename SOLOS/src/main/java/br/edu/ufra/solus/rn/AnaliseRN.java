/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.rn;

import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.dao.DAOFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class AnaliseRN implements GenericRN<Analise> {

    private final GenericDAO<Analise> dao = DAOFactory.criarGenericDAO();

    @Override
    public void salvar(Analise entity) throws DAOException {
        dao.salvar(entity);
    }

    @Override
    public void remover(Analise entity) throws DAOException {
        dao.remover(entity);
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
