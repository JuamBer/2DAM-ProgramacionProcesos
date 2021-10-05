import java.util.Scanner;

public class Exemple1{
	public static void main(String[] args){
		Runtime r = Runtime.getRuntime();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el comando: ");
		String comando = sc.nextLine();
		Process p;
		
		try{
			p = r.exec(comando);
		}catch(Exception e){
			System.out.println("Error en "+comando);
			e.printStackTrace();
		}
	}
}
