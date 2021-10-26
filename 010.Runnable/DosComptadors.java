import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class DosComptadors extends Applet implements Runnable, ActionListener {
	
	private FilComptador comp1;
	private FilComptador comp2;
	private Thread h;
	private Font fuente;
	private Button b1,b2;
	
	public DosComptadors(long comp1,long comp2){
		this.comp1 = new FilComptador(comp1,"Parar Fil 1", 1);
		this.comp2 = new FilComptador(comp2,"Parar Fil 2", 2);
	}
	
	public void init(){
		setBackground(Color.yellow);
		
		add(this.b1 = new Button(this.comp1.getBtn()));
		b1.addActionListener(this);
		
		add(this.b2 = new Button(this.comp2.getBtn()));
		b2.addActionListener(this);
		
		this.fuente = new Font("Verdana", Font.BOLD,26);
	}
	
	public void start(){
	}
	
	public void run(){
		Thread filActual=Thread.currentThread();
		while(this.h==filActual && !this.comp1.getParar()){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
			
			repaint();
			this.comp1.sumComptador();
		}
	}
	
	public void stop(){
		this.h = null;
	}
	
	public void paint(Graphics g){
		g.setFont(this.fuente);
		g.drawString(Long.toString((long) this.comp1.getComptador()),80,100);
	}
	
	public void actionPerformed(ActionEvent e){
		//this.b1.setLabel("Continuar");
		//
		//if(e.getSource()==this.b1){
		//	if(this.h != null && this.h.isAlive()){
		//	}else{
		//		this.h = new Thread(this);
		//		this.h.start();
		//	}
		//}else if(e.getSource()==this.b2){
		//	this.parar=true;
		//}
	}
}

