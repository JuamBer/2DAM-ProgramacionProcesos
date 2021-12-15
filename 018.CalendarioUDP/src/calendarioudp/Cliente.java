package act1;

import java.net.*;
import java.io.*;

public class Cliente { 
// REBEN EN #CES MISSATGE, HOST DESTINACIÓ I PORT 
    public static void main(String args[]) {
        DatagramSocket dsocket = null;
        
        if (args.length <3) { 
            System.out.println("Utilització: java U3Exemple3 UDPClient <missatge> <nom del Host> <número de port>");
            System.exit(1); 
        } 
        
        try {
            // ENVIAMENT DEL DATAGRAMA
            dsocket = new DatagramSocket();
            byte[] missatgeEnviat = args[0].getBytes(); 
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = Integer.valueOf(args[2]).intValue(); // RECUPERE EL PORT DES DE L'ARGUMENT

            DatagramPacket dpEnviament = new DatagramPacket(missatgeEnviat, args[0].length(), aHost, serverPort); // DATAGRAMA A ENVIAR
            dsocket.send(dpEnviament); // ENVIE EL DATAGRAMA

            // RECEPCIÓ DEL DATAGRAMA
            byte[] missatgeRebut = new byte[1000];
            DatagramPacket dpResposta = new DatagramPacket (missatgeRebut, missatgeRebut.length); 
            dsocket.receive(dpResposta); // REP EL DATAGRAMA System.out.println("Resposta: " + new String(dpResposta getbata()));

        }catch (SocketException ex) {
            System.out.println("Socket:" + ex.getMessage());
        }catch (IOException ex) { 
            System.out.println("IO: " + ex.getMessage());
        }finally { 
            if (dsocket != null){
                dsocket.close(); 
            }
        }
    }
}