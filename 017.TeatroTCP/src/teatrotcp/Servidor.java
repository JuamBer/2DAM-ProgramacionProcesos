package teatrotcp;

import java.io.*;
import java.net.*;

public class Servidor {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        Teatro teatro = new Teatro("Teatro Olympia", "C. de Sant Vicent Màrtir, 44, 46001 València, Valencia");
        teatro.addSeccionTeatro("GAL", 150, 8);
        teatro.addSeccionTeatro("CEN", 80, 54);
        teatro.addSeccionTeatro("LAT1", 100, 4);
        teatro.addSeccionTeatro("LAT2", 100, 4);
        teatro.addSeccionTeatro("VIP1", 250, 3);
        teatro.addSeccionTeatro("VIP2", 250, 3);

        abrirServidor(teatro);
    }

    private static void abrirServidor(Teatro teatro) {
        try {
            ServerSocket ssServidor = new ServerSocket(PORT);
            System.out.println("---------------------------");
            System.out.println("SERVIDOR ACTIVO");
            System.out.println(ssServidor.getLocalSocketAddress());
            System.out.println("---------------------------");

            boolean key = true;
            Socket sCliente = ssServidor.accept();
            OutputStream auxOut = sCliente.getOutputStream();
            DataOutputStream fluxOut = new DataOutputStream(auxOut);

            while (key) {
                InputStream auxIn = sCliente.getInputStream();
                DataInputStream fluxIn = new DataInputStream(auxIn);
                String msg = fluxIn.readUTF();
                int op = Integer.parseInt(msg);

                Butaca butaca = null;
                String msgEnviar = "";

                switch (op) {
                    case 1:
                        butaca = reservar(teatro, "GAL");
                        break;
                    case 2:
                        butaca = reservar(teatro, "CEN");
                        break;
                    case 3:
                        butaca = reservar(teatro, "LAT1");
                        break;
                    case 4:
                        butaca = reservar(teatro, "LAT2");
                        break;
                    case 5:
                        butaca = reservar(teatro, "VIP1");
                        break;
                    case 6:
                        butaca = reservar(teatro, "VIP2");
                        break;
                    case 7:
                        msgEnviar = teatro.toString();
                        break;
                    case 8:
                        key = false;
                        msgEnviar = "Cerrando conexión";
                        break;
                }
                System.out.println("Opción: " + msg);
                if (msgEnviar.equals("")) {
                    try {
                        msgEnviar = "Butaca numero " + butaca.getNumero() + " reservada correctamente";
                    } catch (Exception ex) {
                        msgEnviar = "No hay ninguna butaca disponible";
                    }
                    enviarMensageAlCliente(sCliente, auxOut, msgEnviar);
                } else {
                    enviarMensageAlCliente(sCliente, auxOut, msgEnviar);
                }
            }
            sCliente.close();

        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void enviarMensageAlCliente(Socket sCliente, OutputStream auxOut, String msg) throws IOException {
        auxOut = sCliente.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        fluxOut.writeUTF(msg);
    }

    private static Butaca reservar(Teatro teatro, String seccionTeatro) {
        Butaca butaca = null;
        for (int i = 0; i < teatro.getSeccionesTeatro().size(); i++) {
            if ((teatro.getSeccionesTeatro().get(i).getNombre()).equals(seccionTeatro)) {
                for (int j = 0; j < teatro.getSeccionesTeatro().get(i).getButacas().size(); j++) {
                    if (teatro.getSeccionesTeatro().get(i).getButacas().get(j).isOcupada() == false) {
                        teatro.getSeccionesTeatro().get(i).getButacas().get(j).setOcupada(true);
                        return teatro.getSeccionesTeatro().get(i).getButacas().get(j);
                    }
                }
            }
        }
        return butaca;
    }
}
