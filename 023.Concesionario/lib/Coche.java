
import java.io.Serializable;

public class Coche implements Serializable {

    String dni;
    String matricula;
    String marca;
    String model;
    String combustible;
    int year;
    
    // serialVersionUID
    private static final long serialVersionUID = 1L;

    public Coche(String dni, String matricula, String marca, String model, String combustible, int year) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.combustible = combustible;
        this.year = year;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Coche{" + "dni=" + dni + ", matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", combustible=" + combustible + ", year=" + year + '}';
    }

   

}
