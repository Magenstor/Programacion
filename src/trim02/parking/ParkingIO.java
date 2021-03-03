package trim02.parking;

import java.util.Scanner;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ParkingIO {	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>() {{
			add(new Coche("1038-SOP", 2.7f));
			add(new Coche("0254-UWU", 3.0f));
			add(new Coche("6669-OWO", 5.5f));
			
			add(new Minibus("8354-SDK", 10));
			add(new Minibus("0173-XCS", 15));
			add(new Minibus("6503-ASD", 25));
		}};
		
		String opt = "";
				
		do {
			System.out.println("1.- A�adir un veh�culo");
			System.out.println("2.- Sacar el listado");
			System.out.println("3.- Eliminar vehiculo");
			System.out.println("0.- Salir");
			
			System.out.print("\nElige una opci�n:");
			opt = sc.nextLine();
			
			System.out.println();
			
			switch(opt) {
				case "1":
					addVehiculo(vehiculos);
					
					break;
				case "2":
					listarVehiculos(vehiculos);
					
					break;
				case "3":
					elimnarVehiculo(vehiculos);

					break;
				case "0":
					System.out.println("Hasta luego");

					break;
				default:
					System.out.println("Opci�n no v�lida");

					break;
			}
			
			System.out.println();
			
		} while(!opt.equals("0"));
	}

	public static void addVehiculo(ArrayList<Vehiculo> lista) {
		Scanner sc = new Scanner(System.in);
		Vehiculo nuevo = new Coche();

		String vopt;
		String matricula;
		String dato;
		
		do {
			System.out.print("�Quiere un Coche(1) o un Minibus(2)?: ");
			vopt = sc.next();
			
			if(!vopt.matches("[12]")) {
				System.out.println("Formato inv�lido");
			}			
			
		} while(!vopt.matches("[12]"));

		do {
			System.out.print("Introduzca una matricula: ");
			matricula = sc.next();
			
			if(!validarMatricula(matricula)) {
				System.out.println("Formato inv�lido");
			}			
			
		} while(!validarMatricula(matricula));
				
		switch(vopt){
			case "1":
				do {
					System.out.print("Introduzca la longitud deseada (se permiten decimales): ");
					dato = sc.next();
					
					if(!validarLongitud(Float.parseFloat(dato))) {
						System.out.println("Formato inv�lido");
					}			
					
				} while(!validarLongitud(Float.parseFloat(dato)));				

				nuevo = new Coche(matricula, Float.parseFloat(dato));
				
				break;
			case "2":
				do {
					System.out.print("Introduzca la longitud deseada (se permiten decimales): ");
					dato = sc.next();
					
					if(!validarPlazas(Integer.parseInt(dato))) {
						System.out.println("Formato inv�lido");
					}			
					
				} while(!validarPlazas(Integer.parseInt(dato)));	

				nuevo = new Minibus(matricula,Integer.parseInt(dato));
				break;
		}

		System.out.println("�Creado con �xito!");		
		lista.add(nuevo);

	}
	
	public static void listarVehiculos(ArrayList<Vehiculo> lista) {
		for(Vehiculo v : lista) {
			System.out.println(v.mostrarVehiculo());
			System.out.println();
		}
	}

	public static void elimnarVehiculo(ArrayList<Vehiculo> lista) {
		Scanner sc = new Scanner(System.in);
		Vehiculo eliminado = new Minibus();
		String dato;

		System.out.println("Estos son los veh�culos actuales:");

		for(Vehiculo m : lista){
			System.out.println("\t" + m.getMatricula());
		}

		do {
			System.out.print("Indica qu� veh�culo quieres eliminar: ");
			
			dato = sc.next();
			eliminado.setMatricula(dato);

			if(!lista.contains(eliminado)){
				System.out.println("No existe o se ha introducido mal.");
			}

		} while (!lista.contains(eliminado));
		
		System.out.println("Vehiculo eliminado");
		lista.remove(eliminado);

	}
	
	public static boolean validarTelefono(String telefono) {
		return telefono.matches("[679][0-9]{8}");
	}
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[0-9]{4}-[B-DF-HJ-NP-TV-Z]{3}");
	}
	
	public static boolean validarLongitud(float longitud) {
		return longitud >= 2.5f && longitud <= 6.0f;
	}
	
	public static boolean validarPlazas(int puertas) {
		return puertas >= 5 && puertas <= 25;
	}	
	
}
