import java.util.Scanner;

public class u2p1e1QuasibashSáezGarcía{
	public static void main(String[] args){
        Runtime r = Runtime.getRuntime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un comando:");    
		String input = sc.nextLine();
		Process p;
		
		try{
			p = r.exec(input);
		}catch(Exception e){
			System.out.println("Error en "+input);
			e.printStackTrace();
		}
	}
}
