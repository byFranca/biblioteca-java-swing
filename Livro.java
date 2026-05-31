public class Livro {
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