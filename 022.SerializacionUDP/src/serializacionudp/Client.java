package serializacionudp;

import java.io.*;
import java.net.*;

public class Client {
	DatagramSocket dSocket;

	public void CreaIEscoltaSocket() {
		try {
			dSocket = new DatagramSocket();
			// ENVIAMENT DEL DATAGRAMA
			InetAddress direccioIP = InetAddress.getByName("localhost"); // IP
			Persona persona = new Persona("Joan", 26); // CREE OBJECTE persona

			// CONVERTIM OBJECTE A BYTES
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(outputStream);
			os.writeObject(persona); // ESCRIC OBJECTE persona AL FLUX
			byte[] missatgeEixida = outputStream.toByteArray(); // OBJECTE A BYTES

			// CREE DATAGRAMA
			DatagramPacket dpEixida = new DatagramPacket(missatgeEixida, missatgeEixida.length, direccioIP, 9876);
			dSocket.send(dpEixida); // ENVIE DATAGRAMA
			System.out.println("Client ha enviat el missatge");

			// RECEPCI� DEL DATAGRAMA
			// CREE DATAGRAMA
			byte[] missatgeEntrada = new byte[1024];
			DatagramPacket dpEntrada = new DatagramPacket(missatgeEntrada, missatgeEntrada.length);
			dSocket.receive(dpEntrada); // REP DATAGRAMA
			// TRANSFORME DE BYTES A STRING
			String sMissatge = new String(dpEntrada.getData());
			System.out.println("Servidor respon: " + sMissatge);

			// TANQUE FLUX I SOCKET
			os.close();
			dSocket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.CreaIEscoltaSocket();
	}
}
