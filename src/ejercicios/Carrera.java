package ejercicios;

import java.util.Scanner;

public class Carrera {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String dni;
		int opciones, sumaTiemposTotal = 0, menos60mins = 0, seguirSalir, i = 0, tiempoMinutos, tiempoSegundos, tiempoMedio2, tiempoTotal, mejorTiempo = 999999999, carreras, carrerasCont = 0;

		//Introduccion del principio. Es un bucle hasta que el usuario decida salir.
		do {
			System.out.println("Hola! Bienvenido a la carrera popular de Erandio.");
			System.out.println("Introduzca su DNI: ");
			dni = sc.next();
			System.out.println("Perfecto. ¿Vas a participar en la carrera individual o por parejas? ");
			System.out.println("1. Individual ");
			System.out.println("2. Parejas ");
			opciones = sc.nextInt();

			//FILTRO PARA LA OPCION INDIVIDUAL O PAREJAS
			while (opciones < 1 || opciones > 2) {
				System.out.println("ERROR");
				System.out.println("Introduzca de nuevo si va a participar en la carrera individual o por parejas.");
				System.out.println("1. Individual ");
				System.out.println("2. Parejas ");
				opciones = sc.nextInt();
			}

			//Individual suma 1 participante y parejas suma 2 (el valor de opciones coincide con el numero de participantes)
			if (opciones == 1) {
				System.out.println("Individual");
			} else {
				System.out.println("Por parejas");
			}
			i = i + opciones;

			System.out.print("Vale, ¿cual es el número de carreras populares en las que ha participado anteriormente? ");
			carreras = sc.nextInt();

			//FILTRO PARA EL NUMERO DE CARRERAS
			while (carreras < 0) {
				System.out.println("ERROR");
				System.out.print("No puedes haber corrido menos de 0 carreras. Introduzcalo de nuevo: ");
				carreras = sc.nextInt();
			}

			//esto nos sirve para saber el numero de gente que ha participado en MAS de 3 carreras
			if (carreras > 3) {
				carrerasCont = carrerasCont + opciones;
			}

			//Nos piden el tiempo realizado, primero minutos y luego segundos.
			System.out.println("Okey, ¿cual fue tu tiempo realizado en la carrera? ");
			System.out.print("Minutos: ");
			tiempoMinutos = sc.nextInt();

			//FILTRO PARA LOS MINUTOS
			while (tiempoMinutos < 0) {
				System.out.println("ERROR");
				System.out.print("Introduzca de nuevo sus minutos: ");
				tiempoMinutos = sc.nextInt();
			}

			System.out.print("Segundos: ");
			tiempoSegundos = sc.nextInt();

			//FILTRO PARA LOS SEGUNDOS
			while (tiempoSegundos < 0 || tiempoSegundos > 59) {
				System.out.println("ERROR");
				System.out.print("Introduzca de nuevo sus segundos (0-59): ");
				tiempoSegundos = sc.nextInt();
			}

			//Para tener calculado el tiempo total en segundos, haciendolo mas comodo para el calculo final
			tiempoTotal = tiempoMinutos * 60 + tiempoSegundos;
			if (tiempoTotal < mejorTiempo) {
				mejorTiempo = tiempoTotal;
			}

			//El tiempo se suma una vez por cada participante (1 si es individual, 2 si es pareja)
			sumaTiemposTotal = sumaTiemposTotal + (tiempoTotal * opciones);

			//Comprobacion de si ha terminado en menos de 60 minutos
			if (tiempoMinutos < 60) {
				if (opciones == 2) {
					System.out.println("Felicidades. Habéis terminado la carrera en menos de 60 minutos.");
				} else {
					System.out.println("Felicidades. Has terminado la carrera en menos de 60 minutos.");
				}
				menos60mins = menos60mins + opciones;
			} else {
				if (opciones == 2) {
					System.out.println("Ohhh. No habéis terminado la carrera en menos de 60 minutos.");
				} else {
					System.out.println("Ohhh. No has terminado la carrera en menos de 60 minutos.");
				}
			}

			//Se terminan las preguntas y te deja decidir si quieres salir y que te de la media de todo o continuar registrando participantes
			System.out.println("\n¿Desea continuar registrando participantes? ");
			System.out.println("1. Si");
			System.out.println("2. Salir");
			seguirSalir = sc.nextInt();

			//FILTRO PARA CONTINUAR O SALIR
			while (seguirSalir < 1 || seguirSalir > 2) {
				System.out.println("ERROR");
				System.out.println("Introduzca 1 para continuar o 2 para salir.");
				seguirSalir = sc.nextInt();
			}

		} while (seguirSalir != 2);

		System.out.println("Hasta la proxima");

		//Con esto podemos calcular el tiempo medio de todos los participantes.
		tiempoMedio2 = sumaTiemposTotal / i;

		System.out.println("\nEl número total de participantes: " + i + " personas.");
		System.out.println("Numero de participantes que han terminado la carrera en menos de 60 minutos: " + menos60mins);
		System.out.println("Numero de participantes que han participado en más de 3 carreras: " + carrerasCont + " personas.");
		System.out.println("Tiempo medio de todos los participantes: " + (tiempoMedio2 / 60) + "min " + (tiempoMedio2 % 60) + "s");
		System.out.println("Mejor tiempo registrado: " + (mejorTiempo / 60) + "min " + (mejorTiempo % 60) + "s");

	}

}