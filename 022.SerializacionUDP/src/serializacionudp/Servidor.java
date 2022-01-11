package serializacionudp;

import java.io.*;
import java.net.*;

public class Servidor {
	DatagramSocket dsSocket = null;

	public Servidor() {
	}

	public void CreaIEscoltaSocket() {
		try {
			// CREE socket
			dsSocket = new DatagramSocket(9876);
			System.out.println("Servidor UDP escoltant al port 9876");

			byte[] missatgeEntrada;

			while (true) {
				missatgeEntrada = new byte[1024];
				DatagramPacket dpEntrada = new DatagramPacket(missatgeEntrada, missatgeEntrada.length);
				dsSocket.receive(dpEntrada); // REP DATAGRAMA

				// GUARDE DADES EN MATRIU DE BYTES
				byte[] bEntrada = dpEntrada.getData();

				// CONVERTIM BYTES A OBJECTE CLASSE Persona
				ByteArrayInputStream in = new ByteArrayInputStream(bEntrada);
				ObjectInputStream is = new ObjectInputStream(in);

				try {
					Persona persona = (Persona) is.readObject();
					System.out.println("Rebut l'objecte Persona = " + persona.getNom());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				// IP I PORT DEL CLIENT
				InetAddress direccioIP = dpEntrada.getAddress();
				int port = dpEntrada.getPort();
				// RESPOSTA PER AL CLIENT
				String sResposta = "Gr�cies pel teu missatge";

				// CONVERTEISC RESPOSTA LA CADENA A BYTES
				byte[] bEixida = sResposta.getBytes();
				// CREE EL DATAGRAMA
				DatagramPacket dpEixida = new DatagramPacket(bEixida, bEixida.length, direccioIP, port);
				// ENVIE EL DATAGRAMA
				dsSocket.send(dpEixida);

				// System.exit(0);
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Servidor server = new Servidor();
		server.CreaIEscoltaSocket();
	}
}
