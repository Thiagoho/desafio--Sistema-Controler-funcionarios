package services;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioService {
	private List<Funcionario> funcionarios = new ArrayList<>();

	public void cadastrar(Funcionario funcionario) {
		funcionarios.add(funcionario);
		System.out.println("Funcionario cadastrado com sucesso!");
	}

	public List<Funcionario> listarTodos() {
		return funcionarios;
	}

	public Funcionario buscarPorId(int id) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId() == id) {
				return funcionario;
			}
		}
	return null;
	}

	public boolean atualizar(int id, String nome, String cargo, double salarioBase) {
		Funcionario funcionario = buscarPorId(id);
		if (funcionario != null) {
			funcionario.setNome(nome);
			funcionario.setCargo(cargo);
			funcionario.setSalarioBase(salarioBase);
			return true;
		}
		return false;
	}

	public boolean excluir(int id) {
		Funcionario funcionario = buscarPorId(id);
		if (funcionario != null) {
			funcionarios.remove(funcionarios);
			return true;
		}
		return false;
	}
}
