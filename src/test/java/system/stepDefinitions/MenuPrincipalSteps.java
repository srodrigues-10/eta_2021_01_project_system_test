package system.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.InvalidArgumentException;
import system.helpers.DriverManager;
import system.helpers.PagesURLConstants;
import system.pages.MenuPrincipalPage;

public class MenuPrincipalSteps {

    MenuPrincipalPage menuPrincipalPage = new MenuPrincipalPage();

    @Dado("que o usuário acesse a página principal do site stanley")
    public void queOUsuárioAcesseAPáginaPrincipalDoSiteStanley() {
        DriverManager.getDriver().get(PagesURLConstants.STANLEY_PMI_URL);
    }

    @Quando("selecionar no menu Usuario a opção {string}")
    public void selecionarNoMenuUsuarioAOpção(String opcaoMenu) {

        menuPrincipalPage.mouseOverBotaoUsuario();

        if (opcaoMenu.equals("Entre")) {
            menuPrincipalPage.clicarOpcaoUsuarioEntrar();

        } else if (opcaoMenu.equals("Cadastre-se")) {
            menuPrincipalPage.clicarOpcaoUsuarioCadastrar();

        } else if (opcaoMenu.equals("Meus Pedidos")) {
            menuPrincipalPage.clicarOpcaoUsuarioMeusPedidos();

        } else {
            throw new InvalidArgumentException("Argumento está inválido!");
        }

    }

}
