package exercicios_fixacao;

import javax.swing.*;

public class Ex10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Exercicio de Menu");
        frame.setLocationRelativeTo(null);

        JMenuBar barraDeMenu = new JMenuBar();
        JMenu opc1 = new JMenu("Livros");
        JMenu opc2 = new JMenu("Leitores");


        barraDeMenu.add(opc1);
        barraDeMenu.add(opc2);

        JMenuItem itemMostrar = new JMenuItem("Mostrar livros");
        opc1.add(itemMostrar);

        JMenuItem itenLeitor = new JMenuItem("Mostrar leitores");
        opc2.add(itenLeitor);

        itemMostrar.addActionListener(e ->{
            System.out.println("Clicou em livros");
        });

        itenLeitor.addActionListener(e ->{
            System.out.println("Clicou em leitores");
        });

        frame.setJMenuBar(barraDeMenu);
        frame.setVisible(true);
    }
}
