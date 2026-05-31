import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrar {
    public TelaCadastrar(ArrayList<Livro> livros, ArrayList<Leitor> leitores, DefaultTableModel modeloTabela,
            String[] modoAtual) {

        if (modoAtual[0].equals("Livro")) {
            JFrame frameCadastro = new JFrame();
            frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameCadastro.setSize(300, 250);
            frameCadastro.setLocationRelativeTo(null);
            frameCadastro.setTitle("Cadastrar Livro");

            JPanel painel = new JPanel(new GridLayout(6, 2, 10, 10));

            JLabel labelNome = new JLabel("Nome Do Livro:");
            JTextField campoNome = new JTextField();

            JLabel labelAutor = new JLabel("Autor Do Livro:");
            JTextField campoAutor = new JTextField();

            JLabel labelPreco = new JLabel("Preço Do Livro:");
            JTextField campoPreco = new JTextField();

            JLabel labelPaginas = new JLabel("Numero De Páginas Do Livro:");
            JTextField campoPaginas = new JTextField();

            JLabel labelGenero = new JLabel("Gênero Do Livro:");
            JTextField campoGenero = new JTextField();

            JButton botaoCadastrar = new JButton("Cadastrar");

            painel.add(labelNome);
            painel.add(campoNome);
            painel.add(labelAutor);
            painel.add(campoAutor);
            painel.add(labelPreco);
            painel.add(campoPreco);
            painel.add(labelPaginas);
            painel.add(campoPaginas);
            painel.add(labelGenero);
            painel.add(campoGenero);
            painel.add(new JLabel());
            painel.add(botaoCadastrar);

            frameCadastro.add(painel);
            frameCadastro.setVisible(true);
        }

        if (modoAtual[0].equals("Leitor")) {
            System.out.println("VAI DACASTRAR UM LEITOR");
            
        }

    }
}