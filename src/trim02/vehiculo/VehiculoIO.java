package trim02.vehiculo;

import java.util.Scanner;

public class VehiculoIO {
	
	private static final String MATRICULA_DEF = "AAAA001";
	private static final String CONDUCTOR = "Usuario1";
	private static final int NUM_PUERTAS = 4;
	private static final int FACTOR_COCHE = 3;
	private static final int CILINDROS = 6;
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[A-Z]{4}[0-9]{3}");
	}
	
	public static boolean validarFactor(int factor) {
		return factor >= 1 && factor <= 5;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 2 && puertas <= 5;
	}
	
	public static Vehiculo crear(){
		Scanner sc = new Scanner(System.in);
		Vehiculo escogido = new Vehiculo();
		int v = 0;

		do {
			System.out.print("�Quieres un Coche(1) o una Moto(2)? ");
			v = sc.nextInt();

			if(v != 1 && v != 2){
				System.out.println("Opci�n no v�lida.");
			}

		} while(v != 1 && v != 2);

		if(v == 1) {
			escogido = new Coche(MATRICULA_DEF,NUM_PUERTAS,FACTOR_COCHE);
		} else {
			escogido = new Moto(MATRICULA_DEF,CILINDROS);
		}

		return escogido;
	}

	public static void verFicha(Vehiculo vuser){
		if(vuser instanceof Coche){
			System.out.println(((Coche) vuser).verFicha());
		} else {
			System.out.println(((Moto) vuser).verFicha());
		}
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Vehiculo user = new Vehiculo();

		int opt = 0;
		int optv = 0;

		do {

			System.out.println("1.- Escoger un veh�culo");
			System.out.println("2.- Cambiar datos del veh�culo");
			System.out.println("3.- Ver ficha t�cnica del veh�culo");
			System.out.println("4.- Cambiar de veh�culo");
			System.out.println("5.- Salir\n");			

			System.out.print("Escoge una opci�n: ");
			opt = sc.nextInt();

			switch(opt){
				case 1:
					user = crear();
					user.setConductor(CONDUCTOR);
					
					System.out.println("Se ha creado correctamente");

					break;
				case 2:
					//user

					break;
				case 3:
					verFicha(user);
					
					break;
				case 4:
					//user = cambiar(user);
					
					break;
				case 5:
					System.out.println("Gracias por usar nuestro sistema");
					break;
				default:
					System.out.println("Opci�n no v�lida.");
					break;
			}
			
			System.out.println("\n");

		} while (opt != 5);

	}
		
}
