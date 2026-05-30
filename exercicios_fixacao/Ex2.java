package exercicios_fixacao;
import javax.swing.*;

public class Ex2 {
    public static void main(String[] args) {

        JFrame janela = new JFrame();

        janela.setSize(500, 400);
        janela.setTitle("Meu primeiro Swing");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JButton meuBotao = new JButton("Clique aqui");
        janela.add(meuBotao);
        janela.setVisible(true);

    }
}
