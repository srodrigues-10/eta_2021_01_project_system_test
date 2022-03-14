package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;

import static java.lang.Thread.*;

public class CompraPage {

    //Locators
    private By iconeLogin = By.cssSelector(".sd-login svg[aria-hidden='true'].icon");
    private By inputEmail = By.xpath("//*[@id=\"input\"]");
    private By inputSenha = By.cssSelector("input[name='senha']");
    private By buttonEntrar = By.cssSelector("div.fbits-box-login > form > div:nth-child(5) > button");
    private By telaProdutos = By.className("logoHome");
//    private By telaProdutosBar = By.cssSelector(".seguraMenuLemoon li:nth-child(1) > a > img");
    private By telaProdutosBar = By.xpath("div.seguraMenuLemoon > div > div > div > div > div > div > ul > li:nth-child(1) > a > img");
    private By produto = By.id("produto-spot-imagem-98490-1");
    private By buttonAddCarrinho = By.id("produto-botao-adicionar-carrinho-98490");


    //Ações inserir dados

    public void inserirEmail(String texto) {
        //Acessar tela de login
        DriverManager.getDriver().findElement(iconeLogin).click();

        //Inserir email válidos para o login
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(inputEmail));
        DriverManager.getDriver().findElement(inputEmail).clear();
        DriverManager.getDriver().findElement(inputEmail).sendKeys(texto);
    }

    //Inserir senha válida para o login
    public void inserirSenha(String texto) {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(inputSenha));
        DriverManager.getDriver().findElement(inputSenha).clear();
        DriverManager.getDriver().findElement(inputSenha).sendKeys(texto);
    }
    public void confirmarLogin() {
        DriverManager.getDriver().findElement(buttonEntrar).click();
    }
    public void acessarTelaProdutos(){
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(telaProdutos));
        DriverManager.getDriver().findElement(telaProdutos).click();
    }
    public void addProdutoCarrinho(){
        //Tela de produtos Bar
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(telaProdutosBar));
        DriverManager.getDriver().findElement(telaProdutosBar).click();
        //Selecionando produto
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(produto));
        DriverManager.getDriver().findElement(produto).click();
        //Adicionando ao carrinho
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(buttonAddCarrinho));
        DriverManager.getDriver().findElement(buttonAddCarrinho).click();
    }
}

