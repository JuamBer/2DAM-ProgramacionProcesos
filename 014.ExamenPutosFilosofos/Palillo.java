public class Palillo{
    private int id;
    private boolean palilloDisponible;

    Palillo(int id, boolean palilloDisponible){
        this.id = id;
        this.palilloDisponible = palilloDisponible;
        System.out.println("Palillo Creado");
    }

    public int getId(){
        return this.id;
    }

    public boolean isPalilloDisponible(){
        return this.palilloDisponible;
    }

    public void setPalilloDisponible(boolean palilloDisponible){
        this.palilloDisponible = palilloDisponible;
    }
}