package act4;

import java.io.*;
import java.net.*;

// SERVIDOR ESPERA CONNEXIONS A LES QUE ATENDRA
// SERVIDOR SALUDARÀ AMB LA FRASE "Hola client"
public class Servidor {

    // PORT EN EL QUE ESPERA CONNEXIONS
    static final int PORT = 5000;
    
    public static void main(String[] args) {
        new Servidor();
    }
    
    
    public Servidor(){
        try{
            //CREA SOCKET I ESPERA
            ServerSocket ssServidor = new ServerSocket(PORT);
            System.out.println("Escolte al port "+PORT);
            
            while (true) {                
                
                boolean key = true;
                //MÉTODO accept() CREA UN NUEVO SOCKET PER A COMUNICARSE CON EL CLIENTE
                Socket sCliente = ssServidor.accept();
                                
                OutputStream auxOut = sCliente.getOutputStream();
                DataOutputStream fluxOut = new DataOutputStream(auxOut);
                fluxOut.writeUTF("Servidor Escuchando");
                
                while(key){
                    InputStream auxIn = sCliente.getInputStream();
                    DataInputStream fluxIn = new DataInputStream(auxIn);
                    String msg = fluxIn.readUTF();
                    System.out.println("Mensage Recivido: "+msg);
                    
                    if(msg.equals("Adios")){
                        System.out.println("Servidor Cerrado");
                        key = false;
                        
                        auxOut = sCliente.getOutputStream();
                        fluxOut = new DataOutputStream(auxOut);
                        fluxOut.writeUTF("Servidor Cerrado");
                    }else{
                        auxOut = sCliente.getOutputStream();
                        fluxOut = new DataOutputStream(auxOut);
                        fluxOut.writeUTF("Mensage Integigencia artificial");
                    }
                    
                
                    
                }
                
                
                //ASOCIO UN FLUX DE SALIDA DE DATOS AL SOCKET
                sCliente.close();
            }
            //ssServidor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}