/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.usuario;

import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solus.dao.DAOFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import selenium.SeleniumFactory;
import selenium.caf.UsuarioPO;

/**
 *
 * @author bpmlab
 */
public class UsuarioExcluirTest {
    
    private static WebDriver driver;
    private static GenericDAO<Usuario> dao;
    private static UsuarioPO po;
    
    public UsuarioExcluirTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = SeleniumFactory.getDriver();
        dao = DAOFactory.criarGenericDAO();
        po = new UsuarioPO(driver);
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
    public void testExcluir() throws Exception {
        Usuario usuario = new Usuario(null, "Mikael Lima", "mkmikael", "123456", "ADM");
        dao.salvar(usuario);
        
        po.irParaPagina().clickExcluir();
        
        assertEquals("Excluído com sucesso!", po.getMensagem().getText());
        dao.getEntityManager().clear();
        Usuario atual = dao.obter(Usuario.class, usuario.getId());
        assertNull(atual);
    }
}
