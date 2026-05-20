package model;

public class Vendedor extends Funcionario {
	private double comissao;

	public Vendedor(int id, String nome, String cargo, double salarioBase, double comissao) {
		super(id, nome, cargo, salarioBase);
		this.comissao = comissao;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;

	}

	public double calcularSalarioFinal() {
		return calcularSalarioFinal() + comissao;
	}

	@Override
	public String toString() {
		return super.toString() + "| comissao=" + comissao + "| salarioFinal=" + calcularSalarioFinal();
	}

}
