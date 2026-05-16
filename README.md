# Sistema de Gerenciamento da Padaria Unipão

Este é um sistema de gerenciamento comercial desenvolvido em Java, aplicando os pilares da Programação Orientada a Objetos (POO), arquitetura MVC (Model-View-Controller) e o padrão DAO (Data Access Object) para persistência em banco de dados relacional.

## Tecnologias Utilizadas
* **Java 21**
* **Maven** (Gerenciamento de dependências)
* **MySQL** (Banco de dados relacional)
* **JDBC** (Conexão com o banco)

## Estrutura do Projeto
* `Model`: Classes de domínio (Produto, Cliente, Venda, etc.)
* `View`: Interface de interação e execução do sistema.
* `Controller`: Regras de negócio e intermediação.
* `DAO`: Manipulação de dados e comandos SQL (INSERT, SELECT, UPDATE).
* `Connection`: Gerenciamento da conexão com o MySQL.

## Como rodar o projeto localmente

### 1. Configurar o Banco de Dados
1. Abra o seu gerenciador de banco de dados (MySQL Workbench, DBeaver, etc.).
2. Localize o arquivo `script_padaria.sql` dentro da pasta `database/` na raiz deste projeto.
3. Execute todo o conteúdo do script. Ele criará automaticamente o banco de dados `padaria_poo`, as tabelas, os dados iniciais e um usuário dedicado (`padaria_app`) com as permissões corretas para a aplicação rodar.

### 2. Configurar a Conexão
Mude "Seu_Usuario" e "Sua_Senha" em Conexao dentro de Connection.

```java
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";