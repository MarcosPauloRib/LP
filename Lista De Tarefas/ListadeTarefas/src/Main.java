import java.util.ArrayList;
import java.util.Scanner;
// tirar print das telas e colocar no read me do github
public class Main {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<String>();
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        do{
            System.out.println("|-- Aplicativo de Lista de Tarefas --|");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Listar tarefas");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção:");
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a tarefa a ser adicionada:");
                    String tarefa = ler.nextLine();
                    // chame o método para adicionar a tarefa
                    adicionarTarefa(tarefas, tarefa);
                    break;

                case 2:
                    System.out.println("Digite o indice da tarefa a ser removida: ");
                    int indice = ler.nextInt();
                    //chame o método para remover tarefa
                    removerTarefa(tarefas, indice);
                    break;

                case 3:
                    //chame o método para listar tarefas
                    listarTarefas(tarefas);
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    ler.close();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 4);
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
}