package trim01.bloqueEjercicios01;

import java.util.Scanner;

public class Eje03_EsBisiesto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un a�o y te dir� si es bisiesto: ");
		int ahno = sc.nextInt();
		
		if(ahno % 4 == 0 && (ahno % 100 != 0 || ahno % 400 == 0)) {
			System.out.println("Es Bisiesto");
		} else {
			System.out.println("No es Bisiesto");
		}

	}

}
