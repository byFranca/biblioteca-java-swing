package exercicios_fixacao;
import javax.swing.*;

public class Ex7 {
    public static void main(String[] args) {
        JFrame tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setTitle("Teste tbela");
        tela.setSize(500, 500);
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        String[] cabecalho = {"Nome", "Autor", "Genero"};
        Object[][] dados = {
            {"Diario de um banana", "autor 1", "comedia"},
            {"A culpa é das estrelas", "autor 2", "romance"},
            {"Ordem paranormal", "autor 3", "terror"}
        };

        JTable tabela = new JTable(dados, cabecalho);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
        tela.add(painel);
        tela.setVisible(true);


    }
}
