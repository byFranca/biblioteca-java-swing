import java.util.ArrayList;
import javax.swing.*;

public class TelaLogin {
    public TelaLogin(ArrayList<Livro> livros, ArrayList<Leitor> leitores) {
        JFrame frameLogin = new JFrame();
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setTitle("Tela De Login");
        frameLogin.setSize(400, 300);
        frameLogin.setLocationRelativeTo(null);

        JPanel painelLogin = new JPanel();
        JLabel labelNome = new JLabel("Insira seu nome:");
        JLabel labelSenha = new JLabel("Insira sua senha:");
        JTextField campoNome = new JTextField(20);
        JTextField campoSenha = new JTextField(20);
        JButton botaoEntrar = new JButton("Entrar");

        painelLogin.add(labelNome);
        painelLogin.add(campoNome);
        painelLogin.add(labelSenha);
        painelLogin.add(campoSenha);
        painelLogin.add(new JLabel());
        painelLogin.add(botaoEntrar);

        frameLogin.add(painelLogin);
        frameLogin.setVisible(true);

        botaoEntrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String senha = campoSenha.getText();

            if (nome.equals("admin") && senha.equals("1234")) {
                // new TelaAdmin();
                System.out.println("entrou como admin");
            } else {
                Leitor leitorLogado = null;
                for (int i = 0; i < leitores.size(); i++) {
                    if (leitores.get(i).nome.equals(nome) && leitores.get(i).senha.equals(senha)) {
                        leitorLogado = leitores.get(i);
                        break;
                    }
                }

                if (leitorLogado != null) {
                    // new TelaLeitor();
                    System.out.println("entrou como o leitor "+leitorLogado.nome);
                } else {
                    JOptionPane.showMessageDialog(null, "Nome ou senha incorretos!");
                }
            }
        });

    }
}
