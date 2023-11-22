package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaCorrente extends Conta {

	private float limite; /* LIMITE é o parametro atribuido para a classe Conta Corrente */

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		/*
		 * O "SUPER" TRAZ O METODO CONSTRUTOR DA CLASSE CONTA PARA DENTRO DA CLASSE
		 * CONTA CORRENTE, OU SEJA HERDA A CLASSE CONTA
		 */
		this.limite = limite;

	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override 
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + "SALDO INSUFICIENTE." + Cores.TEXT_RESET);
			return false; // ESSE RETURN VALIDA A AÇÃO COMO FALSA
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override // Esse OVERRIDE indica que o metodo abaixo esta sendo SOBRESCRITO de outra classe //
	public void visualizar () {
		super.visualizar();
		System.out.println("Limite da Conta: " + this.limite + "\n");
		
	}
	
	

} 
