<h1 align="center">📚 Aplicação utilizando JFrame - Programação Orientada a Objetos II</h1>

<p align="center">

![app overview](./.github/assets/images/2022-05-07_17-48.png)

</p>

> Avaliação aplicada pelo professor Adriano Maia.

## 📢 Sobre a Questão

Devemos criar um programa utilizando a biblioteca JFrame responsável que será responsável por cadastrar um usuário 
em um determinado sistema.

### 📋 Critérios avaliados

1. Criar mascarás para o CPF, RG e Números telefonicos.;
2. Campos que foram definidos no slide devem ser obrigatórios;
3. O usuário deve conseguir cadastrar, alterar, excluir e pesquisar um usuário;
4. Código precisa ser autoral e se desejável validações;

## 🎯 Ferramentas utilizadas no desenvolvimento da aplicação:

- `Java 18`
- `openjdk-18-jre`
- `openjdk-18-jdk`
- `IntelliJ IDEA`
- `GIT`

## 📚 Oque está sendo entregue

Nessa aplicação o funcionário vai conseguir ter todo o processo de CRUD de um usuário.
Além disso as classes possuem validação e tratamento de exceções, para que o usuário não possa fazer algo que não deveria.
Para melhor escalabilidade da aplicação, foi utilizado o padrão de projeto `Micro Service`,
onde cada classe é responsável por uma única funcionalidade e nada mais que isso.

Para uma compravação de um código funcinal, foi utilizado do [GitHubActions](https://github.com/features/actions) responsável por ci/cd,
que testará o código e verificará se está funcionando corretamente em cada `push` e `pull-request` feita no repo.

Para gerar um arquivo executável foi utilizado um script que gerava um `.jar` a cada versão da aplicação.

## 🦥 Futuras atualizações

Dentro da aplicação, pode-se encontrar alguns _TODOS_ que vão ser implementados como forma externa a avaliação, com 
o intuito de melhorar a qualidade do código.

- `Adaptação da classe UTILS`: Será removido algumas lógicas que são repetitivas para um Utils, onde todo o contexto 
  poderá utilizar.
- `Reescrita de algumas regras de négocio`: Será reescrita algumas regras de négocio para melhorar a performance da aplicação.

## 🚀 Releases

Cada release foi gerada por uma `Command Line Interface` (CLI) chamada [GitHub CLI](https://cli.github.com/).
As releases são categorizadas por versão da aplicação, onde cada uma possui um nome e um arquivo executável.

Caso queira uma release mais recente ou especifica, basta [clicar aqui](https://github.com/deverebor/jframe-user-registration/releases/).

---

<p align='center'>
  Developer with ❤️‍🔥 by Lucas Souza (@deverebor)
</p>
