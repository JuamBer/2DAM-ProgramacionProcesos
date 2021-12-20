

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Principal {

    private static final Object HACKERS[][] = {{"Neo", 20, 2, true, false}, {"P4q1T0", 10, 1, true, false}, {"PaU3T", 10, 1, true, false}, {"Ab4$t0$", 10, 1, false, false}};
    private static ArrayList<Thread> hackerList = new ArrayList<Thread>();
    private static MeetingRoom meetingRoom = new MeetingRoom();
    private static Socket socket;
    private static String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        /*
		COSES QUE CAL FER:
		-Crear la sala de reunions per a esperar que arriben tots
		-Crear els 4 hackers -fils- (Neo, P4Qu1T0, Pa13T i Ab4$T0$)
		-Llen�ar els atacs
         */

        

        //Creem la sala de reunions que es compartida per tots els hackers.
        //S'ha de fer ac� i passar-la com a par�metre perqu� �s compartida per tots els fils.
        

        //-Crear els 4 hackers -fils- (Neo, P4Qu1T0, PaU3T i Ab4$T0$)
        for (int i = 0; i < HACKERS.length; i++) {
            String name = (String) HACKERS[i][0];
            int strength = (int) HACKERS[i][1];
            int cadence = (int) HACKERS[i][2];
            boolean side = (boolean) HACKERS[i][3];
            boolean attacking = (boolean) HACKERS[i][4];

            Hacker hacker = new Hacker(name, strength, cadence, side, attacking, meetingRoom);
            hackerList.add(new Thread(hacker));
        }
        
        sendNumberOfHackers();
        
        //-Llen�ar els fils (i atacs)
        for (int i = 0; i < HACKERS.length; i++) {
            hackerList.get(i).start();
        }

    }

    private static void sendNumberOfHackers() throws IOException {
        socket = new Socket(HOST, PORT);
            
        System.out.println("---------------------------");
        System.out.println("CLIENTE ACTIVO (Principal)");
        System.out.println(socket.getLocalSocketAddress());
        System.out.println("---------------------------");
        
        OutputStream auxOut = socket.getOutputStream();
        DataOutputStream fluxOut = new DataOutputStream(auxOut);
        fluxOut.writeInt(hackerList.size());
                
        socket.close();
        System.out.println("\n---------------------------");
        System.out.println("CLIENTE CERRADO");
        System.out.println("---------------------------");    
    }
}
