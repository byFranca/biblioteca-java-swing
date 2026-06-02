import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

public class TelaLogin {
    public TelaLogin(ArrayList<Livro> livros, ArrayList<Leitor> leitores, String[] modoAtual) {
        modoAtual[0] = "Livro";

        JFrame frameLogin = new JFrame();
        frameLogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameLogin.setTitle("Tela De Login");
        frameLogin.setSize(400, 150);
        frameLogin.setLocationRelativeTo(null);

        JPanel painelLogin = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel labelNome = new JLabel("Insira seu nome:");
        JLabel labelSenha = new JLabel("Insira sua senha:");
        JTextField campoNome = new JTextField(20);
        JPasswordField campoSenha = new JPasswordField(20);
        JButton botaoEntrar = new JButton("Entrar");

        painelLogin.add(labelNome);
        painelLogin.add(campoNome);
        painelLogin.add(labelSenha);
        painelLogin.add(campoSenha);

        frameLogin.add(painelLogin);
        frameLogin.add(botaoEntrar, BorderLayout.SOUTH);
        frameLogin.setVisible(true);

        // CONFIRMAÇÃO AO FECHAR
        frameLogin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(
                    frameLogin,
                    "Tem certeza que deseja sair do sistema?",
                    "Confirmar saída",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirmacao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        botaoEntrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String senha = new String(campoSenha.getPassword());

            if (nome.equals("admin") && senha.equals("1234")) {
                new TelaAdmin(livros, leitores, modoAtual);
                frameLogin.dispose();
            } else {
                Leitor leitorLogado = null;
                for (int i = 0; i < leitores.size(); i++) {
                    if (leitores.get(i).getNome().equals(nome) && leitores.get(i).getSenha().equals(senha)) {
                        leitorLogado = leitores.get(i);
                        break;
                    }
                }

                if (leitorLogado != null) {
                    new TelaLeitor(livros, leitores, leitorLogado, modoAtual);
                    frameLogin.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Nome ou senha incorretos!");
                }
            }
        });
    }
}
