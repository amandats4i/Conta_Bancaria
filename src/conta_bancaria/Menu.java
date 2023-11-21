package conta_bancaria;

import java.util.Scanner;


import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	public static String theme = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_PURPLE_BOLD;
	public static String theme2 = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_GREEN_BOLD;
	public static void main(String[] args) {

		int opcao; 
		float saque;
		String nome;

		/* Criar Objetos da Classe Conta para testes */

		Conta c1 = new Conta(1, 123, 2, "Victoria Moraes", 100000.00f);
		c1.visualizar();
		System.out.println("Exibir o Saldo: " + c1.getSaldo());
		// o metodo SET aqui deve ser usado para alterar o Saldo
		c1.setSaldo(200000.00f);
		c1.visualizar();
		c1.sacar(210000.00f);
		c1.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Felipe Silva", 100000.00f, 2000.00f);
		cc1.visualizar();
		cc1.sacar(99000.00f);
		cc1.visualizar();
		
		ContaPoupanca cc2 = new ContaPoupanca (1, 234, 2, "Joanna Martins", 30000.00f, 15);
		cc2.visualizar();
		
		ContaPoupanca cc3 = new ContaPoupanca (3, 552, 2, "Paula Fortini", 450000.00f, 20);
		cc3.visualizar();

		while (true) {

			System.out.println(theme2 + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println(theme + "                BANCO MANILA S.A                     ");
			System.out.println("                                                     ");
			System.out.println(theme2 + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println(theme + "            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println(theme2 + "*****************************************************");
			System.out.println(theme + "Por favor, digite a opção desejada:                  ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out
						.println(Cores.TEXT_WHITE_BOLD + "\nAtendimento encerrado. \nBanco Manila S.A - For Everone.");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				System.out.println("Digite seu nome completo: ");
				nome = leia.next();

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				System.out.println(Cores.TEXT_WHITE + "Digite o valor a ser sacado: ");
				saque = leia.nextFloat();

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}

		}

	}
}
