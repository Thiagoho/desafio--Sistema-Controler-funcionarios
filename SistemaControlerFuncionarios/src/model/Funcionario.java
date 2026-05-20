package model;
// 	Usando Encapsulamento

public class Funcionario {
	// Atributos
	private int id;
	private String nome;
	private String cargo;
	private double salarioBase;

	// Construtores
	public Funcionario(int id, String nome, String cargo, double salarioBase) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salarioBase = salarioBase;

	}
	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double calcularSalarioFinal() {
		return salarioBase;
	}

	// Método toString()
    @Override
    public String toString() {
        return "Funcionario {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
