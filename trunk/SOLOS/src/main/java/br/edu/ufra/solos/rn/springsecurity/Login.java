/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn.springsecurity;

import br.edu.ufra.solos.dao.UsuarioDAO;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.util.JsfUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author bpmlab
 */
public class Login implements UserDetailsService {

    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
        if (string == null || string.isEmpty()) {
            throw new UsernameNotFoundException(string);
        }

        Usuario usuarioLogado;
        try {
            usuarioLogado = dao.obterPorEmail(string);
        } catch (NoResultException e) {
            throw new UsernameNotFoundException(string, e);
        }
        List<GrantedAuthority> papeis = new ArrayList<>();
        papeis.add(new GrantedAuthorityImpl(usuarioLogado.getPerfil()));
        return new User(usuarioLogado.getEmail(),
                usuarioLogado.getSenha(),
                true,
                true,
                true,
                true,
                papeis);
    }

    public static String encode(String senha) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
        return sha.encodePassword(senha, null);
        
    }
    
    public static void main(String[] args) {
        System.out.println(encode("123"));
    }
}
