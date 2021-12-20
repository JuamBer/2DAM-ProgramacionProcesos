package ramonix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Ramonix implements Serializable{
    
    private static int vida;
    
    
    private static final int PORT = 5000;
    private static Socket socket;
    private static ServerSocket server;
    
    public Ramonix(int vida) {
        System.out.println("RAMONIX CREADA");
        this.vida = vida;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Ramonix ramonix = new Ramonix(500);
        ramonix.startServer();
    }
    
    public static void startServer() throws IOException, InterruptedException{
        server = new ServerSocket(PORT);
        System.out.println("---------------------------");
        System.out.println("SERVIDOR ACTIVO");
        System.out.println(server.getLocalSocketAddress());
        System.out.println("---------------------------");
        
        int numberOfHackers = recieveNumberOfHackers();
        acceptsHackers(numberOfHackers);
        
        while(vida >= 0){
            sendStopAtack();
            recieveAtack();
        }
        
        
        System.out.println("\n---------------------------");
        System.out.println("RAMONIX DESTRUIDA");
        System.out.println("---------------------------");
        
 
        
        server.close();
        System.out.println("\n---------------------------");
        System.out.println("SERVIDOR CERRADO");
        System.out.println("---------------------------");
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public static void sendStopAtack() throws IOException{
        OutputStream auxOut = socket.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        if(vida >= 0){
            fluxOut.writeBoolean(false);
        }else{
            fluxOut.writeBoolean(true);
        }
        
    }
    
    public static void recieveAtack() throws IOException {
        InputStream auxIn = socket.getInputStream();
        DataInputStream fluxIn = new DataInputStream(auxIn);
        int atack =  Integer.parseInt(fluxIn.readUTF());
        vida += atack;
        System.out.println("\nRECIVIENDO ATAQUE: atack:"+atack+", vida:"+vida);
    } 
    
    public static int recieveNumberOfHackers() throws IOException {
        socket = server.accept();
        System.out.println("\n---------------------------");
        System.out.println("HACKER CONECTADO (Main)");
        System.out.println("---------------------------");
        
        InputStream auxIn = socket.getInputStream();
        DataInputStream fluxIn = new DataInputStream(auxIn);
        return fluxIn.readInt();
    }    
    
    public static void acceptsHackers(int numberOfHackers) throws IOException {
        for (int i = 0; i < numberOfHackers; i++) {
            socket = server.accept();
            System.out.println("\n---------------------------");
            System.out.println("CLIENTE CONECTADO");
            System.out.println("---------------------------");
        }
    }
    
}
