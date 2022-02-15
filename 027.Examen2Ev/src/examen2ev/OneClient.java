
package examen2ev;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class OneClient implements Serializable{
    private int numberOfStrings;
    private ArrayList<ArrayList<Character>> texts = new ArrayList<ArrayList<Character>>();
    
    public OneClient(int numberOfStrings, ArrayList<String> textsr){
        this.numberOfStrings = numberOfStrings;
        
        for (int i = 0; i < textsr.size(); i++) {
            ArrayList<Character> characters = new ArrayList<Character>();
            for (int j = 0; j < textsr.get(i).length(); j++) {
                String word = textsr.get(i);
                characters.add(word.charAt(j));
            }
            texts.add(characters);
        }
    }
    
    public void sendInfo(){
         try {
            Socket socket = new Socket("localhost", 10000);

            System.out.println("---------------------------");
            System.out.println("CLIENT CONNECTED (OneClient)");
            System.out.println("---------------------------");
            
            System.out.println("We are going to send this: "+this);
        
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
            outputStream.writeObject(this);
            
            for (int i = 0; i < numberOfStrings; i++) {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                Integer asccitext = inputStream.readInt();
                System.out.println(asccitext+ " (Que es la suma de "+this.texts.get(i)+")");
            }
            
            socket.close();
            System.out.println("---------------------------");
            System.out.println("CLIENT DISCONNECTED (OneClient)");
            System.out.println("---------------------------\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public ArrayList<ArrayList<Character>> getTexts() {
        return texts;
    }

    public void setTexts(ArrayList<ArrayList<Character>> texts) {
        this.texts = texts;
    }


    @Override
    public String toString() {
        return "OneClient{" + "numberOfStrings=" + numberOfStrings + ", texts=" + texts + '}';
    }
    
    
    
}
