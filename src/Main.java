import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU RH ---");
            System.out.println("1 - Cadastrar Departamento");
            System.out.println("2 - Listar Departamentos");
            System.out.println("3 - Cadastrar Funcionário");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Exportar Funcionários CSV");
            System.out.println("6 - Gerar gráfico de salários"); // <-- adicionado
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do departamento: ");
                    String nomeDep = sc.nextLine();
                    Departamento d = new Departamento();
                    d.setNome(nomeDep);
                    try {
                        new DepartamentoDAO().inserir(d);
                        System.out.println("Departamento inserido!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        for (Departamento dep : new DepartamentoDAO().listar()) {
                            System.out.println(dep.getId() + " - " + dep.getNome());
                        }
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Nome do funcionário: ");
                        String nomeFunc = sc.nextLine();
                        System.out.print("Salário: ");
                        double salario = sc.nextDouble();
                        sc.nextLine(); // limpar buffer
                        System.out.print("ID do Departamento: ");
                        int idDep = sc.nextInt();
                        sc.nextLine(); // limpar buffer

                        Funcionario f = new Funcionario();
                        f.setNome(nomeFunc);
                        f.setSalario(salario);

                        Departamento dep = new Departamento();
                        dep.setId(idDep);
                        f.setDepartamento(dep);

                        new FuncionarioDAO().salvar(f);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        for (Funcionario f : new FuncionarioDAO().listar()) {
                            System.out.printf("%d - %s | Salário: %.2f | Departamento: %s%n",
                                    f.getId(), f.getNome(), f.getSalario(), f.getDepartamento().getNome());
                        }
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        new FuncionarioDAO().exportarFuncionariosCSV("funcionarios.csv");
                    } catch (Exception e) {
                        System.out.println("Erro ao exportar CSV: " + e.getMessage());
                    }
                    break;
                    case 6:
                        try {
                        List<Funcionario> lista = new FuncionarioDAO().listar();
                            new Grafico().gerarGraficoSalarios(lista, "grafico_salarios.png");
                        } catch (Exception e) {
                        System.out.println("Erro ao gerar gráfico: " + e.getMessage());
                     }
                break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
