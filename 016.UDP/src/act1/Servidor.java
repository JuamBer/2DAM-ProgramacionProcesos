package act1;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String args[]) {
        new Servidor(args);
    }
    
    public Servidor(String args[]){
        DatagramSocket dSocket = null;
        
        if(args.length < 1){
            System.out.println("Uso: java UDPServer <N'umero de puerto>");
            System.exit(0);
        }
        
        try{
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
