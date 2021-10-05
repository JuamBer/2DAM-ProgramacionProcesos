import java.io.*;

public class Exemple3 {

public static void main(String[] args) { Runtime r-Runtime.getRuntime(); //objecte runtime String comando="java Unasalutacio "Hola Món! \""; //comando a executar i params

	Process p=null; //inicialitze vble process

	//control params entrada

	if (args.length<1) {

		System.out.println("Se necesita nombre de fichero..");

		System.exit(1);

	}//fi control parametros

	try{ //fitxer al que s'enviará l'eixida del programa Unasalutacio FileOutputStream fos-new FileOutputStream(args[0]); PrintWriter pw=new PrintWriter (fos);

		//execute comando
		p=r.exec(comando);

		//cree buffer

		InputStream is=p.getInputStream(); 
		BufferedReader br=new BufferedReader(new InputStreamReader (is));

		String linia;

		//llegisc línia a línia i imprimisc en el fitxer 
		while ((linia-br.readLine()) !=null){
			System.out.println("Es necessita nom de fitxer.."); 
			System.out.println("Inserisc en "+args [0]++linia); 
			pw.println(linia); //la inserisc en el fitxer
		}//fi bucle línies

		br.close();
		pw.close();

	catch (Exception e) {
		e.printStackTrace(); 
	}

	//comprobació d'errors: 0 bé 1 malament int exitVal;

	try {
		exitVal=p.waitfor(); 
		System.out.println("Valor d'eixida "+exitVal); 
	} catch (InterruptedException e) { 
		e.printStackTrace(); 
	}

}//fi main }//fi Exemple3
