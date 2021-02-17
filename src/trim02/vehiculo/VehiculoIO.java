 package trim02.vehiculo;

import java.util.Scanner;

public class VehiculoIO {
	
	private static final String MATRICULA_DEF = "0001AAA";
	private static final String CONDUCTOR = "Usuario1";
	private static final int NUM_PUERTAS = 4;
	private static final int FACTOR_COCHE = 3;
	private static final int CILINDROS = 6;
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[0-9]{4}[A-Za-z]{3}");
	}
	
	public static boolean validarFactor(int factor) {
		return factor >= 1 && factor <= 5;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 2 && puertas <= 5;
	}

	public static Vehiculo crear() {

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
	
	public static void calcularCouta(Vehiculo vuser) {
		if(vuser instanceof Coche){
			System.out.println(((Coche) vuser).calcularCuota());
		} else {
			System.out.println(((Moto) vuser).calcularCuota());
		}
	}

	public static Vehiculo cambiarDatos(Vehiculo vuser){

		Scanner sc = new Scanner(System.in);
		Vehiculo cambiado = vuser;

		String opt = "";
		String dato = "";

		do {

			System.out.println("1.- Cambiar matricula");
			
			if(cambiado instanceof Coche){
				System.out.println("2.- Cambiar N�mero de puertas");
				System.out.println("3.- Cambiar Factor de Potencia");
			} else {
				System.out.println("2.- Cambiar Cilindrada");
			}

			System.out.println("0.- Men� principal");

			System.out.print("Escoge una opci�n: ");
			opt = sc.next();

			switch(opt) {

				case "1":
					do {
						System.out.print("Introduce la nueva matr�cula (Ejemplo: 1457AFB): ");
						dato = sc.next();

						if(!validarMatricula(dato)){
							System.out.println("Formato no v�lido.");
						}

					} while (!validarMatricula(dato));

					cambiado.setMatricula(dato);

					System.out.println("Cambio realizado correctamente\n");

					break;

				case "2":

					if(cambiado instanceof Coche) {
						
						do {
							System.out.print("Introduce el n�mero de puertas que quieras (entre 2 y 5): ");
							dato = sc.next();

							if(!validarPuertas(Integer.parseInt(dato))){
								System.out.println("N�mero fuera de los l�mites.");
							}
						} while (!validarPuertas(Integer.parseInt(dato)));
						
						((Coche) cambiado).setNumPuertas(Integer.parseInt(dato));

					}

					if(cambiado instanceof Moto) {
						System.out.print("Introduce el n�mero de cilindros: ");

						((Moto)cambiado).setCilidrada(Integer.parseInt(sc.next()));

						System.out.println("Cambio realizado correctamente\n");
					}

					break;

				case "0":
					break;

				default:
					if(cambiado instanceof Coche){

						do {
							System.out.print("Introduce la potencia del coche (Entre 1 y 5): ");
							dato = sc.next();

							if(!validarFactor(Integer.parseInt(dato))){
								System.out.println("N�mero fuera de los l�mites.");
							}
						} while (!validarFactor(Integer.parseInt(dato)));

						((Coche) cambiado).setFactorPot(Integer.parseInt(dato));

						break;
					}

					break;
			}

		} while (!opt.equals("0"));

		return cambiado;

	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Vehiculo user = new Vehiculo();

		int opt = 0;

		do {

			System.out.println("1.- Escoger un veh�culo");
			System.out.println("2.- Cambiar datos del veh�culo");
			System.out.println("3.- Ver ficha t�cnica del veh�culo");
			System.out.println("4.- Calcular la cuota del veh�culo");
			System.out.println("0.- Salir\n");			

			System.out.print("Escoge una opci�n: ");
			opt = sc.nextInt();

			switch(opt){
				case 1:
					user = crear();
					user.setConductor(CONDUCTOR);
					
					System.out.println("Se ha creado correctamente");

					break;
				case 2:
					user = cambiarDatos(user);

					break;
				case 3:
					verFicha(user);
					
					break;
				case 4:				
					calcularCouta(user);
					
					break;
				case 0:
					System.out.println("Gracias por usar nuestro sistema");

					break;
				default:
					System.out.println("Opci�n no v�lida.");

					break;
			}
			
			System.out.println("\n");

		} while (opt != 0);

	}
	
}
