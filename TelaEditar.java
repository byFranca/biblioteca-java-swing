import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaEditar {
    public TelaEditar(ArrayList<Livro> livros, ArrayList<Leitor> leitores,
            DefaultTableModel modeloTabela, String[] modoAtual, JTable tabela) {

        if (modoAtual[0].equals("Livro")) {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja editar os dados dessa linha?");
            if (confirmacao != JOptionPane.YES_OPTION)
                return;

            JFrame frameEditar = new JFrame();
            frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameEditar.setSize(500, 250);
            frameEditar.setLocationRelativeTo(null);
            frameEditar.setTitle("Editar Livro");

            JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));

            JLabel labelNome = new JLabel("Novo Nome:");
            JTextField campoNome = new JTextField();
            JLabel labelAutor = new JLabel("Novo Autor:");
            JTextField campoAutor = new JTextField();
            JLabel labelPreco = new JLabel("Novo Preço:");
            JTextField campoPreco = new JTextField();
            JLabel labelPaginas = new JLabel("Novo Nº de Páginas:");
            JTextField campoPaginas = new JTextField();
            JLabel labelGenero = new JLabel("Novo Gênero:");
            JTextField campoGenero = new JTextField();
            JButton botaoEditar = new JButton("Salvar");

            Livro livroAtual = livros.get(linha);
            campoNome.setText(livroAtual.getNome());
            campoAutor.setText(livroAtual.getNomeAutor());
            campoPreco.setText(String.valueOf(livroAtual.getPreco()));
            campoPaginas.setText(String.valueOf(livroAtual.getNumeroPaginas()));
            campoGenero.setText(livroAtual.getGenero());

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

            frameEditar.add(painel);
            frameEditar.add(botaoEditar, BorderLayout.SOUTH);
            frameEditar.setVisible(true);

            botaoEditar.addActionListener(e -> {
                // VALIDAÇÃO DE CAMPOS VAZIOS OU SÓ ESPAÇOS
                if (campoNome.getText().trim().isEmpty() || campoAutor.getText().trim().isEmpty() ||
                        campoPreco.getText().trim().isEmpty() || campoPaginas.getText().trim().isEmpty() ||
                        campoGenero.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frameEditar, "Preencha todos os campos!");
                    return;
                }

                try {
                    double novoPreco = Double.parseDouble(campoPreco.getText().trim());
                    int novoNPagina = Integer.parseInt(campoPaginas.getText().trim());

                    // VALIDAÇÃO DE PREÇO NEGATIVO
                    if (novoPreco < 0) {
                        JOptionPane.showMessageDialog(frameEditar, "O preço não pode ser negativo!");
                        return;
                    }

                    // VALIDAÇÃO DE PÁGINAS
                    if (novoNPagina <= 0) {
                        JOptionPane.showMessageDialog(frameEditar, "O número de páginas deve ser maior que zero!");
                        return;
                    }

                    Livro l = livros.get(linha);
                    l.setNome(campoNome.getText().trim());
                    l.setNomeAutor(campoAutor.getText().trim());
                    l.setPreco(novoPreco);
                    l.setNumeroPaginas(novoNPagina);
                    l.setGenero(campoGenero.getText().trim());

                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameEditar.dispose();
                    JOptionPane.showMessageDialog(null, "Livro editado com sucesso!");

                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(frameEditar, "Preço e Páginas devem ser números!");
                }
            });
        }

        if (modoAtual[0].equals("Leitor")) {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja editar os dados dessa linha?");
            if (confirmacao != JOptionPane.YES_OPTION)
                return;

            JFrame frameEditar = new JFrame();
            frameEditar.setTitle("Editar Leitor");
            frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameEditar.setLocationRelativeTo(null);
            frameEditar.setSize(400, 150);

            JPanel painelEditar = new JPanel(new GridLayout(3, 2, 10, 10));

            JLabel labelNome = new JLabel("Novo Nome:");
            JTextField campoNome = new JTextField(20);
            JLabel labelTelefone = new JLabel("Novo Telefone:");
            JTextField campoTelefone = new JTextField(20);
            JLabel labelSenha = new JLabel("Nova Senha:");
            JPasswordField campoSenha = new JPasswordField(20);
            JButton botaoEditar = new JButton("Salvar");

            Leitor leitorAtual = leitores.get(linha);
            campoNome.setText(leitorAtual.getNome());
            campoTelefone.setText(leitorAtual.getTelefone());
            campoSenha.setText(leitorAtual.getSenha());

            painelEditar.add(labelNome);
            painelEditar.add(campoNome);
            painelEditar.add(labelTelefone);
            painelEditar.add(campoTelefone);
            painelEditar.add(labelSenha);
            painelEditar.add(campoSenha);

            frameEditar.add(painelEditar);
            frameEditar.add(botaoEditar, BorderLayout.SOUTH);
            frameEditar.setVisible(true);

            botaoEditar.addActionListener(e -> {
                String senha = new String(campoSenha.getPassword());

                // VALIDAÇÃO DE CAMPOS VAZIOS OU SÓ ESPAÇOS
                if (campoNome.getText().trim().isEmpty() || campoTelefone.getText().trim().isEmpty()
                        || senha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frameEditar, "Preencha todos os campos!");
                    return;
                }

                // VALIDAÇÃO DE TELEFONE
                if (campoTelefone.getText().trim().length() < 10) {
                    JOptionPane.showMessageDialog(frameEditar,
                            "Telefone inválido! Digite pelo menos 10 caracteres. Ex: (14)99999-9999");
                    return;
                }

                // VALIDAÇÃO DE SENHA
                if (senha.length() < 4) {
                    JOptionPane.showMessageDialog(frameEditar, "A senha deve ter pelo menos 4 caracteres!");
                    return;
                }

                Leitor l = leitores.get(linha);
                l.setNome(campoNome.getText().trim());
                l.setTelefone(campoTelefone.getText().trim());
                l.setSenha(senha);

                TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                frameEditar.dispose();
                JOptionPane.showMessageDialog(null, "Leitor editado com sucesso!");
            });
        }
    }
}
