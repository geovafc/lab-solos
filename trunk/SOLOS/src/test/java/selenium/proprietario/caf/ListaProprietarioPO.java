/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.proprietario.caf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.SeleniumFactory;

/**
 *
 * @author bpmlab
 */
public class ListaProprietarioPO {

    private static WebDriver driver = SeleniumFactory.getDriver();

    @FindBy(id = "bt_inserir")
    private WebElement inserir;
    @FindBy(id = "cb_excluir")
    private WebElement excluir;
    @FindBy(id = "cb_editar")
    private WebElement editar;

    public ListaProprietarioPO clickInserir() {
        inserir.click();
        return this;
    }

    public ListaProprietarioPO clickExcluir() {
        excluir.click();
        return this;
    }

    public ListaProprietarioPO clickEditar() {
        editar.click();
        return this;
    }

}
