public class FilExemple2 extends Thread {
	public void run(){
		System.out.println("Dins del fil: "+this.getName()+" Prioritat: "+this.getPriority()+" ID: "+this.getId());
	}
	
	public static void main(String[] args){
		FilExemple2 h = null;
		
		for (int i = 0; i < 3; i++)
		{
			h = new FilExemple2();
			
			h.setName("FIL "+i);
			h.setPriority(i+1);
			h.start();
			
			System.out.println("Informació del " +h.getName()+": "+h.toString());
			
		}
		System.out.println("Creant 3 fills....");
	}
}
