package quizmagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Cliente {
    public static void main(String args[]) throws IOException {
        boolean parar = false;
        try (Socket socket = new Socket("localhost", 6000)) {
            
            // CREE FLUXOS D'ENTRADA I EIXIDA
            PrintWriter feixida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // FLUX PER A L'ENTRADA PER TECLAT
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String cadena, cadenaRebuda;

            System.out.println("Introduce cadenas y las devuelve en mayusculas. Introduce * para finalizar");

            do {
                cadenaRebuda = fentrada.readLine();
                if(!cadenaRebuda.equals("*")){
                    System.out.println(cadenaRebuda);

                    cadena = in.readLine();
                    feixida.println(cadena);
                }else{
                    cadenaRebuda = fentrada.readLine();
                    System.out.println(cadenaRebuda);
                    feixida.println("*");
                    parar = true;

                }
                
            } while (!parar);

            System.out.println("Final comunicación");

            // TANQUE FLUXOS I SOCKET
            feixida.close();
            fentrada.close();

            in.close();
            socket.close();

        }

    }
}
