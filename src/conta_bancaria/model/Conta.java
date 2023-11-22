package conta_bancaria.model;

import conta_bancaria.util.Cores;

public abstract class Conta {
	
	public static String theme = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_PURPLE_BOLD;
	public static String theme2 = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_GREEN_BOLD;

	// DEFINIR "ATRIBUTOS" DA CLASSE
	// É PRIVATE PARA SER ATLERADO APENAS POR CLASSE QUE RECEBEM "PERMISSÃO" DE
	// ALTERAR ESSES DADOS

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// O "METODO CONSTRUTOR" SEMPRE DEVE SER PUBLICO PARA QUE OUTRAS CLASSES O
	// ACESSE.
	// PARA GERÁ-LO, CLIQUE NO PRIMEIRO
	// "SOURCE", DEPOIS EM GENERATE CONSTRUCTOR USING FIELDS, MARCANDO A OPÇÃO DE
	// OMIT SUPER()
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		// o THIS está interagindo com o atributo
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// METODO GET SET, sempre comecará em minusculo. MANTEM O CONCEITO DO
	// ENCAPSULAMENTO E MANTEM AS INFOS SEGURAS.
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	// ABAIXO, TEMOS TRES "MÉTODOS AUXILIAR": VISUALIZADOR QUE VAI LISTAR OS
	// OBJETOS, SACAR E DEPOSITAR

	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + "SALDO INSUFICIENTE." + Cores.TEXT_RESET);
			return false; // ESSE RETURN VALIDA A AÇÃO COMO FALSA
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}

		System.out.println(theme2 + "\n\n*************************************");
		System.out.println(theme + "           Dados da Conta:           ");
		System.out.println(theme2 + "*************************************");
		System.out.println(theme + "Numero da Conta: " + this.numero);
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular da Conta: " + this.titular);
		System.out.println("Saldo da Conta: " + this.saldo);
	}

}
