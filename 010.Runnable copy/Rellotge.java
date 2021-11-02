import java.awt.*;
import java.applet.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Rellotge extends Applet implements Runnable {
	
	private Thread fil;
	private Font font;
	private String horaActual;
	
	public Rellotge(){
		this.fil = null;
		this.horaActual = "";
	}
	
	public void init(){
		this.font = new Font("Verdana", Font.BOLD,26);
	}
	
	public void start(){
		if(this.fil==null){
			this.fil = new Thread(this);
			this.fil.start();
		}
	}
	
	public void run(){
		Thread filActual=Thread.currentThread();
		while(fil==filActual){
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			this.horaActual= sdf.format(cal.getTime());
			
			repaint();
			
			try{
				Thread.sleep(3000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
		}
	}
	
	public void stop(){
		this.fil = null;
	}
	
	public void paint(Graphics g){
		g.clearRect(1,1,getSize().width,getSize().height);
		setBackground(Color.yellow);
		g.setFont(this.font);
		g.drawString(this.horaActual,20,200);
	}
}

