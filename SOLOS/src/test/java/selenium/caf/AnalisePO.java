/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.caf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.SeleniumFactory;

/**
 *
 * @author bpmlab
 */
public class AnalisePO {

    private final WebDriver driver;
    private WebElement inserir;
    private WebElement excluir;
    private WebElement editar;
    private WebElement mensagem;

    public AnalisePO(WebDriver driver) {
        this.driver = driver;
    }

    public AnalisePO irParaPagina() {
        driver.get(SeleniumFactory.PATH + "/privado/secretaria/analise/lista_analise.xhtml");
        return this;
    }
    
    public AnalisePO clickInserir() {
        excluir = driver.findElement(By.id("bt_inserir"));
        inserir.click();
        return this;
    }

    public AnalisePO clickExcluir() {
        excluir = driver.findElement(By.id("form_analise:dt_analise:0:cb_excluir"));
        excluir.click();
        return this;
    }

    public AnalisePO clickEditar() {
        excluir = driver.findElement(By.id("form_analise:dt_analise:0:cb_editar"));
        editar.click();
        return this;
    }

    public WebElement getMensagem() {
        mensagem = driver.findElement(By.cssSelector("span.ui-growl-title"));
        return mensagem;
    }
}
