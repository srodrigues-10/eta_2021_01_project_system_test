package system.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import system.pages.CadastroUsuarioPage;

public class CadastroUsuarioSteps {

    CadastroUsuarioPage cadastroUsuarioPage = new CadastroUsuarioPage();

    @Então("o usuário será redirecionado para a página de Cadastro com o título {string}")
    public void oUsuárioSeráRedirecionadoParaAPáginaDeCadastroComOTítulo(String titulo) {
        Assertions.assertEquals(titulo, cadastroUsuarioPage.getTituloPaginaCadastro());
    }

    @Então("com a página de cadastro de Pessoa física exibida por default")
    public void comAPáginaDeCadastroDePessoaFísicaExibidaPorDefault() {
        Assertions.assertTrue(cadastroUsuarioPage.isRadioTipoPessoaFisicaSelecionado(), "Radio Button 'Pessoa Física' não está selecionado!");
    }

    @Quando("o usuário preencher todo o formulário com os dados {string}")
    public void oUsuárioPreencherTodoOFormulárioComOsDados(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("clicar no botão Cadastrar")
    public void clicarNoBotãoCadastrar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
