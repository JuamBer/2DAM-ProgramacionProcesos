package abastoszombie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Human {
    private String name;
    private Integer strength;
    private Map<String, Boolean> vaccinatedVirus;

    public Human(String name, Integer strength, Map<String, Boolean> vaccinatedVirus) {
        this.name = name;
        this.strength = generateStrength();
        this.vaccinatedVirus = generateVaccinatedVirus();
    }
    
    private static int generateRandomNumber(int max){
        return (int) Math.floor(Math.random()*max+1);
    }
            
    private static Integer generateStrength(){
        return null;
    }
    private static Map<String, Boolean> generateVaccinatedVirus(){
        ArrayList<String> totalVirus = new ArrayList<String>(Arrays.asList("Coronavirus Delta", "Coronavirus Omicron", "Virus Ebola", "Virus de Marburg"));
        
        return null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Map<String, Boolean> getVaccinatedVirus() {
        return vaccinatedVirus;
    }

    public void setVaccinatedVirus(Map<String, Boolean> vaccinatedVirus) {
        this.vaccinatedVirus = vaccinatedVirus;
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", strength=" + strength + ", vaccinatedVirus=" + vaccinatedVirus + '}';
    }
    
}
