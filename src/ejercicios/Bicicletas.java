package ejercicios;

import java.util.Scanner;

public class Bicicletas {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int dia, mes, año, id_Bici, dia_Bici, mes_Bici, año_Bici, bicis_A_Revisar = 0, bicis_Revisadas = 0;
		boolean fecha_Correcta = false, fecha_Correcta_Bici = false;
		char selector;

		// 1. FECHA ACTUAL. Se repite hasta que la fecha sea valida.
		do {
			System.out.print("Introduce la fecha actual (DD/MM/AAAA): ");
			dia = entrada.nextInt();
			while (dia < 1 || dia > 31) {
				System.out.print("Error! Introduce el día de nuevo: ");
				dia = entrada.nextInt();
			}
			System.out.print(dia + "/");
			mes = entrada.nextInt();
			while (mes < 1 || mes > 12) {
				System.out.print("Error! Introduce el mes de nuevo: " + dia + "/");
				mes = entrada.nextInt();
			}
			System.out.print(dia + "/" + mes + "/");
			año = entrada.nextInt();
			while (año < 2001 || año > 2050) {
				System.out.print("Error! Introduce el año de nuevo: " + dia + "/" + mes + "/");
				año = entrada.nextInt();
			}

			// Comprueba si la fecha es válida, teniendo en cuenta años bisiestos.
			if ((año % 4 != 0 && mes == 2 && dia > 28) || (año % 4 == 0 && mes == 2 && dia > 29) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)) {
				System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
			} else {
				fecha_Correcta = true;
			}
		} while (fecha_Correcta == false);


		// 2. REGISTRO DE BICICLETAS.
		System.out.println("\n--- Registrando bicicleta ---");
		
		do {
			System.out.print("Introduce el número de identificación de la bicicleta: ");
			id_Bici = entrada.nextInt();

			// FILTRO PARA EL NUMERO DE IDENTIFICACION
			while (id_Bici < 0) {
				System.out.print("Error! Introduce el número de identificación de nuevo: ");
				id_Bici = entrada.nextInt();
			}

			// FECHA DE LA ULTIMA REVISION. Se repite hasta que la fecha sea valida.
			do {
				fecha_Correcta_Bici = false;
				System.out.print("Introduce la fecha de la última revisión (DD/MM/AAAA): ");
				dia_Bici = entrada.nextInt();
				while (dia_Bici < 1 || dia_Bici > 31) {
					System.out.print("Error! Introduce el día de nuevo: ");
					dia_Bici = entrada.nextInt();
				}
				System.out.print(dia_Bici + "/");
				mes_Bici = entrada.nextInt();
				while (mes_Bici < 1 || mes_Bici > 12) {
					System.out.print("Error! Introduce el mes de nuevo: " + dia_Bici + "/");
					mes_Bici = entrada.nextInt();
				}
				System.out.print(dia_Bici + "/" + mes_Bici + "/");
				año_Bici = entrada.nextInt();
				while (año_Bici < 2001 || año_Bici > 2050) {
					System.out.print("Error! Introduce el año de nuevo: " + dia_Bici + "/" + mes_Bici + "/");
					año_Bici = entrada.nextInt();
				}

				// Comprueba si la fecha es válida, teniendo en cuenta años bisiestos.
				if ((año_Bici % 4 != 0 && mes_Bici == 2 && dia_Bici > 28) || (año_Bici % 4 == 0 && mes_Bici == 2 && dia_Bici > 29) || ((mes_Bici == 4 || mes_Bici == 6 || mes_Bici == 9 || mes_Bici == 11) && dia_Bici > 30)) {
					System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
				} else {
					fecha_Correcta_Bici = true;
				}
			} while (fecha_Correcta_Bici == false);

			// Comprueba si ha pasado MAS de un año desde la ultima revision.
			if (año - año_Bici > 1 || (año - año_Bici == 1 && mes > mes_Bici) || (año - año_Bici == 1 && mes == mes_Bici && dia > dia_Bici)) {
				System.out.println("Esta bicicleta necesita revisión.");
				bicis_A_Revisar++;
			} else {
				System.out.println("Esta bicicleta NO necesita revisión.");
				bicis_Revisadas++;
			}
			
			// 3. PREGUNTAR SI SE DESEA CONTINUAR CON EL TEXTO EXACTO DEL ENUNCIADO
			System.out.print("\n¿Quiere registrar otra bicicleta? Conteste S o N: ");
			selector = entrada.next().charAt(0);

			// FILTRO PARA LA RESPUESTA S/N
			while (selector != 'S' && selector != 's' && selector != 'N' && selector != 'n') {
				System.out.print("Error! Conteste S o N: ");
				selector = entrada.next().charAt(0);
			}

		} while (selector == 'S' || selector == 's'); // Se repite solo si la respuesta es S o s

		// 4. RESULTADOS FINALES (Texto exacto del enunciado)
		System.out.println("\nBicicletas que necesitan revisión: " + bicis_A_Revisar);
		System.out.println("Bicicletas que no necesitan revisión: " + bicis_Revisadas);

		entrada.close();
	}
}