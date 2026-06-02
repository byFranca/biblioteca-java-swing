import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrar {
    public TelaCadastrar(ArrayList<Livro> livros, ArrayList<Leitor> leitores,
            DefaultTableModel modeloTabela, String[] modoAtual) {

        if (modoAtual[0].equals("Livro")) {
            JFrame frameCadastro = new JFrame();
            frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameCadastro.setSize(500, 250);
            frameCadastro.setLocationRelativeTo(null);
            frameCadastro.setTitle("Cadastrar Livro");

            JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));

            JLabel labelNome = new JLabel("Nome Do Livro:");
            JTextField campoNome = new JTextField();
            JLabel labelAutor = new JLabel("Autor Do Livro:");
            JTextField campoAutor = new JTextField();
            JLabel labelPreco = new JLabel("Preço Do Livro:");
            JTextField campoPreco = new JTextField();
            JLabel labelPaginas = new JLabel("Numero De Páginas:");
            JTextField campoPaginas = new JTextField();
            JLabel labelGenero = new JLabel("Gênero Do Livro:");
            JTextField campoGenero = new JTextField();
            JButton botaoCadastrar = new JButton("Cadastrar");

            painel.add(labelNome); painel.add(campoNome);
            painel.add(labelAutor); painel.add(campoAutor);
            painel.add(labelPreco); painel.add(campoPreco);
            painel.add(labelPaginas); painel.add(campoPaginas);
            painel.add(labelGenero); painel.add(campoGenero);

            frameCadastro.add(painel);
            frameCadastro.add(botaoCadastrar, BorderLayout.SOUTH);
            frameCadastro.setVisible(true);

            botaoCadastrar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoAutor.getText().isEmpty() ||
                        campoPreco.getText().isEmpty() || campoPaginas.getText().isEmpty() ||
                        campoGenero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }
                try {
                    String nome = campoNome.getText();
                    String autor = campoAutor.getText();
                    double preco = Double.parseDouble(campoPreco.getText());
                    int paginas = Integer.parseInt(campoPaginas.getText());
                    String genero = campoGenero.getText();

                    livros.add(new Livro(nome, autor, preco, paginas, genero));
                    JOptionPane.showMessageDialog(null, "Livro '" + nome + "' cadastrado!");
                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameCadastro.dispose();
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Preço e Páginas devem ser números!");
                }
            });
        }

        if (modoAtual[0].equals("Leitor")) {
            JFrame frameCadastro = new JFrame();
            frameCadastro.setTitle("Cadastrar Leitor");
            frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameCadastro.setLocationRelativeTo(null);
            frameCadastro.setSize(400, 150);

            JPanel painelCadastro = new JPanel(new GridLayout(3, 2, 10, 10));

            JLabel labelNome = new JLabel("Nome do Novo Leitor:");
            JTextField campoNome = new JTextField(20);
            JLabel labelTelefone = new JLabel("Telefone do Novo Leitor:");
            JTextField campoTelefone = new JTextField(20);
            JLabel labelSenha = new JLabel("Senha do Novo Leitor:");
            JPasswordField campoSenha = new JPasswordField(20);
            JButton botaoCadastrar = new JButton("Cadastrar Leitor");

            painelCadastro.add(labelNome); painelCadastro.add(campoNome);
            painelCadastro.add(labelTelefone); painelCadastro.add(campoTelefone);
            painelCadastro.add(labelSenha); painelCadastro.add(campoSenha);

            frameCadastro.add(painelCadastro);
            frameCadastro.add(botaoCadastrar, BorderLayout.SOUTH);
            frameCadastro.setVisible(true);

            botaoCadastrar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()
                        || new String(campoSenha.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }
                try {
                    String nome = campoNome.getText();
                    String telefone = campoTelefone.getText();
                    String senha = new String(campoSenha.getPassword());

                    leitores.add(new Leitor(nome, telefone, senha));
                    JOptionPane.showMessageDialog(null, "Leitor '" + nome + "' cadastrado!");
                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameCadastro.dispose();
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!");
                }
            });
        }
    }
}
