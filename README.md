# grupo-B1-SCRIPTS

Projeto desenvolvido para a disciplina de **Desenvolvimento de Sistemas** — 2° DS.

## Objetivo

Sistema em **PHP** para exploração da geração dinâmica de páginas Web e da arquitetura de aplicações em camadas. A proposta é entender na prática como as tecnologias do lado cliente e do lado servidor se comunicam para construir uma aplicação Web funcional.

O projeto abrange três camadas principais: o **Cliente/Navegador**, responsável pela renderização e interatividade; o **Servidor Web**, que processa as requisições; e a **Aplicação**, onde a lógica em PHP gera o conteúdo dinamicamente. O conjunto de tecnologias envolvidas inclui marcação com HTML, estilização com CSS, scripts client-side com JavaScript e processamento server-side com PHP.

## Como rodar o projeto

**Pré-requisitos:** ter o [XAMPP](https://www.apachefriends.org/), [WAMP](https://www.wampserver.com/) ou [Laragon](https://laragon.org/) instalado.

**1. Clone o repositório:**
``bash
git clone https://github.com/seu-usuario/grupo-B1-SCRIPTS.git
cd grupo-B1-SCRIPTS
2. Coloque os arquivos na pasta do servidor local:
XAMPP: C:\xampp\htdocs\grupo-B1-SCRIPTS
WAMP: C:\wamp64\www\grupo-B1-SCRIPTS
3. Inicie o Apache pelo painel de controle.
4. Acesse no navegador:
plain
http://localhost/grupo-B1-SCRIPTS
Etapas de desenvolvimento
[ ] Estrutura HTML e estilização CSS
[ ] Scripts de interatividade com JavaScript
[ ] Lógica server-side com PHP
[ ] Integração entre camadas Cliente/Servidor
O projeto foi estruturado de forma intencional para explorar cada camada da arquitetura Web:
1. Cliente (Navegador)
Camada responsável pela apresentação e interação com o usuário. Envolve:
Estruturação das páginas com HTML
Estilização visual com CSS
Interatividade e validações no navegador com JavaScript
2. Servidor Web
Camada intermediária que recebe as requisições do cliente e as encaminha para a aplicação. Utiliza:
Apache ou Nginx como servidor HTTP
3. Aplicação (PHP)
Camada de processamento e lógica do servidor. Responsável por:
Geração dinâmica de conteúdo HTML
Processamento de dados enviados pelo cliente
Comunicação com banco de dados (se aplicável)
Validações e segurança no lado servidor
Estrutura do projeto
plain
grupo-B1-SCRIPTS/
├── assets/           # CSS, JavaScript e imagens
│   ├── css/
│   ├── js/
│   └── images/
├── includes/        # Componentes PHP reutilizáveis
├── pages/           # Páginas dinâmicas do site
├── config/          # Configurações do projeto
├── index.php        # Página inicial
├── .htaccess        # Configurações do Apache
└── README.md
Autores
Table
https://github.com/apoteosii	https://github.com/membro2	https://github.com/membro3
apoteosii	[Membro 2]	[Membro 3]
github.com/apoteosii	github.com/membro2	github.com/membro3
