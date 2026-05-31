import java.util.ArrayList;
import java.util.Scanner;

public class Leitor {
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
            System.out.print((i + 1) + " - ");
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

    public Livro escolherLivroFavorito(Scanner Teclado) {
        do {
            mostrarCatalogo();
            String opcStr = Teclado.nextLine();
            try {
                int opc = Integer.parseInt(opcStr);
                return livrosFavoritos.get(opc - 1);
            } catch (Exception e) {
                System.out.println("Insira uma opção válida.");
            }
        } while (true);
    }

    public void removerFavorito(Scanner Teclado) {
        if (livrosFavoritos.size() == 0) {
            System.out.println("Voce nao tem livros favoritos cadastrados!");
            return;
        }
        Livro l = escolherLivroFavorito(Teclado);
        livrosFavoritos.remove(l);
        System.out.println("O livro '" + l.nome + "' foi removido do seu catalogo, " + nome + "!!");
    }

}