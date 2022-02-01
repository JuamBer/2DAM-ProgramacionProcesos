package abastoszombie;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Virus implements Serializable {

    private Integer id;
    private String name;
    private int strength;
    private int infectious;

    public Virus(Integer id, String name, int strength, int infectious) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.infectious = infectious;
    }

    public int getAttackStrength() {
        return this.strength * this.infectious;
    }

    public void attack() {
        try {
            Socket socket = new Socket("localhost", 6000);

            System.out.println("---------------------------");
            System.out.println("CLIENT CONNECTED (Virus)");
            System.out.println("---------------------------");

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
            outputStream.writeObject(this);

            System.out.println(this);

            socket.close();

            System.out.println("---------------------------");
            System.out.println("CLIENT DISCONNECTED (Virus)");
            System.out.println("---------------------------\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getInfectious() {
        return infectious;
    }

    public void setInfectious(int infectious) {
        this.infectious = infectious;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Virus{" + "id=" + id + ", name=" + name + ", strength=" + strength + ", infectious=" + infectious + '}';
    }
}
