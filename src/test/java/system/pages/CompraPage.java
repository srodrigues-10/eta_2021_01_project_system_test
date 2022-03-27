package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;
import system.helpers.GeneralFuncions;

import static java.lang.Thread.*;

public class CompraPage extends BasePage{

    //Locators
    private By iconeLogin = By.cssSelector(".sd-login svg[aria-hidden='true'].icon");
    private By inputEmail = By.xpath("//*[@id=\"input\"]");
    private By inputSenha = By.cssSelector("input[name='senha']");
    private By buttonEntrar = By.cssSelector("div.fbits-box-login > form > div:nth-child(5) > button");
    private By telaProdutos = By.className("logoHome");
    private By telaProdutosBar = By.cssSelector(".item:first-child .menu-geral");
    private By produto = By.id("produto-spot-imagem-98490-1");
    private By produtoMenor = By.id("produto-spot-imagem-98490-2");
    private By aceitarCookies = By.cssSelector("#bodyProduto > footer > div.lgpd-modal > div > div.content-right > div > a");
    private By permitirCookies = By.cssSelector("a[class='aceitar-cookies']");
    private By buttonComprar = By.cssSelector("input[value='COMPRAR']");
    private By buttonFinalizarCompra = By.cssSelector(".btfinalizar:nth-child(1)");
    private By buttonTipoFrete = By.cssSelector("input[type=\"radio\"]:nth-child(1)");
    private By pagBoleto = By.id("g2237-tab");
    private By efetuarCompra = By.cssSelector("input[value='Finalizar Compra']");

    //Ações inserir dados

    public void inserirEmail(String texto) {
        //Acessar tela de login
        DriverManager.getDriver().findElement(iconeLogin).click();
        escrever(inputEmail, texto);
    }

    //Inserir senha válida para o login
    public void inserirSenha(String texto) {
        escrever(inputSenha, texto);
    }
    public void confirmarLogin() {
        clicarElementoVisivel(buttonEntrar);
    }
    public void acessarTelaProdutos(){
        clicarElementoVisivel(telaProdutos);
    }
    public void addProdutoCarrinho(){
        //Tela de produtos Bar
        clicarElementoVisivel(telaProdutosBar);
        //Selecionando produto
        clicarElementoVisivel(permitirCookies);
        GeneralFuncions.esperaFixa(1000);
        mouseOverElementoVisivel(produto);
        GeneralFuncions.esperaFixa(1000);
        clicarElementoVisivel(produtoMenor);
        //Adicionando ao carrinho
        clicar(buttonComprar);
    }

    public void finalizarCompra(){
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(buttonFinalizarCompra));
        GeneralFuncions.esperaFixa(3000);
        DriverManager.getDriver().findElement(buttonFinalizarCompra).click();
    }
    public void selecionarTipoFrete(){
        clicarElementoVisivel(buttonTipoFrete);
    }
    public void selecionarFromaPagamento(){
        clicarElementoVisivel(pagBoleto);
        GeneralFuncions.esperaFixa(3000);
    }
    public void efetuarCompra(){
        clicarElementoVisivel(efetuarCompra);
        GeneralFuncions.esperaFixa(6000);
    }

}

