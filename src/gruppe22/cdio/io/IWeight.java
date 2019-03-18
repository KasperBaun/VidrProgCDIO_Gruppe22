package gruppe22.cdio.io;

import java.io.IOException;

public interface IWeight {
    void openConnection(String host, int port);
    void closeConnection() throws IOException;
    void sendMessage();
    String getInput();
    String sendAndAwaitReturn();
}
