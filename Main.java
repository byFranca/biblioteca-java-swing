import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Leitor> leitores = new ArrayList<>();
        String[] modoAtual = {"Livro"};

        livros.add(new Livro("Diario de um banana", "autor 1", 10, 200, "comedia"));
        livros.add(new Livro("A culpa é das estrelas", "autor 2", 15, 150, "romance"));
        livros.add(new Livro("Romeu e Julieta", "autor 1", 13, 180, "drama"));
        livros.add(new Livro("Ordem paranormal", "autor 3", 60, 120, "terror"));

        leitores.add(new Leitor("Miguel", "(14)99999-9999", "1234"));
        leitores.add(new Leitor("Aline", "(14)88888-8888", "1234"));


        new TelaLogin(livros, leitores, modoAtual);//apenas para ir testando o menu do admin
    }


}


