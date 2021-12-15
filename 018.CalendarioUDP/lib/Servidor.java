
import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class Servidor {
	public static void main(String args[]) {

		DatagramSocket dSocket = null;

		if (args.length < 1) { // REBEM EN args EL PORT
			System.out.println("Utilitzaci�: java U3P6UDPServidor <n�mero de port>");
			System.exit(1);
		}

		try {
			int socket_no = Integer.valueOf(args[0]).intValue(); // GUARDE EL N�MERO DE PORT
			dSocket = new DatagramSocket(socket_no);
			byte[] missatgeRebut;

			while (true) {
				missatgeRebut = new byte[1000];
				DatagramPacket dpRebut = new DatagramPacket(missatgeRebut, missatgeRebut.length);
				dSocket.receive(dpRebut);
				String dataString = new String(dpRebut.getData()).trim();
				System.out.println("Rep del client: " + dataString);

				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				Date dataActual = null;
				try {
					dataActual = df.parse(dataString);
					// System.out.println("DATA CONVERTIDA: " + dataActual.toString());
				} catch (ParseException e) {
					System.err.println("No s'ha pogut convertir la data.");
					e.printStackTrace();
				}

				GregorianCalendar dataCalendari = new GregorianCalendar();
				dataCalendari.setTime(dataActual);

				// AIX� �S PER SI LA DATA �S 31-2-2016. AL FER parse, LA DATA SERA 2-3-2016.
				// CANVIEM LA CADENA A LA NOVA DATA
				dataString = dataCalendari.get(Calendar.DAY_OF_MONTH) + "-"
						+ Integer.toString(dataCalendari.get(Calendar.MONTH) + 1) + "-"
						+ dataCalendari.get(Calendar.YEAR);
				int diaSetmana = dataCalendari.get(Calendar.DAY_OF_WEEK);
				if (diaSetmana == 1) {
					dataString = dataString + "-Diumenge";
				} else if (diaSetmana == 2) {
					dataString = dataString + "-Dilluns";
				} else if (diaSetmana == 3) {
					dataString = dataString + "-Dimarts";
				} else if (diaSetmana == 4) {
					dataString = dataString + "-Dimecres";
				} else if (diaSetmana == 5) {
					dataString = dataString + "-Dijous";
				} else if (diaSetmana == 6) {
					dataString = dataString + "-Divendres";
				} else if (diaSetmana == 7) {
					dataString = dataString + "-Dissabte";
				}
				// System.out.println("El dia de la setmana �s: " + dataString);

				// ENVIE EL DATAGRAMA a dpRebut.getAddress() I AL PORT dpRebut.getPort() (DEL
				// QUE HE REBUT)
				byte[] missatgeData = dataString.getBytes();
				DatagramPacket dpResposta = new DatagramPacket(missatgeData, dataString.length(), dpRebut.getAddress(),
						dpRebut.getPort());
				dSocket.send(dpResposta);

			}
		} catch (SocketException e) { // captura excepcion
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) { // captura excepcion
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (dSocket != null) // SI EL SOCKET EXISTEIX
				dSocket.close(); // TANQUE
		}
	}
}
