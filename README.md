# <p>Trabalho-OO-FGA0158</p>
UnB - Universidade de Brasilia<br>
FGA - Faculdade do Gama<br>
OO - Orientação por Objetos<br>
Prof. André Luiz Peron Martins Lanna

## :octocat: Integrantes do Projeto

| [![Euller Vasco da Gama](https://avatars.githubusercontent.com/u/125329742?v=4)](https://github.com/Potatoyz908) | [![Kaiky](https://avatars.githubusercontent.com/u/17420604?v=4)](https://github.com/kaikysousa) | [![Pedro](https://avatars.githubusercontent.com/u/142694744?v=4)](https://github.com/314dro) | [![Tiago Antunes](https://avatars.githubusercontent.com/u/143669941?s=400&u=b16d161f8a130c590d63271ea41f4dd02d3c573d&v=4)](https://github.com/TiagoBalieiro) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Euller Júlio da Silva | Kaiky Dourado Mendes de Sousa | Pedro Henrique Martins Silva | Tiago Antunes Balieiro 
231026714 | 231035277 | 231029270 | 231011838 |

## Resumo do Projeto

### Objetivo

Desenvolver um sistema de cadastro e gerenciamento de alunos, professores, disciplinas e turmas para a Universidade de Brasília (UnB). O sistema é desenvolvido em Java e utiliza a interface gráfica Swing para facilitar a interação com o usuário.

### Funcionalidades Principais

#### Cadastro de Alunos
- Gerenciamento das informações dos alunos, incluindo matrícula, nome e dados pessoais.
- Funcionalidades para adicionar, buscar, atualizar e remover alunos.

#### Cadastro de Professores
- Registro e atualização dos dados dos professores, como matrícula, nome e áreas de atuação.
- Funcionalidades para adicionar, buscar, atualizar e remover professores.

#### Cadastro de Disciplinas
- Adição e manutenção das disciplinas oferecidas pela universidade.
- Armazena informações como código da disciplina e nome.
- Funcionalidades para adicionar, buscar, atualizar e remover disciplinas.

#### Cadastro de Turmas
- Associação de alunos e professores às turmas.
- Definição da capacidade da turma e matrícula de alunos em turmas específicas.
- Funcionalidades para cadastrar, buscar, atualizar, remover turmas e imprimir lista de presença.

### Exceções

O sistema implementa várias exceções personalizadas para garantir a integridade dos dados e a consistência das operações:

- **CampoEmBrancoException**: Lançada quando um campo obrigatório (nome, código, horário) está vazio durante o cadastro ou atualização.
- **DisciplinaNaoAtribuidaException**: Lançada quando uma turma não tem uma disciplina ou professor associado.
- **NumeroIncorretoAlunosException**: Lançada quando o número de alunos matriculados não corresponde ao esperado.
- **NumeroMaximoAlunosException**: Lançada quando a tentativa de adicionar um aluno excede a capacidade máxima da turma.

### Processos e Interação

- **Cadastro de Turmas**: Permite associar uma turma a uma disciplina e a um professor, além de definir a quantidade de vagas e matricular alunos.
- **Atualização de Turmas**: Permite alterar informações da turma, como nome, código, horário e quantidade de vagas. O sistema verifica se as alterações são válidas, atualiza a lista de alunos se necessário e garante que a capacidade da turma não seja excedida.
- **Remoção de Alunos e Turmas**: Permite a remoção de alunos de uma turma e a exclusão de turmas do sistema.
- **Impressão de Lista de Presença**: Gera uma lista de presença para uma turma específica, exibindo o código da turma, o nome da disciplina, o nome do professor e os alunos matriculados.

### Modelagem e Ferramentas

- **UML (Linguagem de Modelagem Unificada)**: Utilizada para modelar a estrutura e os processos do sistema, garantindo uma organização clara e a integridade do projeto.
- **Trello**: Utilizado para o gerenciamento de tarefas e acompanhamento do progresso do desenvolvimento.
- **Lucidchart**: Utilizado para a criação de diagramas e visualização dos processos e fluxos de dados.

### Interface Gráfica

Desenvolvida em Swing, a interface gráfica proporciona uma interação intuitiva com o sistema, permitindo realizar operações através de menus e diálogos.

### Desafios e Soluções

- **Gerenciamento Dinâmico de Vagas**: Aumentar ou diminuir a quantidade de vagas nas turmas exige uma gestão eficiente do array de alunos, garantindo que o sistema não quebre ao adicionar ou remover alunos.
- **Validação de Dados**: Implementação de verificações rigorosas para garantir que todos os dados estejam corretos e que as operações sejam realizadas de forma consistente.



## Features

- [x] Cadastro de Alunos
- [x] Cadastro de Professores
- [x] Cadastro de Disciplinas
- [x] Cadastro de Turmas
- [x] Print da Lista de Presença
- [x] Implementação de Exceções
- [x] Uso dos conceitos de OO:

- Encapsulamento
- Herança
- Polimorfismo

## ☕ Como executar o projeto (WINDOWS)
1. Certifique-se de ter uma versão do Java atualizada e o OpenJDK. Sugiro que caso tenha instalado a versão Java 1.8, desinstale-a e instale uma nova versão com o JDK para evitar instabilidades.
   Segue o link para instalar a versão mais recente Java/jdk:

   [![Baixar JDK](https://img.shields.io/badge/Download_JDK-Oracle-red)](https://www.oracle.com/java/technologies/downloads/?er=221886#jdk22-windows)

3. Para executar o projeto é bem simples, basta instalar o arquivo `TPOO.jar` na sua máquina e executá-lo.
4. Outra forma é executar o arquivo pelo terminal entrando no diretório em que o arquivo .jar se encontra:
   ```
   cd C:\Caminho\Para\O\Diretório
   ```
   substitua `C:\Caminho\Para\O\Diretório` pelo caminho real onde o arquivo `TPOO.jar` está.
   Agora use o comando `java -jar TPOO.jar` para executar o arquivo `.jar`.
   ```
   java -jar TPOO.jar
   ```
## ☕ Como executar o projeto (LINUX-DEBIAN)
1. Certifique-se de ter uma versão atualizada do Java. Você pode instalar o OpenJDK, que é uma versão open-source do JDK. Para instalar a versão mais recente do OpenJDK, você pode usar o seguinte comando no terminal:
   ```
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
   Substitua `openjdk-17-jdk` pelo número da versão desejada, se necessário. Certifique-se de verificar a versão recomendada para o seu projeto.
2. Instale e execute o arquivo `TPOO.jar`.
3. Outra forma é executar o arquivo pelo terminal entrando no diretório em que o arquivo .jar se encontra:
   ```
   cd /caminho/para/o/diretório
   ```
   Substitua `/caminho/para/o/diretório` pelo caminho real onde o arquivo `TPOO.jar` está.
   Agora use o comando `java -jar TPOO.jar` para executar o arquivo `.jar`.
   ```
   java -jar TPOO.jar
   ```
   Certifique-se de que o arquivo `TPOO.jar` tenha permissões de execução. Se necessário, ajuste as permissões com:
   ```
   chmod +x TPOO.jar
   ```
 ## 💻 Exemplos de execução

### Imagens de funcionamento do programa:

| ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura1) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura2) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura3) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura4) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Tela específica de cada cadastro                                                | Tela dos CRUDs                                                  | Tela de preenchimento de dados                                                     | Tela de sucesso ao cadastrar                                   |


| ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura1) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura2) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura10.png) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura5.png) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Tela específica de cada cadastro                                              | Tela dos CRUDs                                                  | Tela de preenchimento de dados      | Tela de sucesso ao pesquisar  

| ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura1) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura2) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura6.png) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura7.png) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Tela específica de cada cadastro                                              | Tela dos CRUDs                                                  | Tela de preenchimento de dados                                                     | Tela de sucesso ao atualizar                                  |

| ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura1) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura2) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura9.png) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura8.png) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Tela específica de cada cadastro                                              | Tela dos CRUDs                                                  | Tela de preenchimento de dados                                                     | Tela de sucesso ao remover                                  |

| ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura1) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura12.png) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura13.png) | ![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Captura11.png) |
|-------------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Tela específica de cada cadastro                                              | Tela dos CRUDs                                                  | Tela de preenchimento de dados                                                     | Tela de sucesso ao imprimir lista de presença                                |


## <p>🛠 Ferramentas</p>

## <img src="https://img.icons8.com/color/48/000000/trello.png" alt="Trello"/> Gerenciamento de projeto

Foi acordado entre os membros da equipe que a modelagem do projeto seria realizada utilizando o Trello. Esta ferramenta foi escolhida para minimizar eventuais erros estruturais e para orientar nosso desenvolvimento. Além disso, o quadro do Trello foi atualizado conforme as necessidades do projeto ao longo do seu desenvolvimento. Confira o quadro do Trello desenvolvido na imagem 1 a seguir.

![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/Trello.png)

Imagem 1: Quadro de Gerenciamento de Projeto no Trello<br>
Ref.: autoria própria. (Desenvolvido em [Trello](https://trello.com))

## <img height="40" width="40" src="https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/lucidchart.png" alt="Lucidchart"/> Modelagem

Como foi definido no cenário, foi acordado entre os membros a modelagem do projeto utilizando a Linguagem de Modelagem Unificada (UML) para a minimalização de eventuais erros estruturais, além de guiar nosso desenvolvimento. Somado a isso, vale ressaltar que o artefato Diagrama de Classes UML desenvolvido foi atualizado conforme a necessidade durante o desenvolvimento do projeto. Confira o artefato UML desenvolvido na imagem 2 a seguir.

![](https://github.com/TiagoBalieiro/TP-Orientacao-a-Objetos/blob/main/imgs/TP00.png)

Imagem 2: artefato Diagrama de Classes UML<br>
[![ABRIR UML](https://img.shields.io/badge/ABRIR_UML-F57F17?style=for-the-badge&logo=lucidchart&logoColor=white)](https://lucid.app/lucidchart/ae1d3b43-800a-448b-a7fc-fb16b956549b/edit?viewport_loc=747%2C69%2C5578%2C2699%2CHWEp-vi-RSFO&invitationId=inv_b0ac075d-a917-4c88-bc21-54b5a816569a)<br>
Ref.: autoria própria. (Desenvolvido em [Lucidchart](https://www.lucidchart.com))

