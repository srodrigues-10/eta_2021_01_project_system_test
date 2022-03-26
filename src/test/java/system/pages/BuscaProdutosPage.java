package system.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.DriverManager;
import system.helpers.GeneralFuncions;

public class BuscaProdutosPage extends BasePage {

//edrone-close-popup
    //Locators do menu para busca de produtos
    private By btnBuscarproduto = By.cssSelector("#btnBusca > svg");
    private By campodeBuscar = By.cssSelector(".container-fluid #txtBuscaPrincipal[placeholder='Digite sua busca']");
    private By poupMenu =By.cssSelector("#edrone--main--pu--container > div:nth-child(1) > span > div > span > div > div > img");

    //Locators da tela de busca
    private By termosSugeridos = By.cssSelector(".ac_results li:nth-child(2) span b");
    private By selOrdenarMenorPreco = By.cssSelector("#Parametro > option:nth-child(5)");
    private By labelTotaldeProd = By.cssSelector(".container-categoria .mostrando .fbits-qtd-produtos-pagina");


    //interações
    public void pesquisaPor(String texto) {

        clicarElementoVisivel(btnBuscarproduto);
        clicarElementoVisivel(poupMenu);
        clicarElementoVisivel(btnBuscarproduto);
        GeneralFuncions.esperaFixa(2000);
        escrever(campodeBuscar,texto);
        GeneralFuncions.esperaFixa(4000);
        clicarElementoVisivel(termosSugeridos);
        clicarElementoVisivel(selOrdenarMenorPreco);

    }
    public void clicaBotãoBusca() {
        DriverManager.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(btnBuscarproduto));
        clicarElementoVisivel(btnBuscarproduto);


    }
    public String getQtdeResultadoFiltrado() {
        return getTextoElemento(labelTotaldeProd);
    }



}
