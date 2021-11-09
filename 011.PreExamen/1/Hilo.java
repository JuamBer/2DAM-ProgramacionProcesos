import java.util.ArrayList;
import java.io.*;

public class Hilo extends Thread{

	private ArrayList<String> comidas = new ArrayList<String>(); 
    private int type;
	private String fil;

	public Hilo(int type){
		this.type = type;
        System.out.println("HILO "+type+" CREADO");

        this.start();
	}
	
	public void run(){
        try{
		System.out.println("Metodo Run Hilo "+this.fil);
		Thread filActual=Thread.currentThread(); 
		String line;
        BufferedReader br  = new BufferedReader(new FileReader("menu.txt"));
		while((line = br.readLine()) != null){
            System.out.println(line);
            switch(this.type){
                case 1:
                    if(line.substring(0,1).equals("1")){
                        FileWriter fichero = new FileWriter("primeros.txt", true);
                        PrintWriter pw = new PrintWriter(fichero);
                        pw.println(line);
                        fichero.close();
                    }
                    break;
                case 2:
                    if(line.substring(0,1).equals("2")){
                        FileWriter fichero = new FileWriter("segundos.txt");
                        PrintWriter pw = new PrintWriter(fichero);
                        pw.println(line);
                        fichero.close();
                    }
                    break;
                case 3:
                    if(line.substring(0,1).equals("3")){
                        FileWriter fichero = new FileWriter("postres.txt");
                        PrintWriter pw = new PrintWriter(fichero);
                        pw.println(line);
                        fichero.close();
                    }
                    break;
			}
		}
        br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}
	
	
}


