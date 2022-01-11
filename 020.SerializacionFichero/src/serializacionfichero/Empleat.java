package serializacionfichero;
import java.io.Serializable;

// CLASSE Empleat SERIALITZABLE
public class Empleat implements Serializable {
	private int id;
	private String nom;
	private String department;
	private double nivell;

	// ATRIBUT serialVersionUId
	private static final long serialVersionUID = 2L;

        public Empleat(int id, String nom, String department, double nivell) {
            this.id = id;
            this.nom = nom;
            this.department = department;
            this.nivell = nivell;
        }

	// ATRIBUTS AMB getters I setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getNivell() {
		return nivell;
	}

	public void setNivell(double nivell) {
		this.nivell = nivell;
	}

        @Override
        public String toString() {
            return "Empleat{" + "id=" + id + ", nom=" + nom + ", department=" + department + ", nivell=" + nivell + '}';
        }
}