package ramonix;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    
    private static ServerSocket servidor;
    private static Socket socket;
    private static InputStream auxIn;
    private static OutputStream auxOut;
    private static String HOST = "localhost";
    private static final int PORT = 5000;
    private static Ramonix ramonix;
    private static SalaReunions sala;
    
    private static Hacker neo;
    private static Thread threadNeo;
    private static Hacker morfeo;
    private static Thread threadMorfeo;
    private static Hacker triniti;
    private static Thread threadTriniti;
    
    private static Scanner sc = new Scanner(System.in);
            
    public static void main(String[] args) throws IOException, ClassNotFoundException {
  
            boolean key = true;
            
            socket = new Socket(HOST, PORT);
            
            System.out.println("---------------------------");
            System.out.println("CLIENTE ACTIVO");
            System.out.println(socket.getLocalSocketAddress());
            System.out.println("---------------------------");
            
            recibirtRamonixSala(socket);
            
            neo = new Hacker("Neo","Neo",20,2,true,false,ramonix);
            morfeo = new Hacker("Mofeo","P4q1T0",10,1,true,false,ramonix);
            triniti = new Hacker("Triniti","PaU3T",10,1,true,false,ramonix);
            sala.addHacker(neo,true);
            sala.addHacker(morfeo,false);
            sala.addHacker(triniti,false);
            
            if(sala.isNeo()){
                iniciarHilos();
            }
            
            
            socket.close();
            System.out.println("\n---------------------------");
            System.out.println("CLIENTE CERRADO");
            System.out.println("---------------------------");    
    }
    
    public static void iniciarHilos() {
        System.out.println("START CLIENTE");
        threadNeo = new Thread(neo);
        threadNeo.start();
        threadMorfeo = new Thread(morfeo);
        threadMorfeo.start();
        threadTriniti = new Thread(triniti);
        threadTriniti.start();
    }
    private static void recibirtRamonixSala(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
        ramonix = (Ramonix) objectInput.readObject();
        objectInput = new ObjectInputStream(socket.getInputStream());
        sala = (SalaReunions) objectInput.readObject();
    }}
