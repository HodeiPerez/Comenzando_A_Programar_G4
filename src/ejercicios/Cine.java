package ejercicios;

import java.util.Scanner;

public class Cine {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int clientes, entradas_Adulto, entradas_Niño, entradas_Adultos_Total = 0, entradas_Niños_Total = 0, cliente_Mas_Compras = 0, entradas_0 = 0, entradas_1;
		double precio, precio_Total = 0;
		
		System.out.print("Introduce la cantidad de clientes: ");
		clientes = entrada.nextInt();
		while(clientes <= 0) {
			System.out.print("Ha habido un error. Introduce la cantidad de clientes de nuevo: ");
			clientes = entrada.nextInt();
		}
		
		for(int i = 1; i <= clientes; i++) {
			System.out.println("========================");
			do {
				System.out.print("¿Cuántas entradas de adulto quiere comprar el "+i+"º cliente? ");
				entradas_Adulto = entrada.nextInt();
				while(entradas_Adulto < 0) {
					System.out.print("Ha habido un error. Introduce de nuevo: ");
					entradas_Adulto = entrada.nextInt();
				}
				
				System.out.print("¿Cuántas entradas infantiles quiere comprar el "+i+"º cliente? ");
				entradas_Niño = entrada.nextInt();
				while(entradas_Niño < 0) {
					System.out.print("Ha habido un error. Introduce de nuevo: ");
					entradas_Niño = entrada.nextInt();
				}
				
				if (entradas_Niño + entradas_Adulto < 1) {
					System.out.println("Ha habido un error. Inténtalo de nuevo (debes comprar al menos 1 entrada).");
				}
			} while (entradas_Niño + entradas_Adulto < 1);
			
			// Calcular precio base
			precio = entradas_Adulto * 9 + entradas_Niño * 6;
			
			// APLICAR DESCUENTO (Corregido a >= 5 según el enunciado "5 o más")
			if(entradas_Adulto + entradas_Niño >= 5) {
				precio = precio * 0.9;
			}
			
			// Mostrar datos por cliente con el texto exacto del enunciado
			System.out.println("Número de entradas de adulto: " + entradas_Adulto);
			System.out.println("Número de entradas infantiles: " + entradas_Niño);
			System.out.println("Número total de entradas: " + (entradas_Adulto + entradas_Niño));
			System.out.println("Precio a pagar: " + precio + " euros");
			
			// Sumar la cantidad total de entradas de todos los clientes
			entradas_Adultos_Total = entradas_Adultos_Total + entradas_Adulto;
			entradas_Niños_Total = entradas_Niños_Total + entradas_Niño;
			precio_Total = precio_Total + precio;
			
			entradas_1 = entradas_Adulto + entradas_Niño; 	// Calcula cuántas entradas quiere comprar este cliente
			if(entradas_1 > entradas_0) {					// Compara si este cliente ha comprado más entradas que el máximo anterior
				cliente_Mas_Compras = i;					// Se guarda el índice de este cliente como cliente con más compras
				entradas_0 = entradas_1;					// Se asigna su total de compras como nueva base de comparación
			}
		}
		
		System.out.println("========================");
		// Resultados finales con el orden y texto exactos del enunciado
		System.out.println("El dinero total recaudado: " + precio_Total + " euros");
		System.out.println("El número total de entradas de adulto: " + entradas_Adultos_Total);
		System.out.println("El número total de entradas infantiles: " + entradas_Niños_Total);
		System.out.println("El cliente que compró más entradas: Cliente " + cliente_Mas_Compras);
		
		entrada.close();
	}
}