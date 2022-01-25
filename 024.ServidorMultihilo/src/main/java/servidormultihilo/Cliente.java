package servidormultihilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String args[]) throws IOException {

        try (
            Socket socket = new Socket("localhost", 6000)) {

            // CREE FLUXOS D'ENTRADA I EIXIDA
            PrintWriter feixida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // FLUX PER A L'ENTRADA PER TECLAT
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String cadena, cadenaRebuda;

            System.out.println("Introduce cadenas y las devuelve en mayusculas. Introduce * para finalizar");

            do {
                System.out.println("Introduce cadena: ");
                cadena = in.readLine();

                feixida.println(cadena);
                cadenaRebuda = fentrada.readLine();

                System.out.println("Recibida: " + cadenaRebuda);

            } while (!(cadena.contentEquals("*")));

            System.out.println("Final comunicación");

            // TANQUE FLUXOS I SOCKET
            feixida.close();
            fentrada.close();

            in.close();
            socket.close();

        }

    }
}
