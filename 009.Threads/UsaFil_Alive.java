public class UsaFil_Alive extends Thread{
	public static void main(String[] args){
		FilExemple_Alive h = null;
		h = new FilExemple_Alive(1);
		
		System.out.println("Abans cridaba a start");
		System.out.println("Està viu?: "+h.isAlive());
		System.out.println("Estat: "+h.getState());
		
		System.out.println("Cride a start");
		h.start();
		
		System.out.println("Està viu?: "+h.isAlive());
		System.out.println("Estat: "+h.getState());
		
		try
		{
			h.join();
		}
		catch (Exception ex)
		{
			System.out.println("Error: "+ex.getMessage());
		}
		
		System.out.println("Despres de finalitzar el fil");
		System.out.println("Està viu?: "+h.isAlive());
		System.out.println("Estat: "+h.getState());
	}
}
