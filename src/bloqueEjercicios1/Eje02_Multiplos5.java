package bloqueEjercicios1;

import java.util.Scanner;

public class Eje02_Multiplos5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un numero");
		int n = sc.nextInt();
		
		if(n % 5 == 0) {
			System.out.println("Es m�ltiplo de 5");
		} else  {
			System.out.println("No es m�ltiplo de 5");
		}

	}

}
