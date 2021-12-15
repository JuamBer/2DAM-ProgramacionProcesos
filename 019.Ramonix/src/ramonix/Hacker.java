package ramonix;

    
class Hacker implements Runnable{
    
    private String name;
    private String aka;
    private int fuerza;
    private int cadencia;
    private boolean bando;

    public Hacker(String name, String aka, int fuerza, int cadencia, boolean bando) {
        this.name = name;
        this.aka = aka;
        this.fuerza = fuerza;
        this.cadencia = cadencia;
        this.bando = bando;
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
    
    public void atacar(){
       
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String toString() {
        return "Hacker{" + "name=" + name + ", aka=" + aka + ", fuerza=" + fuerza + ", cadencia=" + cadencia + ", bando=" + bando + '}';
    }
}
    
