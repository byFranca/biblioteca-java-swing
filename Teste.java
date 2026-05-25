import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        livros.add(new Livro("livro 1", "autor 1", 10, 200, "comedia"));
        livros.add(new Livro("livro 2", "autor 2", 15, 150, "romance"));
        livros.add(new Livro("livro 3", "autor 1", 13, 180, "drama"));
        livros.add(new Livro("livro 4", "autor 3", 60, 120, "terror"));

        mostrarMenu(livros, Teclado);

        Teclado.close();
    }

    public static void mostrarMenu(ArrayList<Livro> livros, Scanner Teclado) {
        int opc;
        do {
            System.out.println("==== MENU DE OPERAÇÕES ====");
            System.out.println("1 - Mostrar Livros Cadastrados");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Editar Livro Cadastrado");
            System.out.println("0 - Sair");

            opc = Teclado.nextInt();
            switch (opc) {
                case 1:
                    mostrarLivros(livros);
                    break;

                case 2:
                    // metodo para cadastrar um livro
                    System.out.println("2");
                    break;

                case 3:
                    // metodo para editar um livro ja existente
                    System.out.println("3");
                    break;

                default:
                    System.out.println("opção invalida, escolha algo válido!!");
                    break;
            }

        } while (opc != 0);
    }

    public static Livro escolherLivro(ArrayList<Livro> livros, Scanner Teclado) {
        // Essa é o medoto para escolher um livro em especifico, para quando precisar
        int opc;
        do {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " " + livros.get(i).nome);
            }
            opc = Teclado.nextInt();
            if (opc > 0 && opc <= livros.size()) {
                return livros.get(opc - 1);
            } else {
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
