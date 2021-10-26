import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class ComptadorApplet extends Applet implements Runnable, ActionListener {
	
	private Thread h;
	private Font fuente;
	private long comptador;
	private boolean parar;
	private Button b1,b2;
	
	public ComptadorApplet(){
		this.comptador = 0;
	}
	
	public void init(){
		setBackground(Color.yellow);
		
		add(this.b1 = new Button("Iniciar Contador"));
		b1.addActionListener(this);
		
		add(this.b2 = new Button("Parar Contador"));
		b2.addActionListener(this);
		
		this.fuente = new Font("Verdana", Font.BOLD,26);
	}
	
	public void start(){
	}
	
	public void run(){
		this.parar = false;
		Thread filActual=Thread.currentThread();
		while(this.h==filActual && !parar){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
			
			repaint();
			this.comptador++;
		}
	}
	
	public void stop(){
		this.h = null;
	}
	
	public void paint(Graphics g){
		g.setFont(this.fuente);
		g.drawString(Long.toString((long) this.comptador),80,100);
	}
	
	public void actionPerformed(ActionEvent e){
		this.b1.setLabel("Continuar");
		
		if(e.getSource()==this.b1){
			if(this.h != null && this.h.isAlive()){
			}else{
				this.h = new Thread(this);
				this.h.start();
			}
		}else if(e.getSource()==this.b2){
			this.parar=true;
		}
	}
}

