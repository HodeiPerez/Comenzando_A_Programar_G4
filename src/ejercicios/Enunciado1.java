package damiPrimerPrograma;

import java.util.Scanner;

public class Enunciado1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int actividades,opcionesPlancha, numPersonas, selectorMax = 0;
		double consMax = 0,distanciaCoche = 0, consumoTotal, distanciaCocheTotal=0, mayorConsumo=999999999,distanciaBus=0, distanciaBusTotal=0, distanciaBici=0, distanciaBiciTotal=0, usoPlancha=0, usoPlanchaTotal=0, usoOrdenadorTotal=0, usoOrdenador=0,usoMovil=0, usoMovilTotal=0, usoAvion=0, usoAvionTotal=0, usoAire=0, usoAireTotal=0;

		System.out.print("Bienvenido. ¿Cuantas personas se van a registrar? ");
		numPersonas = sc.nextInt();

		//FILTRO PARA NUMERO NEGATIVOS DE PERSONAS
		while (numPersonas<=0) {
			System.out.println("ERROR");
			System.out.print("Introduzca el numero de personas que se van a registrar (debe ser mayor o igual a 1): ");
			numPersonas = sc.nextInt();
		}

		System.out.println("Perfecto, "+numPersonas+" personas.");

		do {
			System.out.println("\nMenu de actividades:");
			System.out.println("1- Transporte en coche (0,21 kg CO2 por km).");
			System.out.println("2- Transporte en autobús (0,10 kg CO2 por km).");
			System.out.println("3- Transporte en bicicleta (0 kg CO2 por km).");
			System.out.println("4- Uso de plancha (0,70 kg CO2 por hora).");
			System.out.println("5- Uso del ordenador (0,08 kg CO2 por hora).");
			System.out.println("6- Uso del móvil (0,02 kg CO2 por hora).");
			System.out.println("7- Viaje en avión (0,25 kg CO2 por km).");
			System.out.println("8- Uso del aire acondicionado (1,35 kg CO2 por hora).");
			System.out.println("9- Finalizar actividades del día.");

			actividades = sc.nextInt();

			//FILTRO PARA LOS NUMEROS QUE NO ESTEN EN EL RANGO DEL MENU
			while (actividades>9||actividades<=0) {
				System.out.println("ERROR");
				System.out.println("Introduzca lo que quiere hacer (1-7)");
				actividades = sc.nextInt();
			}

			switch(actividades) {

			//APARTADO DEL USO DEL COCHE
			case 1:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantos km has recorrido en coche? ");
					distanciaCoche = sc.nextDouble();

					while (distanciaCoche<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						distanciaCoche = sc.nextInt();
					}

					distanciaCocheTotal = distanciaCocheTotal + distanciaCoche;

				}	
				System.out.println("\n"+distanciaCocheTotal+"km has recorrido en coche.");
				System.out.println("En total habeis consumido "+(0.21*distanciaCocheTotal)+"kg de CO2.");

				if(0.21*distanciaCocheTotal > consMax) {
					consMax = 0.21*distanciaCocheTotal;
					selectorMax = actividades;
				}
				
				break;	

				//APARTADO DEL USO DEL BUS
			case 2:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantos km has recorrido en autobús? ");
					distanciaBus = sc.nextDouble();

					while (distanciaBus<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						distanciaBus = sc.nextInt();
					}

					distanciaBusTotal = distanciaBusTotal + distanciaBus;

				}	
				System.out.println("\n"+distanciaBusTotal+"km has recorrido en autobús.");
				System.out.println("En total habeis consumido "+(0.10*distanciaBusTotal)+"kg de CO2.");

				if(0.10*distanciaBusTotal > consMax) {
					consMax = 0.10*distanciaBusTotal;
					selectorMax = actividades;
				}
				
				break;	

				//APARTADO DEL USO DE LA BICI
			case 3:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantos km has recorrido en bicicleta? ");
					distanciaBici = sc.nextDouble();

					while (distanciaBici<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero km en positivo. ");
						distanciaBici = sc.nextInt();
					}

					distanciaBiciTotal = distanciaBiciTotal + distanciaBici;

				}	
				System.out.println("\n"+distanciaBiciTotal+"km has recorrido en bicicleta.");
				System.out.println("En total habeis consumido "+(0*distanciaBiciTotal)+"kg de CO2.");

				if(0*distanciaBiciTotal > consMax) {
					consMax = 0*distanciaBiciTotal;
					selectorMax = actividades;
				}
				
				break;

				//APARTADO DEL USO DE LA PLANCHA
			case 4:
				System.out.println("¿Has usado la plancha(1-2)?" );
				System.out.println("1. Si" );
				System.out.println("2. No" );
				opcionesPlancha = sc.nextInt();

				while (opcionesPlancha>2||opcionesPlancha<=0) {
					System.out.println("ERROR");
					System.out.println("Introduzca lo que quiere hacer (1-2)");
					opcionesPlancha = sc.nextInt();
				}

				switch(opcionesPlancha) {
				case 1:
					for (int i = 1; i<=numPersonas; i++) {
						System.out.println("Persona numero "+i+":");
						System.out.print("¿Cuantas horas has usado la plancha? ");
						usoPlancha = sc.nextDouble();

						while (usoPlancha<0) {
							System.out.println("ERROR");
							System.out.print("Introduzca el numero de horas en positivo. ");
							usoPlancha = sc.nextInt();
						}

						usoPlanchaTotal = usoPlanchaTotal + usoPlancha;

					}	
					System.out.println("\nHabeis usado la plancha "+usoPlanchaTotal+" horas.");
					System.out.println("En total habeis consumido "+(0.7*usoPlanchaTotal)+"kg de CO2.");
					
					if(0.7*usoPlanchaTotal > consMax) {
						consMax = 0.7*usoPlanchaTotal;
						selectorMax = actividades;
					}
					
					break;
				case 2:
					System.out.println("Ops.");
					break;
				default:
				}
				break;

				//APARTADO DEL USO DEL ORDENADOR
			case 5:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantas horas has usado el ordenador? ");
					usoOrdenador = sc.nextDouble();

					while (usoOrdenador<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						usoOrdenador = sc.nextInt();
					}

					usoOrdenadorTotal = usoOrdenadorTotal + usoOrdenador;

				}	
				System.out.println("\nHabeis usado el ordenador "+usoOrdenadorTotal+" horas.");
				System.out.println("En total habeis consumido "+(0.08*usoOrdenadorTotal)+"kg de CO2.");
				
				if(0.08*usoOrdenadorTotal > consMax) {
					consMax = 0.08*usoOrdenadorTotal;
					selectorMax = actividades;
				}
				
				break;

				//APARTADO DEL USO DE MOVIL
			case 6:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantas horas has usado el móvil? ");
					usoMovil = sc.nextDouble();

					while (usoMovil<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						usoMovil = sc.nextInt();
					}

					usoMovilTotal = usoMovilTotal + usoMovil;

				}	
				System.out.println("\nHabeis usado el móvil "+usoMovilTotal+" horas.");
				System.out.println("En total habeis consumido "+(0.02*usoMovilTotal)+"kg de CO2.");
				
				if(0.02*usoMovilTotal > consMax) {
					consMax = 0.02*usoMovilTotal;
					selectorMax = actividades;
				}
				
				break;
				
			case 7:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantas horas has viajado en avión? ");
					usoAvion = sc.nextDouble();

					while (usoAvion<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						usoAvion = sc.nextInt();
					}

					usoAvionTotal = usoAvionTotal + usoAvion;

				}	
				System.out.println("\nHabeis usado el móvil "+usoAvionTotal+" horas.");
				System.out.println("En total habeis consumido "+(0.25*usoAvionTotal)+"kg de CO2.");
				
				if(0.25*usoAvionTotal > consMax) {
					consMax = 0.25*usoAvionTotal;
					selectorMax = actividades;
				}
				
				break;
				
			case 8:
				for (int i = 1; i<=numPersonas; i++) {
					System.out.println("Persona numero "+i+":");
					System.out.print("¿Cuantas horas has usado el aire acondicionado? ");
					usoAire = sc.nextDouble();

					while (usoMovil<0) {
						System.out.println("ERROR");
						System.out.print("Introduzca el numero de horas en positivo. ");
						usoAire = sc.nextInt();
					}

					usoAireTotal = usoAireTotal + usoAire;

				}	
				System.out.println("\nHabeis usado el móvil "+usoAireTotal+" horas.");
				System.out.println("En total habeis consumido "+(1.35*usoAireTotal)+"kg de CO2.");
				
				if(1.35*usoAireTotal > consMax) {
					consMax = 1.35*usoAireTotal;
					selectorMax = actividades;
				}
				
				break;

			default:
			}
			
			consumoTotal=(0.21*distanciaCocheTotal)+(0.10*distanciaBusTotal)+(0*distanciaBiciTotal)+(0.7*usoPlanchaTotal)+(0.08*usoOrdenadorTotal)+(0.02*usoMovilTotal)+(0.25*usoAvionTotal)+(1.35*usoAireTotal);
			if(consumoTotal < mayorConsumo) {
				mayorConsumo = consumoTotal;
			}
			
		}while(actividades!=9);

		System.out.println("En total habeis consumido "+(0.21*distanciaCocheTotal)+"kg de CO2 del coche");
		System.out.println("En total habeis consumido "+(0.10*distanciaBusTotal)+"kg de CO2 del autobús");
		System.out.println("En total habeis consumido "+(0*distanciaBiciTotal)+"kg de CO2 de la bicicleta");
		System.out.println("En total habeis consumido "+(0.7*usoPlanchaTotal)+"kg de CO2 con la plancha");
		System.out.println("En total habeis consumido "+(0.08*usoOrdenadorTotal)+"kg de CO2 con el ordenador");
		System.out.println("En total habeis consumido "+(0.02*usoMovilTotal)+"kg de CO2 con el móvil");
		System.out.println("En total habeis consumido "+(0.25*usoAvionTotal)+"kg de CO2 del avión");
		System.out.println("En total habeis consumido "+(1.35*usoAireTotal)+"kg de CO2 con el aire acondicionado");
		System.out.println("Total: "+((0.21*distanciaCocheTotal)+(0.10*distanciaBusTotal)+(0*distanciaBiciTotal)+(0.7*usoPlanchaTotal)+(0.08*usoOrdenadorTotal)+(0.02*usoMovilTotal)+(0.25*usoAvionTotal)+(1.35*usoAireTotal))+"kg");
		System.out.println("El que mas consume es el numero: "+selectorMax+(". Por eso mismo te recomendamos que intentes hacer un menor uso de ello, logrando asi gastar menos CO2."));
		System.out.println("Hasta la próxima!");

	}

}
