package gruppe22.cdio.ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

//Skal tale med IController - metoderne skal kalde fra controlleren til sidst
public class TUI extends JFrame implements IUserInterface{

    //Drop-down menu!


    void printLine(String text){
        System.out.println(text);
    }

    void printList(ArrayList<String> array){
        //Hvad skal array-navnet være - mere specifikt, userList?
        System.out.println(array);
    }

    void clearScreen(){}

    //Skal der være flere input - int vægt? - definere med forskellige meyode-navne
    String getInput(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }

    //Double getMachineInput(){
    // Scanner scanner = new Scanner(System.in);
    // Double weight = scanner.nextDouble();
    // scanner.close();
    // return weight;
    // }
}
