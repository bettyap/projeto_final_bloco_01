package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.Controller;
import projeto_final_bloco_01.model.Monitor;
import projeto_final_bloco_01.model.MonitorGamer;
import projeto_final_bloco_01.model.MonitorTradicional;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		Controller monitores = new Controller();

		int opcao, id, categoria, numeroSerie, fps;
		String marca;
		float polegada, valor;

		MonitorTradicional mt1 = new MonitorTradicional(1, "LG", 1, 14, 200.00f, 12345);
		mt1.visualizar();

		MonitorGamer mg2 = new MonitorGamer(2, "SONY", 2, 18, 100.00f, 54321);
		mg2.visualizar();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  LOJA DE MONITORES                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Monitor                    ");
			System.out.println("            2 - Listar todos os Monitores            ");
			System.out.println("            3 - Buscar Monitor por Número            ");
			System.out.println("            4 - Atualizar Dados do Monitor           ");
			System.out.println("            5 - Deletar Dados do Monitor             ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");

			System.out.print("Entre com a opção desejada: ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite números válidos!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("*****************************************************");
				System.out.println("\n                                                   ");
				System.out.println("             Encontre aqui o seu Monitor!            ");
				System.out.println("\n                                                   ");
				System.out.println("*****************************************************");
				sair();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Monitor");

				System.out.print("Digite o id do monitor: ");
				id = leia.nextInt();

				System.out.print("Digite a marca do monitor: ");
				leia.skip("\\R");
				marca = leia.nextLine();

				System.out.print("Digite a categoria do monitor (1- Tradicional / 2- Gamer): ");
				categoria = leia.nextInt();

				System.out.print("Digite a polegada do monitor: ");
				polegada = leia.nextFloat();

				System.out.print("Digite o valor do monitor: ");
				valor = leia.nextFloat();

				switch (categoria) {
				case 1 -> {
					System.out.print("Digite o número de série do monitor: ");
					numeroSerie = leia.nextInt();
					monitores.cadastrar(new MonitorTradicional(id, marca, categoria, polegada, valor, numeroSerie));
				}
				case 2 -> {
					System.out.print("Digite o FPS do monitor gamer: ");
					fps = leia.nextInt();
					monitores.cadastrar(new MonitorGamer(id, marca, categoria, polegada, valor, fps));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Monitores");
				monitores.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println("Buscar Monitor por Número");

				System.out.println("Digite o id do monitor: ");
				id = leia.nextInt();

				monitores.procurarPorNumero(id);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Dados do Monitor");

				System.out.println("Digite o id do monitor: ");
				id = leia.nextInt();

				Optional<Monitor> monitor = monitores.buscarNaCollection(id);

				if (monitor.isPresent()) {

					System.out.println("Digite a marca do monitor: ");
					leia.skip("\\R");
					marca = leia.nextLine();

					System.out.print("Digite a categoria do monitor (1- Tradicional / 2- Gamer): ");
					categoria = leia.nextInt();

					System.out.print("Digite a polegada do monitor: ");
					polegada = leia.nextFloat();

					System.out.print("Digite o valor do monitor: ");
					valor = leia.nextFloat();

					switch (categoria) {
						case 1 -> {
							System.out.print("Digite o número de série do monitor: ");
							numeroSerie = leia.nextInt();
							monitores.atualizar(new MonitorTradicional(id, marca, categoria, polegada, valor, numeroSerie));
						}
						case 2 -> {
							System.out.print("Digite o FPS do monitor gamer: ");
							fps = leia.nextInt();
							monitores.atualizar(new MonitorGamer(id, marca, categoria, polegada, valor, fps));
						}
					}

				} else {
					
					System.out.println("O monitor com id " + id + " não foi encontrado!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Deletar Dados do Monitor");
				
				System.out.println("Digite o id do monitor: ");
				id = leia.nextInt();
				
				monitores.deletar(id);
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;

			}
		}
	}

	public static void sair() {
		System.out.println("                                                     ");
		System.out.println("             Projeto Desenvolvido por:               ");
		System.out.println("             Elisabeth Aparecida                     ");
		System.out.println("             https://github.com/bettyap              ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
	}

	public static void keyPress() {

		try {
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida!!");
		}
	}
}