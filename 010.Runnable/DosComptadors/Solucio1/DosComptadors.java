import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class DosComptadors extends Applet implements Runnable, ActionListener {
	
	private FilComptador comp1;
	private FilComptador comp2;
	private Button btn1;
	private Button btn2;
	private Thread thread;
	private Font font;
	
	public DosComptadors(){
		this.comp1 = new FilComptador(10, "Parar Hilo 1" ,1);
		this.comp2 = new FilComptador(1000, "Parar Hilo 2",2);
		System.out.println("DosComptadors creat");
	}

	public void init(){
		setBackground(Color.yellow);
		
		add(this.btn1 = new Button(this.comp1.getBtn()));
		add(this.btn2 = new Button(this.comp2.getBtn()));

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		this.font = new Font("Verdana", Font.BOLD,26);
	} 
	
	public void start(){
		if(this.thread==null){
			this.thread = new Thread(this);
			this.thread.start();
		}
	}
	
	public void run(){
		Thread filActual=Thread.currentThread(); //&& (this.parar != true)
	
		while((this.thread==filActual) ){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
			
			repaint();
			if(!comp1.getParar()){
				this.comp1.sumComptador();
			}else{
				//this.thread.stop();
			}
			if(!comp2.getParar()){
				this.comp2.sumComptador();
			}else{
				//this.thread.stop();
			}
		}
	}
	
	public void stop(){
		this.thread = null;
	}
	
	public void paint(Graphics g){
		g.setFont(this.font);
		g.drawString(Long.toString((long) this.comp1.getComptador()),80,100);
		g.drawString(Long.toString((long) this.comp2.getComptador()),80,50);
	}
	
	public void actionPerformed(ActionEvent e){
		this.btn1.setLabel(this.comp1.getBtn());
		this.btn2.setLabel(this.comp2.getBtn());

		if(e.getSource()==this.btn1){
			if(this.thread != null && this.thread.isAlive()){
				this.comp1.pararContador();
			}
		}else if(e.getSource()==this.btn2){
			if(this.thread != null && this.thread.isAlive()){
				this.comp2.pararContador();
			}
		}
	}
}

