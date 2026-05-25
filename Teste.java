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

        Livro livroEscolhido = escolherLivro(livros, Teclado);

        System.out.println(livroEscolhido.numeroPaginas);

        Teclado.close();
    }

    public static Livro escolherLivro(ArrayList<Livro> livros, Scanner Teclado) {
        int opc;

        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + 1 + " " + livros.get(i).nome);

        }
        opc = Teclado.nextInt();
        return livros.get(opc-1);
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
