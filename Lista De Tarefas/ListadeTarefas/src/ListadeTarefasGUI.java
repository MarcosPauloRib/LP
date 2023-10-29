import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ListadeTarefasGUI extends JFrame {
    ArrayList<String> tarefas = new ArrayList<String>();
    private JPanel painel = new JPanel();
    private JButton jButtonAdicionar = new JButton("Adicionar Tarefa");
    private JButton jButtonRemover = new JButton("Remover Tarefa");
    private JButton jButtonListar = new JButton("Listar Tarefas");

    public ListadeTarefasGUI(){
        this.setTitle("Aplicativo de Lista de Tarefas");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));


        jButtonAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tarefa = JOptionPane.showInputDialog(null, "Insira sua tarefa: ", "Adicionar Tarefa", JOptionPane.INFORMATION_MESSAGE);
                    if (tarefa != null) {
                        // O usuário pressionou "Ok"
                        if (!tarefa.isEmpty()) {
                            adicionarTarefa(tarefas, tarefa);
                            JOptionPane.showMessageDialog(null, "Tarefa Adicionada com sucesso!", "Adicionando Tarefa", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhuma tarefa foi inserida.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // O usuário pressionou "Cancel" ou o botão de fechar
                        System.err.println("Operação cancelada.");
                    }
                } catch (NullPointerException exception) {
                    System.err.println("Operação cancelada.");
                }
            }
        });

        jButtonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object indice = JOptionPane.showInputDialog(null, "Insira o indice da tarefa que deseja remover", "Remover Tarefa", JOptionPane.INFORMATION_MESSAGE);
                    int indiceInt = Integer.parseInt(indice.toString());
                    removerTarefa(tarefas, indiceInt);
                    JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!", "Removendo Tarefa", JOptionPane.INFORMATION_MESSAGE);
                }catch(IndexOutOfBoundsException exception){
                    System.err.println("Esta tarefa não existe!");
                    JOptionPane.showMessageDialog(null, "Esta tarefa não existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }catch(NumberFormatException Exception){
                    System.err.println("Indice inválido!");
                    JOptionPane.showMessageDialog(null, "O indice inserido é invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }catch(NullPointerException exception){
                    System.err.println("Operação cancelada.");
                }
            }
        });

        jButtonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tarefas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você não tem tarefas.");
                } else {
                    int i=0;
                    StringBuilder mensagem = new StringBuilder("Suas tarefas são:\n");
                    for (String tarefa : tarefas) {
                        mensagem.append(i).append(" - ").append(tarefa).append("\n");
                        i++;
                    }
                    JOptionPane.showMessageDialog(null, mensagem.toString());
                }

            }
        });


        painel.add(jButtonAdicionar);
        painel.add(jButtonRemover);
        painel.add(jButtonListar);

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static void adicionarTarefa(ArrayList<String> tarefas, String tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void removerTarefa(ArrayList<String> tarefas, int indice){
        tarefas.remove(indice);
        System.out.println("Tarefa removida com sucesso!");
    }

    private static void listarTarefas(ArrayList<String> tarefas){
        int i = 0;
        for (String tarefa : tarefas) {
            System.out.println("Minha tarefa " + i + " = " + tarefa);
            i++;
        }
    }

    public static void main(String[] args) {
        new ListadeTarefasGUI();
    }

}
