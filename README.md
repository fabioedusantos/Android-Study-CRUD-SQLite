# Android Study CRUD SQLite

Material didático desenvolvido para aulas de **desenvolvimento Android na FACOL**, em 2018, com o objetivo de demonstrar de forma prática a construção de um CRUD local e a interação entre componentes gráficos da interface e objetos persistidos em SQLite.

O repositório foi publicado como apoio às aulas e para permitir que os alunos consultassem posteriormente a implementação construída em sala.

> **Nome original do repositório:** `CrudComManipulacaodeObjetosGraficos`  
> **Nome recomendado:** `Android-Study-CRUD-SQLite`

## Objetivo didático

O exemplo reúne, em uma única tela, conceitos fundamentais do desenvolvimento Android em Java utilizados no contexto tecnológico de 2018:

- criação e manipulação de componentes de interface;
- associação entre dados da tela e objetos Java;
- modelagem de uma entidade de domínio;
- persistência local com SQLite;
- organização do acesso ao banco com DAO;
- operações de cadastro, consulta, alteração e exclusão;
- atualização da interface após alterações nos dados;
- validação simples de campos;
- eventos de clique e toque prolongado em `ListView`.

## Funcionalidades

O aplicativo mantém um cadastro local de usuários contendo **nome** e **senha**.

A tela permite:

- listar os usuários cadastrados;
- cadastrar um novo usuário;
- validar nome, senha e confirmação da senha;
- selecionar um usuário na lista para edição;
- atualizar os dados de um usuário existente;
- excluir um usuário por toque prolongado na lista;
- limpar o formulário e retornar ao estado de novo cadastro;
- informar o resultado das operações por meio de `Toast`.

## Fluxo da interface

```text
ListView de usuários
       |
       | toque simples
       v
Carrega usuário no formulário
       |
       v
Alteração + Salvar

ListView de usuários
       |
       | toque prolongado
       v
Exclusão no SQLite
```

O mesmo formulário é reutilizado para inclusão e alteração. A decisão é feita a partir do `id` do objeto `Usuario`: quando o identificador é zero, o fluxo executa um `INSERT`; caso contrário, executa um `UPDATE`.

## Estrutura do código

```text
app/src/main/java/com/fabio/professor/crudcommanipulaodeobjetosgrficos/
├── MainActivity.java
├── dao/
│   ├── DaoAdapter.java
│   ├── DaoUsuarios.java
│   └── ObjetoBanco.java
└── domain/
    └── Usuario.java
```

### `MainActivity`

Responsável pela interação com a interface, validação dos campos, preenchimento do formulário, atualização da lista e acionamento das operações do DAO.

### `Usuario`

Objeto de domínio simples com os atributos:

```text
id
nome
senha
```

### `DaoAdapter`

Centraliza a infraestrutura do SQLite por meio de `SQLiteOpenHelper` e fornece métodos auxiliares para executar comandos e consultas parametrizadas.

### `DaoUsuarios`

Implementa as operações de persistência específicas da entidade `Usuario`:

```text
INSERT
UPDATE
DELETE
SELECT
```

### `ObjetoBanco`

Converte o conteúdo retornado por um `Cursor` para uma estrutura de dados que permite recuperar os valores por nome de coluna e convertê-los para tipos Java básicos.

## Banco de dados

O aplicativo cria localmente o banco:

```text
aula
```

com a tabela:

```sql
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(30) NOT NULL,
    senha VARCHAR(100) NOT NULL
);
```

As consultas utilizam parâmetros (`?`) em vez de concatenar diretamente os valores recebidos pela interface.

## Tecnologias do projeto

O projeto preserva o ambiente utilizado nas aulas em 2018:

- Java;
- Android SDK 27;
- `minSdkVersion 15`;
- `targetSdkVersion 27`;
- Android Support Library 27.1.1;
- ConstraintLayout 1.1.0;
- SQLite / `SQLiteOpenHelper`;
- Gradle 4.4;
- Android Gradle Plugin 3.1.1.

## Como abrir

Por se tratar de um projeto histórico, versões atuais do Android Studio podem exigir ajustes de compatibilidade com Gradle, JDK e Android SDK.

O wrapper original aponta para:

```text
Gradle 4.4
```

Para estudar o código, basta clonar o repositório e abrir a raiz do projeto no Android Studio.

```bash
git clone https://github.com/fabioedusantos/CrudComManipulacaodeObjetosGraficos.git
```

## Observações sobre segurança e práticas atuais

Este repositório é **material didático histórico**, não uma referência de arquitetura ou segurança para aplicações atuais.

A senha presente no exemplo é armazenada em texto simples porque o objetivo da aula era demonstrar CRUD, objetos, interface e persistência SQLite. **Esse modelo não deve ser utilizado para armazenar senhas reais.** Aplicações de produção devem utilizar mecanismos adequados de autenticação e armazenamento seguro de credenciais.

Da mesma forma, em projetos Android modernos é comum utilizar soluções como AndroidX, RecyclerView, Room, ViewModel e outras APIs posteriores a este material. Elas não foram incorporadas aqui para preservar o exemplo no contexto em que foi ensinado.

## Contexto acadêmico

Este código foi criado por **Fábio Eduardo dos Santos** como material de apoio às aulas na **FACOL**, permitindo acompanhar em código conceitos apresentados e desenvolvidos durante as aulas presenciais.

O histórico Git foi reorganizado posteriormente para representar de forma mais legível os marcos técnicos do conteúdo originalmente construído, preservando o estado final do código-fonte de 2018.
