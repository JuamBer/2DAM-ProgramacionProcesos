package teatrotcp;

import java.util.ArrayList;

public class Teatro {
    
    private String name;
    private String location;
    private ArrayList<SeccionTeatro> seccionesTeatro;
    
    
    public Teatro(String name,String location){
        this.name = name;
        this.location = location;
        this.seccionesTeatro = new ArrayList<SeccionTeatro>();
    }
    
    public Teatro(String name,String location, ArrayList<SeccionTeatro> seccionesTeatro){
        this.name = name;
        this.location = location;
        this.seccionesTeatro = seccionesTeatro;
    }
    
    public void addSeccionTeatro(String nombre, int precio, int numeroButacas){
        this.seccionesTeatro.add(new SeccionTeatro(nombre,precio,numeroButacas));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<SeccionTeatro> getSeccionesTeatro() {
        return seccionesTeatro;
    }

    public void setSeccionesTeatro(ArrayList<SeccionTeatro> seccionesTeatro) {
        this.seccionesTeatro = seccionesTeatro;
    }

    @Override
    public String toString() {
        return "Teatro{" + "\n\tname=" + name + ", \n\tlocation=" + location + ", \n\tseccionesTeatro=" + seccionesTeatro + "\n}";
    }
    
    
    
    
}
