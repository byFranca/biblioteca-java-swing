import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaLeitor {
    public TelaLeitor(ArrayList<Livro> livros, ArrayList<Leitor> leitores, Leitor leitorLogado, String[] modoAtual) {
        modoAtual[0] = "livros";

        JFrame frameLeitor = new JFrame();
        frameLeitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLeitor.setSize(700, 500);
        frameLeitor.setLocationRelativeTo(null);
        frameLeitor.setTitle("Menu Leitor — " + leitorLogado.nome);

        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.setColumnIdentifiers(new String[]{"id", "Nome", "Autor", "Gênero"});
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            modeloTabela.addRow(new Object[]{(i + 1), l.nome, l.nomeAutor, l.genero});
        }

        JTable tabela = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabela);

        JPanel painelTitulo = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Livros disponíveis");
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        painelTitulo.add(titulo, BorderLayout.WEST);

        JButton botaoSair = new JButton("Sair");
        JPanel painelSair = new JPanel();
        painelSair.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        painelSair.add(botaoSair);
        painelTitulo.add(painelSair, BorderLayout.EAST);

        JPanel painelBotoes = new JPanel();
        JButton botaoFavoritos = new JButton("Ver Meus Favoritos");
        JButton botaoAdicionar = new JButton("Adicionar aos Favoritos");
        JButton botaoRemover = new JButton("Remover dos Favoritos");
        painelBotoes.add(botaoFavoritos);
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoRemover);

        frameLeitor.add(painelTitulo, BorderLayout.NORTH);
        frameLeitor.add(scroll, BorderLayout.CENTER);
        frameLeitor.add(painelBotoes, BorderLayout.SOUTH);
        frameLeitor.setVisible(true);

        // SAIR
        botaoSair.addActionListener(e -> {
            frameLeitor.dispose();
            new TelaLogin(livros, leitores, modoAtual);
        });

        //  VER FAVORITOS
        botaoFavoritos.addActionListener(e -> {
            if (leitorLogado.livrosFavoritos.isEmpty()) {
                JOptionPane.showMessageDialog(frameLeitor, "Você ainda não tem livros favoritos!");
                return;
            }

            DefaultTableModel modeloFavoritos = new DefaultTableModel();
            modeloFavoritos.setColumnIdentifiers(new String[]{"id", "Nome", "Autor", "Gênero"});
            for (int i = 0; i < leitorLogado.livrosFavoritos.size(); i++) {
                Livro l = leitorLogado.livrosFavoritos.get(i);
                modeloFavoritos.addRow(new Object[]{(i + 1), l.nome, l.nomeAutor, l.genero});
            }

            JTable tabelaFavoritos = new JTable(modeloFavoritos);
            JDialog dialog = new JDialog(frameLeitor, "Meus Favoritos", true);
            dialog.add(new JScrollPane(tabelaFavoritos));
            dialog.setSize(500, 300);
            dialog.setLocationRelativeTo(frameLeitor);
            dialog.setVisible(true);
        });

        //  ADICIONAR AOS FAVORITOS
        botaoAdicionar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(frameLeitor, "Selecione um livro na tabela primeiro!");
                return;
            }

            Livro livroSelecionado = livros.get(linha);

            for (Livro fav : leitorLogado.livrosFavoritos) {
                if (fav == livroSelecionado) {
                    JOptionPane.showMessageDialog(frameLeitor, "Este livro já está nos seus favoritos!");
                    return;
                }
            }

            leitorLogado.livrosFavoritos.add(livroSelecionado);
            JOptionPane.showMessageDialog(frameLeitor, "'" + livroSelecionado.nome + "' adicionado aos favoritos!");
        });

        // REMOVER DOS FAVORITOS
        botaoRemover.addActionListener(e -> {
            if (leitorLogado.livrosFavoritos.isEmpty()) {
                JOptionPane.showMessageDialog(frameLeitor, "Você não tem favoritos para remover!");
                return;
            }

            DefaultTableModel modeloRemover = new DefaultTableModel();
            modeloRemover.setColumnIdentifiers(new String[]{"id", "Nome", "Autor"});
            for (int i = 0; i < leitorLogado.livrosFavoritos.size(); i++) {
                Livro l = leitorLogado.livrosFavoritos.get(i);
                modeloRemover.addRow(new Object[]{(i + 1), l.nome, l.nomeAutor});
            }

            JTable tabelaRemover = new JTable(modeloRemover);
            JButton botaoConfirmar = new JButton("Remover selecionado");
            JDialog dialogRemover = new JDialog(frameLeitor, "Remover Favorito", true);
            dialogRemover.add(new JScrollPane(tabelaRemover), BorderLayout.CENTER);
            dialogRemover.add(botaoConfirmar, BorderLayout.SOUTH);
            dialogRemover.setSize(400, 300);
            dialogRemover.setLocationRelativeTo(frameLeitor);

            botaoConfirmar.addActionListener(ev -> {
                int linhaSelecionada = tabelaRemover.getSelectedRow();
                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(dialogRemover, "Selecione um livro para remover!");
                    return;
                }
                Livro livroRemovido = leitorLogado.livrosFavoritos.get(linhaSelecionada);
                leitorLogado.livrosFavoritos.remove(linhaSelecionada);
                JOptionPane.showMessageDialog(dialogRemover, "'" + livroRemovido.nome + "' removido dos favoritos!");
                dialogRemover.dispose();
            });

            dialogRemover.setVisible(true);
        });
    }
}
