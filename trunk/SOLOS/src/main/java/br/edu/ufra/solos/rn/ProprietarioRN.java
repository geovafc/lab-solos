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
public class ProprietarioRN {

    private final ProprietarioDAO dao = new ProprietarioDAO();

    public void salvar(Proprietario entidade) throws DAOException {
        dao.salvar(entidade);
    }

    public void remover(Proprietario entidade) throws DAOException {
        dao.remover(entidade);
    }

    public Proprietario obter(Object id) {
        return dao.obter(id);
    }

    public List<Proprietario> obterTodos() {
        return dao.obterTodos();
    }

    public List<Proprietario> obterPorNomeComo(String nome) {
        return dao.obterPorNomeComo(nome);
    }
}
