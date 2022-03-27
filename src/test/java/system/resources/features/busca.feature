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
  @done @verificarPedidos
  Cenario: Verificar pedidos realizados
    Dado que o usuário acesse a página principal do site stanley
    Quando  realizar login com informações válidas "alexsantos_13032022150114@gmail.com" "ab123456"
    E selecionar o menu Meus Pedidos na página Minha Conta
    Então o usuário irá visualisar 6 pedidos