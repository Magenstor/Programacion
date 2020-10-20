package trim01.bloqueEjercicios01;

import java.util.Scanner;

public class Eje06_EsCapicua {

	public static int invertirCifras(int n) {
		int r = 0;
		int inv = 0;
		
		do {
	        r = n % 10;
	        inv = inv * 10 + r;
	        n /= 10;
	    } while (n > 0);
		
		return inv;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un numero");
		int num = sc.nextInt();
		
		if(num == invertirCifras(num)) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua");
		}		

	}

}
