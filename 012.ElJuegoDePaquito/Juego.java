import java.io.*;
import java.util.*;

public class Juego {
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Juego(int numeroJugadores){
        for(int i = 0; i < numeroJugadores; i++){
            this.jugadores.add(new Jugador("name",i));
        }
    }
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    public static void main(String args[]){
        Juego j = new Juego(456);
        System.out.println(j.getJugadores().size());
        j.eliminarJugadores();
        System.out.println(j.getJugadores().size());
	}
    public void eliminarJugadores(){
        long ne = Math.round(Math.random()*this.jugadores.size());
        for(int i = 0; i <= ne; i++){
            long je = Math.round(Math.random()*this.jugadores.size());
            this.jugadores.remove((int) je);
        }
    }
} 