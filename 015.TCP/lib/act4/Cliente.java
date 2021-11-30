
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static String HOST = "localhost";
    static final int PORT = 5000;
    static Scanner sc = new Scanner(System.in);
            
    public static void main(String[] args) {
        //this.HOST = args[0];
        new Cliente();
    }
    public Cliente(){
        try{
            boolean key = true;
            
            Socket sCliente = new Socket(HOST, PORT);
            
            InputStream auxIn = sCliente.getInputStream();
            DataInputStream fluxIn = new DataInputStream(auxIn);
            System.out.println(fluxIn.readUTF());
            
            while(key){
                OutputStream auxOut = sCliente.getOutputStream();
                DataOutputStream fluxOut = new DataOutputStream(auxOut);
                String msg = sc.nextLine();
                fluxOut.writeUTF(msg);
                
                auxIn = sCliente.getInputStream();
                fluxIn = new DataInputStream(auxIn);
                System.out.println("Mensage Servidor: "+fluxIn.readUTF());
                
                if(msg.equals("Adios")){
                    key = false;
                }
            }
            sCliente.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
