/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ufra.solus.rn;

import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.dao.DAOFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class UsuarioRN implements GenericRN<Usuario>{
private final GenericDAO<Usuario> dao= DAOFactory.criarGenericDAO();
    @Override
    public void salvar(Usuario entity) throws DAOException {
        dao.salvar(entity);
    }

    @Override
    public void remover(Usuario entity) throws DAOException {
        dao.remover(entity);
    }

    @Override
    public Usuario obter(Object id) {
        return dao.obter(Usuario.class, id);
    }

    @Override
    public List<Usuario> obterTodos() {
        return dao.obterTodos(Usuario.class);
    }
    
}
