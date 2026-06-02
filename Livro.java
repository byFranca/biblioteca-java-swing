public class Livro {
    private String nome;
    private String nomeAutor;
    private double preco;
    private int numeroPaginas;
    private String genero;

    public Livro(String nome, String nomeAutor, double preco, int numeroPaginas, String genero) {
        this.nome = nome;
        this.nomeAutor = nomeAutor;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    // GETTERS
    public String getNome() { return nome; }
    public String getNomeAutor() { return nomeAutor; }
    public double getPreco() { return preco; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public String getGenero() { return genero; }

    // SETTERS
    public void setNome(String nome) { this.nome = nome; }
    public void setNomeAutor(String nomeAutor) { this.nomeAutor = nomeAutor; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }
    public void setGenero(String genero) { this.genero = genero; }

    public void exibir() {
        System.out.println(nome + " | " + nomeAutor + " | " + genero);
    }
}
