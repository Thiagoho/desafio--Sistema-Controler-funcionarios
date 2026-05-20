package model;

//	Usando HERANÇA
public class Gerente extends Funcionario {

	private double bonusGerencial;

	public Gerente(int id, String nome, String cargo, double salarioBase, double bonusGerencial) {
		super(id, nome, cargo, salarioBase);
		this.bonusGerencial = bonusGerencial;
	}

	public double getBonusGerencial() {
		return bonusGerencial;

	}

	public void setBonusGerencial(double bonusGerencial) {
		this.bonusGerencial = bonusGerencial;
	}

	public double calcularSalarioFinal() {
		return getSalarioBase() + bonusGerencial;
	}

	@Override
	public String toString() {
		return super.toString() + " | bunusGerencial=" + bonusGerencial + " | salarioFinal=" + calcularSalarioFinal();
	}
}
