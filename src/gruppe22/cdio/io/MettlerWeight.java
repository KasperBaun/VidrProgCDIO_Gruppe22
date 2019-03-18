package gruppe22.cdio.io;

import java.io.*;
import java.net.Socket;

public class MettlerWeight implements IWeight {
    private Socket socket;
    private PrintWriter output;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private OutputStream outputStream;

    @Override
    public void openConnection(String host, int port) {
        try {
            socket = new Socket(host, port);

            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();


            output = new PrintWriter(outputStream, true);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void closeConnection() throws IOException {
        socket.close();
    }

    @Override
    public void sendMessage(String msg) {

    }

    @Override
    public String getInput() {
        return null;
    }

    @Override
    public String sendAndAwaitReturn() {
        return null;
    }
}
