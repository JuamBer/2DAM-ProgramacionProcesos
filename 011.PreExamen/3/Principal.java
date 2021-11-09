import java.io.*;
import java.util.*;

public class Principal extends Thread{
    public static Scanner sc = new Scanner(System.in);
	private Coche c1;
    private Coche c2;
    private Thread f1;
    private Thread f2;

	public Principal(String n1, String n2, String m1, String m2){
		this.c1 = new Coche(n1,m1);
        this.c2 = new Coche(n2,m2);
		System.out.println("PRINCIPAL CREADO");
	}
	public static void main(String args[]){
        System.out.println("Numero coche 1:");    
        String n1 = sc.nextLine();
        System.out.println("Marca coche 1:");    
        String m1 = sc.nextLine();
        System.out.println("Numero coche 2:");    
        String n2 = sc.nextLine();
        System.out.println("Marca coche 2:");    
        String m2 = sc.nextLine();
		new Principal(n1,n2,m1,m2);
	}
	public void start(){
			this.f1 = new Thread(this.c1);
			this.f2 = new Thread(this.c2);
			this.f1.start();
			this.f2.start();
	}

	public void run(){
		System.out.println("Metodo Run Principal ");
	}
}


