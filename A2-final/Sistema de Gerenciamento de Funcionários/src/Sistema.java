import Individuos.Funcionario;
import Individuos.Gerente;
import Individuos.Desenvolvedor;
import Individuos.Estagiario;


import Trabalhavel.Trabalhavel;

public class Sistema {

    private static void exibirMenu() {

        menu();

        System.out.println("\n");
        System.out.println("[1] Cadastrar Funcionario");
        System.out.println("[2] Remover Funcionario");
        System.out.println("[3] Exibir Funcionario");
        System.out.println("[4] Listar todos os Funcionarios");
        System.out.println("|0| Sair...");
        System.out.print("\nInforme uma opção: ");
    }

    private static void verificarOpcao(int op) {
        switch (op) {
            case 1: // Cadastrar Funcionario
                cadastrarNovoFuncionario();
                break;
            case 2: // Remover Funcionario
                removerFuncionario();
                break;
            case 3: // Exibir Funcionario
                exibirFuncionario();
                break;
            case 4: // Listar Funcionarios
                listarFuncionarios();
                break;
            case 0: // Sair
                mensagemDeSaida();
                break;
            default:
                System.out.println("\nOpção inválida! Tente novamente...");
                break;
        }
    }
    private static void cadastrarNovoFuncionario() {
        System.out.println("Qual tipo de funcionário deseja cadastrar?");
        System.out.println("[1] Gerente");
        System.out.println("[2] Desenvolvedor");
        System.out.println("[3] Estagiario");
        int tipo = Console.lerInt();

        switch (tipo) {
            case 1:
                System.out.println("Informe o nome do gerente:");
                String nomeGerente = Console.lerString();

                System.out.println("Informe a matrícula do gerente:");
                String matriculaGerente = Console.lerString();

                System.out.println("Informe a equipe sob gerência do gerente:");
                String equipeGerencia = Console.lerString();

                System.out.println("Informe o bônus do gerente:");
                float bonusGerente = Console.lerFloat();

                System.out.println("Informe o salário do gerente:");
                float salarioGerente = Console.lerFloat();

                Gerente gerente = new Gerente(nomeGerente, matriculaGerente, salarioGerente, equipeGerencia, bonusGerente);
                Cadastro.cadastrar(gerente);
                break;
            case 2:
                System.out.println("Informe o nome do desenvolvedor:");
                String nomeDesenvolvedor = Console.lerString();

                System.out.println("Informe a matrícula do desenvolvedor:");
                String matriculaDesenvolvedor = Console.lerString();

                System.out.println("Informe as linguagens do desenvolvedor:");
                String linguagensDesenvolvedor = Console.lerString();

                System.out.println("Informe o salário do desenvolvedor:");
                float salarioDesenvolvedor = Console.lerFloat();

                Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDesenvolvedor, matriculaDesenvolvedor, salarioDesenvolvedor, linguagensDesenvolvedor);
                Cadastro.cadastrar(desenvolvedor);
                break;
            case 3:
                System.out.println("Informe o nome do estagiário:");
                String nomeEstagiario = Console.lerString();

                System.out.println("Informe a matrícula do estagiário:");
                String matriculaEstagiario = Console.lerString();

                System.out.println("Informe as horas de trabalho do estagiário:");
                float horasTrabalhoEstagiario = Console.lerFloat();

                System.out.println("Informe o nome do supervisor do estagiário:");
                String nomeSupervisorEstagiario = Console.lerString();

                System.out.println("Informe o salário do estagiário:");
                float salarioEstagiario = Console.lerFloat();

                Estagiario estagiario = new Estagiario(nomeEstagiario, matriculaEstagiario, salarioEstagiario, horasTrabalhoEstagiario, nomeSupervisorEstagiario);
                Cadastro.cadastrar(estagiario);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("\nFuncionário cadastrado com sucesso!");
        enterParaSeguir();
    }

    private static void removerFuncionario(){
        System.out.println("Informe a Matricula do funcionario a ser excluído:");
        String matricula = Console.lerString();
        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                Cadastro.getListaFuncionarios().remove(funcionario);
                System.out.println("Funcionario excluído com sucesso!");
                enterParaSeguir();
                return;
            }
        }
        System.out.println("Funcionario não encontrado.");
    }
    private static void exibirFuncionario() {
        System.out.println("Informe a matrícula do funcionário:");
        String matricula = Console.lerString();

        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.toString());


                //imprime os metodos da interface Trabalhavel...
                if (funcionario instanceof Trabalhavel) {
                    Trabalhavel trabalhavel = (Trabalhavel) funcionario;

                    System.out.println("\nTrabalhando: " + trabalhavel.trabalhar());
                    System.out.println("Progresso: " + trabalhavel.relatarProgresso());

                    //imprime o salario de cada funcionario respectivamente..
                    float salario = funcionario.calcularSalario();
                    System.out.println("Salário: " + salario);
                }
                enterParaSeguir();
                return;
            }
        }

        System.out.println("Funcionário não encontrado.");
    }
    private static void listarFuncionarios() {
        if (Cadastro.getListaFuncionarios().isEmpty()) {
            System.out.println("\nNão há FUncionarios cadastrados.");
        } else {
            System.out.println("\nLista de Funcionarios:");
            for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
                System.out.println(funcionario.toString());

                if (funcionario instanceof Trabalhavel) {
                    Trabalhavel trabalhavel = (Trabalhavel) funcionario;

                    System.out.println("\nTrabalhando: " + trabalhavel.trabalhar());
                    System.out.println("Progresso: " + trabalhavel.relatarProgresso());

                    //imprime o salario de cada funcionario respectivamente..
                    float salario = funcionario.calcularSalario();
                    System.out.println("Salário: " + salario);
                }
            }
            enterParaSeguir();
        }
    }


    public static void enterParaSeguir() {
        System.out.println("\nClique em qualquer tecla para continuar");
        Console.lerString();
    }


    private static void mensagemDeSaida(){
        System.out.println("\nO Encerramndo...");

    }



    private static void menu(){
        System.out.println("Cadastro de Funcionarios");

    }

    public static void executar() {
        int op;
        do {
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);
        } while (op != 0);
    }
}