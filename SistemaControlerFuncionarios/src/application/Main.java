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
				if (service.listarTodos().isEmpty()) {
					System.out.println("\t Nenhum funcionário cadastrado.");
				} else {
					System.out.println("\t ==== LISTA DE FUNCIONÁRIOS ====");
				}
					
				
			for (Funcionario f : service.listarTodos()) {
				System.out.println(f);
			}
			break;
			
			case 3:
				System.out.println("Digite o ID do funcionário: ");
				int idBusca = scanner.nextInt();
				Funcionario funcionarioEncontrado = service.buscarPorId(idBusca);
				
				if (funcionarioEncontrado != null) {
					System.out.println("\t >> Funcionário encontrado.");
				} else {
					System.out.println("\t >> Funcionário não encontrado.");
				}
				break;
				
			case 4:
				System.out.println("Digite o ID do funcionário que deseja atualizar");
				int idAtualizar = scanner.nextInt();
				scanner.nextLine();
				Funcionario funcionarioAtualizar = service.buscarPorId(idAtualizar);
				
				if (funcionarioAtualizar != null) {
					System.out.println("Nome atual: " + funcionarioAtualizar.getNome());
					System.out.println("Novo nome ou ENTER para manter: ");
					String novoNome = scanner.nextLine();
					if (novoNome.isBlank()) {
						novoNome = funcionarioAtualizar.getNome();
					}
					
					System.out.println("Cargo atual: " + funcionarioAtualizar.getCargo());
					System.out.println("Novo Cargo ou ENTER para manter: ");
					String novoCargo = scanner.nextLine();
					if (novoCargo.isBlank()) {
						novoCargo = funcionarioAtualizar.getCargo();
					}
					
					System.out.println("Salário atual: " + funcionarioAtualizar.getSalarioBase());
					System.out.println("Novo salário ou ENTER para manter: ");
					String salarioDigitado = scanner.nextLine();
					
					double novoSalario;
					
					if (salarioDigitado.isBlank()) {
						novoSalario = funcionarioAtualizar.getSalarioBase();
						
					} else {
						novoSalario = Double.parseDouble(salarioDigitado);
					}
					
					boolean atualizado = service.atualizar(idAtualizar, novoNome, novoCargo, novoSalario);
				if (atualizado) {
					System.out.println("\t >> Funcionário atualizando com sucesso!");
				}
				} else {
					System.out.println("\t >> Funcionário não encontrado.");
				}
						
				break;
			case 5:
				System.out.println("Digite o ID do funcionário que deseja excluir:");
				int idExcluir = scanner.nextInt();
				boolean excluido = service.excluir(idExcluir);
				if (excluido) {
					System.out.println("\t >> Funcionario excluído com sucesso!");
					
				} else {
					System.out.println("\t >>Funcionario não encontrado.");
				}
				break;
			
			case 0:
				System.out.println("\t >>>Sistema encerrado.<<<");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
				
		} while (opcao != 0);
		scanner.close();

	}

}
