
import java.net.*;
import java.util.*;
import java.io.*;

public class Cliente {
	// REBEM EN args MISSATGE, HOST DESTINACI� I PORT
	public static void main(String args[]) {

		DatagramSocket dSocket = null;

		// CONTROL ENTRADA ARGUMENTS
		if (args.length < 2) {
			System.out.println("Utilitzaci�: java U3P6UDPClient <nom del Host> <n�mero de port>");
			System.exit(1);
		}

		try {

			// DEMANE DATA PER TECLAT
			String cadena, data = "";
			Scanner in;
			int i;
			in = new Scanner(System.in);
			System.out.println("Introducci� de la data ------");

			do {
				System.out.println("Introducci� del dia (1/31):");
				cadena = in.nextLine();
				i = Integer.parseInt(cadena);
			} while (i < 1 || i > 31);
			data = data + cadena;
			do {
				System.out.println("Introducci� del mes (1/12):");
				cadena = in.nextLine();
				i = Integer.parseInt(cadena);
			} while (i < 1 || i > 12);
			data = data + "-" + cadena;

			do {
				System.out.println("Introducci� de l'any (major que 1800):");
				cadena = in.nextLine();
				i = Integer.parseInt(cadena);
			} while (i < 1800);
			data = data + "-" + cadena;
			in.close();
			
			// ENVIAMENT DEL DATAGRAMA
			dSocket = new DatagramSocket();
			byte[] missatgeEnviat = data.getBytes();
			InetAddress aHost = InetAddress.getByName(args[0]); // RECUPERE EL HOST DES DE L'ARGUMENT
			int serverPort = Integer.valueOf(args[1]).intValue(); // RECUPERE EL PORT DES DE L'ARGUMENT
			DatagramPacket dpEnviament = new DatagramPacket(missatgeEnviat, data.length(), aHost, serverPort); // DATAGRAMA A ENVIAR
			dSocket.send(dpEnviament); // ENVIE EL DATAGRAMA

			// RECEPCI� DEL DATAGRAMA
			byte[] missatgeRebut = new byte[1000];
			DatagramPacket dpResposta = new DatagramPacket(missatgeRebut, missatgeRebut.length);
			dSocket.receive(dpResposta); // REP EL DATAGRAMA
			System.out.println("Resposta: " + new String(dpResposta.getData()));

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (dSocket != null) // SI EL SOCKET EXISTEIX
				dSocket.close(); // TANQUE
		}
	}
}