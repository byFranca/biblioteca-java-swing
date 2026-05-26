import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        livros.add(new Livro("Diario de um banana", "autor 1", 10, 200, "comedia"));
        livros.add(new Livro("A culpa é das estrelas", "autor 2", 15, 150, "romance"));
        livros.add(new Livro("Romeu e Julieta", "autor 1", 13, 180, "drama"));
        livros.add(new Livro("Ordem paranormal", "autor 3", 60, 120, "terror"));
        mostrarMenu(livros, Teclado);

        Teclado.close();
    }

    public static void mostrarMenu(ArrayList<Livro> livros, Scanner Teclado) {
        int opc;
        boolean rodando = true; 
        do {
            System.out.println("==== MENU DE OPERAÇÕES ====");
            System.out.println("1 - Mostrar Livros Cadastrados");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Editar Livro Cadastrado");
            System.out.println("0 - Sair");

            opc = Teclado.nextInt();
            switch (opc) {
                case 0:
                        System.out.println("Obrigado por usar o meu sistema!!");
                        rodando = false;
                    break;
                case 1:
                    mostrarLivros(livros);
                    break;

                case 2:
                    criarLivro(livros, Teclado);
                    break;

                case 3:
                    // metodo para editar um livro ja existente
                    System.out.println("3");
                    break;

                default:
                    System.out.println("opção invalida, escolha algo válido!!");
                    break;
            }

        } while (rodando);
    }

    public static Livro escolherLivro(ArrayList<Livro> livros, Scanner Teclado) {
        // Essa é o medoto para escolher um livro em especifico, para quando precisar
        int opc;
        do {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " " + livros.get(i).nome);
            }
            opc = Teclado.nextInt();
            try{
                return livros.get(opc - 1);
            }catch(Exception e){
                System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public static void mostrarLivros(ArrayList<Livro> livros) {
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.println((i + 1) + " - " + l.nome + " | " + l.nomeAutor + " | " + l.genero);
        }
    }

    public static void criarLivro(ArrayList<Livro> livros, Scanner Teclado) {
        Teclado.nextLine();
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
            System.out.println("O livro '" + novoNome + "' foi cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro! Digite um número válido onde for pedido.");
        }
    }

}

class Livro {
    String nome;
    String nomeAutor;
    double preco;
    int numeroPaginas; // pode ser que mais pra frente isso mude
    String genero;

    Livro(String nome, String nomeAutor, double preco, int numeroPaginas, String genero) {
        this.nome = nome;
        this.nomeAutor = nomeAutor;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;

    }



}
