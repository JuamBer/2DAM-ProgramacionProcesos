package ramonix;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static String HOST = "localhost";
    private static final int PORT = 5000;
    private static Scanner sc = new Scanner(System.in);
            
    public static void main(String[] args) {
        try{
            boolean key = true;
            
            Socket sCliente = new Socket(HOST, PORT);
            
            System.out.println("---------------------------");
            System.out.println("CLIENTE ACTIVO");
            System.out.println(sCliente.getLocalSocketAddress());
            System.out.println("---------------------------");
            
            InputStream auxIn = sCliente.getInputStream();
            DataInputStream fluxIn = new DataInputStream(auxIn);
            
            
            sCliente.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
