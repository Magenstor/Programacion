package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje05_UsuarioContra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String passUser = "aBcDeF38";
       
        System.out.println("Introduce Usuario");
        String user = sc.next();
        
        System.out.println("Introduce contrase�a");
        String passwd = sc.next();
               
        if(user.length() <= 7 && !user.contains(".")){
            System.out.println("Usuario correcto");
        } else {
            System.out.println("Usuario no v�lido");
        }
        
        if(passwd.length() >= 8 && (passwd.contains("8") && passwd.contains("3"))){
            System.out.println("Contrase�a correcta");
        } else {
            System.out.println("Contrase�a no v�lida");
        }

	}

}
