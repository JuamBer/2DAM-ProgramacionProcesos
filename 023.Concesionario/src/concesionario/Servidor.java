package concesionario;

import java.io.*;
import java.net.*;

public class Servidor {

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectInputStream inStream = null;

	public void comunicar() {
		try {
			serverSocket = new ServerSocket(4445);
			System.out.println("---------------------------");
                        System.out.println("SERVIDOR ACTIVO");
                        System.out.println(serverSocket.getLocalSocketAddress());
                        System.out.println("---------------------------");
                        
                        socket = serverSocket.accept();
                        System.out.println("\n---------------------------");
                        System.out.println("CLIENTE CONECTADO");
                        System.out.println("---------------------------");
                        
			inStream = new ObjectInputStream(socket.getInputStream());
			System.out.println("Rebut");

			Coche coche = (Coche) inStream.readObject();
			System.out.println("Objecto Recibido: " + coche);
                        
			File file = new File("Vechiculo.txt");
			FileOutputStream foStream = new FileOutputStream(file);
			ObjectOutputStream oStream = new ObjectOutputStream(foStream);
			oStream.writeObject(coche);
                        
			inStream.close();
			socket.close();

		} catch (SocketException se) {
                    System.out.println(se.getMessage());
		} catch (IOException e) {
                    System.out.println(e.getMessage());
		} catch (ClassNotFoundException cn) {
                    System.out.println(cn.getMessage());
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.comunicar();
	}

}
