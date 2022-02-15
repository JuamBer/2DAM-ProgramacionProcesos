package examen2ev;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLogic {

    private ServerSocket server;

    public void recieveClients() throws IOException {
        this.server = new ServerSocket(10000);

        System.out.println("---------------------------");
        System.out.println("SERVER ACTIVE (ServerLogic)");
        System.out.println(server.getLocalSocketAddress());
        System.out.println("---------------------------\n");

        
        while(true){
            try {
                Socket socketClient = new Socket();
                socketClient = server.accept();
                OneServer virusAttack = new OneServer(this, socketClient);
                virusAttack.start();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
