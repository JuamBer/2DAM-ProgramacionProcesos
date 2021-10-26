import java.awt.*;
import java.applet.*;

public class AppletThread extends Applet implements Runnable {
	
	private Thread fil;
	
	public AppletThread(){
		this.fil = null;
	}
	
	public void init(){
		
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
			
		}
	}
	
	public void stop(){
		this.fil = null;
	}
	
	public void paint(Graphics g){
	
	}
}
