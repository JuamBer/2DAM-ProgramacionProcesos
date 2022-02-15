package examen2ev;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 10000);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n---------------------------");
        System.out.println("EXAMEN 2EV");
        System.out.println("---------------------------\n");
        
        System.out.println("How many strings do you want to send ? ");
        Integer numberOfStrings = Integer.parseInt(sc.nextLine());
        ArrayList<String> texts = new ArrayList<String>();
        
        
        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println(i+ " string:");
            String text = sc.nextLine();
            texts.add(text);
        }
        
        OneClient client = new OneClient(numberOfStrings,texts);
        client.sendInfo();
    }
    
}
