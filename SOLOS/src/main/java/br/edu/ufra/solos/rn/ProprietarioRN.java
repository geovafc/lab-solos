/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.ProprietarioDAO;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class ProprietarioRN implements GenericRN<Proprietario> {

    private final ProprietarioDAO dao = new ProprietarioDAO();

    @Override
    public void salvar(Proprietario entity) throws DAOException {
        if (entity.getId() == null || entity.getId() == 0) {
            dao.criar(entity);
        } else {
            dao.alterar(entity);
        }
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

    public List<Proprietario> obterPorNomeComo(String nome) {
        return dao.obterPorNomeComo(nome);
    }
}
