package gruppe22.cdio.ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Skal tale med IController - metoderne skal kalde fra controlleren til sidst
public class TUI implements IUserInterface{

    //Drop-down menu - lavet i Controller!

    public void printLine(String text){
        System.out.println(text);
    }

    public void printList(List<String> array){
        //Hvad skal array-navnet være - mere specifikt, userList?
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
    }

    public void clearScreen(){
        System.out.flush(); //Virker ikke?
    }

    //Skal der være flere input - int vægt? - definere med forskellige meyode-navne
    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }

    //public double getMachineInput(){
    // Scanner scanner = new Scanner(System.in);
    // Double weight = scanner.nextDouble();
    // scanner.close();
    // return weight;
    // }
}
