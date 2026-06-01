import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaEditar {
    public TelaEditar(ArrayList<Livro> livros, ArrayList<Leitor> leitores, DefaultTableModel modeloTabela,
            String[] modoAtual, JTable tabela) {
        if (modoAtual[0].equals("Livro")) {

            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para fazer essa opereação!!");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja editar os dados dessa linha?");
            if (confirmacao == JOptionPane.YES_OPTION) {
                JFrame frameEditar = new JFrame();
                frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameEditar.setSize(500, 250);
                frameEditar.setLocationRelativeTo(null);
                frameEditar.setTitle("Editar livro");

                JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));

                JLabel labelNome = new JLabel("Novo Nome Livro:");
                JTextField campoNome = new JTextField();

                JLabel labelAutor = new JLabel("Novo Autor Do Livro:");
                JTextField campoAutor = new JTextField();

                JLabel labelPreco = new JLabel("Novo Preço Do Livro:");
                JTextField campoPreco = new JTextField();

                JLabel labelPaginas = new JLabel("Novo Numero De Páginas Do Livro:");
                JTextField campoPaginas = new JTextField();

                JLabel labelGenero = new JLabel("Novo Gênero Do Livro:");
                JTextField campoGenero = new JTextField();

                JButton botaoEditar = new JButton("Editar");

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

                        Livro l = livros.get(linha);
                        l.nome = novoNome;
                        l.nomeAutor = novoAutor;
                        l.preco = novoPreco;
                        l.numeroPaginas = novoNPagina;
                        l.genero = novoGenero;

                        TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                        frameEditar.dispose();
                        JOptionPane.showMessageDialog(null, "Livro editado com sucesso!!");

                    } catch (Exception erro) {
                        JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!!");
                        return;
                    }

                });

            } else {
                return;
            }

        }

        if (modoAtual[0].equals("Leitor")) {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para fazer essa opereação!!");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja editar os dados dessa linha?");
            if (confirmacao == JOptionPane.YES_OPTION) {
                JFrame frameEditar = new JFrame();
                frameEditar.setTitle("Editar leitor");
                frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameEditar.setLocationRelativeTo(null);
                frameEditar.setSize(400, 150);

                JPanel painelEditar = new JPanel(new GridLayout(3, 2, 10, 10));

                JLabel labelNome = new JLabel("Insira o Nome do Novo Leitor");
                JTextField campoNome = new JTextField(20);

                JLabel labelTelefone = new JLabel("Insira o Telefone do Novo Leitor");
                JTextField campoTelefone = new JTextField(20);

                JLabel labelSenha = new JLabel("Insira o Senha do Novo Leitor");
                JTextField campoSenha = new JTextField(20);

                JButton botaoEditar = new JButton("Editar Leitor");

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
                    if (campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()
                            || campoSenha.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
                        return;
                    }

                    try {
                        String novoNome = campoNome.getText();
                        String novoTelefone = campoTelefone.getText();
                        String novaSenha = campoSenha.getText();

                        Leitor l = leitores.get(linha);

                        l.nome = novoNome;
                        l.telefone = novoTelefone;
                        l.senha = novaSenha;

                        TelaAdmin.renderizarTabela(livros, leitores, modeloTabela, modoAtual);
                        frameEditar.dispose();
                        JOptionPane.showMessageDialog(null, "Leitor editado com sucesso!!");

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "Dados inseridos de forma incorreta!!");
                    }
                });

            } else {
                return;
            }
        }
    }
}
