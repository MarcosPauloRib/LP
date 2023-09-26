package lotofacil;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import javax.swing.*;
import java.lang.String;

public class LotofacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");

    // Construtor
    public LotofacilGUI(){
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));


        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Antes
                //Scanner in = new Scanner(System.in);
                //int aposta = in.Nextint();

                //Depois
                String numeroApostado = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100: ");
                Random rdn = new Random();
                int numeroSorteado = rdn.nextInt(101);
                int numeroApostadoInt = Integer.parseInt(numeroApostado);
                if(numeroSorteado == numeroApostadoInt){
                    JOptionPane.showMessageDialog(null, "Você ganhou mil reais.");
                }else{
                    JOptionPane.showMessageDialog(null, "Você perdeu. O número sorteado foi: " + numeroSorteado);
                }
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letraApostada = JOptionPane.showInputDialog(null, "Digite a letra de A a Z: ");

                char letra[] = {'J'};
                String letraSorteada = new String(letra);
                char letrinha[] = {'j'};
                String letrinhaSorteada = new String(letrinha);

                if(Objects.equals(letraApostada, letraSorteada) || Objects.equals(letraApostada, letrinhaSorteada)){
                    JOptionPane.showMessageDialog(null, "Você ganhou quinhentos reais!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Você perdeu!" + "\n" + "A letra sorteada foi: " + "\t" + letraSorteada);
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDigitado = JOptionPane.showInputDialog(null, "Digite um número:");
                int numeroDigitadoInt = Integer.parseInt(numeroDigitado);

                if(numeroDigitadoInt % 2 == 0){
                    JOptionPane.showMessageDialog(null, "Você ganhou cem reais!");
                }else{
                    JOptionPane.showMessageDialog(null, "Você perdeu!" + "\n" + "O número deveria ser par.");
                }

            }
        });

        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }
    public static void main(String[] args) {
        new LotofacilGUI();
    }
}
