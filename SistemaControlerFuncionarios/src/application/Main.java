package application;

import java.util.Scanner;

import database.Conexao;
import model.Funcionario;
import services.FuncionarioService;

public class Main {

	public static void main(String[] args) {
		 Conexao.conectar(); // Seria a ligação com Mysql
		 
		Scanner scanner = new Scanner(System.in);

		FuncionarioService service = new FuncionarioService();
		
		int opcao;
		do {
			System.out.println("\t ===== SISTEMA DE CONTROLE DE FUNCIONÁRIOS =====");
			System.out.println("1 - Cadastrar funcionário");
			System.out.println("2 - Listar funcionários");
			System.out.println("3 - Buscar funcionário por ID");
			System.out.println("4 - Atualizar funcionário");
			System.out.println("5 - Excluir funcionario");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção:");
			opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
            case 1:
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();

                System.out.print("Salário base: ");
                double salarioBase = scanner.nextDouble();

                Funcionario funcionario = new Funcionario(id, nome, cargo, salarioBase);
                service.cadastrar(funcionario);
                break;
                
			case 2:
			for (Funcionario f : service.listarTodos()) {
				System.out.println(f);
			}
			break;
			
			case 3:
				System.out.println("Digite o ID do funcionário: ");
				int idBusca = scanner.nextInt();
				Funcionario funcionarioEncontrado = service.buscarPorId(idBusca);
				
				if (funcionarioEncontrado != null) {
					System.out.println("\t Funcionário encontrado:");
				} else {
					System.out.println("Funcionário não encontrado.");
				}
				break;
				
			case 4:
				System.out.println("Digite o ID do funcionário que deseja atualizar");
				int idAtualizar = scanner.nextInt();
				scanner.nextLine();
				Funcionario funcionarioAtualizar = service.buscarPorId(idAtualizar);
				
				if (funcionarioAtualizar != null) {
					System.out.println("Novo nome: ");
					String novoNome = scanner.nextLine();
					
					System.out.println("NovoCargo: ");
					String novoCargo = scanner.nextLine();
					
					System.out.println("Novo salário base: ");
					double novoSalario = scanner.nextDouble();
					
					boolean atualizado = service.atualizar(idAtualizar, novoNome, novoCargo, novoSalario);
					if (atualizado) {
						System.out.println("Funcionário atualizado com sucesso!");
			
					} else {
						System.out.println("Funcionário não encontrado.");
			
					}
					break;
				}
			case 5:
				System.out.println("Digite o ID do funcionário que deseja excluir:");
				int idExcluir = scanner.nextInt();
				boolean excluido = service.excluir(idExcluir);
				if (excluido) {
					System.out.println("Funcionario excluído com sucesso!");
					
				} else {
					System.out.println("Funcionario não encontrado.");
				}
				break;
			
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
				
		} while (opcao != 0);
		scanner.close();

	}

}
