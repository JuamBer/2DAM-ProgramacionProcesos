package ramonix;

import java.io.*;
import java.net.*;

public class Servidor {
    
    private static ServerSocket servidor;
    private static Socket socket;
    private static InputStream auxIn;
    private static OutputStream auxOut;
    private static final int PORT = 5000;
    private static Ramonix ramonix;
    private static SalaReunions sala;
    private static Hacker smith;
    private static Thread threadSmith;

    public static void main(String[] args) throws IOException {
        abrirServidor();
    }

    private static void abrirServidor() throws IOException {
        
            
            servidor = new ServerSocket(PORT);
            
            System.out.println("---------------------------");
            System.out.println("SERVIDOR ACTIVO");
            System.out.println(servidor.getLocalSocketAddress());
            System.out.println("---------------------------");
            
            socket = servidor.accept();
            
            System.out.println("\n---------------------------");
            System.out.println("CLIENTE CONECTADO");
            System.out.println("---------------------------");
            
            ramonix = new Ramonix(500, new SalaReunions());
            sala = new SalaReunions();
            smith = new Hacker("Smith", "Ab4$t0$", 10, 1, false, false, ramonix);   
            
            sala.addHacker(smith,false);
            
            enviarRamonixSala(socket,ramonix,sala);
            
            //while (ramonix.getVida()>=0) {
            //    
            //}
            
            if(sala.isNeo()){
                iniciarHilos();
            }
            
            servidor.close();
            System.out.println("\n---------------------------");
            System.out.println("SERVIDOR CERRADO");
            System.out.println("---------------------------");
    }

    public static void iniciarHilos() {
        System.out.println("START SERVIDOR");
        threadSmith = new Thread(smith);
        threadSmith.start();
    }

    private static void enviarRamonixSala(Socket socket, Ramonix ramonix, SalaReunions sala) throws IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
        objectOutput.writeObject(ramonix);
        objectOutput = new ObjectOutputStream(socket.getOutputStream());
        objectOutput.writeObject(sala);
    }
    
        

}
