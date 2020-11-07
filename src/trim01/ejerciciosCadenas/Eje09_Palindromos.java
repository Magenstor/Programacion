package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje09_Palindromos {
	
	public static String limpiarFrase(String frase) {
		String fraseLimpia;
		
		fraseLimpia = frase.replace(" ","");
		fraseLimpia = fraseLimpia.replace("�","a");
		fraseLimpia = fraseLimpia.replace("�","e");
		fraseLimpia = fraseLimpia.replace("�","i");
		fraseLimpia = fraseLimpia.replace("�","o");
		fraseLimpia = fraseLimpia.replace("�","u");
		fraseLimpia = fraseLimpia.toLowerCase();
		
		return fraseLimpia;
	}
	
	public static String invertirFrase(String frase) {
		String fraseInv = "";
		String frase2 = limpiarFrase(frase);
		
		for(int i = frase2.length() - 1; i >= 0; i--) {
			fraseInv += frase2.charAt(i);			
		}
		
		return fraseInv;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
        
        System.out.print("Dime una frase y te la analizo: ");
        String fraseU = sc.nextLine();
        
        if(limpiarFrase(fraseU).equals(invertirFrase(fraseU))){
            System.out.println("Esta frase es un pal�ndromo");
        } else {
            System.out.println("Es una frase corriente");
        }
        
	}
	
}
