package ramonix;

import java.io.Serializable;

class Hacker implements Runnable, Serializable{

    private String name;
    private String aka;
    private int fuerza;
    private int cadencia;
    private boolean bando;
    private boolean atacando;
    private Ramonix ramonix;

    public Hacker(String name, String aka, int fuerza, int cadencia, boolean bando, boolean atacando,Ramonix ramonix) {
        System.out.println("HILO DE "+name+" CORRIENDO");
        this.name = name;
        this.aka = aka;
        this.fuerza = fuerza;
        this.cadencia = cadencia;
        this.bando = bando;
        this.atacando = atacando;
        this.ramonix = ramonix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int cadencia) {
        this.cadencia = cadencia;
    }

    public boolean isBando() {
        return bando;
    }

    public void setBando(boolean bando) {
        this.bando = bando;
    }

    public void atacar(Ramonix ramonix) {
        if (bando) {
            ramonix.setVida(ramonix.getVida() - this.fuerza);
        } else {
            ramonix.setVida(ramonix.getVida() + this.fuerza);
        }
    }

    @Override
    public void run() {
        System.out.println("RUN DE "+this.name+" CORRIENDO");
        Thread filActual=Thread.currentThread();

        while (atacando) {
                System.out.println(this.name+" ATACANDO");
                this.atacar(this.ramonix);
            try {
                filActual.sleep(this.cadencia*1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Hacker{" + "name=" + name + ", aka=" + aka + ", fuerza=" + fuerza + ", cadencia=" + cadencia + ", bando=" + bando + ", atacando=" + atacando + ", ramonix=" + ramonix + '}';
    }

    

   
}
