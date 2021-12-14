package teatrotcp;

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
                
                System.out.println("1. Reservar Butaca GAL"
                                    +"\n2. Reserver Butaca CEN"
                                    +"\n3. Reserver Butaca LAT1"
                                    +"\n4. Reserver Butaca LAT2"
                                    +"\n5. Reserver Butaca VIP1"
                                    +"\n6. Reserver Butaca VIP2"
                                    +"\n7. Ver Butacas"
                                    +"\n8. Salir");
                String op = sc.nextLine();
                fluxOut.writeUTF(op);
                
                auxIn = sCliente.getInputStream();
                fluxIn = new DataInputStream(auxIn);
                System.out.println("Mensage Servidor: "+fluxIn.readUTF()+"\n");
                
                if(op.equals("8")){
                    key = false;
                }
            }
            sCliente.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
