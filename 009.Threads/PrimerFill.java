
public class PrimerFill extends Thread {
	
	private int x;
	
	public PrimerFill(int x){
		this.x=x;
	}
	public void run(){
		for (int i = 0; i < this.x; i++)
		{
			System.out.println("Dins del fill");	
		}
		
	}
	public static void main(String[] args){
		PrimerFill p = new PrimerFill(10);
		p.start();
	}
}
