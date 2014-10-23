/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.usuario;

import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.dao.DAOFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import selenium.SeleniumFactory;
import selenium.caf.ListaUsuarioPO;

/**
 *
 * @author bpmlab
 */
public class UsuarioExcluirTest {
    
    private static WebDriver driver;
    private static GenericDAO<Usuario> dao;
    private static ListaUsuarioPO po;
    
    public UsuarioExcluirTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = SeleniumFactory.getDriver();
        dao = DAOFactory.criarGenericDAO();
        po = new ListaUsuarioPO(driver);
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
    @Ignore
    public void testExcluir() throws Exception {
        Usuario usuario = new Usuario(null, "mkmikael@gmail.com", "Mikael Lima", "ROLE_ADM", "123");
        dao.criar(usuario);
        
        po.irParaPagina().clickExcluir();
        
        assertEquals("Excluído com sucesso!", po.getMensagem().getText());
        dao.getEntityManager().clear();
        Usuario atual = dao.obter(Usuario.class, usuario.getId());
        assertNull(atual);
    }
}
