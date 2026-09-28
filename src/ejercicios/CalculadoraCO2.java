package ejercicios;

import java.util.Scanner;

public class CalculadoraCO2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int actividades, opcionesPlancha, numPersonas;
		double cantidad;
		double distanciaCoche, distanciaBus, distanciaBici, usoPlancha, usoOrdenador, usoMovil;
		double totalPersona, totalGrupo = 0;

		System.out.print("Bienvenido. ¿Cuantas personas se van a registrar? ");
		numPersonas = sc.nextInt();

		// FILTRO PARA NUMERO DE PERSONAS NO VALIDO
		while (numPersonas <= 0) {
			System.out.println("ERROR");
			System.out.print("Introduzca el numero de personas que se van a registrar (debe ser mayor o igual a 1): ");
			numPersonas = sc.nextInt();
		}

		System.out.println("Perfecto, " + numPersonas + " personas.");

		for (int i = 0; i < numPersonas; i++) {

			// LOS CONTADORES DE CADA PERSONA EMPIEZAN EN 0
			distanciaCoche = distanciaBus = distanciaBici = usoPlancha = usoOrdenador = usoMovil = 0;
			totalPersona = 0;
			System.out.println("\nPersona numero " + (i + 1) + ":");

			do {
				System.out.println("\nMenu de actividades:");
				System.out.println("1- Transporte en coche (0,21 kg CO2 por km).");
				System.out.println("2- Transporte en autobús (0,10 kg CO2 por km).");
				System.out.println("3- Transporte en bicicleta (0 kg CO2 por km).");
				System.out.println("4- Uso de plancha (0,70 kg CO2 por hora).");
				System.out.println("5- Uso del ordenador (0,08 kg CO2 por hora).");
				System.out.println("6- Uso del móvil (0,02 kg CO2 por hora).");
				System.out.println("7- Finalizar actividades del día.");

				actividades = sc.nextInt();

				// FILTRO PARA LOS NUMEROS QUE NO ESTEN EN EL RANGO DEL MENU
				while (actividades > 7 || actividades <= 0) {
					System.out.println("ERROR");
					System.out.println("Introduzca lo que quiere hacer (1-7)");
					actividades = sc.nextInt();
				}

				switch (actividades) {

				// APARTADO DEL USO DEL COCHE
				case 1:
					System.out.print("¿Cuantos km has recorrido en coche? ");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						cantidad = sc.nextDouble();
					}

					distanciaCoche = distanciaCoche + cantidad;
					totalPersona = totalPersona + 0.21 * cantidad;
					break;

				// APARTADO DEL USO DEL BUS
				case 2:
					System.out.print("¿Cuantos km has recorrido en autobús? ");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						cantidad = sc.nextDouble();
					}

					distanciaBus = distanciaBus + cantidad;
					totalPersona = totalPersona + 0.10 * cantidad;
					break;

				// APARTADO DEL USO DE LA BICI
				case 3:
					System.out.print("¿Cuantos km has recorrido en bicicleta? ");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						cantidad = sc.nextDouble();
					}

					distanciaBici = distanciaBici + cantidad;
					totalPersona = totalPersona + 0 * cantidad;
					break;

				// APARTADO DEL USO DE LA PLANCHA
				case 4:
					System.out.println("¿Has usado la plancha?");
					System.out.println("1. Si");
					System.out.println("0. No");
					opcionesPlancha = sc.nextInt();

					while (opcionesPlancha != 0 && opcionesPlancha != 1) {
						System.out.println("ERROR");
						System.out.println("Introduzca lo que quiere hacer (1 = si, 0 = no)");
						opcionesPlancha = sc.nextInt();
					}

					// SOLO SE PIDEN LAS HORAS SI LA HA USADO
					if (opcionesPlancha == 1) {
						System.out.print("¿Cuantas horas has usado la plancha? ");
						cantidad = sc.nextDouble();

						while (cantidad < 0) {
							System.out.println("ERROR");
							System.out.print("Introduzca el numero de horas en positivo. ");
							cantidad = sc.nextDouble();
						}

						usoPlancha = usoPlancha + cantidad;
						totalPersona = totalPersona + 0.70 * cantidad;
					}
					break;

				// APARTADO DEL USO DEL ORDENADOR
				case 5:
					System.out.print("¿Cuantas horas has usado el ordenador? ");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						cantidad = sc.nextDouble();
					}

					usoOrdenador = usoOrdenador + cantidad;
					totalPersona = totalPersona + 0.08 * cantidad;
					break;

				// APARTADO DEL USO DEL MOVIL
				case 6:
					System.out.print("¿Cuantas horas has usado el móvil? ");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						cantidad = sc.nextDouble();
					}

					usoMovil = usoMovil + cantidad;
					totalPersona = totalPersona + 0.02 * cantidad;
					break;

				default:
				}

			} while (actividades != 7);

			// LISTA DE CONSUMO DE LA PERSONA POR TIPO DE EMISION
			System.out.println("\nPersona " + (i + 1));
			System.out.println("En total has consumido " + (0.21 * distanciaCoche) + " kg de CO2 del coche");
			System.out.println("En total has consumido " + (0.10 * distanciaBus) + " kg de CO2 del autobús");
			System.out.println("En total has consumido " + (0 * distanciaBici) + " kg de CO2 de la bicicleta");
			System.out.println("En total has consumido " + (0.70 * usoPlancha) + " kg de CO2 con la plancha");
			System.out.println("En total has consumido " + (0.08 * usoOrdenador) + " kg de CO2 con el ordenador");
			System.out.println("En total has consumido " + (0.02 * usoMovil) + " kg de CO2 con el móvil");
			System.out.println("Total de la persona " + (i + 1) + ": " + totalPersona + " kg");

			// SUMA AL TOTAL DEL GRUPO
			totalGrupo = totalGrupo + totalPersona;
		}

		System.out.println("\nTotal de CO2 emitido por el grupo: " + totalGrupo + " kg.");
		System.out.println("Hasta la próxima!");
	}

}