/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.proprietario;

import br.edu.ufra.solos.dao.service.GenericDAO;
import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solus.dao.DAOFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.SeleniumFactory;
import selenium.caf.ProprietarioPO;
import static org.junit.Assert.*;

/**
 *
 * @author bpmlab
 */
public class ProprietarioExcluirTest {

    private static WebDriver driver;
    private static GenericDAO<Proprietario> dao;
    private static ProprietarioPO propPO;
    private Proprietario p;

    public ProprietarioExcluirTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        driver = SeleniumFactory.getDriver();
        dao = DAOFactory.criarGenericDAO();
        propPO = new ProprietarioPO(driver);
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
        p = new Proprietario(null, "Mikael", "Barcarena", "PA", "(91)8888-6666");
        dao.salvar(p);
        
        propPO.irParaPagina().clickExcluir();
        
        assertEquals("Excluído com sucesso!", propPO.getMensagem().getText());
        dao.getEntityManager().clear();
        Proprietario atual = dao.obter(Proprietario.class, p.getId());
        assertNull(atual);
    }
}
