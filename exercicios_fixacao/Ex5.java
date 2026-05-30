package exercicios_fixacao;

import javax.swing.*;

public class Ex5 {
    public static void main(String[] args) {
        JFrame tela = new JFrame();
        tela.setTitle("Tela qualquer");
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(600, 500);

        JPanel painel = new JPanel();
        JLabel labelNome = new JLabel("Digite o seu nome: ");
        JTextField campoNome = new JTextField(20);
        JButton botao = new JButton("Clique aqui");

        botao.addActionListener(e -> {
            String nome = campoNome.getText();
            JOptionPane.showMessageDialog(null, "Ola, " + nome);
        });

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(botao);
        tela.add(painel);

        tela.setVisible(true);
    }
}
