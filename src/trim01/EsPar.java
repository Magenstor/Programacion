package trim01;

import java.util.Scanner;

public class EsPar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un n�mero y te dir� si es par");
		int num = sc.nextInt();
		
		if (num % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("No es par");
		}
		

	}

}
