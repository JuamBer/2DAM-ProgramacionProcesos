package ramonix;

import java.io.Serializable;
import java.util.ArrayList;

class SalaReunions implements Serializable{
    
    private ArrayList<Hacker> hackers;
    private boolean isNeo;
    
    public SalaReunions() {
        System.out.println("SALA DE REUNIONES CREADA");
        this.hackers = new ArrayList<>();
        this.isNeo = false;
    }
    
    public SalaReunions(ArrayList<Hacker> hackers) {
        this.hackers = hackers;
    }

    public ArrayList<Hacker> getHackers() {
        return hackers;
    }
    public boolean isNeo(){
        return this.isNeo;
    }

    public void setHackers(ArrayList<Hacker> hackers) {
        this.hackers = hackers;
    }
    
    public void addHacker(Hacker hacker,boolean isNeo){
        this.hackers.add(hacker);
        this.isNeo = false;
    }
    
    public void addHacker(String name, String aka, int fuerza, int cadencia, boolean bando, boolean atacando, Ramonix ramonix){
        this.hackers.add(new Hacker(name,aka,fuerza,cadencia,bando,atacando,ramonix));
    }
    
    @Override
    public String toString() {
        return "SalaReunions{" + "hackers=" + hackers + '}';
    }
    
    

}
