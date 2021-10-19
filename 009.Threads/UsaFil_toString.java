public class UsaFil_toString extends Thread{
	public static void main(String[] args){
		FilExemple_Alive h = null;
		h = new FilExemple_Alive(1);
		
		h.start();
		
		System.out.println("Id del fil: "+h.getId());
		System.out.println("Informació fil: "+h.toString());
	}
}
