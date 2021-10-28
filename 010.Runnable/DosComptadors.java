import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class DosComptadors {
	
	private FilComptador comp1;
	private FilComptador comp2;
	
	public DosComptadors(long comp1,long comp2){
		this.comp1 = new FilComptador(comp1,"Parar Fil 1", 1);
		this.comp2 = new FilComptador(comp2,"Parar Fil 2", 2);
	}
	
	public static void main(String args[]){
		new DosComptadors(0,2000);
	}
	
}

