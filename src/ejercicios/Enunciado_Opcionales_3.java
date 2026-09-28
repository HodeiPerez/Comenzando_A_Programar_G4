package dami_Reto_13;

import java.util.Scanner;

public class Enunciado_Opcionales_3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int filas;
		
		System.out.print("Introduce cuántas filas: ");
		filas = entrada.nextInt();
		
		for(int i = filas;i>0;i--) {
			for(int j = i; j>0;j--) {
				System.out.print(j+" ");
			}
			System.out.print("\n");
		}
		
		entrada.close();
	}

}
