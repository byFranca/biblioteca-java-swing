package exercicios_fixacao;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.*;

public class Ex9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Exercicio de BorderLayout");
        frame.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Lista de livros");
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "nome", "autor", "genero" });
        modelo.addRow(new String[] { "livro 1", "autor 1", "genero 1" });
        modelo.addRow(new String[] { "livro 2", "autor 2", "genero 2" });
        modelo.addRow(new String[] { "livro 3", "autor 3", "genero 3" });

        JTable tabela = new JTable(modelo);

        JButton botao = new JButton("Limpar tabela");
        botao.addActionListener(e -> {
            modelo.setRowCount(0);
        });
        JButton add = new JButton("adicionar");
        add.addActionListener(e ->{
            modelo.addRow(new String[] { "livro 3", "autor 3", "genero 3" });
        });

        JPanel painelBtn = new JPanel();
        painelBtn.add(botao);
        painelBtn.add(add);

        JPanel painelTitulo = new JPanel();
        painelTitulo.add(titulo);
        frame.add(tabela, BorderLayout.CENTER);
        frame.add(painelBtn, BorderLayout.SOUTH);
        frame.add(painelTitulo, BorderLayout.NORTH);

        

        frame.setVisible(true);

    }
}