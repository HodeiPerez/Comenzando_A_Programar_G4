package dami_Reto_13;

import java.util.Scanner;

public class Enunciado_3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int dia,mes,año,id_Bici,dia_Bici,mes_Bici,año_Bici,bicis_A_Revisar = 0,bicis_Revisadas = 0;
		boolean fecha_Correcta = false,fecha_Correcta_Bici = false;
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
				System.out.print("Error! Introduce el mes de nuevo: "+dia+"/");
				mes = entrada.nextInt();
			}
			System.out.print(dia+"/"+mes+"/");
			año = entrada.nextInt();
			while(año < 2001 || año > 2050) {
				System.out.print("Error! Introduce el año de nuevo: "+dia+"/"+mes+"/");
				año = entrada.nextInt();
			}
			
			// Comprueba si la fecha es válida, teniendo en cuenta años bisiestos.
			if((año % 4 != 0 && mes == 2 && dia > 28) || (año % 4 == 0 && mes == 2 && dia > 29) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)) {
				System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
			} else {
				fecha_Correcta = true;
			}
		} while (fecha_Correcta == false);
		
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
					id_Bici = entrada.nextInt();
					while(id_Bici < 0) {
						System.out.print("Error! Introduce el número de identificación de nuevo: ");
						id_Bici = entrada.nextInt();
					}
					do {
						fecha_Correcta_Bici = false;
						System.out.print("Introduce la fecha de la última revisión (DD/MM/AA): ");
						dia_Bici = entrada.nextInt();
						while(dia_Bici < 1 || dia_Bici > 31) {
							System.out.print("Error! Introduce el día de nuevo: ");
							dia_Bici = entrada.nextInt();
						}
						System.out.print(dia_Bici+"/");
						mes_Bici = entrada.nextInt();
						while(mes_Bici < 1 || mes_Bici > 12) {
							System.out.print("Error! Introduce el mes de nuevo: "+dia_Bici+"/");
							mes_Bici = entrada.nextInt();
						}
						System.out.print(dia_Bici+"/"+mes_Bici+"/");
						año_Bici = entrada.nextInt();
						while(año_Bici < 2001 || año_Bici > 2050) {
							System.out.print("Error! Introduce el año de nuevo: "+dia_Bici+"/"+mes_Bici+"/");
							año_Bici = entrada.nextInt();
						}
						if((año_Bici % 4 != 0 && mes_Bici == 2 && dia_Bici > 28) || (año_Bici % 4 == 0 && mes_Bici == 2 && dia_Bici > 29) || ((mes_Bici == 4 || mes_Bici == 6 || mes_Bici == 9 || mes_Bici == 11)&& dia_Bici > 30)) {
							System.out.println("Error! La fecha introducida es invalida. Inténtalo de nuevo.");
						} else {
							fecha_Correcta_Bici = true;
						}
					} while (fecha_Correcta_Bici == false);
					if(año - año_Bici > 1 || (año - año_Bici == 1 && mes > mes_Bici) || (año - año_Bici == 1 && mes == mes_Bici && dia > dia_Bici)) {
						if(mes_Bici >= 0) {
							System.out.print("Esta bicicleta necesita una revisión.\n");
							bicis_A_Revisar++;
						} else {
							System.out.print("Esta bicicleta no necesita una revisión.\n");
							bicis_Revisadas++;
						}
					} else {
						System.out.print("Esta bicicleta no necesita una revisión.\n");
						bicis_Revisadas++;
					}
					break;
				case 'N','n':
					System.out.println("Bicicletas a revisar: "+bicis_A_Revisar);
					System.out.print("Bicicletas que no necesitan revisión: "+bicis_Revisadas);
					break;
			}
		} while(selector != 'n' && selector != 'N');
		entrada.close();
	}
}
