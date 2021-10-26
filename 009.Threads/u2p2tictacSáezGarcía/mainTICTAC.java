public class mainTICTAC extends Thread {
	public static void main(String[] args){
		
		try{
			TICTAC tic= new TICTAC("TIC",1000);
			TICTAC tac= new TICTAC("TAC",1000);
			
			tic.start();
			
			tic.sleep(2000);
			
			tac.start();
			
		}catch(Exception ex){
			System.out.println("Error: "+ex.getMessage());
		}
		
	}
}
