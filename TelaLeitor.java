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

        botaoSair.addActionListener(e ->{
            new TelaLogin(livros, leitores, modoAtual);
            frameLeitor.dispose();
        });

    }
}