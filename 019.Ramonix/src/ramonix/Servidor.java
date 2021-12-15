package ramonix;

import java.io.*;
import java.net.*;

public class Servidor {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        abrirServidor();
    }

    private static void abrirServidor() {
        try {
            ServerSocket ssServidor = new ServerSocket(PORT);
            System.out.println("---------------------------");
            System.out.println("SERVIDOR ACTIVO");
            System.out.println(ssServidor.getLocalSocketAddress());
            System.out.println("---------------------------");

        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void enviarMensageAlCliente(Socket sCliente, OutputStream auxOut, String msg) throws IOException {
        auxOut = sCliente.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        fluxOut.writeUTF(msg);
    }

}
