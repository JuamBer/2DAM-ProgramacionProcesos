package serializaciontcp;

import java.io.*;
import java.net.*;

public class Client {

	private Socket socket = null;
	private ObjectOutputStream outputStream = null;
	private boolean estaConnectat = false;

	public Client() {
	}

	public void comunicar() {
		while (!estaConnectat) {
			try {
				// CONNECTE
				socket = new Socket("localhost", 4445);
				System.out.println("Connectat");
				estaConnectat = true;

				// CREE EL FLUX D'EIXIDA
				outputStream = new ObjectOutputStream(socket.getOutputStream());

				// CARREGUE DADES EN OBJECTE
				Persona persona = new Persona("Pepe", 25);
				System.out.println("Objecte a enviar: " + persona);
				// NETEGE BUFFER
				outputStream.flush();
				// ESCRIC OBJECTE EN FLUX D'EIXIDA
				outputStream.writeObject(persona);
				System.out.println("Enviat.");

				// TANQUE STREAMS I SOCKET
				outputStream.close();
				socket.close();

			} catch (SocketException se) {
				se.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.comunicar();
	}
}
