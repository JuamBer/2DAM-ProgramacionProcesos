import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class FilComptador extends Applet implements Runnable, ActionListener {
	
	private long comptador;
	private boolean parar;
	private int fil;
	private String btnv;
	private Button btn;
	private Thread thread;
	private Font font;
	
	public FilComptador(long comptador,String btnv,int fil){
		this.comptador = comptador;
		this.fil = fil;
		this.parar = false;
		this.btnv = btnv;
	}
	
	public void pararContador(){
		this.parar = true;
		this.stop();
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
		return this.btnv;
	}
	
	public void init(){
		setBackground(Color.yellow);
		
		//add(this.btn = new Button(this.btnv);
		//b1.addActionListener(this);
		
		this.font = new Font("Verdana", Font.BOLD,26);
	} 
	
	public void start(){
	}
	
	public void run(){
		Thread filActual=Thread.currentThread();
		while((this.thread==filActual) && (this.parar != true)){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
			
			repaint();
			this.sumComptador();
		}
	}
	
	public void stop(){
		this.thread = null;
	}
	
	public void paint(Graphics g){
		g.setFont(this.font);
		g.drawString(Long.toString((long) this.getComptador()),80,100);
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


