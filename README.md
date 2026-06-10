# Sistema de Biblioteca

Projeto desenvolvido para a disciplina de **Desenvolvimento de Sistemas** — 2° DS.

## Objetivo

Sistema em **Java** para gerenciamento de uma biblioteca escolar. A proposta é oferecer uma solução completa para cadastro de livros e leitores, com suporte a edição e remoção de registros, tudo por meio de uma interface gráfica construída com **Java Swing**.

O sistema conta com dois perfis de acesso: o **Admin**, que tem controle total sobre o acervo e os leitores cadastrados, e o **Leitor**, que pode visualizar os livros disponíveis e montar sua própria lista de favoritos. O acesso é feito por uma tela de login com nome e senha.

## Como rodar o projeto

**Pré-requisitos:** ter o [JDK](https://www.oracle.com/java/technologies/downloads/) instalado na máquina.

**1. Clone o repositório:**
```bash
git clone https://github.com/byFranca/biblioteca-java-swing
cd biblioteca-java-swing
```

**2. Compile todos os arquivos:**
```bash
javac *.java
```

**3. Execute o programa:**
```bash
java Main
```

**Credenciais de acesso:**

| Perfil | Nome | Senha |
|--------|------|-------|
| Admin | admin | 1234 |
| Leitor | Miguel | 1234 |
| Leitor | Maria | 1234 |
| Leitor | Murilo | 1234 |

## Etapas de desenvolvimento
- [x] Lógica em console
- [x] Interface com Java Swing

---

O projeto foi estruturado em duas fases, de forma intencional:

### 1. Lógica em console
Antes de partir para a interface visual, toda a lógica do sistema foi desenvolvida e validada no terminal. Essa etapa envolveu:
- Modelagem das classes `Livro` e `Leitor`, cada uma com seus atributos e métodos próprios
- Uso de `ArrayList` para armazenar e manipular os registros em memória
- Menus interativos com `Scanner`, `do/while` e `switch/case`
- Tela de login que direciona o usuário para o menu correto de acordo com seu perfil
- CRUD completo de livros: cadastrar, listar, editar e remover
- CRUD completo de leitores: cadastrar, listar e remover
- Área do leitor: visualizar o acervo e gerenciar a lista de favoritos
- Tratamento de erros para entradas inválidas

### 2. Interface com Java Swing
Com a lógica já funcional, ela foi integrada a uma interface gráfica construída com **Java Swing**, composta por:
- Tela de login com validação de perfil (admin ou leitor)
- Menu admin com tabela dinâmica de livros e leitores
- Cadastro, edição e remoção de livros e leitores via formulários
- Barra de menus para navegação entre seções
- Tela do leitor com visualização do acervo e gerenciamento de favoritos
- Caixas de diálogo para confirmações e alertas
- Validações de campos em todos os formulários

## Estrutura do projeto

```
biblioteca-java-swing/
├── exercicios_fixacao/     # Exercícios de fixação do Java Swing
│   ├── Ex1.java
│   ├── Ex2.java
│   └── ...
├── parte_logica/           # Fase console do projeto
│   └── BibliotecaLogica.java
├── Main.java               # Ponto de entrada — inicializa os dados e abre o login
├── Livro.java              # Modelo de livro com getters e setters
├── Leitor.java             # Modelo de leitor com getters e setters
├── TelaLogin.java          # Tela de login com validação de perfil
├── TelaAdmin.java          # Menu do administrador com tabela dinâmica
├── TelaLeitor.java         # Menu do leitor com acervo e favoritos
├── TelaCadastrar.java      # Formulário de cadastro de livros e leitores
├── TelaEditar.java         # Formulário de edição de livros e leitores
└── README.md
```

## **Autores**
| [<img src="https://github.com/byFranca.png" width="80" style="border-radius:50%"/>](https://github.com/byFranca) | [<img src="https://github.com/apothesi.png" width="80" style="border-radius:50%"/>](https://github.com/apothesi) | [<img src="https://github.com/Kauazinpropley.png" width="80" style="border-radius:50%"/>](https://github.com/Kauazinpropley) | [<img src="https://github.com/RafaViena.png" width="80" style="border-radius:50%"/>](https://github.com/RafaViena) |
|:---:|:---:|:---:|:---:|
| **Miguel França** | **apothesi** | **Kauazinpropley** | **RafaViena** |
| [github.com/byFranca](https://github.com/byFranca) | [github.com/apothesi](https://github.com/apothesi) | [github.com/Kauazinpropley](https://github.com/Kauazinpropley) | [github.com/RafaViena](https://github.com/RafaViena) |
