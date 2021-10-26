public class UsaPrimerFilR{
	public static void main(String[] args){
		
		PrimerFilR p = new PrimerFilR(10);
		
		new Thread(p).start();
	}	
}
