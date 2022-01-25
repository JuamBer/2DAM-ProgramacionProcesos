package servidormultihilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
    
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    
    public HiloServidor(Socket socket) throws IOException{
        System.out.println("Creamos el hilo del servidor");
        this.socket=socket;
        this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.pw = new PrintWriter(socket.getOutputStream(),true);
    }
    
    public void run(){
        
            String cadena = "";
            boolean parar = false;
            
            while(!cadena.trim().equals("*") && !parar){
                System.out.println("El hilo se comunica con: "+this.socket.toString());
            
                try{
                    cadena = br.readLine();
                    System.out.println("El hilo lee cadena: "+cadena);
                    pw.println(cadena.trim().toUpperCase());
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    parar = true;
                }
            }
            System.out.println("Hilo con: "+socket.toString());
    }
}
