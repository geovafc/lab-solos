/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class UsuarioRN implements GenericRN<Usuario> {

    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    public void salvar(Usuario entidade) throws DAOException {
        if (entidade.getId() == null || entidade.getId() == 0) {
            dao.criar(entidade);
        } else {
            dao.alterar(entidade);
        }
    }

    @Override
    public void remover(Usuario entidade) throws DAOException {
        dao.remover(entidade);
    }

    @Override
    public Usuario obter(Object id) {
        return dao.obter(Usuario.class, id);
    }
    
    @Override
    public List<Usuario> obterTodos() {
        return dao.obterTodos(Usuario.class);
    }

    public Usuario obterPorEmail(String nome) {
        return dao.obterPorEmail(nome);
    }

}
