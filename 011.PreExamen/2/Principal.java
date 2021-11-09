import java.io.*;
import java.awt.*;

public class Principal extends Thread{
	private Hilo primeros;
    private Hilo segundos;
	private Hilo postres;
    private Thread f1;
    private Thread f2;
    private Thread f3;

	public Principal(){
		this.primeros = new Hilo(1);
        this.segundos = new Hilo(2);
        this.postres = new Hilo(3);
		System.out.println("PRINCIPAL CREADO");
	}
	public static void main(String args[]){
		new Principal();
	}
	public void start(){
			this.f1 = new Thread(this.primeros);
			this.f2 = new Thread(this.segundos);
            this.f3 = new Thread(this.postres);
			this.f1.start();
			this.f2.start();
            this.f3.start();	
	}

	public void run(){
		System.out.println("Metodo Run Principal ");
	}
}


