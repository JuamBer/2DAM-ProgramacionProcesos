package teatrotcp;

import java.util.ArrayList;

public class SeccionTeatro {
    
    private String nombre;
    private int precio;
    private ArrayList<Butaca> butacas;


    public SeccionTeatro(String nombre,int precio, int numeroButacas){
        this.nombre = nombre;
        this.precio = precio;
        this.butacas = new ArrayList<Butaca>();
        
        for (int i = 1; i <= numeroButacas; i++) {
            this.butacas.add(new Butaca(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(ArrayList<Butaca> butacas) {
        this.butacas = butacas;
    }

    @Override
    public String toString() {
        String butacas = "\t\t\t";
        for (int i = 1; i <= this.butacas.size(); i++) {
            butacas += " "+this.butacas.get(i-1);
            if(i%5==0){
                butacas += "\n\t\t\t";
            }
        }
                
        return "\n\t\tSeccionTeatro{" + "\n\t\tnombre=" + nombre + ",\n\t\tprecio=" + precio + ", \n\t\tbutacas={\n" + butacas + "\n\t\t}\n\t}";
    }
    
}
