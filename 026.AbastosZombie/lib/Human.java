import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class Human {

    private String name;
    private Integer strength;
    private Integer strengthToBeZombie;
    private HashSet<Integer> vaccinatedVirus;
    private static ServerSocket server;
            
    public Human(String name) {
        this.name = name;
        this.strength = generateStrength();
        this.strengthToBeZombie = (int) (this.strength * 0.1);
        this.vaccinatedVirus = generatevVaccinatedVirus();
    }

    public void receiveViruses() throws IOException{
        this.server = new ServerSocket(6000);
        
        System.out.println("---------------------------");
        System.out.println("SERVER ACTIVE (Human)");
        System.out.println(server.getLocalSocketAddress());
        System.out.println("---------------------------\n");
        
        Socket socketClient = new Socket();
        socketClient = server.accept();
        
        DataInputStream inputStream = new DataInputStream(socketClient.getInputStream());
        int numberOfAttacks = inputStream.readInt();
        
        System.out.println("INITIAL ESTATUS: "+this+"\n");
        
        System.out.println("---------------------------");
        System.out.println("START GETTING ATTACKED");
        System.out.println("---------------------------\n");
        
        for (int i = 0; i < numberOfAttacks; i++) {
            socketClient = new Socket();
            socketClient = server.accept();
            VirusAttack virusAttack = new VirusAttack(this, socketClient);
            virusAttack.start();
            
        }
        
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n---------------------------");
        System.out.println("FINISH GETTING ATTACKED");
        System.out.println("---------------------------\n");
        
        System.out.println("FINAL ESTATUS: "+this+"\n");
       
        checkIfIamZombie();
        
        System.out.println("---------------------------");
        System.out.println("SERVER OFF (Human)");
        System.out.println(server.getLocalSocketAddress());
        System.out.println("---------------------------");
        this.server.close();
    }
    
    private void checkIfIamZombie() {
        if(strength < strengthToBeZombie){
            System.out.println("I AM A ZOMBIE: (strengthToBeZombie:"+strengthToBeZombie+"; myActualStrength:"+strength+")\n");
        }else{
            System.out.println("I STILL BEING HUMAN: (strengthToBeZombie:"+strengthToBeZombie+"; myActualStrength:"+strength+")\n");
        }
    }
    
    private static int generateRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    private static Integer generateStrength() {
        final int minStrength = 1;
        final int maxStrength = 2000;
        final int strength = generateRandomNumber(minStrength, maxStrength);
        return strength;
    }

    private static HashSet<Integer> generatevVaccinatedVirus() {
        final int numberOfVaccinatedVirus = generateRandomNumber(2,4);
        HashSet<Integer> virus = new HashSet<Integer>();
        
        for (int i = 0; i < numberOfVaccinatedVirus; i++) {
            generateRandomImmunity(virus);
        }
        return virus;
    }

    private static void generateRandomImmunity(HashSet<Integer> virus) {
        DataBaseViruses db = DataBaseViruses.getDataBaseViruses();
        ArrayList<Virus> totalViruses = db.getViruses();
        
        int number = generateRandomNumber(0, totalViruses.size() - 1);
        System.out.println("generateRandomNumber: "+number);
        System.out.println("totalViruses.get(number)"+totalViruses.get(number));
        if (virus.contains(totalViruses.get(number).getId())) {
            System.out.println("IS CONTAINED");
            generateRandomImmunity(virus);
        } else {
            System.out.println("not is: totalViruses.get(number).getId(): "+totalViruses.get(number).getId());
            virus.add(totalViruses.get(number).getId());
        }
    }
    public boolean checkVirusImmunity(Virus virus) {
        boolean isImmune = false;
        
        for (int i = 0; i < vaccinatedVirus.size(); i++) {
            if(vaccinatedVirus.contains(virus.getId())){
                isImmune = true;
            }
        }
        
        return isImmune;
    }
    
    public synchronized void receiveAttack(int attackStrength) {
        this.strength -= attackStrength;
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

    public HashSet<Integer> getVaccinatedVirus() {
        return vaccinatedVirus;
    }

    public void setVaccinatedVirus(HashSet<Integer> vaccinatedVirus) {
        this.vaccinatedVirus = vaccinatedVirus;
    }

    public static ServerSocket getServer() {
        return server;
    }

    public static void setServer(ServerSocket server) {
        Human.server = server;
    }



    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", strength=" + strength + ", vaccinatedVirus=" + vaccinatedVirus + '}';
    }
   
}
