/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.analise;

import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.dao.DAOFactory;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.SeleniumFactory;
import selenium.caf.ListaAnalisePO;

/**
 *
 * @author bpmlab
 */
public class AnaliseExcluirTest {
    
    private static WebDriver driver;
    private static GenericDAO<Analise> dao;
    private static ListaAnalisePO po;
    private Analise analise;
    
    public AnaliseExcluirTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = SeleniumFactory.getDriver();
        dao = DAOFactory.criarGenericDAO(Analise.class);
        po = new ListaAnalisePO(driver);
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
        analise = new Analise(null, "Magnésio", BigDecimal.TEN, "Solo");
        dao.salvar(analise);
        
        po.irParaPagina().clickExcluir();
        
        assertEquals("Excluído com sucesso!", po.getMensagem().getText());
        dao.getEntityManager().clear();
        Analise atual = dao.obter(analise.getId());
        assertNull(atual);
    }
}
