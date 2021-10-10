import java.io.*;

public class u2p1e2tasklistSáezGarcía{
	public static void main(String[] args){
        Runtime r = Runtime.getRuntime();
        Process p;
        String command = "ps -ef";

        try{
            FileWriter fw = new FileWriter("processos.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            //execute the command and save the process in out
            Process out = r.exec(command);
            //take the result and print it on screen
            BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                fw.write(line+"\n");
            }
            fw.close();
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }
		

        
		
	}
}