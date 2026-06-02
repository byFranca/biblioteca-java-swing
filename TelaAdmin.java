import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaAdmin {
    public TelaAdmin(ArrayList<Livro> livros, ArrayList<Leitor> leitores, String[] modoAtual) {
        modoAtual[0] = "Livro";

        JFrame frameAdmin = new JFrame();
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdmin.setSize(700, 500);
        frameAdmin.setLocationRelativeTo(null);
        frameAdmin.setTitle("MENU ADMINISTRADOR");

        JMenuBar barraMenu = new JMenuBar();
        JMenu menuLivro = new JMenu("Livros");
        JMenu menuleitor = new JMenu("Leitores");
        JMenuItem itenLivro = new JMenuItem("Operações com livros");
        JMenuItem itenLeitor = new JMenuItem("Operações com leitores");
        menuLivro.add(itenLivro);
        menuleitor.add(itenLeitor);
        barraMenu.add(menuLivro);
        barraMenu.add(menuleitor);
        JMenuItem itenSair = new JMenuItem("Sair");
        barraMenu.add(itenSair);
        frameAdmin.setJMenuBar(barraMenu);

        DefaultTableModel modeloTabela = new DefaultTableModel();
        JTable tabela = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabela);

        renderizarTabela(livros, leitores, modeloTabela, modoAtual);

        JPanel painelBotoes = new JPanel();
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoRemover = new JButton("Remover");
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoRemover);

        frameAdmin.add(scroll, BorderLayout.CENTER);
        frameAdmin.add(painelBotoes, BorderLayout.SOUTH);
        frameAdmin.setVisible(true);

        itenLivro.addActionListener(e -> {
            modoAtual[0] = "Livro";
            renderizarTabela(livros, leitores, modeloTabela, modoAtual);
        });

        itenLeitor.addActionListener(e -> {
            modoAtual[0] = "Leitor";
            renderizarTabela(livros, leitores, modeloTabela, modoAtual);
        });

        botaoCadastrar.addActionListener(e -> {
            new TelaCadastrar(livros, leitores, modeloTabela, modoAtual);
        });

        botaoRemover.addActionListener(e -> {
            removerIten(livros, leitores, modeloTabela, modoAtual, tabela);
        });

        botaoEditar.addActionListener(e -> {
            new TelaEditar(livros, leitores, modeloTabela, modoAtual, tabela);
        });

        itenSair.addActionListener(e -> {
            frameAdmin.dispose();
            new TelaLogin(livros, leitores, modoAtual);
        });
    }

    public static void renderizarTabela(ArrayList<Livro> livros, ArrayList<Leitor> leitores,
            DefaultTableModel modeloTabela, String[] modoAtual) {
        modeloTabela.setColumnCount(0);
        modeloTabela.setRowCount(0);

        if (modoAtual[0].equals("Livro")) {
            modeloTabela.setColumnIdentifiers(new String[]{"id", "Nome", "Autor", "Genero", "Preço"});
            for (int i = 0; i < livros.size(); i++) {
                Livro l = livros.get(i);
                modeloTabela.addRow(new Object[]{
                    (i + 1), l.getNome(), l.getNomeAutor(), l.getGenero(), "R$" + l.getPreco()
                });
            }
        }

        if (modoAtual[0].equals("Leitor")) {
            modeloTabela.setColumnIdentifiers(new String[]{"id", "Nome", "Telefone"});
            for (int i = 0; i < leitores.size(); i++) {
                Leitor l = leitores.get(i);
                modeloTabela.addRow(new Object[]{(i + 1), l.getNome(), l.getTelefone()});
            }
        }
    }

    public static void removerIten(ArrayList<Livro> livros, ArrayList<Leitor> leitores,
            DefaultTableModel modeloTabela, String[] modoAtual, JTable tabela) {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para fazer essa operação!");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa linha?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (modoAtual[0].equals("Livro")) livros.remove(linha);
            if (modoAtual[0].equals("Leitor")) leitores.remove(linha);
            renderizarTabela(livros, leitores, modeloTabela, modoAtual);
        }
    }
}
