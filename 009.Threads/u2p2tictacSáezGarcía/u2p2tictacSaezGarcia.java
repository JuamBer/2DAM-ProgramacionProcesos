public class u2p2tictacSaezGarcia extends Thread {
	
	private String valor;
	private int tiempo;
	
	public u2p2tictacSaezGarcia(String valor,int tiempo){
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

    public static void main(String[] args){
		
		try{
			u2p2tictacSaezGarcia tic= new u2p2tictacSaezGarcia("TIC",1000);
			u2p2tictacSaezGarcia tac= new u2p2tictacSaezGarcia("TAC",1000);
			
			tic.start();
			
			tic.sleep(500);
			
			tac.start();
			
		}catch(Exception ex){
			System.out.println("Error: "+ex.getMessage());
		}
		
	}
	
	
}
