package ejercicios;

	import java.util.Scanner;
	public class Gimnasio {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int diasGimSemanal, cantidadUsuarios, minutosEjercicio=0, 
					totalMinutos = 0, diasMas60=0, totalMinutosGlobal = 0, 
					rankingMinutos=0, usuarioTopMinutos=0, diasTotal = 0;

			System.out.println("Bienvenido al gimnasio. Cuantos usuarios sois?");
			cantidadUsuarios=sc.nextInt();
			while(cantidadUsuarios<0||cantidadUsuarios>100) {
				System.out.println("No podeis ser negativos y nuestro cupo maximo es de 100 personas. Cuantos sois?");
				cantidadUsuarios=sc.nextInt();
			}
			for(int i=0;i<cantidadUsuarios;i++) {
				totalMinutos=0;
				diasMas60=0;
				System.out.println("\nBuenas usuario "+(i+1));
				System.out.println("Introduzca cuantos dias ha venido al gimnasio.");
				diasGimSemanal=sc.nextInt();
				while(diasGimSemanal<=0||diasGimSemanal>7) {
					System.out.println("Una semana no tiene dias negativos y solo tiene siete dias. ");
					diasGimSemanal=sc.nextInt();
				}
				diasTotal+=diasGimSemanal;
				for(int j=0;j<diasGimSemanal;j++) {
					System.out.println("Introduzca cuantos minutos ha hecho ejercicio el dia "+(j+1));
					minutosEjercicio=sc.nextInt();
					while(minutosEjercicio<0||minutosEjercicio>480) {
						System.out.println("Solo estamos abiertos 8 horas, no puedes estar mas de nuestro horario haciendo un ejercicio.");
						minutosEjercicio=sc.nextInt();
					}
					totalMinutos+=minutosEjercicio;
					totalMinutosGlobal+=minutosEjercicio;
					if(minutosEjercicio>60) {
						diasMas60++;
					}
					if(totalMinutos>rankingMinutos) {
						rankingMinutos=totalMinutos;
						usuarioTopMinutos=i+1;
					}
				}
				System.out.println("Total de minutos de ejercicio realizados esta semana: "+totalMinutos);
				System.out.println("Media de minutos por asistencia: "+(totalMinutos/diasGimSemanal));
				System.out.println("Dias con mas de 60 minutos de ejercicio: "+diasMas60);

				if(totalMinutos>300) {
					System.out.println("¡Has alcanzado el objetivo semanal!");
				}
			}

			System.out.println("\nEl usuario que mas minutos ha realizado de ejercicos es el usuario "+usuarioTopMinutos+" con "+ rankingMinutos+" minutos");
			System.out.println("El total de minutos realizados por los usuarios es de "+totalMinutosGlobal+" minutos");
			System.out.println("El total de dias de entrenamiento es de "+diasTotal+" dias");
		}

	}

