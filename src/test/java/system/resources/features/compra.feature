#language: pt

Funcionalidade: Feature correspondente ao cenário de efetuar compra por boleto

  @done @compra
  Cenario:Efetuar compra por  boleto
    Dado que o usuário acesse a página principal do site stanley
    Quando  realizar login com informações válidas "alexsantos_13032022150114@gmail.com" "ab123456"
    E inserir um produto no carrinho
    Então deverá finalizar a compra por boleto



