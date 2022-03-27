package system.pages;

import org.openqa.selenium.By;

public class MinhaContaPage extends BasePage{

    //Locators
    private By menuMeusPedidos = By.cssSelector("#menu-minha-conta > li:first-child > ul:first-child > li:first-child > a");
    private By quantidadePedidos = By.cssSelector(".fbits-minhaconta-order");

    //Ações
    public void clicarMenuMeusPedidos (){
        clicarElementoVisivel(menuMeusPedidos);
    }

    public int retornarQuantidadePedidos (){
        return getQuantidadeElementos(quantidadePedidos);
    }

}
