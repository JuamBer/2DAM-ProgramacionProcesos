import java.util.*;
import java.io.*;

public class Filosofo extends Thread{
    
    private int id;
	private int tiempoPensar;
    private int tiempoComer;
	private boolean pensando;
    private Palillo palilloDerecha;
    private Palillo palilloIzquierda;

	public Filosofo(int id,int tiempoPensar,int tiempoComer, boolean pensando, Palillo palilloDerecha, Palillo palilloIzquierda){
		this.id = id;
        this.tiempoPensar = tiempoPensar;
        this.tiempoComer = tiempoComer;
        this.pensando = pensando;
        this.palilloDerecha = palilloDerecha;
        this.palilloIzquierda = palilloIzquierda;
        System.out.println("Filosofo (Hilo) "+this.id+" Creado");
	}

    public void comer(){
        try{
            System.out.println("Filosofo "+this.id+" Comiendo");
            this.palilloDerecha.setPalilloDisponible(false);
            this.palilloIzquierda.setPalilloDisponible(false);
            this.pensando = false;
            this.sleep(this.tiempoComer);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}

    public void pensar(){
        try{
            System.out.println("Filosofo "+this.id+" Pensando");
            this.palilloDerecha.setPalilloDisponible(true);
            this.palilloIzquierda.setPalilloDisponible(true);
            this.pensando = true;
            this.sleep(this.tiempoPensar);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}

	public void run(){
		try{
            System.out.println("Metodo Run Hilo Del Filosofo "+this.id);
            Thread filActual=Thread.currentThread(); 
            FileWriter borrar = new FileWriter("u2ExamenFilosofosSalida.txt");
            borrar.write("SALIDA EXAMEN\n\n");
            borrar.close();
		    while(true){
                FileWriter fw = new FileWriter("u2ExamenFilosofosSalida.txt",true);
                
                if(this.pensando){
                    synchronized(palilloDerecha){
                        synchronized(palilloIzquierda){ 
                            // AQUI CLARAMENTE HAY QUE IMPLEMENTAR WAIT O WAITFOR NOTIFY ETC PERO NO TENGO LA DOCUMENTACIÓN DE ESTOS MÉTODOS
                            if(this.palilloDerecha.isPalilloDisponible() && this.palilloIzquierda.isPalilloDisponible()){
                                this.comer();
                                fw.write("FILOSOFO "+this.id+": Coge los palillos "+this.palilloDerecha.getId()+" y "+this.palilloIzquierda.getId()+"\n");
                                fw.close();
                            }else{
                                System.out.println("Filosofo "+this.id+" Intenta Comer Pero No Tiene Palillos");
                                fw.write("FILOSOFO "+this.id+": Intenta coger los palillos "+this.palilloDerecha.getId()+" y "+this.palilloIzquierda.getId()+" pero no puede, espera\n");
                                fw.close();
                            }
                        }
                    }
                    
                }else{
                    this.pensar();
                    fw.write("FILOSOFO "+this.id+": Suelta los palillos "+this.palilloDerecha.getId()+" y "+this.palilloIzquierda.getId()+" pero no puede, espera\n");
                    fw.close();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}
}