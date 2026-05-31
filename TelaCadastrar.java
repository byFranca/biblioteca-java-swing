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

            frameCadastro.add(painel);
            frameCadastro.add(botaoCadastrar, BorderLayout.SOUTH);
            frameCadastro.setVisible(true);

            botaoCadastrar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoAutor.getText().isEmpty() ||
                        campoPreco.getText().isEmpty() || campoPaginas.getText().isEmpty() ||
                        campoGenero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
                    return;
                }

                try {
                    String novoNome = campoNome.getText();
                    String novoAutor = campoAutor.getText();
                    double novoPreco = Double.parseDouble(campoPreco.getText());
                    int novoNPagina = Integer.parseInt(campoPaginas.getText());
                    String novoGenero = campoGenero.getText();

                    livros.add(new Livro(novoNome, novoAutor, novoPreco, novoNPagina, novoGenero));
                    JOptionPane.showMessageDialog(null, "O livro '" + novoNome + "' foi adicionado!");
                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameCadastro.dispose();

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!!");
                }

            });
        }

        if (modoAtual[0].equals("Leitor")) {
            JFrame frameCadastro = new JFrame();
            frameCadastro.setTitle("Cadastrar leitor");
            frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameCadastro.setLocationRelativeTo(null);
            frameCadastro.setSize(400, 150);

            JPanel painelCadastro = new JPanel(new GridLayout(3, 2, 10, 10));

            JLabel labelNome = new JLabel("Insira o Nome do Novo Leitor");
            JTextField campoNome = new JTextField(20);

            JLabel labelTelefone = new JLabel("Insira o Telefone do Novo Leitor");
            JTextField campoTelefone = new JTextField(20);

            JLabel labelSenha = new JLabel("Insira o Senha do Novo Leitor");
            JTextField campoSenha = new JTextField(20);

            JButton botaoCadastrar = new JButton("Cadastrar Leitor");

            painelCadastro.add(labelNome);
            painelCadastro.add(campoNome);
            painelCadastro.add(labelTelefone);
            painelCadastro.add(campoTelefone);
            painelCadastro.add(labelSenha);
            painelCadastro.add(campoSenha);

            frameCadastro.add(painelCadastro);
            frameCadastro.add(botaoCadastrar, BorderLayout.SOUTH);
            frameCadastro.setVisible(true);

            botaoCadastrar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()
                        || campoSenha.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
                    return;
                }

                try {
                    String novoNome = campoNome.getText();
                    String novoTelefone = campoTelefone.getText();
                    String novaSenha = campoSenha.getText();

                    leitores.add(new Leitor(novoNome, novoTelefone, novaSenha));
                    JOptionPane.showMessageDialog(null, "O leitor '" + novoNome + "' foi adicionado!");
                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameCadastro.dispose();

                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!!");
                }
            });

        }

    }
}