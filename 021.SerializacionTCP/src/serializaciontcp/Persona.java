package serializaciontcp;

import java.io.Serializable;

public class Persona implements Serializable {

    String nom;
    int edat;

    // serialVersionUID
    private static final long serialVersionUID = 1L;

    public Persona(String nom, int edat) {
        super();
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }

}
