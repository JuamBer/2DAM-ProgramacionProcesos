public class TICTAC extends Thread {
	
	private String valor;
	private int tiempo;
	
	public TICTAC(String valor,int tiempo){
		this.valor = valor;
		this.tiempo = tiempo;
		
		System.out.println("Creant Fil "+valor);
	}
	
	public void run(){
		while(true){
			System.out.print(this.valor);
			try{
				this.sleep(this.tiempo);
			}catch(Exception ex){
				System.out.println("Error: "+ex.getMessage());
			}
			
		}
	}
	
	
}
