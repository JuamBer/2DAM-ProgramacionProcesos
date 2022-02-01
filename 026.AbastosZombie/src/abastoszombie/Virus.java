package abastoszombie;

public class Virus {
    private String name;
    private int strength;

    public Virus(String name, int strength) {
        this.name = name;
        this.strength = strength;
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
        return "Virus{" + "name=" + name + ", strength=" + strength + '}';
    }
    
}
