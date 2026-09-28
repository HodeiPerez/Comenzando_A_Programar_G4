package damiPrimerPrograma;

import java.util.Scanner;

public class Enunciado2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String dni;
		int opciones, sumaTiemposTotal=0, menos60mins = 0, seguirSalir, i=0, tiempoMinutos, tiempoSegundos,tiempoMedio2, tiempoTotal, mejorTiempo = 999999999, carreras,tiempoMedio=0, carrerasCont=0;

		//Introduccion del principio. Es un bucle hasta que el usuario decida salir.
		do {
			System.out.println("Hola! Bienvenido a la carrera popular de Erandio.");
			System.out.println("Introduzca su DNI: ");
			dni = sc.next();
			System.out.println("Perfecto. ¿Vas a participar en la carrera individual o por parejas? ");
			System.out.println("1. Individual ");
			System.out.println("2. Parejas ");
			opciones = sc.nextInt();

			//Opciones a elegir entre individual o por parejas
			if (opciones == 1) {
				System.out.println("Individual");
				i++;
			}else if(opciones==2){
				System.out.println("Por parejas");
				i = i+2;
			}	

			while (opciones<1||opciones>2) {
				System.out.println("ERROR");
				System.out.println("Introduzca de nuevo si va a participar en la carrera individual o por parejas.");
				System.out.println("1. Individual ");
				System.out.println("2. Parejas ");
				opciones = sc.nextInt();
			}	

			System.out.print("Vale, ¿cual es el número de carrereas populares en las que ha participado anteriormente? ");
			carreras = sc.nextInt();

			//esto nos sirve para saber el numero de gente que ha participado en 3 o mas carreras
			if (carreras>3) {
				carrerasCont = carrerasCont + 1;
				if (opciones==2) {
					carrerasCont = carrerasCont + 1;
				}
			}

			//Nos piden el tiempo realizado, primero minutos y luego segundos.
			System.out.println("Okey, ¿cual fue tu tiempo realizado en la carrera? ");
			System.out.print("Minutos: ");
			tiempoMinutos = sc.nextInt();

			while (tiempoMinutos<0) {
				System.out.println("ERROR");
				System.out.print("Introduzca de nuevo sus minutos.");
				tiempoMinutos = sc.nextInt();
			}

			System.out.print("Segundos: ");
			tiempoSegundos = sc.nextInt();
			while (tiempoSegundos<0||tiempoSegundos>60) {
				System.out.println("ERROR");
				System.out.print("Introduzca de nuevo sus segundos (0-60).");
				tiempoSegundos = sc.nextInt();
			}

			//Para tener calculado el tiempo total en segundos, haciendolo mas comodo para el calculo final
			tiempoTotal = tiempoMinutos*60 + tiempoSegundos; 
			if(tiempoTotal < mejorTiempo) {
				mejorTiempo = tiempoTotal;
			}

			// La suma del tiempo para ambos integrantes de la pareja
			if (opciones == 2) {
				sumaTiemposTotal = sumaTiemposTotal+(tiempoTotal * 2); 
				if (tiempoMinutos < 60) {
					System.out.println("Felicidades. Habéis terminado la carrera en menos de 60 minutos.");
					menos60mins = menos60mins + 2;
				} else {
					System.out.println("Ohhh. No habéis terminado la carrera en menos de 60 minutos.");
				}
			
			// La suma del tiempo para los integrantes individuales
			} else {
				sumaTiemposTotal = sumaTiemposTotal + tiempoTotal; 
				if (tiempoMinutos < 60) {
					System.out.println("Felicidades. Has terminado la carrera en menos de 60 minutos.");
					menos60mins++;
				} else {
					System.out.println("Ohhh. No has terminado la carrera en menos de 60 minutos.");
				}
			}
			
			//Se terminan las preguntas y te deja decidir en si quieres salir y que te de la media de todo o continuar registrando participantes
			System.out.println("\n¿Desea continuar registrando participantes? ");
			System.out.println("1. Si");
			System.out.println("2. Salir");
			seguirSalir = sc.nextInt();

			switch(seguirSalir) {
			case 1:
				break;

			case 2:
				System.out.println("Hasta la proxima");
				break;

			default:
			}

		}while(seguirSalir!=2);

		//Con esto podemos calcular el tiempo medio de todos los participantes.

		tiempoMedio2 = sumaTiemposTotal / i;
		
		System.out.println("\nEl número total de participantes: "+i+" personas.");
		System.out.println("Numero de participantes que han terminado la carrera en menos de 60 minutos: "+menos60mins);
		System.out.println("Numero de participantes que han participado en más de 3 carreras: "+carrerasCont+" personas.");
		System.out.println("Tiempo medio de todos los participantes: "+(tiempoMedio2/60)+"min "+(tiempoMedio2%60)+"s");
		System.out.println("Mejor tiempo registrado: "+(mejorTiempo/60)+"min "+(mejorTiempo%60)+"s");



	}

}

