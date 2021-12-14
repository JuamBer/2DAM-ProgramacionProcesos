package teatrotcp;

import static teatrotcp.Butaca.ANSI_RED;

public class Butaca {
    int numero;
    boolean ocupada;
    
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    
    public Butaca(int numero){
        this.numero = numero;
        this.ocupada = false;
    }
    
    public Butaca(int numero,boolean ocupada){
        this.numero = numero;
        this.ocupada = ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        String color;
        if(this.ocupada){
            color = ANSI_RED;
        }else{
            color = ANSI_GREEN;
        }
        return color+"Butaca{" + "numero=" + numero + ", ocupada=" + ocupada + '}'+ANSI_RESET;
    }
    
}

