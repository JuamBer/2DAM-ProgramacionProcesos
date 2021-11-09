import java.io.*;
import java.util.*;

public class Coche extends Thread{
	private String marca;
    private String numero;
    private long distanciaTotal;

	public Coche(String numero, String marca){
		this.marca = marca;
        this.numero = numero;
        this.distanciaTotal = 0;
        this.start();
	}

	public void run(){
		Thread filActual=Thread.currentThread(); 

        while(this.distanciaTotal <= 500){
            long d = Math.round((Math.random() * 100));
            distanciaTotal+=d;
            System.out.println(this.marca+" ha recorrido "+distanciaTotal);
            try{
                filActual.sleep(1000);
            }catch(InterruptedException ex){ 
                System.out.println(ex.getMessage()); 
            }
        }
	}
}


