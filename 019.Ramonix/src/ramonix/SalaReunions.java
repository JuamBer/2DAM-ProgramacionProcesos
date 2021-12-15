package ramonix;

import java.util.ArrayList;

class SalaReunions {
    
    private ArrayList<Hacker> hackers;
    
    public SalaReunions() {
        this.hackers = new ArrayList<>();
    }
    
    public SalaReunions(ArrayList<Hacker> hackers) {
        this.hackers = hackers;
    }

    public ArrayList<Hacker> getHackers() {
        return hackers;
    }

    public void setHackers(ArrayList<Hacker> hackers) {
        this.hackers = hackers;
    }
    
    public void addHacker(Hacker hacker){
        this.hackers.add(hacker);
    }
    
    public void addHacker(String name, String aka, int fuerza, int cadencia, boolean bando){
        this.hackers.add(new Hacker(name,aka,fuerza,cadencia,bando));
    }
    
    @Override
    public String toString() {
        return "SalaReunions{" + "hackers=" + hackers + '}';
    }
    
    

}
