package system.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import system.helpers.GeneralFuncions;
import system.helpers.ResourcesConstants;
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
        System.out.println("Novo email gerado:" + email);
        cadastroUsuarioPage.preencherCampoEmail(email);
        GeneralFuncions.esperaFixa(1000);

        //Inserindo CPF
        String cpf = GeneralFuncions.geradorCPF(false);
        System.out.println("Primeiro CPF gerado: " + cpf);
        cadastroUsuarioPage.preencherCampoCPF(cpf);
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Nome do Destinatário
        cadastroUsuarioPage.preencherCampoNomeDestinatario(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "NOME_DESTINATARIO"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Nome Completo
        cadastroUsuarioPage.preencherCampoNomeCompleto(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "NOME_COMPLETO"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo CEP
        cadastroUsuarioPage.preencherCampoCEP(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "CEP"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Data de Nascimento
        cadastroUsuarioPage.preencherCampoDataNascimento(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "DATA_NASCIMENTO"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Senha
        cadastroUsuarioPage.preencherCampoSenha(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "SENHA"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Confirmação de Senha
        cadastroUsuarioPage.preencherCampoConfirmacaoSenha(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "SENHA"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo DDD do telefone principal
        cadastroUsuarioPage.preencherCampoDDDTelPrincipal(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "DDD_TELEFONE_PRINCIPAL"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Telefone Principal
        cadastroUsuarioPage.preencherCampoTelPrincipal(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "TELEFONE_PRINCIPAL"));
        GeneralFuncions.esperaFixa(1000);

        //Inserindo Número do Endereço
        cadastroUsuarioPage.preencherCampoNumero(GeneralFuncions.capturarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH,
                "NUMERO_ENDERECO"));
        GeneralFuncions.esperaFixa(2000);

        //WA Validação CPF:
        int x = 0;
        while ((x < 20) && (cadastroUsuarioPage.getTextValidacaoCPF().length() > 0)){
            cpf = GeneralFuncions.geradorCPF(false);
            System.out.println("Novo CPF:" + cpf);
            cadastroUsuarioPage.preencherCampoCPF(cpf);
            cadastroUsuarioPage.clicarLabelCPF();
            x++;
        }

        //Alteração dos novos dados gerados para o usuário na planilha de dados
        GeneralFuncions.alterarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH, "NOVO_CPF", cpf);
        GeneralFuncions.alterarValorDoXLSX(ResourcesConstants.DATA_CAD_PESSOAS_FISICAS_PATH, "NOVO_EMAIL", email);

    }

    @Quando("clicar no botão Cadastrar")
    public void clicarNoBotãoCadastrar() {
        cadastroUsuarioPage.clicarBotaoCadastrar();
    }

}
