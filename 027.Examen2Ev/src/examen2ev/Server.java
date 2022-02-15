package examen2ev;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerLogic server = new ServerLogic();
        server.recieveClients();
    }
}