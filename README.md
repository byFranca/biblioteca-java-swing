# Sistema de Biblioteca

Projeto desenvolvido para a disciplina de **Desenvolvimento de Sistemas** — 2° DS.

## Objetivo

Sistema em **Java** para gerenciamento de uma biblioteca escolar. A proposta é oferecer uma solução completa para cadastro de livros e leitores, com suporte a busca, edição e remoção de registros, tudo por meio de uma interface gráfica construída com **Java Swing**.

O sistema conta com dois perfis de acesso: o **Admin**, que tem controle total sobre o acervo e os leitores cadastrados, e o **Leitor**, que pode visualizar os livros disponíveis e montar sua própria lista de favoritos. O acesso é feito por uma tela de login com nome e senha.

## Etapas de desenvolvimento
- [X] Lógica em console
- [ ] Interface com Java Swing

---

O projeto foi estruturado em duas fases, de forma intencional:

### 1. Lógica em console
Antes de partir para a interface visual, toda a lógica do sistema é desenvolvida e validada no terminal. Essa etapa envolve:
- Modelagem das classes `Livro` e `Leitor`, cada uma com seus atributos e métodos próprios
- Uso de `ArrayList` para armazenar e manipular os registros em memória
- Menus interativos com `Scanner`, `do/while` e `switch/case`
- Tela de login que direciona o usuário para o menu correto de acordo com seu perfil
- CRUD completo de livros: cadastrar, listar, editar e remover
- CRUD completo de leitores: cadastrar, listar e remover
- Área do leitor: visualizar o acervo e adicionar livros à lista de favoritos
- Tratamento de erros para entradas inválidas

O objetivo é consolidar o raciocínio orientado a objetos e garantir que toda a lógica esteja funcionando corretamente antes de adicionar qualquer complexidade visual.

### 2. Interface com Java Swing
Com a lógica já funcional, ela será integrada a uma interface gráfica construída com **Java Swing**, composta por:
- Tela de login com campos de nome e senha
- Formulários de cadastro com campos de texto
- Tabela de listagem de registros
- Tela de busca por diferentes critérios
- Botões de ação (cadastrar, editar, remover)
- Caixas de diálogo para confirmações e alertas
- Barra de menus para navegação

## **Autores**
| [<img src="https://github.com/byFranca.png" width="80" style="border-radius:50%"/>](https://github.com/byFranca) | [<img src="https://github.com/apothesi.png" width="80" style="border-radius:50%"/>](https://github.com/apothesi) | [<img src="https://github.com/Kauazinpropley.png" width="80" style="border-radius:50%"/>](https://github.com/Kauazinpropley) | [<img src="https://github.com/RafaViena.png" width="80" style="border-radius:50%"/>](https://github.com/RafaViena) |
|:---:|:---:|:---:|:---:|
| **Miguel França** | **apothesi** | **Kauazinpropley** | **RafaViena** |
| [github.com/byFranca](https://github.com/byFranca) | [github.com/apothesi](https://github.com/apothesi) | [github.com/Kauazinpropley](https://github.com/Kauazinpropley) | [github.com/RafaViena](https://github.com/RafaViena) |
