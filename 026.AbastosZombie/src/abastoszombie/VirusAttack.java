package abastoszombie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class VirusAttack extends Thread {

    private final Human human;
    private final Socket socket;

    public VirusAttack(Human human, Socket socket) throws IOException {
        this.human = human;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Virus virus = (Virus) inputStream.readObject();
            if (human.checkVirusImmunity(virus)) {
                System.out.println(virus.getName() + " (ID:" + virus.getId() + ") IS TRYING TO ATTACK ME. BUT IM VACCINATED. ");
            } else {
                System.out.println(virus.getName() + " (ID:" + virus.getId() + ") IS ATTACKING ME, AND HITS ME " + virus.getAttackStrength() + ".");
                this.human.receiveAttack(virus.getAttackStrength());
                
                if(this.human.getStrength() <= 0){
                    //this.human.closeServer();
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
