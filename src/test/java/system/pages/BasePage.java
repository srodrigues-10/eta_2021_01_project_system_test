package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;

public class BasePage {

    public void clicar(By by) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        DriverManager.getDriver().findElement(by).click();
    }

    public void escrever(By by, String texto) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        DriverManager.getDriver().findElement(by).sendKeys(texto);
    }

}
