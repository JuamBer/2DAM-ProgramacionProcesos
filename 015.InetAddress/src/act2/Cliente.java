package clienteservidor;

import java.io.*;
import java.net.*;

public class Cliente {
    static final String HOST = "localhost";
    static final int PORT = 5000;
    
    public static void main(String[] args) {
        new Cliente();
    }
    public Cliente(){
        try{
            
            Socket sCliente = new Socket(HOST, PORT);
            InputStream aux = sCliente.getInputStream();
            DataInputStream flux = new DataInputStream(aux);
            System.out.println(flux.readUTF());
            sCliente.close();
            
            System.out.println("Cliente Creado");
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
