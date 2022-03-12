package system.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class Hooks {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void before() {
        // SETUP
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    @After
    public void after() {
        //TEAR DOWN
        DriverManager.quitDriver();
    }

}
