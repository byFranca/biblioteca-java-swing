import java.util.ArrayList;

public class Leitor {
    private String nome;
    private String telefone;
    private String senha;
    public ArrayList<Livro> livrosFavoritos = new ArrayList<>();

    public Leitor(String nome, String telefone, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void exibir() {
        System.out.println(nome + " | " + telefone);
    }
}
