package ejercicios;

import java.util.Scanner;

public class Videojuego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cantidadUsuarios, totalEnemigosGlobal = 0, totalPuntosGlobal = 0, rankingPuntos = 0, usuarioTop = 0, totalPartidas, puntosPartida = 0, cantEnemigos = 0, totalPuntos, totalEnemigos = 0;
		
		System.out.println("Bienvenido a este videojuego. Cuantos jugadores sois?");
		cantidadUsuarios=sc.nextInt();
		while(cantidadUsuarios<0||cantidadUsuarios>100) {
			System.out.println("No podeis ser negativos y nuestro cupo maximo es de 100 personas. Cuantos sois?");
			cantidadUsuarios=sc.nextInt();
		}
		for(int i=0;i<cantidadUsuarios;i++) {
			totalPartidas=0;
			totalPuntos=0;
			totalEnemigos=0;
			System.out.println("Jugador "+ (i+1)+" Cuantas partidas has jugado?");
			totalPartidas=sc.nextInt();
			for(int j=0;j<totalPartidas;j++) {
				System.out.println("Cuantos puntos has conseguido en la partida " +(j+1));
				puntosPartida=sc.nextInt();
				while(puntosPartida<0||puntosPartida>9999) {
				System.out.println("no puedes tener menos de 0 puntos ni mas de 9999, vuelve a introducir este dato");
				puntosPartida=sc.nextInt();
				}
				totalPuntos+=puntosPartida;
				System.out.println("Introduce cuantos enemigos has eliminado. ");
				cantEnemigos=sc.nextInt();
				while(cantEnemigos<0||cantEnemigos>100) {
					System.out.println("no puedes eliminar a enemigos negativos ni eliminar a mas enemigos que los que hay en una partida. Vuelve a introducir el dato.");
					puntosPartida=sc.nextInt();
					}
				totalEnemigos+=cantEnemigos;
				totalEnemigosGlobal+=cantEnemigos;
				
				
				if(puntosPartida>1000) {
					totalPuntos+=100;
				}
				totalPuntosGlobal+=totalPuntos;
			}
			
			System.out.println("Puntuacion total: "+(totalPuntos));
			System.out.println("Enemigos derrotados: "+totalEnemigos);
			System.out.println("Media de puntuacion: "+(totalPuntos/totalPartidas));
		
			if(totalPuntos>rankingPuntos) {
				rankingPuntos=totalPuntos;
				usuarioTop=i+1;
			}
		}
		
		System.out.println("Jugador con mayor puntuacion: "+usuarioTop);
		System.out.println("Puntuacion total global: "+ totalPuntosGlobal);
		System.out.println("Enemigos eliminados global: "+ totalEnemigosGlobal);
	}
	}


