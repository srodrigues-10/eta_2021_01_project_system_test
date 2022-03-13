package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;
import system.helpers.GeneralFuncions;

public class BasePage {

    //Ações com Mouser
    protected void clicar(By by) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        DriverManager.getDriver().findElement(by).click();
    }

    protected void clicarElementoVisivel(By by) {
        DriverManager.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        DriverManager.getDriver().findElement(by).click();
    }

    protected void mouseOverElementoVisivel(By by){
        DriverManager.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement elemento = DriverManager.getDriver().findElement(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(elemento).build().perform();
        GeneralFuncions.esperaFixa(1000);
    }


    //Ações com o teclado
    protected void escrever(By by, String texto) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        DriverManager.getDriver().findElement(by).clear();
        DriverManager.getDriver().findElement(by).sendKeys(texto);
    }


    //Açoes de recuperação de textos
    protected String getTituloPagina(){
        return DriverManager.getDriver().getTitle();
    }

    protected String getTextoElemento(By by) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return DriverManager.getDriver().findElement(by).getText();
    }

    //Ações com Radio ou Checkbox
    protected boolean isRadioSelecionado(By by) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return DriverManager.getDriver().findElement(by).isSelected();
    }

}
