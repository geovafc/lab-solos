/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.dao;

import br.edu.ufra.solos.dao.service.DAOFactory;
import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Usuario;
import javax.persistence.NoResultException;
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
        dao = DAOFactory.criarGenericDAO();
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
        Usuario usuario = new Usuario(null, "Mikael Lima", "mkmikael", "123", "ADM");
        
        dao.salvar(usuario);
        
        Usuario novo = dao.obter(Usuario.class, usuario.getId());
        assertEquals(usuario.getId(), novo.getId());
        assertEquals(usuario.getLogin(), novo.getLogin());
        assertEquals(usuario.getPerfil(), novo.getPerfil());
        assertEquals(usuario.getSenha(), novo.getSenha());
        dao.remover(novo);
    }

    @Test(expected = NoResultException.class)
    public void testRemover() throws Exception {
        Usuario usuario = new Usuario(null, "Mikael Lima", "mkmikael", "123", "ADM");
        dao.salvar(usuario);
        Integer id = usuario.getId();
        
        dao.remover(usuario);
        dao.obter(Usuario.class, id);
    }

    @Test
    public void testObter() {
    }

    @Test
    public void testObterTodos() {
    }
    
}
