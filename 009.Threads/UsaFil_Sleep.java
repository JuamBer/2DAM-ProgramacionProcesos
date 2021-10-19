public class UsaFil_Sleep extends Thread{
	public static void main(String[] args){
		FilExemple_Alive h = null;
		h = new FilExemple_Alive(1);
		
		h.start();
		
		try{
			h.sleep(4000);
			System.out.println("---------");	
		}
		catch (Exception ex){
			System.out.println("Error: "+ex.getMessage());
		}
	}
}
