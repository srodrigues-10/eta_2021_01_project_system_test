package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;

public class MenuPrincipalPage extends BasePage {

    //Locators
    private By menuBar = By.cssSelector(".container-fluid .menu > li:nth-child(1) > a");
    private By menuCafe = By.cssSelector(".container-fluid .menu > li:nth-child(2) > a");
    private By menuHidratacao = By.cssSelector(".container-fluid .menu > li:nth-child(3) > a");
    private By menuMate = By.cssSelector(".container-fluid .menu > li:nth-child(4) > a");
    private By menuCamping = By.cssSelector(".container-fluid .menu > li:nth-child(5) > a");
    private By menuAtendimento = By.cssSelector(".container-fluid .menu > li:nth-child(6) > a");
    private By btnBuscar = By.cssSelector(".container-fluid #btnBusca");
    private By btnUsuario = By.cssSelector(".container-fluid .sd-login");
    private By selUsuarioEntrar = By.cssSelector(".container-fluid .sd-login .usuario_nao_identificado > a.fbits-login-link-login");
    private By selUsuarioCadastrar = By.cssSelector(".container-fluid .sd-login .usuario_nao_identificado > a.fbits-login-link-cadastro");
    private By selUsuarioMeusPedidos = By.cssSelector(".container-fluid .sd-login .usuario_nao_identificado > a.fbits-login-link-pedidos");
    private By btnCarrinho = By.cssSelector(".container-fluid .cart__icon");

    //Ações
    public void mouseOverBotaoUsuario(){
        mouseOverElementoVisivel(btnUsuario);
    }

    public void clicarOpcaoUsuarioEntrar (){
        clicarElementoVisivel(selUsuarioEntrar);
    }

    public void clicarOpcaoUsuarioCadastrar (){
        clicarElementoVisivel(selUsuarioCadastrar);
    }

    public void clicarOpcaoUsuarioMeusPedidos (){
        clicarElementoVisivel(selUsuarioMeusPedidos);
    }

}
