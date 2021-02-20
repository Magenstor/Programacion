package trim02.reloj;

import java.util.Scanner;

public class RelojIO {
	
	private static final int INCREMENTO_HORA = 1;
	private static final int INCREMENTO_MIN_SEG = 10;
	private static final int INCREMENTO_MILI = 100;

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Reloj r1 = new Reloj(12);
		

		String opt = "";
		String viejoFormato = r1.getFormato();
		String nuevoFormato = "12h";
		int unidad = 0;

		System.out.println("Gracias por adquirir nuestro nuevo Reloj.");
		System.out.println("Por defecto, la hora viene en formato 24h. Puedes cambiarlo m�s tarde\n");

		do {
			r1.darHora();

			System.out.println("\n1.- A�adir horas");
			System.out.println("2.- A�adir minutos");
			System.out.println("3.- A�adir segundos");
			System.out.println("4.- A�adir milisegundos");
			System.out.println("5.- Cambiar formato");
			System.out.println("0.- Salir\n");

			System.out.print("Elige una opci�n: ");
			opt = sc.nextLine();			
			
			switch(opt) {
				case "1":
					unidad = validarUnidades(opt);
					r1.sumarHoras(unidad);
					
					break;
				case "2":
					unidad = validarUnidades(opt);
					r1.sumarMinutos(unidad);
					
					break;
				case "3":
					unidad = validarUnidades(opt);
					r1.sumarSegundos(unidad);
					
					break;
				case "4":
					unidad = validarUnidades(opt);
					r1.sumarMilisegundos(unidad);
					
					break;
				case "5":
					System.out.println("Se va cambiar a " + nuevoFormato);
										
					r1.setFormato(nuevoFormato);
					nuevoFormato = viejoFormato;
					viejoFormato = r1.getFormato();
					
					
					break;
				case "0":
					System.out.println("Has salido del men�.");

					break;
				default:
					System.out.println("Opci�n no v�lida");

					break;
			}
			
		} while (!opt.equals("0"));
		
	}

	public static int validarUnidades(String opt) {
		Scanner sc = new Scanner(System.in);
		String valido = "0";

		do {
			System.out.print("Indica cuanto quieres a�adir (Dejarlo en blanco se aplicar� la unidad por defecto): ");
			valido = sc.nextLine();

			if(!valido.matches("[0-9]{1,}") && !valido.equals("")){
				System.out.println("Unidad no v�lida.");
			}

		} while(!valido.matches("[0-9]{1,}") && !valido.equals(""));
		
		if(valido.equals("")) {
			switch(opt) {
			 case "1":
				 valido = String.valueOf(INCREMENTO_HORA);
				 
				 break;
			 case "2":
			 case "3":
				 valido = String.valueOf(INCREMENTO_MIN_SEG);
				 
				 break;
			 case "4":
				 valido = String.valueOf(INCREMENTO_MILI);
				 
				 break;
			}
		}
		
		System.out.println("");

		return Integer.parseInt(valido);
	}

}
