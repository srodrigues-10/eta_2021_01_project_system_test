package system.stepDefinitions;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import system.pages.BuscaProdutosPage;

public class BuscaProdutoSteps {
    BuscaProdutosPage buscaProdutosPage = new BuscaProdutosPage();

    @Quando("selecionar o botão de buscar")
    public void selecionar_o_botão_de_buscar() {
        buscaProdutosPage.clicaBotãoBusca();
    }

    @Quando("pesquisar por {string} filtrando por Menores preços")
    public void pesquisar_por_filtrando_por(String string) {
        buscaProdutosPage.pesquisaPor("Garrafa termica");
    }

    @Então("o resultado da busca é apresentado na tela informando o {string}")
    public void o_resultado_da_busca_é_apresentado_na_tela_informando_o(String qtt) {
        Assertions.assertEquals(qtt, buscaProdutosPage.getQtdeResultadoFiltrado());
    }
}
