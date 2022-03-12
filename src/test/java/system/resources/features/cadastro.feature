#language: pt

  @cadastro
  Funcionalidade: Feature correspondente aos cenários de cadastros em geral do site Stanley

    @done
    Cenario: Realizar cadastro de usuário com sucesso
      Dado que o usuário acesse a página principal do site stanley
      Quando selecionar no menu Usuario a opção "Cadastre-se"
      Então o usuário será redirecionado para a página de Cadastro com o título "Cadastro - Stanley"
      E com a página de cadastro de Pessoa física exibida por default
      Quando o usuário preencher todo o formulário com os dados "cadastro_pessoa_fisica.xlsx"
      E clicar no botão Cadastrar



