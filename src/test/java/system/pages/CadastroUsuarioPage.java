package system.pages;

import org.openqa.selenium.By;
import system.helpers.GeneralFuncions;

public class CadastroUsuarioPage extends BasePage{

    //Locators Dados Pessoais
    private By tituloHeaderCadastro = By.cssSelector(".header-cadastro > h1");
    private By radioTipoPessoaFisica = By.cssSelector("#TipoPessoa[value='PessoaFisica']");
    private By campoEmail = By.cssSelector("input[name='Email']");
    private By campoCPF = By.cssSelector("input[name='CPF']");
    private By labelCPF = By.cssSelector("label[for='CPF']");
    private By campoNomeCompleto = By.cssSelector("input[name='NomeCompleto']");
    private By campoDataNascimento = By.cssSelector("input[name='DataNascimento']");
    private By campoSenha = By.cssSelector("input[name='Senha']");
    private By campoConfirmacaoSenha = By.cssSelector("input[name='ConfirmacaoSenha']");
    private By campoDDDTelPrincipal = By.cssSelector("input[name='TelefonePrincipalDDD']");
    private By campoTelPrincipal = By.cssSelector("input[name='TelefonePrincipal']");
    private By msgErroValidacaoCPF = By.cssSelector("span[data-valmsg-for='CPF']");

    //Locators Endereço de Cadastro
    private By labelCampoCEP = By.cssSelector("label[for='CEP']");
    private By campoNomeDestinatario = By.cssSelector("input[name='NomeEndereco']");
    private By campoCEP = By.cssSelector("input[name='CEP']");
    private By campoNumero = By.cssSelector("input[name='Numero']");

    //Lacators Botões
    private By btnCadastrar = By.cssSelector("button[type='submit'].btn-primary");


    //Ações
    public String getTituloPaginaCadastro() {
        return getTituloPagina();
    }

    public String getTituloHeaderPaginaCadastro(){
        return getTextoElemento(tituloHeaderCadastro);
    }

    public String getTextValidacaoCPF(){
        GeneralFuncions.esperaFixa(2000);
        return getTextoElemento(msgErroValidacaoCPF);
    }

    public void clicarLabelCPF(){
        clicar(labelCPF);
    }

    public boolean isRadioTipoPessoaFisicaSelecionado(){
        return isRadioSelecionado(radioTipoPessoaFisica);
    }

    public void clicarBotaoCadastrar(){
        clicar(btnCadastrar);
    }

    public void preencherCampoEmail(String email){
        escrever(campoEmail, email);
    }

    public void preencherCampoCPF(String cpf){
        escrever(campoCPF, cpf);
    }

    public void preencherCampoNomeDestinatario(String nomeDestinatario){
        escrever(campoNomeDestinatario, nomeDestinatario);
    }

    public void preencherCampoNomeCompleto(String nomeCompleto){
        escrever(campoNomeCompleto, nomeCompleto);
    }

    public void preencherCampoCEP(String cep){
        escrever(campoCEP, cep);
    }

    public void preencherCampoDataNascimento(String dataNascimento){
        escrever(campoDataNascimento, dataNascimento);
    }

    public void preencherCampoSenha(String senha){
        escrever(campoSenha, senha);
    }

    public void preencherCampoConfirmacaoSenha(String senha){
        escrever(campoConfirmacaoSenha, senha);
    }

    public void preencherCampoDDDTelPrincipal(String DDDTelPrincipal){
        escrever(campoDDDTelPrincipal, DDDTelPrincipal);
    }

    public void preencherCampoTelPrincipal(String TelPrincipal){
        escrever(campoTelPrincipal, TelPrincipal);
    }

    public void preencherCampoNumero(String numero){
        escrever(campoNumero, numero);
    }

}
