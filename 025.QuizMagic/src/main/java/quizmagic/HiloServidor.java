package quizmagic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloServidor extends Thread{
    
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    
    public HiloServidor(Socket socket) throws IOException{
        System.out.println("Creamos el hilo del servidor");
        this.socket=socket;
        this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.pw = new PrintWriter(socket.getOutputStream(),true);
    }
    
    public void run(){
            File archivo;
            FileReader frArc;
            BufferedReader brArc = null;
            int puntuacion = 0;
            
            try {
                archivo = new File("C:\\Users\\7JDAM\\Documents\\2DAM-ProgramacionProcesos\\025.QuizMagic\\lib\\PreguntesRespostes.txt");
                frArc = new FileReader(archivo);
                brArc = new BufferedReader(frArc);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
           
                    
            boolean parar = false;
            
            while(!parar){
                System.out.println("El hilo se comunica con: "+this.socket.toString());
            
                try{
                    
                    String linea = brArc.readLine();
                    this.pw.println(linea);
                    String respuesta = br.readLine();
                    String respuestaCorrecta = brArc.readLine();
                    if(respuestaCorrecta != null){
                        if(respuesta.equals(respuestaCorrecta)){
                            puntuacion++;
                        }
                    }else{
                        this.pw.println("*");
                        this.pw.println("Puntuación: "+puntuacion);
                    }
                    
                    
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    parar = true;
                }
            }
            System.out.println("Hilo con: "+socket.toString());
    }
}
