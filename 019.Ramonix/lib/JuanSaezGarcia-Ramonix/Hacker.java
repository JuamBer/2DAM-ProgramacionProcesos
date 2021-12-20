

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Hacker implements Runnable, Serializable {

    private String name;
    private int strength;
    private int cadence;
    private boolean side;
    private boolean attacking;
    private MeetingRoom meetingRoom;

    private static Socket socket;
    private static InputStream auxIn;
    private static OutputStream auxOut;
    private static String HOST = "localhost";
    private static final int PORT = 5000;

    public Hacker(String name, int strength, int cadence, boolean side, boolean attacking, MeetingRoom meetingRoom) throws IOException {
        this.name = name;
        this.strength = strength;
        this.cadence = cadence;
        this.side = side;
        this.attacking = attacking;
        this.meetingRoom = meetingRoom;
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

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public void connectServer() throws IOException, InterruptedException {
        socket = new Socket(HOST, PORT);

        System.out.println(""
                + "---------------------------\n"
                + "CLIENTE ACTIVO (" + name + ")\n"
                + socket.getLocalSocketAddress() + "\n"
                + "---------------------------\n");

        checkNeo(socket);
        this.attacking = true;
        System.out.println("\n"
                + "---------------------------\n"
                + name + " ATACA!!!\n"
                + "---------------------------\n");
        atacar(socket);

        socket.close();
        System.out.println(""
                + "---------------------------\n"
                + "CLIENTE CERRADO (" + name + ")\n"
                + "---------------------------\n");
    }

    public void checkNeo(Socket socket) throws IOException, InterruptedException {

        synchronized (meetingRoom) {
            meetingRoom.addParticipant(this.name);

            if (this.name.equals("Neo")) {
                meetingRoom.setNeo();
                if (meetingRoom.getParticipants().size() == 4) {
                    System.out.println("NEO HA LLEGADO Y ESTÁN TODOS");
                    meetingRoom.notifyAll();
                } else {
                    System.out.println("NEO HA LLEGADO PERO FALTAN " + (4 - meetingRoom.getParticipants().size()) + " HACKERS");
                    meetingRoom.wait();
                }
            } else {
                if (meetingRoom.isNeo()) {
                    if (meetingRoom.getParticipants().size() == 4) {
                        System.out.println("ESTÁ NEO Y ESTAMOS TODOS");
                        meetingRoom.notifyAll();
                    } else {
                        System.out.println("ESTÁ NEO PERO NO ESTAMOS TODOS");
                        meetingRoom.wait();
                    }
                } else {
                    System.out.println("NO ESTÁ NEO");
                    meetingRoom.wait();
                }
            }
        }
    }

    public void atacar(Socket socket) throws IOException, InterruptedException {
        Thread filActual = Thread.currentThread();

        while (attacking) {
            
            filActual.sleep(this.cadence * 1000);
            OutputStream auxOut = socket.getOutputStream();
            DataOutputStream fluxOut = new DataOutputStream(auxOut);
            int outputData;
            if (side) {
                outputData = this.strength * (-1);
            } else {
                outputData = this.strength;
            }
            System.out.println(name + " ATACANDO (" + outputData + ")");
            fluxOut.writeUTF(String.valueOf(outputData));

        }

    }

    public void recieveStopAtack() throws IOException {
        InputStream auxIn = socket.getInputStream();
        DataInputStream fluxIn = new DataInputStream(auxIn);
        String msg = fluxIn.readUTF();
        System.out.println(msg);
    }

    @Override
    public String toString() {
        return "Hacker{" + "name=" + name + ", strength=" + strength + ", cadence=" + cadence + ", side=" + side + ", attacking=" + attacking + ", meetingRoom=" + meetingRoom + '}';
    }

    @Override
    public void run() {
        try {
            connectServer();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(Hacker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
