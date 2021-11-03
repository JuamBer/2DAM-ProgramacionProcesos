import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class FilComptador extends Applet implements Runnable{
	
	private long comptador;
	private boolean parar;
	private int fil;
	private String btn;
	
	
	public FilComptador(long comptador,String btn,int fil){
		this.comptador = comptador;
		this.fil = fil;
		this.parar = false;
		this.btn = btn;
		System.out.println("FilCompatdor "+fil+" creat");
	}
	
	public void pararContador(){
		System.out.println("Parar Contador "+this.fil);
		this.parar = true;
	}
	
	public long sumComptador(){
		return this.comptador++;
	}
	
	public long getComptador(){
		return this.comptador;
	}
	
	public boolean getParar(){
		return this.parar;
	}
	
	public int getFil(){
		return this.fil;
	}
	
	public String getBtn(){
		return this.btn;
	}
	
	public void run(){
		System.out.println("Metodo Run FilCompatador "+this.fil);
		Thread filActual=Thread.currentThread(); 
		 
		while(!this.parar){
			System.out.println("CONTADOR: ("+this.fil+")"+this.comptador);
			try{
				filActual.sleep(1000);
			}catch(InterruptedException ex){ 
				System.out.println(ex.getMessage()); 
			}
			sumComptador();
		}
	}
	
	
}


