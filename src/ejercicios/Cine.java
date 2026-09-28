package ejercicios;

import java.util.Scanner;

public class Cine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int dia,mes,año,ID_bici,dia_bici,mes_bici,año_bici,bicis_a_revisar = 0,bicis_revisadas = 0;
		boolean fecha_correcta = false,fecha_correcta_bici = false;
		char selector;
		
		do {
			System.out.print("Introduce la fecha de la consulta (DD/MM/AA): ");
			dia = entrada.nextInt();
			while(dia < 1 || dia > 31) {
				System.out.print("Error! Introduce el día de nuevo: ");
				dia = entrada.nextInt();
			}
			System.out.print(dia+"/");
			mes = entrada.nextInt();
			while(mes < 1 || mes > 12) {
				System.out.print("Error! Introduce el mes de nuevo: ");
				mes = entrada.nextInt();
			}
			System.out.print(dia+"/"+mes+"/");
			año = entrada.nextInt();
			while(año < 2001 || año > 2050) {
				System.out.print("Error! Introduce el mes de nuevo: ");
				año = entrada.nextInt();
			}
			
			// Comprueba que el mes y el día introducido concuerden, incluso en años bisiestos
			if((año % 4 != 0 && mes == 2 && dia > 28) || (año % 4 == 0 && mes == 2 && dia > 29) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)) {
				System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
			} else {
				fecha_correcta = true;
			}
		} while (fecha_correcta == false);
		
		do {
			System.out.print("\n¿Quiere registrar otra bicicleta? (S/N)");
			selector = entrada.next().charAt(0);
			while(selector != 'S' && selector != 's' && selector != 'N' && selector != 'n') {
				System.out.print("Error! Inténtalo de nuevo: ");
				selector = entrada.next().charAt(0);
			}
			switch(selector) {
				case 'S','s':
					System.out.print("Introduce el número de identificación de la bicicleta: ");
					ID_bici = entrada.nextInt();
					do {
						System.out.print("Introduce la fecha de la última revisión (DD/MM/AA): ");
						dia_bici = entrada.nextInt();
						while(dia_bici < 1 || dia_bici > 31) {
							System.out.print("Error! Introduce el día de nuevo: ");
							dia_bici = entrada.nextInt();
						}
						System.out.print(dia_bici+"/");
						mes_bici = entrada.nextInt();
						while(mes_bici < 1 || mes_bici > 12) {
							System.out.print("Error! Introduce el mes_bici de nuevo: ");
							mes_bici = entrada.nextInt();
						}
						System.out.print(dia_bici+"/"+mes_bici+"/");
						año_bici = entrada.nextInt();
						while(año_bici < 2001 || año_bici > 2050) {
							System.out.print("Error! Introduce el mes_bici de nuevo: ");
							año_bici = entrada.nextInt();
						}
						if((año_bici % 4 != 0 && mes_bici == 2 && dia_bici > 28) || (año_bici % 4 == 0 && mes_bici == 2 && dia_bici > 29) || ((mes_bici == 4 || mes_bici == 6 || mes_bici == 9 || mes_bici == 11)&& dia_bici > 30)) {
							System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
						} else {
							fecha_correcta_bici = true;
						}
					} while (fecha_correcta_bici == false);
					if(año - año_bici >= 1) {
						System.out.print("Esta bicicleta necesita una revisión.\n");
						bicis_a_revisar++;
					} else {
						System.out.print("Esta bicicleta no necesita una revisión.\n");
						bicis_revisadas++;
					}
					break;
				case 'N','n':
					System.out.println("Bicicletas a revisar: "+bicis_a_revisar);
					System.out.print("Bicicletas que no necesitan revisión: "+bicis_revisadas);
					break;
			}
		} while(selector != 'n' && selector != 'N');
		entrada.close();
	}
}