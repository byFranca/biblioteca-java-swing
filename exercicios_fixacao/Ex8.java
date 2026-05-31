package exercicios_fixacao;
import java.awt.BorderLayout;

import javax.swing.*;

public class Ex8 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Exercicio de BorderLayout");
        frame.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Lista de livros");

        String[] colunas = {"nome", "autor", "genero"};
        Object[][] linhas = {
            {"livro 1", "autor 1", "genero 1"},
            {"livro 2", "autor 2", "genero 2"},
            {"livro 3", "autor 3", "genero 3"}
        };

        JTable tabela = new JTable(linhas, colunas);
        

        JButton botao = new JButton("Limpar tabela");
        botao.addActionListener(e ->{
            System.out.println("voce clicou");
        });

        frame.add(titulo, BorderLayout.NORTH);
        frame.add(tabela, BorderLayout.CENTER);
        frame.add(botao, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
