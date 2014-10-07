/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author bpmlab
 */
public class SeleniumFactory {
    
    private static final WebDriver driver = new FirefoxDriver();

    public static WebDriver getDriver() {
        return driver;
    }
}
