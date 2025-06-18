package TESTES;

import CONTROLADOR.Controlador;
import MODELO.FUNCIONARIOS.Efetivo;
import MODELO.FUNCIONARIOS.Substituto;
import MODELO.FUNCIONARIOS.Tecnico;
import java.util.Scanner;

public class TesteUniversidade {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        System.out.println("===== SISTEMA DE CADASTRO UNIVERSITÁRIO =====");
        System.out.println("===== MENU INTERATIVO DE TESTES =====");
        
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Adicionar Departamento");
            System.out.println("2. Adicionar Funcionário Técnico");
            System.out.println("3. Adicionar Docente Efetivo");
            System.out.println("4. Adicionar Docente Substituto");
            System.out.println("5. Relatórios");
            System.out.println("6. Buscas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch(opcao) {
                case 1:
                    adicionarDepartamento(controlador, scanner);
                    break;
                case 2:
                    adicionarTecnico(controlador, scanner);
                    break;
                case 3:
                    adicionarEfetivo(controlador, scanner);
                    break;
                case 4:
                    adicionarSubstituto(controlador, scanner);
                    break;
                case 5:
                    menuRelatorios(controlador, scanner);
                    break;
                case 6:
                    menuBuscas(controlador, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        scanner.close();
    }
    
    private static void adicionarDepartamento(Controlador controlador, Scanner scanner) {
        System.out.println("\n--- Adicionar Departamento ---");
        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine();
        System.out.print("Código do Departamento: ");
        String codigo = scanner.nextLine();
        
        controlador.adicionaDepartamento(nome, codigo);
    }
    
    private static void adicionarTecnico(Controlador controlador, Scanner scanner) {
        System.out.println("\n--- Adicionar Técnico ---");
        System.out.print("Código do Departamento: ");
        String codDep = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Salário Base: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nível (T1 ou T2): ");
        String nivel = scanner.nextLine();
        System.out.print("Função (Assessor/Laboratório/Secretário): ");
        String funcao = scanner.nextLine();
        
        controlador.adicionaFuncionario(codDep, new Tecnico(nome, codigo, salario, nivel, funcao));
    }
    
    private static void adicionarEfetivo(Controlador controlador, Scanner scanner) {
        System.out.println("\n--- Adicionar Docente Efetivo ---");
        System.out.print("Código do Departamento: ");
        String codDep = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Salário Base: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nível (D1, D2 ou D3): ");
        String nivel = scanner.nextLine();
        System.out.print("Titulação (Graduação/Mestrado/Doutorado/Livre-Docente/Titular): ");
        String titulacao = scanner.nextLine();
        System.out.print("Área (Exatas/Biológicas/Humanas/Saúde): ");
        String area = scanner.nextLine();
        
        controlador.adicionaFuncionario(codDep, new Efetivo(nome, codigo, salario, nivel, titulacao, area));
    }
    
    private static void adicionarSubstituto(Controlador controlador, Scanner scanner) {
        System.out.println("\n--- Adicionar Docente Substituto ---");
        System.out.print("Código do Departamento: ");
        String codDep = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Salário Base: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nível (S1 ou S2): ");
        String nivel = scanner.nextLine();
        System.out.print("Titulação (Graduação/Mestrado/Doutorado/Livre-Docente/Titular): ");
        String titulacao = scanner.nextLine();
        System.out.print("Carga Horária (12 ou 24): ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        controlador.adicionaFuncionario(codDep, new Substituto(nome, codigo, salario, nivel, titulacao, cargaHoraria));
    }
    
    private static void menuRelatorios(Controlador controlador, Scanner scanner) {
        int opcao;
        
        do {
            System.out.println("\n===== MENU DE RELATÓRIOS =====");
            System.out.println("1. Relatório Geral");
            System.out.println("2. Resumo dos Departamentos");
            System.out.println("3. Departamentos com gasto em faixa específica");
            System.out.println("4. Funcionários com salário em faixa específica");
            System.out.println("5. Todos os Funcionários");
            System.out.println("6. Todos os Técnicos");
            System.out.println("7. Todos os Docentes");
            System.out.println("8. Todos os Docentes Efetivos");
            System.out.println("9. Todos os Docentes Substitutos");
            System.out.println("10. Informações de um Departamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch(opcao) {
                case 1:
                    controlador.exibirRelatorioGeral();
                    break;
                case 2:
                    controlador.exibirResumoDepartamento();
                    break;
                case 3:
                    System.out.print("Valor inicial da faixa: ");
                    float inicio = scanner.nextFloat();
                    System.out.print("Valor final da faixa: ");
                    float fim = scanner.nextFloat();
                    scanner.nextLine(); // Limpar o buffer
                    controlador.exibirResumoDepartamentoComGastoEntre(inicio, fim);
                    break;
                case 4:
                    System.out.print("Valor inicial da faixa: ");
                    inicio = scanner.nextFloat();
                    System.out.print("Valor final da faixa: ");
                    fim = scanner.nextFloat();
                    scanner.nextLine(); // Limpar o buffer
                    controlador.exibirFuncionariosQueGanhamNaFaixa(inicio, fim);
                    break;
                case 5:
                    controlador.exibeTodosFuncionariosDaUniversidade();
                    break;
                case 6:
                    controlador.exibeTodosTecnicos();
                    break;
                case 7:
                    controlador.exibeTodosDocentes();
                    break;
                case 8:
                    controlador.exibeTodosDocentesEfetivos();
                    break;
                case 9:
                    controlador.exibeTodosDocentesSubstitutos();
                    break;
                case 10:
                    System.out.print("Código do Departamento: ");
                    String codigo = scanner.nextLine();
                    controlador.exibirInformacoesGeraisDoDepartamento(codigo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
    
    private static void menuBuscas(Controlador controlador, Scanner scanner) {
        int opcao;
        
        do {
            System.out.println("\n===== MENU DE BUSCAS =====");
            System.out.println("1. Buscar Departamento por Nome");
            System.out.println("2. Buscar Departamento por Código");
            System.out.println("3. Buscar Funcionário por Nome");
            System.out.println("4. Buscar Funcionário por Código");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch(opcao) {
                case 1:
                    System.out.print("Nome do Departamento: ");
                    String nome = scanner.nextLine();
                    controlador.BuscaDepartamentoPorNome(nome);
                    break;
                case 2:
                    System.out.print("Código do Departamento: ");
                    String codigo = scanner.nextLine();
                    controlador.BuscaDepartamentoPorCodigo(codigo);
                    break;
                case 3:
                    System.out.print("Nome do Funcionário: ");
                    nome = scanner.nextLine();
                    controlador.BuscaFuncionarioPorNome(nome);
                    break;
                case 4:
                    System.out.print("Código do Funcionário: ");
                    codigo = scanner.nextLine();
                    controlador.BuscaFuncionarioPorCodigo(codigo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
}
