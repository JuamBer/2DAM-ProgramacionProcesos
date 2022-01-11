package serializacionfichero;

import java.io.*;

public class EmpleatPrincipal {
	public static void main(String[] args) {
		try {

			// CREE I OMPLIC L'OBJECTE DE LA CLASSE empleat
			Empleat empleatGuardar = new Empleat(1,"Juan","Informatica",5.0);
			System.out.println("Valors de l'objecte a serialitzar = "+empleatGuardar);

			// ESCRITURA AL FITXER
			File file = new File("Serialitzacio_A_Fitxer.txt");
			FileOutputStream foStream = new FileOutputStream(file);
			ObjectOutputStream oStream = new ObjectOutputStream(foStream);
			// GUARDE L'OBJECTE DE LA CLASSE Empleat AL FITXER
			oStream.writeObject(empleatGuardar);

			// LECTURA DEL FITXER
			ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(file));
			// LLIG L'OBJECTE DE LA CLASSE Empleat DEL FITXER
			Empleat empleatRecuperar = (Empleat) iStream.readObject();
			System.out.println("Valors de l'objecte a deserialitzar = " + empleatRecuperar);

			// TANQUE FLUXES
			oStream.close();
			iStream.close();

		} catch (FileNotFoundException fn) {
                    System.out.println(fn.getMessage());
		} catch (IOException io) {
                    System.out.println(io.getMessage());
		} catch (ClassNotFoundException cnf) {
                    System.out.println(cnf.getMessage());
		}
	}
}