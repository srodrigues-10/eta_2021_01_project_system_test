package system.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import system.pages.MinhaContaPage;

public class MinhaContaSteps {

    MinhaContaPage minhaContaPage = new MinhaContaPage();

    @Quando("selecionar o menu Meus Pedidos na página Minha Conta")
    public void selecionarOMenuMeusPedidosNaPáginaMinhaConta() {
        minhaContaPage.clicarMenuMeusPedidos();
    }

    @Então("o usuário irá visualisar {int} pedidos")
    public void oUsuárioIráVisualisarPedidos(Integer qtdPedidos) {
        Assertions.assertEquals(qtdPedidos, minhaContaPage.retornarQuantidadePedidos());
    }

}
