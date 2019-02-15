package gruppe22.cdio.ui;

import java.util.ArrayList;

public interface IUserInterface {
    void printLine(String text);
    void printList(ArrayList<String> array);
    void clearScreen();
    String getInput();
}
