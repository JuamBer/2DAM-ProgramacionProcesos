package teatrotcp;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Servidor {

    // PORT EN EL QUE ESPERA CONNEXIONS
    private static final int PORT = 5000;
    private static final int numerosTiposButacas = 6;
    private static ArrayList<ArrayList> Infobutacas = new ArrayList<ArrayList>();
    private static ArrayList<ArrayList> butacas;
    
    public static void main(String[] args) {
        cargarInformacionTeatro();
        
        try{
            ServerSocket ssServidor = new ServerSocket(PORT);
            System.out.println("Escolte al port "+PORT);
            
            while (true) { 
                boolean key = true;
                Socket sCliente = ssServidor.accept();
                OutputStream auxOut = sCliente.getOutputStream();
                DataOutputStream fluxOut = new DataOutputStream(auxOut);
                fluxOut.writeUTF("Servidor Escuchando");
                
                while(key){
                    InputStream auxIn = sCliente.getInputStream();
                    DataInputStream fluxIn = new DataInputStream(auxIn);
                    String msg = fluxIn.readUTF();
                    int op = Integer.parseInt(msg);
                    int butaca;
                    switch(op){
                        case 1:  
                            butaca = reservar(this.butacasGAL);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 2:  
                            //butaca = reservar(this.butacasCEN);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 3:  
                            //butaca = reservar(this.butacasLAT1);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 4:  
                            //butaca = reservar(this.butacasLAT2);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 5:  
                            //butaca = reservar(this.butacasVIP1);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 6:  
                            //butaca = reservar(this.butacasVIP2);
                            //enviarMSGCliente(sCliente, auxOut, butaca);
                        break;
                        case 7:  
                            //String butacas = verButacas();
                            //enviarButacas(sCliente, auxOut, butacas);
                        break;
                        case 8:  
                            key = false;
                        break;
                    }
                    
                    System.out.println("Opción: "+msg);
                }
                
                
                //ASOCIO UN FLUX DE SALIDA DE DATOS AL SOCKET
                sCliente.close();
            }
            //ssServidor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Servidor(){
        
    }
    
    private static void cargarInformacionTeatro(){
        for (int i = 0; i < numerosTiposButacas; i++) {
           Infobutacas.add(new ArrayList<>());
        }
        Infobutacas.get(0).add("GAL");
        Infobutacas.get(0).add(150);
        Infobutacas.get(0).add(8);
        Infobutacas.get(0).add(Array);
        
        Infobutacas.get(1).add("CEN");
        Infobutacas.get(1).add(80);
        Infobutacas.get(1).add(54);
        
        Infobutacas.get(2).add("LAT1");
        Infobutacas.get(2).add(100);
        Infobutacas.get(2).add(4);
        
        Infobutacas.get(3).add("LAT2");
        Infobutacas.get(3).add(100);
        Infobutacas.get(3).add(4);
        
        Infobutacas.get(4).add("VIP1");
        Infobutacas.get(4).add(250);
        Infobutacas.get(4).add(3);
        
        Infobutacas.get(5).add("VIP2");
        Infobutacas.get(5).add(250);
        Infobutacas.get(5).add(3);
    }
    
    private void enviarMSGCliente(Socket sCliente,OutputStream auxOut,int butaca) throws IOException {
        auxOut = sCliente.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        
        if(butaca == -1){
            fluxOut.writeUTF("No se ha podido reservar"+"\n");
        }else{
            fluxOut.writeUTF("Se ha reservado la butaca número "+ butaca+"\n");
        }
    }
    private void enviarButacas(Socket sCliente,OutputStream auxOut,String butacas) throws IOException {
        auxOut = sCliente.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        fluxOut.writeUTF(butacas);
    }
    
    
    private int reservar(Boolean[] butacas) {
        for(int i = 0; i < butacas.length; i++){
            if(butacas[i] == true){
                butacas[i] = false;
                return i;
            }
        }
        return -1;
    }

//    private String verButacas() {
//        String butacas = "";
//        
//        butacas += "\n\n-----BUTACAS GAL-----\n";
//        for (int i = 0; i < butacasGAL.length; i++) {
//           butacas += butacasGAL[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        butacas += "\n\n-----BUTACAS CEN-----\n";
//        for (int i = 0; i < butacasCEN.length; i++) {
//           butacas += butacasCEN[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        butacas += "\n\n-----BUTACAS LAT1-----\n";
//        for (int i = 0; i < butacasLAT1.length; i++) {
//           butacas += butacasLAT1[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        butacas += "\n\n-----BUTACAS LAT2-----\n";
//        for (int i = 0; i < butacasLAT2.length; i++) {
//           butacas += butacasLAT2[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        butacas += "\n\n-----BUTACAS VIP1-----\n";
//        for (int i = 0; i < butacasVIP1.length; i++) {
//           butacas += butacasVIP1[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        butacas += "\n\n-----BUTACAS VIP2-----\n";
//        for (int i = 0; i < butacasVIP2.length; i++) {
//           butacas += butacasVIP2[i]+ ", ";
//           if((i+1) % 10 == 0){
//               butacas += "\n";
//           }
//        }
//        return butacas;
//    }
//    
//    };

}

