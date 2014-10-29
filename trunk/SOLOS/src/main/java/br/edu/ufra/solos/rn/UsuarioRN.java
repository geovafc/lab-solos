/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.UsuarioDAO;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.rn.springsecurity.Login;
import java.util.List;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 *
 * @author Dedo
 */
public class UsuarioRN {

    private final UsuarioDAO dao = new UsuarioDAO();

    public void salvar(Usuario entidade) throws DAOException {
        String senhaEncode = Login.encode(entidade.getSenha());
        entidade.setSenha(senhaEncode);
        dao.salvar(entidade);
    }

    public void remover(Usuario entidade) throws DAOException {
        dao.remover(entidade);
    }

    public Usuario obter(Object id) {
        return dao.obter(id);
    }

    public List<Usuario> obterTodos() {
        return dao.obterTodos();
    }

    public Usuario obterPorEmail(String email) {
        return dao.obterPorEmail(email);
    }

    public static void main(String[] args) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
        System.out.println(sha.encodePassword("123", null));
    }
}
