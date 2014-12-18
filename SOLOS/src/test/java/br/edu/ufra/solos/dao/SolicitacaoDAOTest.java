/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.entidade.Solicitacao;
import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dedo
 */
public class SolicitacaoDAOTest {

    private static SolicitacaoDAO dao;

    public SolicitacaoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new SolicitacaoDAO();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFiltroSolicitacao_Case1() {
        List<Solicitacao> lista = dao.filtroSolicitacao(null, null, null, null, null, null);
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testFiltroSolicitacao_Case2() {
        Proprietario p = dao.getEntityManager().find(Proprietario.class, 1);
        List<Solicitacao> lista = dao.filtroSolicitacao(p, null, null, null, null, null);
        assertEquals(3, lista.size());
        assertNotNull(lista);
    }
    
    @Test
    public void testFiltroSolicitacao_Case3() {
        List<Solicitacao> lista = dao.filtroSolicitacao(null, "Particular", null, null, null, null);
        assertEquals(3, lista.size());
        assertNotNull(lista);
    }

}
