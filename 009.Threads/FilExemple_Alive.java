public class FilExemple_Alive extends Thread{
	private int c;
	private int fil;
	
	public FilExemple_Alive (int fil){
		this.fil = fil;
		System.out.println("Creant fil: "+fil);
	}
	
	public void run(){
		c=0;
		while (c<=5)
		{
			System.out.println("Fill="+fil+" C="+c);
			c++;
		}
	}
}
