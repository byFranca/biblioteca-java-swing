import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Leitor> leitores = new ArrayList<>();

        livros.add(new Livro("Diario de um banana", "autor 1", 10, 200, "comedia"));
        livros.add(new Livro("A culpa é das estrelas", "autor 2", 15, 150, "romance"));
        livros.add(new Livro("Romeu e Julieta", "autor 1", 13, 180, "drama"));
        livros.add(new Livro("Ordem paranormal", "autor 3", 60, 120, "terror"));

        leitores.add(new Leitor("Miguel", "(14)99999-9999", "1234"));
        leitores.add(new Leitor("Aline", "(14)88888-8888", "1234"));

        login(livros, leitores, Teclado);

        Teclado.close();
    }

    public static void login(ArrayList<Livro> livros, ArrayList<Leitor> leitores, Scanner Teclado) {
        String opc;
        boolean rodando = true;
        do {
            System.out.println();
            System.out.println("==== BIBLIOTECA ====");
            System.out.println("1 - Entrar como Admin");
            System.out.println("2 - Entrar como Leitor");
            System.out.println("0 - Sair");

            opc = Teclado.nextLine();

            switch (opc) {
                case "1":
                    menuAdmin(livros, leitores, Teclado);
                    break;

                case "2":
                    Leitor leitorLogado = fazerLogin(leitores, Teclado);
                    if (leitorLogado != null) {
                        menuLeitor(livros, leitorLogado, Teclado);
                    }
                    break;

                case "0":
                    System.out.println("Obrigado por usar o meu sistema!!");
                    rodando = false;
                    break;

                default:
                    System.out.println("Insira uma das opções do menu");
                    break;
            }
        } while (rodando);

    }

    public static Leitor fazerLogin(ArrayList<Leitor> leitores, Scanner Teclado) {
        System.out.println();
        System.out.println("Digite seu nome: ");
        String nome = Teclado.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = Teclado.nextLine();

        for (int i = 0; i < leitores.size(); i++) {
            if (leitores.get(i).nome.equals(nome) && leitores.get(i).senha.equals(senha)) {
                System.out.println("Bem vindo, " + nome + "!");
                return leitores.get(i);
            }
        }

        System.out.println("Nome ou senha incorretos!");
        return null;
    }

    public static void menuAdmin(ArrayList<Livro> livros, ArrayList<Leitor> leitores, Scanner Teclado) {
        String opc;
        boolean rodando = true;
        do {
            System.out.println();
            System.out.println();
            System.out.println("==== MENU DE OPERAÇÕES ====");
            System.out.println("1 - Mostrar Livros Cadastrados");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Editar Livro Cadastrado");
            System.out.println("4 - Remover Livro");
            System.out.println("5 - Mostrar leitores");
            System.out.println("6 - Criar leitor");
            System.out.println("7 - Excluir leitor");
            System.out.println("0 - Sair");

            opc = Teclado.nextLine();

            switch (opc) {
                case "0":
                    rodando = false;
                    break;
                case "1":
                    mostrarLivros(livros);
                    break;

                case "2":
                    criarLivro(livros, Teclado);
                    break;

                case "3":
                    editarLivro(livros, Teclado);
                    break;

                case "4":
                    excluirLivro(livros, Teclado);
                    break;

                case "5":
                    mostrarLeitores(leitores);
                    break;

                case "6":
                    criarLeitor(leitores, Teclado);
                    break;

                case "7":
                    excluirLeitor(leitores, Teclado);
                    break;

                default:
                    System.out.println("Insira uma das opções do menu");
                    break;
            }

        } while (rodando);
    }

    public static void menuLeitor(ArrayList<Livro> livros, Leitor leitorLogado, Scanner Teclado) {

        boolean rodando = true;
        String opc;

        do {
            System.out.println();
            System.out.println();
            System.out.println("==== MENU DE OPERAÇÕES DO LEITOR ====");
            System.out.println("1 - Ver Catalogo De Livros");
            System.out.println("2 - Mostrar Meu Catalogo De Favoritos");
            System.out.println("3 - Adicionar Livro ao Meu Catalogo De Favoritos");
            System.out.println("4 - Excluir Minha Conta");
            System.out.println("0 - Sair");

            opc = Teclado.nextLine();
            switch (opc) {
                case "1":
                    mostrarLivros(livros);
                    break;
                case "2":
                    leitorLogado.mostrarCatalogo();
                    break;

                case "3":
                    Livro l = escolherLivro(livros, Teclado);
                    leitorLogado.adicionarFavorito(l);
                    break;

                case "0":
                    rodando = false;
                    break;

                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }

        } while (rodando);
    }

    public static Livro escolherLivro(ArrayList<Livro> livros, Scanner Teclado) {
        String opcStr;
        do {
            mostrarLivros(livros);
            opcStr = Teclado.nextLine();
            try {
                int opc = Integer.parseInt(opcStr);
                return livros.get(opc - 1);
            } catch (Exception e) {
                System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public static void mostrarLivros(ArrayList<Livro> livros) {
        if (livros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }
        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            System.out.print((i + 1) + " - ");
            livros.get(i).exibir();
        }
    }

    public static void criarLivro(ArrayList<Livro> livros, Scanner Teclado) {
        System.out.println();
        System.out.println();
        System.out.println("Digite o nome do novo livro: ");
        String novoNome = Teclado.nextLine();

        System.out.println("Digite o nome do autor: ");
        String novoAutor = Teclado.nextLine();

        System.out.println("Digite o preço do novo livro: ");
        String precoStr = Teclado.nextLine();

        System.out.println("Digite o numero de páginas: ");
        String paginasStr = Teclado.nextLine();

        System.out.println("Digite o genero do novo livro: ");
        String novoGenero = Teclado.nextLine();

        try {
            double novoPreco = Double.parseDouble(precoStr);
            int novoNPaginas = Integer.parseInt(paginasStr);

            livros.add(new Livro(novoNome, novoAutor, novoPreco, novoNPaginas, novoGenero));
            System.out.println();
            System.out.println("O livro '" + novoNome + "' foi cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro! Digite um número válido onde for pedido.");
        }
    }

    public static void editarLivro(ArrayList<Livro> livros, Scanner Teclado) {
        if (livros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        Livro l = escolherLivro(livros, Teclado);
        System.out.println();
        System.out.println();
        System.out.println("Digite o nome do novo livro: ");
        String editNome = Teclado.nextLine();

        System.out.println("Digite o nome do autor: ");
        String editAutor = Teclado.nextLine();

        System.out.println("Digite o preço do novo livro: ");
        String editPreco = Teclado.nextLine();

        System.out.println("Digite o numero de páginas: ");
        String editPaginas = Teclado.nextLine();

        System.out.println("Digite o genero do novo livro: ");
        String editGenero = Teclado.nextLine();

        try {
            double preco = Double.parseDouble(editPreco);
            int numeroPaginas = Integer.parseInt(editPaginas);
            l.preco = preco;
            l.numeroPaginas = numeroPaginas;
            l.nome = editNome;
            l.nomeAutor = editAutor;
            l.genero = editGenero;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Dados inseridos de forma incorreta!!");
        }
    }

    public static void excluirLivro(ArrayList<Livro> livros, Scanner teclado) {
        if (livros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }
        Livro l = escolherLivro(livros, teclado);
        System.out.println("O livro '" + l.nome + "' foi excluido");
        livros.remove(l);

    }

    public static void mostrarLeitores(ArrayList<Leitor> leitores) {
        System.out.println();
        if (leitores.size() == 0) {
            System.out.println("Nenhum leitor cadastrado!");
            return;
        }
        for (int i = 0; i < leitores.size(); i++) {
            System.out.print((i + 1) + " - ");
            leitores.get(i).exibir();
        }
    }

    public static void criarLeitor(ArrayList<Leitor> leitores, Scanner Teclado) {
        System.out.println("Digite o nome do novo leitor: ");
        String novoNome = Teclado.nextLine();

        System.out.println("Digite o telefone do novo leitor: ");
        String novoTelefone = Teclado.nextLine();

        System.out.println("Digite a senha do novo leitor: ");
        String novaSenha = Teclado.nextLine();

        leitores.add(new Leitor(novoNome, novoTelefone, novaSenha));
        System.out.println("O leitor '" + novoNome + "' foi cadastrado com sucesso!");
    }

    public static Leitor escolherLeitor(ArrayList<Leitor> leitores, Scanner Teclado) {
        do {
            mostrarLeitores(leitores);
            String opcStr = Teclado.nextLine();
            try {
                int opc = Integer.parseInt(opcStr);
                return leitores.get(opc - 1);
            } catch (Exception e) {
                System.out.println("Insira uma entrada válida");
            }
        } while (true);
    }

    public static void excluirLeitor(ArrayList<Leitor> leitores, Scanner Teclado) {
        if (leitores.size() == 0) {
            System.out.println("Nenhum Leitor cadastrado");
            return;
        }
        Leitor leitor = escolherLeitor(leitores, Teclado);
        System.out.println("O leitor '" + leitor.nome + "'Foi excluido");
        leitores.remove(leitor);
    }

}

class Livro {
    String nome;
    String nomeAutor;
    double preco;
    int numeroPaginas;
    String genero;

    Livro(String nome, String nomeAutor, double preco, int numeroPaginas, String genero) {
        this.nome = nome;
        this.nomeAutor = nomeAutor;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    public void exibir() {
        System.out.println(nome + " | " + nomeAutor + " | " + genero);
    }
}

class Leitor {
    String nome;
    String telefone;
    String senha;
    ArrayList<Livro> livrosFavoritos = new ArrayList<>();

    Leitor(String nome, String telefone, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    public void exibir() {
        System.out.println(nome + " | " + telefone);
    }

    public void mostrarCatalogo() {
        System.out.println();
        if (livrosFavoritos.size() == 0) {
            System.out.println("Voce nao tem livros favoritos cadastrados");
            return;
        }
        System.out.println("==== LIVROS FAVORITOS ====");
        for (int i = 0; i < livrosFavoritos.size(); i++) {
            livrosFavoritos.get(i).exibir();
        }

    }

    public void adicionarFavorito(Livro l) {
        for (Livro livro : livrosFavoritos) {
            if (l == livro) {
                System.out.println("Este livro ja esta no seu catalogo!!");
                return;
            }
        }
        livrosFavoritos.add(l);
        System.out.println("O livro '" + l.nome + "' foi adicionado ao seu catalogo de favoritos, " + nome + "!!");

    }

}