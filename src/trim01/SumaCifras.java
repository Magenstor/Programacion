package trim01;

import java.util.Scanner;

public class SumaCifras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un n�mero");
		int num = sc.nextInt();
		int r = 0, s = 0;
		
		do {
			r = num % 10;
			num /= 10;
			
			s += r;
		} while (num != 0);

		System.out.println(s);
	}

}
