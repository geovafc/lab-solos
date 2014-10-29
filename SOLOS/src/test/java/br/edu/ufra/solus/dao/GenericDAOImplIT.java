/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.dao;

import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bpmlab
 */
public class GenericDAOImplIT {

    private static GenericDAO<Usuario> dao;
    
    public GenericDAOImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = DAOFactory.criarGenericDAO(Usuario.class);
    }

    @AfterClass
    public static void tearDownClass() {
        DAOFactory.getFactory().close();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSalvar() throws Exception {
        Usuario usuario = new Usuario(null, "mkmikael@gmail.com", "Mikael Lima", "ROLE_ADM", "123");

        dao.salvar(usuario);

        Usuario novo = dao.obter(usuario.getId());
        assertEquals(usuario.getId(), novo.getId());
        assertEquals(usuario.getEmail(), novo.getEmail());
        assertEquals(usuario.getPerfil(), novo.getPerfil());
        assertEquals(usuario.getSenha(), novo.getSenha());
        
        dao.remover(novo);
    }

    @Test
    public void testRemover() throws Exception {
        Usuario usuario = new Usuario(null, "mkmikael@gmail.com", "Mikael Lima", "ROLE_ADM", "123");
        dao.salvar(usuario);
        Integer id = usuario.getId();

        dao.remover(usuario);

        Usuario u = dao.obter(id);
        assertNull(u);
    }

    @Test
    public void testObterTodos() throws Exception {
        Usuario u1 = new Usuario(null, "mkmikael@gmail.com", "Mikael Lima", "ROLE_ADM", "123");
        Usuario u2 = new Usuario(null, "geovane@gmail.com", "Geovane Freitas", "ROLE_ADM", "123");
        Usuario u3 = new Usuario(null, "lucas@gmail.com", "Lucas Toshiaki", "ROLE_ADM", "123");
        dao.salvar(u1);
        dao.salvar(u2);
        dao.salvar(u3);

        List<Usuario> lista = dao.obterTodos();

        assertFalse(lista.isEmpty());
        assertEquals(lista.size(), 3 + 1);
        
        dao.remover(u1);
        dao.remover(u2);
        dao.remover(u3);
    }

}
