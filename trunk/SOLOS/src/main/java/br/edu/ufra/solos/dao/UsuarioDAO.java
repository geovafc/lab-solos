/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.entidade.Usuario;
import javax.persistence.TypedQuery;

/**
 *
 * @author bpmlab
 */
public class UsuarioDAO extends GenericDAOImpl<Usuario> {

    public Usuario obterPorEmail(String email) {
        TypedQuery<Usuario> query = getEntityManager()
                .createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", email);
        return query.getSingleResult();
    }
    
}
