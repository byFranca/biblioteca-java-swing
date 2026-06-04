import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Leitor> leitores = new ArrayList<>();
        String[] modoAtual = { "Livro" };

        livros.add(new Livro("Diario de um Banana", "Jeff Kinney", 15, 217, "comedia"));
        livros.add(new Livro("A Culpa e das Estrelas", "John Green", 39, 285, "romance"));
        livros.add(new Livro("Romeu e Julieta", "William Shakespeare", 19.90, 128, "drama"));
        livros.add(new Livro("Ordem Paranormal", "Cellbit", 60, 320, "terror"));
        livros.add(new Livro("Harry Potter", "J.K. Rowling", 49.90, 232, "fantasia"));
        livros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupery", 30, 96, "ficcao"));
        livros.add(new Livro("O Cortico", "Aluisio Azevedo", 18.90, 248, "realismo"));
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", 29.90, 256, "romance"));
        livros.add(new Livro("O Alquimista", "Paulo Coelho", 34, 208, "ficcao"));
        livros.add(new Livro("1984", "George Orwell", 44.50, 416, "distopia"));
        livros.add(new Livro("O Senhor dos Aneis", "J.R.R. Tolkien", 60, 576, "fantasia"));
        livros.add(new Livro("Fahrenheit 451", "Ray Bradbury", 39.90, 192, "distopia"));
        livros.add(new Livro("Admiravel Mundo Novo", "Aldous Huxley", 42.90, 312, "distopia"));
        livros.add(new Livro("O Hobbit", "J.R.R. Tolkien", 44.90, 288, "fantasia"));
        livros.add(new Livro("Memorias Postumas de Bras Cubas", "Machado de Assis", 16.90, 224, "realismo"));

        leitores.add(new Leitor("Miguel", "(14)99999-9999", "1234"));
        leitores.add(new Leitor("Aline", "(14)88888-8888", "1234"));
        leitores.add(new Leitor("Ana Julia", "(14)99111-1111", "1234"));
        leitores.add(new Leitor("Murilo", "(14)99222-2222", "1234"));
        leitores.add(new Leitor("Rafael", "(14)99333-3333", "1234"));
        leitores.add(new Leitor("Kaua", "(14)99444-4444", "1234"));
        leitores.add(new Leitor("Maria", "(14)99555-5555", "1234"));
        leitores.add(new Leitor("Pedro", "(14)99666-6666", "1234"));
        leitores.add(new Leitor("Arnaldo", "(14)99777-7777", "1234"));
        leitores.add(new Leitor("Ryan", "(14)99888-8888", "1234"));
        leitores.add(new Leitor("Rodrigo", "(14)99999-9999", "1234"));
        leitores.add(new Leitor("Marcos", "(14)98111-1111", "1234"));

        new TelaLogin(livros, leitores, modoAtual);
    }

}
