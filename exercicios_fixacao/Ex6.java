package exercicios_fixacao;

import javax.swing.*;
public class Ex6 {
    public static void main(String[] args) {
        JFrame login = new JFrame();
        login.setSize(400, 300);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setTitle("Tela de login");

        JPanel painel = new JPanel();
        JLabel labelNome = new JLabel("Insira seu nome:");
        JLabel labelSenha = new JLabel("Insira sua senha:");
        JTextField campoNome = new JTextField(20);
        JTextField campoSenha = new JTextField(20);
        JButton meuBotao = new JButton("Entrar");

        meuBotao.addActionListener(e -> {
            String nome = campoNome.getText();
            String senha = campoSenha.getText();
            String mensagem;
            if (nome.equals("admin") && senha.equals("1234")) {
                mensagem = "Bem vindo, " + nome;
            }else{
                mensagem = "Credenciais incorretas!";
            }

            JOptionPane.showMessageDialog(null, mensagem);
        });

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(new JLabel());
        painel.add(meuBotao);
        login.add(painel);

        login.setVisible(true);

    }
}
