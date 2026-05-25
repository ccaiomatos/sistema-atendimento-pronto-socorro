import java.util.Scanner;

public class ProntoSocorro {
    // Três filas separadas por nível de gravidade
    private FilaEncadeada<Paciente> filaGrave = new FilaEncadeada<>();
    private FilaEncadeada<Paciente> filaModerada = new FilaEncadeada<>();
    private FilaEncadeada<Paciente> filaLeve = new FilaEncadeada<>();

    // Contadores de pacientes atendidos por nível
    private int atendidosGrave = 0;
    private int atendidosModerada = 0;
    private int atendidosLeve = 0;

    // Método principal que exibe o menu e controla as opções
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Inserir paciente");
            System.out.println("2 - Atender paciente");
            System.out.println("3 - Exibir filas");
            System.out.println("4 - Fazer todas as filas vazias");
            System.out.println("5 - Relatório final e sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    inserirPaciente(sc);
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    exibirFilas();
                    break;
                case 4:
                    esvaziarFilas();
                    break;
                case 5:
                    gerarRelatorio();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        sc.close();
    }

    // Insere um novo paciente na fila de acordo com a prioridade informada
    private void inserirPaciente(Scanner sc) {
        System.out.print("Nome do paciente: ");
        String nome = sc.nextLine();

        System.out.print("Prioridade [vermelha (1), amarela (2), verde (3)]: ");
        int opcao = sc.nextInt();
        String prioridade;
        
        switch (opcao) {
          case 1:
            prioridade = "vermelha";
            break;
          case 2:
            prioridade = "amarela";
          case 3:
            prioridade = "verde";
          default:
            System.out.println("Prioridade inválida! Paciente não inserido.");
            return;
        }

        Paciente paciente = new Paciente(nome, prioridade);

        switch (opcao) {
            case 1:
                filaGrave.enfileirar(paciente);
                break;
            case 2:
                filaModerada.enfileirar(paciente);
                break;
            case 3:
                filaLeve.enfileirar(paciente);
                break;
        }
    }

    // Atende o próximo paciente com maior prioridade
    private void atenderPaciente() {
        if (!filaGrave.estaVazia()) {
            Paciente p = filaGrave.desenfileirar();
            System.out.println("Atendendo (GRAVE): " + p.getNome());
            atendidosGrave++;
        } else if (!filaModerada.estaVazia()) {
            Paciente p = filaModerada.desenfileirar();
            System.out.println("Atendendo (MODERADA): " + p.getNome());
            atendidosModerada++;
        } else if (!filaLeve.estaVazia()) {
            Paciente p = filaLeve.desenfileirar();
            System.out.println("Atendendo (LEVE): " + p.getNome());
            atendidosLeve++;
        } else {
            System.out.println("Nenhum paciente para atender.");
        }
    }

    // Exibe o conteúdo atual de todas as filas
    private void exibirFilas() {
        System.out.println("\nFila GRAVE: " + filaGrave);
        System.out.println("Fila MODERADA: " + filaModerada);
        System.out.println("Fila LEVE: " + filaLeve);
    }

    // Esvazia todas as filas
    private void esvaziarFilas() {
        filaGrave.fazVazia();
        filaModerada.fazVazia();
        filaLeve.fazVazia();
        System.out.println("Todas as filas foram esvaziadas.");
    }

    // Gera e exibe o relatório final de atendimentos
    private void gerarRelatorio() {
        System.out.println("\nRelatório Final:");
        System.out.println("Pacientes atendidos (GRAVE): " + atendidosGrave);
        System.out.println("Pacientes atendidos (MODERADA): " + atendidosModerada);
        System.out.println("Pacientes atendidos (LEVE): " + atendidosLeve);
    }

}
