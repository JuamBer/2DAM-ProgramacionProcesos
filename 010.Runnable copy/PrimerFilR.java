public class PrimerFilR implements Runnable{
	
	private int x;
	
	PrimerFilR(int x){
		this.x = x;
	}
	
	public void run(){
		for (int i = 0; i < this.x; i++)
		{
			System.out.println("En el fil... "+i);	
		}
		
	}
}
