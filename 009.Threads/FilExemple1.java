
public class FilExemple1 extends Thread {
	private int c;
	private int fil;
	
	public FilExemple1(int fil){
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
	public static void main(String[] args){
		FilExemple1 h = null;
		for (int i = 0; i < 3; i++)
		{
			h = new FilExemple1(i+1);
			h.start();
		} 
		System.out.println("3 Fils creats....");	
		
	}
}
