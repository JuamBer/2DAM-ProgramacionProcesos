public class mainTICTAC extends Thread {
	public static void main(String[] args){
		
		try{
			while(true){
				TIC tic = null;
				tic = new TIC();
				
				TAC tac = null;
				tac = new TAC();
				
				tic.start();
				tic.sleep(500);
				
				tac.start();
				tic.sleep(500);
				
			}
		}catch(Exception ex){
			System.out.println("Error: "+ex.getMessage());
		}
		
	}
}
