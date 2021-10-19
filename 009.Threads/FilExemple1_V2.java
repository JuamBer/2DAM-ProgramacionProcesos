
public class FilExemple1_V2 extends Thread {
	private int c;
	private int fil;
	
	public FilExemple1_V2(int fil){
		this.fil=fil;
		System.out.println("Creant fill: "+fil);	
	}
	public void run(){
		c=0;
		while(c<=5){
			System.out.println("Fill: "+fil+" C="+c);	
			c++;
		}
		
	}
}
