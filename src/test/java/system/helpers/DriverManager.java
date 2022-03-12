package system.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", ResourcesConstants.CHROME_DRIVER_PATH);

            // Propriedades para desativar mensagens vermelhas do chrome no console.
            System.setProperty("webdriver.chrome.silentOutput", "true");
            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

            // Instanciando o Driver e pondo uma espera implicita
            driver = new ChromeDriver();

            // Maximizando o browser
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriverWait getDriverWait(){
        if(wait == null){
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
