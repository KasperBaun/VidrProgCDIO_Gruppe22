package gruppe22.cdio.io;

import java.io.IOException;

public interface IWeight {
    void closeConnection() throws IOException;
    void sendMessageBig(String msg);
    void sendMessageSmall(String msg);
    String tareWeight();
    String sendAndAwaitReturn(String msg);
    String readWeight();

}
