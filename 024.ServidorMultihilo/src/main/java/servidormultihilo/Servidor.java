package servidormultihilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private static ServerSocket servidor;
    
    public static void main(String[] args) throws IOException {
        servidor = new ServerSocket(6000);
        System.out.println("Inicamos servidor en el puesto 6000");
        
        while(true){
            Socket socketClient = new Socket();
            socketClient = servidor.accept();
            HiloServidor hilo = new HiloServidor(socketClient);
            hilo.start();
            System.out.println("Iniciamos el servidor");
        }
    }
}
