package gruppe22.cdio.io;

public interface IWeightInterface {
    void openConnection();
    void closeConnection();
    void sendMessage();
    String getInput();
    String sendAndAwaitReturn();
}
