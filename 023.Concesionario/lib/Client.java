

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	private Socket socket = null;
	private ObjectOutputStream outputStream = null;
	private boolean estaConnectat = false;
        private Scanner sc = new Scanner(System.in);
        
	public Client() {
	}

	public void comunicar() {
		while (!estaConnectat) {
			try {
				socket = new Socket("localhost", 4445);
				System.out.println("Connectat");
				estaConnectat = true;
                                System.out.println("---------------------------");
                                System.out.println("CLIENTE ACTIVO");
                                System.out.println(socket.getLocalSocketAddress());
                                System.out.println("---------------------------");
                                
				outputStream = new ObjectOutputStream(socket.getOutputStream());
                                
                                System.out.println("Introduce DNI");
                                String dni = sc.nextLine();
                                System.out.println("Introduce matricula");
                                String matricula = sc.nextLine();
                                System.out.println("Introduce marca");
                                String marca = sc.nextLine();
                                System.out.println("Introduce model");
                                String model = sc.nextLine();
                                System.out.println("Introduce combustible");
                                String combustible = sc.nextLine();
                                System.out.println("Introduce year");
                                int year = Integer.parseInt(sc.nextLine());
                                
				Coche coche = new Coche(dni, matricula, marca, model, combustible, year);
                                outputStream.flush();
				outputStream.writeObject(coche);
				System.out.println("Objecto Enviado");

				outputStream.close();
				socket.close();
			} catch (SocketException se) {
                            System.out.println(se.getMessage());
			} catch (IOException e) {
                            System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.comunicar();
	}
}
