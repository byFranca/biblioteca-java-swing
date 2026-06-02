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
            if (confirmacao != JOptionPane.YES_OPTION) return;

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

            // Preenche os campos com os valores atuais
            Livro livroAtual = livros.get(linha);
            campoNome.setText(livroAtual.getNome());
            campoAutor.setText(livroAtual.getNomeAutor());
            campoPreco.setText(String.valueOf(livroAtual.getPreco()));
            campoPaginas.setText(String.valueOf(livroAtual.getNumeroPaginas()));
            campoGenero.setText(livroAtual.getGenero());

            painel.add(labelNome); painel.add(campoNome);
            painel.add(labelAutor); painel.add(campoAutor);
            painel.add(labelPreco); painel.add(campoPreco);
            painel.add(labelPaginas); painel.add(campoPaginas);
            painel.add(labelGenero); painel.add(campoGenero);

            frameEditar.add(painel);
            frameEditar.add(botaoEditar, BorderLayout.SOUTH);
            frameEditar.setVisible(true);

            botaoEditar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoAutor.getText().isEmpty() ||
                        campoPreco.getText().isEmpty() || campoPaginas.getText().isEmpty() ||
                        campoGenero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }
                try {
                    Livro l = livros.get(linha);
                    l.setNome(campoNome.getText());
                    l.setNomeAutor(campoAutor.getText());
                    l.setPreco(Double.parseDouble(campoPreco.getText()));
                    l.setNumeroPaginas(Integer.parseInt(campoPaginas.getText()));
                    l.setGenero(campoGenero.getText());

                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameEditar.dispose();
                    JOptionPane.showMessageDialog(null, "Livro editado com sucesso!");
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Preço e Páginas devem ser números!");
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
            if (confirmacao != JOptionPane.YES_OPTION) return;

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

            // Preenche os campos com os valores atuais
            Leitor leitorAtual = leitores.get(linha);
            campoNome.setText(leitorAtual.getNome());
            campoTelefone.setText(leitorAtual.getTelefone());
            campoSenha.setText(leitorAtual.getSenha());

            painelEditar.add(labelNome); painelEditar.add(campoNome);
            painelEditar.add(labelTelefone); painelEditar.add(campoTelefone);
            painelEditar.add(labelSenha); painelEditar.add(campoSenha);

            frameEditar.add(painelEditar);
            frameEditar.add(botaoEditar, BorderLayout.SOUTH);
            frameEditar.setVisible(true);

            botaoEditar.addActionListener(e -> {
                if (campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()
                        || new String(campoSenha.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }
                try {
                    Leitor l = leitores.get(linha);
                    l.setNome(campoNome.getText());
                    l.setTelefone(campoTelefone.getText());
                    l.setSenha(new String(campoSenha.getPassword()));

                    TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                    frameEditar.dispose();
                    JOptionPane.showMessageDialog(null, "Leitor editado com sucesso!");
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!");
                }
            });
        }
    }
}
