import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class FilComptador {
	
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
	
	
	
	
}


