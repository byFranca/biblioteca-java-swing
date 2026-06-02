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
                // VALIDAÇÃO DE CAMPOS VAZIOS OU SÓ ESPAÇOS
                if (campoNome.getText().trim().isEmpty() || campoAutor.getText().trim().isEmpty() ||
                        campoPreco.getText().trim().isEmpty() || campoPaginas.getText().trim().isEmpty() ||
                        campoGenero.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frameCadastro, "Preencha todos os campos!");
                    return;
                }

                try {
                    String nome = campoNome.getText().trim();
                    String autor = campoAutor.getText().trim();
                    double preco = Double.parseDouble(campoPreco.getText().trim());
                    int paginas = Integer.parseInt(campoPaginas.getText().trim());
                    String genero = campoGenero.getText().trim();

                    // VALIDAÇÃO DE PREÇO NEGATIVO
                    if (preco < 0) {
                        JOptionPane.showMessageDialog(frameCadastro, "O preço não pode ser negativo!");
                        return;
                    }

                    // VALIDAÇÃO DE PÁGINAS
                    if (paginas <= 0) {
                        JOptionPane.showMessageDialog(frameCadastro, "O número de páginas deve ser maior que zero!");
                        return;
                    }

                    livros.add(new Livro(nome, autor, preco, paginas, genero));
                    JOptionPane.showMessageDialog(frameCadastro, "Livro '" + nome + "' cadastrado!");
                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameCadastro.dispose();

                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(frameCadastro, "Preço e Páginas devem ser números!");
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
                String senha = new String(campoSenha.getPassword());

                // VALIDAÇÃO DE CAMPOS VAZIOS OU SÓ ESPAÇOS
                if (campoNome.getText().trim().isEmpty() || campoTelefone.getText().trim().isEmpty()
                        || senha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frameCadastro, "Preencha todos os campos!");
                    return;
                }

                // VALIDAÇÃO DE TELEFONE
                if (campoTelefone.getText().trim().length() < 10) {
                    JOptionPane.showMessageDialog(frameCadastro, "Telefone inválido! Digite pelo menos 10 caracteres. Ex: (14)99999-9999");
                    return;
                }

                // VALIDAÇÃO DE SENHA
                if (senha.length() < 4) {
                    JOptionPane.showMessageDialog(frameCadastro, "A senha deve ter pelo menos 4 caracteres!");
                    return;
                }

                String nome = campoNome.getText().trim();
                String telefone = campoTelefone.getText().trim();

                leitores.add(new Leitor(nome, telefone, senha));
                JOptionPane.showMessageDialog(frameCadastro, "Leitor '" + nome + "' cadastrado!");
                TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                frameCadastro.dispose();
            });
        }
    }
}
