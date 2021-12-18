package ramonix;

import java.io.Serializable;

public class Ramonix implements Serializable{
    
    private int vida;
    private SalaReunions salaReunions;

    public Ramonix(int vida, SalaReunions salaReunions) {
        System.out.println("RAMONIX CREADA");
        this.vida = vida;
        this.salaReunions = salaReunions;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public SalaReunions getSalaReunions() {
        return salaReunions;
    }

    public void setSalaReunions(SalaReunions salaReunions) {
        this.salaReunions = salaReunions;
    }

    @Override
    public String toString() {
        return "Ramonix{" + "vida=" + vida + ", salaReunions=" + salaReunions + '}';
    }
    
}
