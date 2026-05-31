import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaAdmin {
    public TelaAdmin(ArrayList<Livro> livros, ArrayList<Leitor> leitores) {
        String[] modoAtual = { "Livro" };

        // Essa parte é o frame em si (a tela)
        JFrame frameAdmin = new JFrame();
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdmin.setSize(700, 500);
        frameAdmin.setLocationRelativeTo(null);
        frameAdmin.setTitle("MENU ADMINISTRADOR");

        // Aqui eu faço a barra do menu, e adiciono os itens no menu
        // tambem adciono a barra do menu ao frame
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuLivro = new JMenu("Livros");
        JMenu menuleitor = new JMenu("Leitores");
        JMenuItem itenLivro = new JMenuItem("Operações com livros");
        JMenuItem itenLeitor = new JMenuItem("Operações com leitores");
        menuLivro.add(itenLivro);
        menuleitor.add(itenLeitor);
        barraMenu.add(menuLivro);
        barraMenu.add(menuleitor);
        frameAdmin.setJMenuBar(barraMenu);

        // crio o modelo da tabela, adiciono o modelo a tabela e adiciono a tabela ao
        // scroll
        DefaultTableModel modeloTabela = new DefaultTableModel();

        JTable tabela = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabela);

        renderizarTabela(livros, leitores, modeloTabela, modoAtual);

        // Adiciono os botoes ao painel deles
        JPanel painelBotoes = new JPanel();
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoRemover = new JButton("Remover");
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoRemover);

        // Adiciono tudo ao meu frame
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
    }

    public static void renderizarTabela(ArrayList<Livro> livros, ArrayList<Leitor> leitores,
            DefaultTableModel modeloTabela, String[] modoAtual) {
        modeloTabela.setColumnCount(0);
        modeloTabela.setRowCount(0);

        if (modoAtual[0].equals("Livro")) {
            modeloTabela.setColumnIdentifiers(new String[] { "id", "Nome", "Autor", "Genero", "Preço" });
            for (int i = 0; i < livros.size(); i++) {
                Livro l = livros.get(i);
                modeloTabela.addRow(new Object[] { (i + 1), l.nome, l.nomeAutor, l.genero, "R$" + l.preco });
            }
        }

        if (modoAtual[0].equals("Leitor")) {
            modeloTabela.setColumnIdentifiers(new String[] { "id", "Nome", "Telefone" });
            for (int i = 0; i < leitores.size(); i++) {
                Leitor l = leitores.get(i);
                modeloTabela.addRow(new Object[] { (i + 1), l.nome, l.telefone });
            }
        }
    }
}
