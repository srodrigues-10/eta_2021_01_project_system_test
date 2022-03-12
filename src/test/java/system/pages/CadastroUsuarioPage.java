package system.pages;

import org.openqa.selenium.By;

public class CadastroUsuarioPage extends BasePage{

    //Locators
    private By radioTipoPessoaFisica = By.cssSelector("#TipoPessoa[value='PessoaFisica']");
    private By radioTipoPessoaJuridica = By.cssSelector("#TipoPessoa[value='PessoaJuridica']");


    //Ações
    public String getTituloPaginaCadastro() {
        return getTituloPagina();
    }

    public boolean isRadioTipoPessoaFisicaSelecionado(){
        return isRadioSelecionado(radioTipoPessoaFisica);
    }

    public boolean isRadioTipoPessoaJuridicaSelecionado(){
        return isRadioSelecionado(radioTipoPessoaJuridica);
    }
}
