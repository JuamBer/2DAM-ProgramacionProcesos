package abastoszombie;

import java.util.ArrayList;


public class DataBaseViruses {
    private static ArrayList<Virus> viruses;
    private static DataBaseViruses db = null;
    
    private DataBaseViruses() {
        viruses = new ArrayList<>();
        
        Virus delta =   new Virus(100,"Coronavirus Delta  ", 30, 1);
        Virus omicron = new Virus(101,"Coronavirus Omicron", 10, 3);
        Virus ebola =   new Virus(102,"Virus ebola        ", 40, 1);
        Virus marburg = new Virus(103,"Virus de Marburg   ", 60, 1);
        
        viruses.add(delta);
        viruses.add(omicron);
        viruses.add(ebola);
        viruses.add(marburg);
    }
    
    public  static DataBaseViruses getDataBaseViruses() {
        if (db == null) {
            db = new DataBaseViruses();
        }
        return db;
    }
    
    public static ArrayList<Virus> getViruses() {
        return viruses;
    }
    
}
