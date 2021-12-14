
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String args[]) {
        Servidor servidor = new Servidor(args);
    }
    
    public Servidor(String args[]){
        DatagramSocket dSocket = null;
        
        if(args.length < 1){
            System.out.println("Uso: java UDPServer <Número de puerto>");
            System.exit(1);
        }
        
        try{
            int socket_no = Integer.valueOf(args[0]).intValue();
            dSocket = new DatagramSocket(socket_no);
            byte[] missatgeRebut = new byte[1000];
            
            while(true){
                DatagramPacket dpRebut = new DatagramPacket(missatgeRebut,missatgeRebut.length);
                dSocket.receive(dpRebut);
                System.out.println("Rep del client: "+ new String(dpRebut.getData()));
                
                DatagramPacket dpResposta = new DatagramPacket(dpRebut.getData(), dpRebut.getLength(), dpRebut.getAddress(), dpRebut.getPort());
                dSocket.send(dpResposta);
            }
                    
        }catch(SocketException ex){
            System.out.println("Socket: "+ex.getMessage());
        }catch(IOException ex){
            System.out.println("IO: "+ex.getMessage());
        }finally{
            if(dSocket != null){
                dSocket.close();
            }
        }
    }
}
