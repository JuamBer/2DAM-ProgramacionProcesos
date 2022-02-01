
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        
        System.out.println("\n---------------------------");
        System.out.println("ABASTOS ZOMBIE");
        System.out.println("---------------------------\n");
        
        DataBaseViruses db = DataBaseViruses.getDataBaseViruses();
        ArrayList<Virus> viruses = db.getViruses();
        ArrayList<Virus> virusesToAttack = new ArrayList<Virus>();
        
        for (int i = 0; i < viruses.size(); i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many viruses of " +viruses.get(i).getName()+" do you want to send to attack ? ");
            Integer number = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < number; j++) {
                virusesToAttack.add(viruses.get(i));
            }
        }
        
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeInt(virusesToAttack.size());
        
        for (Virus virus : virusesToAttack) {
            virus.attack();
        }
        
    }
    
}
