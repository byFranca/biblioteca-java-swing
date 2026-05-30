package exercicios_fixacao;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3 {
    public static void main(String[] args) {
        JFrame janela = new JFrame();

        janela.setSize(500, 400);
        janela.setTitle("Meu primeiro Swing");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JButton meuBotao = new JButton("Clique aqui");
        janela.add(meuBotao);

        meuBotao.addActionListener(e ->{
            System.out.println("Botao clicado");
        });


        janela.setVisible(true);

    }
}
