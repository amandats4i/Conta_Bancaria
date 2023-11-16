package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner (System.in);
	public static String theme = Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_PURPLE_BOLD;
	public static void main(String[] args) {
		
		

			System.out.println(theme + "*****************************************************");		         
			System.out.println("                                                     ");
			System.out.println("                BANCO MANILA S.A                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Por favor, digite a opção desejada:                  ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
		

	}

}


