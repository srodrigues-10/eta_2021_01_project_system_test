package system.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import system.helpers.GeneralFuncions;
import system.pages.CadastroUsuarioPage;

public class CadastroUsuarioSteps {

    CadastroUsuarioPage cadastroUsuarioPage = new CadastroUsuarioPage();

    @Então("o usuário será redirecionado para a página de Cadastro com o título {string}")
    public void oUsuárioSeráRedirecionadoParaAPáginaDeCadastroComOTítulo(String titulo) {
        Assertions.assertEquals("CADASTRO", cadastroUsuarioPage.getTituloHeaderPaginaCadastro());
        Assertions.assertEquals(titulo, cadastroUsuarioPage.getTituloPaginaCadastro());
    }

    @Então("com a página de cadastro de Pessoa física exibida por default")
    public void comAPáginaDeCadastroDePessoaFísicaExibidaPorDefault() {
        Assertions.assertTrue(cadastroUsuarioPage.isRadioTipoPessoaFisicaSelecionado(), "Radio Button 'Pessoa Física' não está selecionado!");
    }

    @Quando("o usuário preencher todo o formulário com os dados {string}")
    public void oUsuárioPreencherTodoOFormulárioComOsDados(String planilhaDados) {

        //Inserindo Email
        String email = "alexsantos_" + GeneralFuncions.getDataHoraAtual() + "@gmail.com";
        System.out.println(email);
        cadastroUsuarioPage.preencherCampoEmail(email);
        GeneralFuncions.esperaFixa(1000);

        //Inserindo CPF
        String cpf = GeneralFuncions.geradorCPF(false);
        System.out.println(cpf);
        cadastroUsuarioPage.preencherCampoCPF(cpf);
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Nome do Destinatário
        cadastroUsuarioPage.preencherCampoNomeDestinatario("Alex da Silva Santos");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Nome Completo
        cadastroUsuarioPage.preencherCampoNomeCompleto("Alex da Silva Santos");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo CEP
        cadastroUsuarioPage.preencherCampoCEP("02860001");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Data de Nascimento
        cadastroUsuarioPage.preencherCampoDataNascimento("01021991");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Senha
        cadastroUsuarioPage.preencherCampoSenha("ab123456");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Confirmação de Senha
        cadastroUsuarioPage.preencherCampoConfirmacaoSenha("ab123456");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo DDD do telefone principal
        cadastroUsuarioPage.preencherCampoDDDTelPrincipal("11");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Telefone Principal
        cadastroUsuarioPage.preencherCampoTelPrincipal("33409292");
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Número do Endereço
        cadastroUsuarioPage.preencherCampoNumero("35");
        GeneralFuncions.esperaFixa(2000);

        //WA Validação CPF:
        int x = 0;
        while ((x < 20) && (cadastroUsuarioPage.getTextValidacaoCPF().length() > 0)){
            String newCpf = GeneralFuncions.geradorCPF(false);
            System.out.println("Novo CPF:" + newCpf);
            cadastroUsuarioPage.preencherCampoCPF(newCpf);
            cadastroUsuarioPage.clicarLabelCPF();
            x++;
        }

    }

    @Quando("clicar no botão Cadastrar")
    public void clicarNoBotãoCadastrar() {
        cadastroUsuarioPage.clicarBotaoCadastrar();
    }

}
