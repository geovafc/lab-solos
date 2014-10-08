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
    
    public static final String PATH = "http://localhost:8084/SOLOS/faces";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
