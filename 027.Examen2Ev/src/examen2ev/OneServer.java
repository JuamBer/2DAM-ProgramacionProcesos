package examen2ev;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class OneServer extends Thread{

    private ServerLogic server;
    private Socket socket;
    private ArrayList<Integer> ASCIINumbers = new ArrayList<Integer>();
    
    public OneServer(ServerLogic server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }
    
    @Override
    public void run() {
        
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            OneClient oneClient = (OneClient) inputStream.readObject();
            System.out.println("oneClient recieved: "+oneClient);
            
            for (int i = 0; i < oneClient.getNumberOfStrings(); i++) {
                ArrayList<Character> ascciText = oneClient.getTexts().get(i);
                
                int ascci = 0;
                for (int j = 0; j < ascciText.size(); j++) {
                    ascci += (int) ascciText.get(j);
                }
                ASCIINumbers.add(ascci);
            }
            
            for (int i = 0; i < ASCIINumbers.size(); i++) {
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeInt(ASCIINumbers.get(i));
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "OneServer{" + "server=" + server + ", socket=" + socket + '}';
    }
    
    
}
