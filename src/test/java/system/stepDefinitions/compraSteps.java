package system.stepDefinitions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import system.pages.CompraPage;

public class compraSteps {

    CompraPage compraPage = new CompraPage();

    @Dado("realizar login com informações válidas {string} {string}")
    public void realizar_login_com_informações_válidas(String email, String senha) {
        compraPage.inserirEmail(email);
        compraPage.inserirSenha(senha);
        compraPage.confirmarLogin();
    }

    @Quando("inserir um produto no carrinho")
    public void inserir_um_produto_no_carrinho() {
        compraPage.acessarTelaProdutos();
        compraPage.addProdutoCarrinho();

    }

    @Quando("acessar o carrinho")
    public void acessar_o_carrinho() {

    }

    @Então("deverá finalizar a compra por boleto")
    public void deverá_finalizar_a_compra_por_boleto() {

    }

}
