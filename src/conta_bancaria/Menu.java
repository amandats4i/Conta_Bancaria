package conta_bancaria;

import java.io.IOException;

import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	public static String theme = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_PURPLE_BOLD;
	public static String theme2 = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_GREEN_BOLD;

	public static void main(String[] args) {

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String nome;

		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joao da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 15);
		contas.cadastrar(cp1);

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
			System.out.println("            9 - Consulta por Titular                 ");
			System.out.println("            10 - Sair                                ");
			System.out.println("                                                     ");
			System.out.println(theme2 + "*****************************************************");
			System.out.println(theme + "Por favor, digite a opção desejada:                  ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 10) {
				System.out.println(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_PURPLE_BOLD + "\nAtendimento encerrado. \nBanco Manila S.A - For Everone.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:

				System.out.println(theme2 + "Criar Conta\n\n");

				System.out.println(theme + "Digite o número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite seu nome completo: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1 - CC  ou 2 - CP):  ");
					tipo = leia.nextInt();
					if (tipo > 2) {
						System.out.println("ERRO: DIGITE UM NÚMERO VÁLIDO: 1 - CC ou 2 - CP\n");
					}
				} while (tipo > 2);

				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, nome, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, nome, saldo, aniversario));
				}
				} 
				keyPress();
				break;

			case 2:
				System.out.println(theme + "Listar todas as Contas: ");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println(theme + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;

			case 4:
				System.out.println(theme2 + "Atualizar dados da Conta\n\n");
				
				System.out.println(theme +"Digite do numero da conta: ");
				numero = leia.nextInt();
				
				Optional <Conta> conta = contas.buscarNaCollection(numero); 
				
				if (conta.isPresent()) {
					
					System.out.println("Digite o numero da agencia: ");
					agencia = leia.nextInt();
					
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					tipo = conta.get().getTipo();

					System.out.println("Digite o saldo da conta: ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, nome, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, nome, saldo, aniversario));
					}
					}
					
				} else
					System.err.println("A conta numero: " + numero + " nao foi encontrada.");
				
				keyPress();
				break;

			case 5:
				System.out.println(theme2 + "Apagar a Conta\n\n");
				
				System.out.println(theme + "Digite o numero da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;

			case 6:
				System.out.println(theme2 + "Saque\n\n");
				
				System.out.println(theme + "Digite o numero da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor a ser sacado: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
				
				
				keyPress();
				break;

			case 7:
				System.out.println(theme2 + "Depósito\n\n");
				
				System.out.println(theme + "Digite o numero da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor a ser depositado: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;

			case 8:
				System.out.println(theme2 + "Transferência entre Contas\n\n");
				
				System.out.println(theme + "Digite o numero da conta de origem: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				if (numero != numeroDestino) {
					System.out.println("Digite o valor a ser transferido: ");
					valor = leia.nextFloat();
					contas.transferir(numero, numeroDestino, valor);
					
				} else
					System.out.println("Os números das contas são iguais. Por favor, digite um número válido.");
				
				keyPress();
				break;
			case 9:
				System.out.println("Consultar contas por Titular");
				System.out.println("Digite o nome completo do Titular: ");
				leia.skip("\\R");
				nome = leia.nextLine();
						
				contas.procurarPorNome(nome);
				keyPress();
				break;
				
			default:
				System.err.println("\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}

		}	

	}
	
	public static void sobre () {
		System.out.println(theme + "**********************************");
		System.out.println(theme2 + "Projeto desenvolvido por: Amanda Tsai");
		System.out.println("Contato: amandatsai16@gmail.com");
		System.out.println("https://github.com/amandats4i");
		System.out.println(theme + "**********************************");
	}
	

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_BLUE_BOLD + "Pressione ENTER para continuar.");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");
		}
	}
}
