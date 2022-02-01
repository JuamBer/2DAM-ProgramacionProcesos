package abastoszombie;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        Human human = new Human("Juan");
        human.receiveViruses();
    }
}
