package dami_Reto_13;

import java.util.Scanner;

public class Enunciado_4 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int clientes,entradas_Adulto,entradas_Niño,entradas_Adultos_Total = 0,entradas_Niños_Total = 0,cliente_Mas_Compras = 0,entradas_0 = 0,entradas_1;
		double precio, precio_Total = 0;
		
		System.out.print("Introduce la cantidad de clientes: ");
		clientes = entrada.nextInt();
		while(clientes <= 0) {
			System.out.print("Ha habido un error. Introduce la cantidad de clientes de nuevo.");
			clientes = entrada.nextInt();
		}
		
		for(int i = 1;i <= clientes;i++) {
			System.out.println("========================");
			do {
				System.out.print("¿Cuántas entradas de adulto quiere comprar el "+i+"º cliente? ");
				entradas_Adulto = entrada.nextInt();
				while(entradas_Adulto<0) {
					System.out.print("Ha habido un error. Introduce de nuevo: ");
					entradas_Adulto = entrada.nextInt();
				}
				System.out.print("¿Cuántas entradas de niño quiere comprar el "+i+"º cliente? ");
				entradas_Niño = entrada.nextInt();
				while(entradas_Niño<0) {
					System.out.print("Ha habido un error. Introduce de nuevo: ");
					entradas_Niño = entrada.nextInt();
				}
				if (entradas_Niño + entradas_Adulto < 1) {
					System.out.println("Ha habido un error. Inténtalo de nuevo.");
				}
			} while (entradas_Niño + entradas_Adulto < 1);
			precio = entradas_Adulto*9 + entradas_Niño*6;
			if(entradas_Adulto + entradas_Niño > 5) {
				precio = precio*0.9;
			}
			System.out.println("Entradas de adulto: "+entradas_Adulto+"\nEntradas de niño: "+entradas_Niño+"\nTotal de entradas: "+(entradas_Adulto+entradas_Niño)+"\nPrecio de la compra: "+precio);
			// Sumar la cantidad total de entradas de todos los clientes
			entradas_Adultos_Total = entradas_Adultos_Total + entradas_Adulto;
			entradas_Niños_Total = entradas_Niños_Total + entradas_Niño;
			precio_Total = precio_Total + precio;
			
			entradas_1 = entradas_Adulto+entradas_Niño; 	// Calcula cuántas entradas quiere comprar este cliente (cliente_1)
			if(entradas_1 > entradas_0) {					// Compara si este cliente ha comprado más entradas que el de más
				cliente_Mas_Compras = i;					// Se guarda el índice de este cliente como cliente con más compras
				entradas_0 = entradas_1;					// Se asigna su total de compras como nueva base de comparación
			}
		}
		System.out.println("========================");
		System.out.print("Total de entradas de adulto vendidas hoy: "+entradas_Adultos_Total+"\nTotal de entradas de niño vendidas hoy: "+entradas_Niños_Total+"\nDinero Total recaudado: "+precio_Total+"\nCliente que más compras ha hecho: "+cliente_Mas_Compras+"º");
		entrada.close();
	}
}