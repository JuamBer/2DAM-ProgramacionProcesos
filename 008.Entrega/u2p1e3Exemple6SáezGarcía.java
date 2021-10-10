
import java.io.*;
import java.util.Scanner;

public class u2p1e3Exemple6SáezGarcía {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "passwd";
        Process p = null;
        Scanner sc = new Scanner(System.in);

        try {
            p = r.exec(comando);
            //escriptura envie entrada a "date" OutputStream 
            OutputStream os=p.getOutputStream();
            //Linux
            os.write("contrasenyaactual\n".getBytes()); //Contrasenya actual
            os.flush(); //buide buffer
            os.write("contrasenyanova\n".getBytes()); //Contrasenya nova
            os.flush(); //buide buffer
            os.write(" contrasenyanova\n".getBytes()); //Repetir contrasenya nova
            os.flush(); //buide buffer

            InputStream is = p.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
           
            
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error en " + comando);
            e.printStackTrace();
        }

        System.out.println("Introduex una cadena...");
        String c = sc.nextLine();
        System.out.println("Cadena escrita: "+c);
        //comprovació d'error: 0 bé 1 malament 
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor d'eixida " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}//fi main 
//fi exemple5
