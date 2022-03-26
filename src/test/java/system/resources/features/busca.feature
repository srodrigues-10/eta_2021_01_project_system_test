#language: pt

Funcionalidade: Feature correspondente aos cenários de busca no site Stanley

  #Rayane Ferreira
  @done @buscarProduto
  Esquema do Cenario: Realizar uma busca com filtros menor preço e contar quantidade de retorno
    Dado que o usuário acesse a página principal do site stanley
    Quando selecionar o botão de buscar
    E pesquisar por "Garrafa termica" filtrando por Menores preços
    Então o resultado da busca é apresentado na tela informando o <total_de_produtos>
    Exemplos:
      |total_de_produtos|
      |           "21"  |

  #Renato Veloso
  @verificarPedidos
  Cenario: Verificar pedidos realizados